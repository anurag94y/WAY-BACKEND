package db.dao;

import db.helper.MorphiaClient;
import db.model.Login;
import org.mongodb.morphia.Datastore;

/**
 * Created by anurag.yadav on 4/13/17.
 */
public class LoginDAO {
    public Login getLoginDetail(String username, String password) {
        Datastore datastore = MorphiaClient.getDataStore("way");
        datastore.ensureIndexes(Login.class);
        Login userDetails = datastore.createQuery(Login.class).field("username").equal(username).field("password").equal(password).get();
        return userDetails;
    }

    public void setLoginDetail(Login login) {
        Datastore datastore = MorphiaClient.getDataStore("way");
        datastore.ensureIndexes(Login.class);
        datastore.save(login);
    }
}
