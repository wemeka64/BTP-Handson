sap.ui.define(["sap/ui/core/mvc/Controller", 
                "jquery.sap.global",
                "wemeka/util/service",
                "sap/m/MessageBox"], 
            function(Controller, jQuery, service, MessageBox){
        return Controller.extend("wemeka.controller.Main", {
            onInit: function(){
               //Create a new UI5 model which contain data
               var oModel = new sap.ui.model.json.JSONModel();
               oModel.setData({
                "postPayload": {
                    "companyName": "",
                    "firstName": "",
                    "lastName": "",
                    "website": "",
                    "email": "",
                    "status": "Unregistered",
                    "gstNo": ""
                },
                "vendor": {}
               });
                                       
               //Set the model object to the Entire App level
               sap.ui.getCore().setModel(oModel);  
            },
            onSave: function(){
                var oModel = sap.ui.getCore().getModel(oModel);
                var payload = oModel.getProperty("/postPayload");
                service.callService("/vendor", "POST", payload ).then(function(){
                    MessageBox.confirm("Saved Successfully");
                }).catch(function(){
                    MessageBox.error("Save failed");
                });
            },
            onDelete: function(){
                var that = this;
                var oTable = that.getView().byId("idTable");
                var rowItem = oTable.getSelectedIndices();
                var  itemId= oTable.getRows()[rowItem].getCells()[0].getText();
                service.callService("/vendor", "DELETE",  itemId ).then(function(){
                    MessageBox.confirm("Deleted Successfully");                    
                }).catch(function(){
                    MessageBox.error("Delete failed");
                });
            },
            onLoadData: function(){
                //alert("todo: we will call our microservice to load vendors");
                var that = this;
                service.callService("/newVendor", "GET", {}).then(function(data){ 
                    //get the object of the table
                    var oTable = that.getView().byId("idTable");

                    var oModel = sap.ui.getCore().getModel();
                    oModel.setProperty("/vendor", data._embedded.vendor);                 
                    
                    //Bind aggregation of the table
                    oTable.bindRows("/vendor");

                }).catch(function(){

                });
            }
        });
    });