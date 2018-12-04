package org.legomd.module.core.persistence;

import io.vertx.reactivex.ext.asyncsql.PostgreSQLClient;
import io.vertx.reactivex.ext.mongo.MongoClient;

public enum DB {

    LEGOMD_PG(PostgreSQLClient.class), LEGOMD_DOC(MongoClient.class);
    Class clazz;

    DB(Class clazz) {this.clazz = clazz;}

    public Class clazz() {return clazz;}
}
