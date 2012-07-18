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

import java.net.UnknownHostException;
import java.util.List;

public class MongoDBConnectionResults {
    
    public DB createConnection(String dbName,String host, int port) {
        DB db = null;
        try {
            db = new Mongo(host,port).getDB(dbName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return db;
    }

    public DBCollection createCollection(String collectionName, DB db) {
        return db.getCollection(collectionName);
    }

    public void insertDBObject( String f1Key, Object f1Value,
                                String f2Key, Object f2Value,
                                String f3Key, Object f3Value,
                                DBCollection collection) {
        BasicDBObject object = new BasicDBObject(f1Key, f1Value);
        object.put(f2Key,f2Value);
        object.put(f3Key, f3Value);
        collection.insert(object);
    }

    /**
     *
     * f2 and f3 pairs should go to inner object
     * @param f1Key
     * @param f1Value
     * @param nestedObjName
     * @param f2Key
     * @param f2Value
     * @param f3Key
     * @param f3Value
     */
    public void insertNestedDBObject( String f1Key, Object f1Value,
                                      String nestedObjName,
                                      String f2Key, Object f2Value,
                                      String f3Key, Object f3Value,
                                      DBCollection collection){
        BasicDBObject object = new BasicDBObject(f1Key,f1Value);
        BasicDBObject innerObject = new BasicDBObject(f2Key, f2Value);
        innerObject.put(f3Key,f3Value);
        object.put(nestedObjName, innerObject);
        collection.insert(object);
    }

    /**
     * the dataset is about apples which has a price and a weight
     * the results which the weight is higher than 150g should be selected
     * @param collection
     * @return
     */
    public List<DBObject> queryForData(DBCollection collection, DBObject reference) {
        BasicDBObject query2 = new BasicDBObject();
        query2.put("weight", new BasicDBObject("$gt", 150));
        DBCursor cursor = collection.find(query2,reference);
        return cursor.toArray();
    }

    /**
     * the same classic apple question.
     * you need to update the prices to Rs.55 if apples color is red
     * @param collection
     */
    public void updateData(DBCollection collection) {
        BasicDBObject query = new BasicDBObject("color", "red");
        BasicDBObject update = new BasicDBObject("price" , 55);
        BasicDBObject updateSet = new BasicDBObject("$set", update);
        collection.update(query,updateSet, false, true);
    }

    /**
     * just like the above example
     * you need to remove the apples with the weight less than 100g
     * @param collection
     */
    public void removeData(DBCollection collection) {
        DBObject params = new BasicDBObject("$gt", 100);
        DBObject query = new BasicDBObject("weight", params);
        System.out.println(collection.find(query).size());
        for (DBObject o : collection.find(query)) {
            System.out.println(o);
            collection.remove(o);
        }
    }
}
