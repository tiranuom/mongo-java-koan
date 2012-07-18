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

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class UpdateDataTest extends TestEnv {

    @Test
    public void testUpdateData() {
        init();
        
        for (int i = 145; i < 155; i++ ) {
            BasicDBObject o = new BasicDBObject("weight", i);
            o.put("price", 45);
            o.put("color", (i % 2 == 0) ? "red" : "green" );
            collection.insert(o);
        }
        
        connection.updateData(collection);
        
        for ( DBObject o : collection.find()) {
            if (o.get("color").toString().equals("red")) {
                assertEquals(o.get("price"), 55);
            } else {
                assertEquals(o.get("price"), 45);
            }
        }
    }
}
