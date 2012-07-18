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

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.junit.Test;

import static junit.framework.TestCase.*;
public class RemoveDataTest extends TestEnv {
    
    @Test
    public void testRemoveData() {
        init();
        
        for (int i = 18; i < 28 ; i++ ) {
            BasicDBObject o = new BasicDBObject("weight", i * 5);
            o.put("price", 45);
            o.put("color", (i % 2 == 0) ? "red" : "green" );
            System.out.println(o);
            collection.insert(o);
        }
        
        connection.removeData(collection);
        
        for (DBObject o : collection.find()) {
            System.out.println(o);
            int weight = (Integer) o.get("weight");

            assertTrue(weight > 100);
        }
    }
    
}
