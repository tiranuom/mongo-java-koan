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
import java.util.Arrays;
import java.util.List;

public class MongoDBConnection {

    /**
     * this method should create a mongodb Database without getting an error
     *
     * run with "mvn -Dtest=com.tixsoft.MongoDBConnectionTest clean test"
     *
     * @param dbName
     * @param host
     * @param port
     * @return
     */
    public DB createConnection(String dbName,String host, int port) {
        return null;
    }

    public DBCollection createCollection(String collectionName, DB db) {
        return db.getCollection(collectionName);
    }

    /**
     * this method should insert a dbobject to the database with the given values
     *
     * run with "mvn -Dtest=com.tixsoft.InsertDBObjectTest clean test"
     *
     * @param f1Key
     * @param f1Value
     * @param f2Key
     * @param f2Value
     * @param f3Key
     * @param f3Value
     * @param collection
     */
    public void insertDBObject( String f1Key, Object f1Value,
                                String f2Key, Object f2Value,
                                String f3Key, Object f3Value,
                                DBCollection collection) {

    }

    /**
     *
     * f2 and f3 pairs should go to inner object
     *
     * run with "mvn -Dtest=com.tixsoft.InsertNestedObjectTest clean test"
     *
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

    }

    /**
     * the dataset is about apples which has a price and a weight
     * the results which the weight is higher than 150g should be selected
     *
     * run with "mvn -Dtest=com.tixsoft.QueryForDataTest clean test"
     *
     * @param collection
     * @return
     */
    public List<DBObject> queryForData(DBCollection collection, DBObject reference) {
        return null;
    }

    /**
     * the same classic apple question.
     * you need to update the prices to Rs.55 if apples color is red
     *
     * run with "mvn -Dtest=com.tixsoft.UpdateDataTest clean test"
     *
     * @param collection
     */
    public void updateData(DBCollection collection) {

    }

    /**
     * just like the above example
     * you need to remove the apples with the weight less than 100g
     *
     * run with "mvn -Dtest=com.tixsoft.RemoveDataTest clean test"
     *
     * @param collection
     */
    public void removeData(DBCollection collection) {

    }
}
