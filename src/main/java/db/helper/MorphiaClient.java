package db.helper;

import lombok.extern.slf4j.Slf4j;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 * Created by anurag.yadav on 4/12/17.
 */
@Slf4j
public class MorphiaClient {

    private static final Morphia morphiaClient = new Morphia().mapPackage("db");

    public static Morphia getMorphiaClient() {
        if (morphiaClient == null) {
            new MorphiaClient();
        }
        return morphiaClient;
    }

    public static Datastore getDataStore(String dbName) {
        try {
            Datastore datastore = getMorphiaClient().createDatastore(MongoDBJDBC.getMongoClient(), dbName);
            return datastore;
        } catch (Exception e) {
            //log.error("Class Name : {}\n Error : {}\n", e.getClass().getName(), e.getMessage());
            return null;
        }
    }

}
