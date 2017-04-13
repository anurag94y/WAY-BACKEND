package db.dao;

import db.helper.MorphiaClient;
import db.model.Location;
import db.model.Login;
import org.mongodb.morphia.Datastore;

/**
 * Created by anurag.yadav on 4/13/17.
 */
public class LocationDAO {
    public Location getLocationDetail(String username) {
        Datastore datastore = MorphiaClient.getDataStore("way");
        datastore.ensureIndexes(Location.class);
        Location location = datastore.createQuery(Location.class).field("username").equal(username).get();
        return location;
    }

    public void setLocationDetail(Location location) {
        Datastore datastore = MorphiaClient.getDataStore("way");
        datastore.ensureIndexes(Location.class);
        datastore.save(location);
    }
}
