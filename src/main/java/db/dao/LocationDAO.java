package db.dao;

import db.helper.MorphiaClient;
import db.model.Location;
import db.model.Login;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

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

    public void updateLocationDetail(Location location) {
        Datastore datastore = MorphiaClient.getDataStore("way");
        Query<Location> query = datastore.createQuery(Location.class).field("username").equal(location.getUsername());
        UpdateOperations<Location> ops = datastore.createUpdateOperations(Location.class).set("latitude", location.getLatitude());
        System.out.println("latitude : longitude -> " + location.getLatitude() + " " + location.getLongitude());
        System.out.println("Query -> " + query);
        datastore.update(query, ops);
        ops = datastore.createUpdateOperations(Location.class).set("longitude", location.getLongitude());
        datastore.update(query, ops);
    }
}
