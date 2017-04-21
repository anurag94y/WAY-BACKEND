package db.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.utils.IndexDirection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anurag.yadav on 4/13/17.
 */
@Entity("friend_details")
public class Friend {
    @Id
    private ObjectId objectId;
    @Indexed(value= IndexDirection.ASC, name="friend_username_indx", unique=true)
    private String username;
    private List<String> friendList;

    public Friend() {
        super();
    }

    public Friend(String username, ArrayList<String> friendList) {
        this.username = username;
        this.friendList = friendList;
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

    public List<String> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<String> friendList) {
        this.friendList = friendList;
    }
}
