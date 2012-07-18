/*
 *   (C) Copyright 2008-2012 hSenid Software International (Pvt) Limited.
 *   All Rights Reserved.
 *
 *   These materials are unpublished, proprietary, confidential source code of
 *   hSenid Software International (Pvt) Limited and constitute a TRADE SECRET
 *   of hSenid Software International (Pvt) Limited.
 *
 *   hSenid Software International (Pvt) Limited retains all title to and intellectual
 *   property rights in these materials.
 *
 */
package com.tixsoft;

import com.mongodb.DB;
import com.mongodb.DBCollection;

abstract class TestEnv {

    MongoDBConnection connection;
    DB db;
    DBCollection collection;

    public void init() {
        connection = new MongoDBConnection();
        db = connection.createConnection("test_db","localhost", 27017);
        db.dropDatabase();
        collection = connection.createCollection("my_collection", db);
    }
}
