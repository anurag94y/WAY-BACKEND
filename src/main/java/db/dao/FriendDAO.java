package db.dao;

import db.helper.MorphiaClient;
import db.model.Friend;
import db.model.Location;
import org.mongodb.morphia.Datastore;

import java.util.List;

/**
 * Created by anurag.yadav on 4/13/17.
 */
public class FriendDAO {
    public Friend getFriendDetail(String username) {
        Datastore datastore = MorphiaClient.getDataStore("way");
        datastore.ensureIndexes(Friend.class);
        Friend friend = datastore.createQuery(Friend.class).field("username").equal(username).get();
        return friend;
    }

    public void setFriendDetail(Friend friend) {
        Datastore datastore = MorphiaClient.getDataStore("way");
        datastore.ensureIndexes(Friend.class);
        datastore.save(friend);
    }

    public void addFriendDetail(String username, List<String> friendList) {
        Datastore datastore = MorphiaClient.getDataStore("way");
        datastore.ensureIndexes(Friend.class);
        Friend friend = datastore.createQuery(Friend.class).field("username").equal(username).get();
        List<String> prevFriendList = null;
        prevFriendList = friend.getFriendList();
        if (prevFriendList != null)
            prevFriendList.addAll(friendList);
        else
            prevFriendList = friendList;
        friend.setFriendList(prevFriendList);
        datastore.save(friend);
    }
}
