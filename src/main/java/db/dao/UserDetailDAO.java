package db.dao;

import db.helper.MorphiaClient;
import db.model.Login;
import db.model.UserDetail;
import org.mongodb.morphia.Datastore;

/**
 * Created by anurag.yadav on 4/13/17.
 */
public class UserDetailDAO {

    public UserDetail getUserDetail(String username) {
        Datastore datastore = MorphiaClient.getDataStore("way");
        datastore.ensureIndexes(UserDetail.class);
        UserDetail userDetails = datastore.createQuery(UserDetail.class).field("username").equal(username).get();
        return userDetails;
    }

    public void setUserDetail(UserDetail userDetail) {
        Datastore datastore = MorphiaClient.getDataStore("way");
        datastore.ensureIndexes(UserDetail.class);
        datastore.save(userDetail);
    }
}
