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

import java.util.List;

import static junit.framework.TestCase.*;

public class QueryForDataTest extends TestEnv{

//    @Test
//    public void testDBObjectInsertion(){
//        MongoDBConnection connection = new MongoDBConnection();
//        DB db = connection.createConnection("test_db","localhost", 27017);
//        db.dropDatabase();
//
//        DBCollection collection = connection.createCollection("my_collection", db);
//        connection.insertNestedDBObject("name", "newName", "inner" , "type", "newType", "price", "newPrice", collection);
//
//        DBCursor cursor = collection.find(new BasicDBObject("name", "newName"));
//        assertEquals(cursor.size(), 1);
//        Object innerOb = cursor.next().get("inner");
//        assertTrue( DBObject.class.isInstance( innerOb));
//        assertEquals( ((DBObject) innerOb).get("type"), "newType");
//    }

    @Test
    public void testQueryForData() {
        init();

        for (int i = 145; i < 155; i++ ) {
            BasicDBObject o = new BasicDBObject("price" , 35);
            o.put("weight", i);
            collection.insert(o);
        }

        BasicDBObject ref = new BasicDBObject("price" , 1);
        ref.put("weight", 1);

        List<DBObject> list = connection.queryForData(collection, ref);

        System.out.println(list);
        assertFalse(list.size() == 0);

        for( DBObject o : list) {
            int weight = (Integer) o.get("weight");
            assertTrue( weight > 150);
        }

        assertEquals(1,1);
    }
}
