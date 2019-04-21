package org.legomd.module.core.persistence;

import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.asyncsql.PostgreSQLClient;
import io.vertx.reactivex.ext.mongo.MongoClient;
import org.legomd.framework.config.ConfigManager;
import org.legomd.framework.core.AppContext;
import org.legomd.framework.utils.ParamUtil;

import java.util.concurrent.ConcurrentHashMap;

public class DatabaseMgr {

    private static final ConcurrentHashMap<DB, Object> DB_POOLS = new ConcurrentHashMap<>(10);

    public static synchronized <T> T init(DB db, JsonObject... configs) {
        JsonObject config = getConfig(ParamUtil.first(configs), db);
        Object client = null;
        Vertx vertx = AppContext.get().getVertx();
        if (MongoClient.class == db.clazz()) {
            client = MongoClient.createShared(vertx, config);
        } else if (PostgreSQLClient.class == db.clazz) {
            client = PostgreSQLClient.createShared(vertx, config);
        }

        return (T) DB_POOLS.put(db, client);
    }

    public static <T> T getAs(DB db) {
        return (T) DB_POOLS.get(db);
    }

    private static JsonObject getConfig(JsonObject config, DB db) {
        if(config==null)
            return new JsonObject();
        if (DB.LEGOMD_DOC.equals(db))
            config = ConfigManager.loadJson(ConfigManager.MONGO_CONF);
        else if(DB.LEGOMD_PG.equals(db)) {
            config = ConfigManager.loadJson(ConfigManager.PGSQL_CONF);
        }
        return config;
    }
}
