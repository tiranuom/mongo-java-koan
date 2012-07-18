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

import static junit.framework.TestCase.*;

public class InsertDBObjectTest extends TestEnv{

    @Test
    public void testDBObjectInsertion(){
        init();

        connection.insertDBObject("name", "newName", "type", "newType", "price", "newPrice", collection);

        DBCursor cursor = collection.find(new BasicDBObject("name", "newName"));
        assertEquals(cursor.size(), 1);
        assertEquals(cursor.next().get("type"), "newType");
        assertEquals(0, 0);
    }

}
