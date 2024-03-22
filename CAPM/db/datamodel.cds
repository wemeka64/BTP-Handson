namespace wemeka.db;

context master {
   entity businesspartner {
    NODE_KEY: String(32);
    BP_ROLE: String(2);
    EMAIL_ADDRESS : String(16);
    PHONE_NUMBER : String(14);
    FAX_NUMBER : String(14);
    WEB_ADDRESS : String(64);
    ADDRESS_GUID : String(32);
    BP_ID : String(16);
    COMPANY_NAME : String(80);
   } 

    entity address{
        key NODE_KEY: String(32);
        CITY : String(64);
        POSTAL_CODE : String(14);
        STREET : String(64);
        BUILDING : String(64);
        COUNTRY : String(2);
        VAL_START_DATE : Date;
        VAL_END_DATE : Date;
        LATITUDE : Decimal;
        LONGITUDE : Decimal;

    }
}

