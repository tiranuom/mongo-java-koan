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

import com.mongodb.*;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class MongoDBConnectionTest extends TestCase {

    @Test
    public void testMongoConnection() {
        MongoDBConnection connection = new MongoDBConnection();
        DB db = connection.createConnection("test_db","localhost", 27017);
        assertNotNull(db);
    }

    public void testCreateCollection() {
        MongoDBConnection connection = new MongoDBConnection();
        DB db = connection.createConnection("test_db","localhost", 27017);
        connection.createCollection("my_collection", db);
    }
}
