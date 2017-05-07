package db.helper;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by anurag.yadav on 4/12/17.
 */

@Slf4j
public class MongoDBJDBC {

    private static final MongoClient mongoClient = new MongoClient("dbhostname", 27017);


    public static MongoClient getMongoClient() {
        if (mongoClient != null) {
            new MongoDBJDBC();
        }
        return mongoClient;
    }

    public static DB getDB(String dbName) {
        try {
            return mongoClient.getDB(dbName);
        } catch (Exception e) {
            //log.error(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }
}
