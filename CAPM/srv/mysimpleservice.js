const mysrvdemo = function(srv){
    srv.on('somesrv', (req, res) => {
        return "Hello" + req.data.msg;
    });
}

module.exports = mysrvdemo;