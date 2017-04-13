package db.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by anurag.yadav on 4/13/17.
 */
@Entity("location_details")
public class Location {
    @Id
    private ObjectId objectId;
    private String username;
    private Double latitude;
    private Double longitude;

    public Location() {
    }

    public Location(String username, Double latitude, Double longitude) {
        this.username = username;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
