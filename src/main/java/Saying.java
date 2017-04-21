import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import controllers.FriendController;
import controllers.RegisterController;
import db.dao.FriendDAO;
import db.dao.LocationDAO;
import db.helper.MorphiaClient;
import db.model.Location;
import db.model.Login;
import db.model.UserDetail;
import org.hibernate.validator.constraints.Length;
import org.mongodb.morphia.Datastore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Saying {
    private long id;

    @Length(max = 3)
    private String content;

    public Saying() {
        // Jackson deserialization
    }

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

    public static void main(String[] args) {
        /*RegisterController registerController = new RegisterController();
        UserDetail login = new UserDetail("hellboy_86", "8anurag6", "anurag94y@id.com", "8958807064", "Anurag", "Yadav");
        registerController.setLocationDetail(new Gson().toJson(login));
        login = new UserDetail("blade_21", "pratul21", "pratul21@id.com", "9259534850", "Pratul", "Tiwari");
        registerController.setLocationDetail(new Gson().toJson(login));
        login = new UserDetail("paras885", "paras885", "paras885@id.com", "9368968501", "Paras", "Meena");
        registerController.setLocationDetail(new Gson().toJson(login));*/
        LocationDAO locationDAO = new LocationDAO();
        locationDAO.updateLocationDetail(new Location("blade_21", 15.905540, 77.605509));
        //final Login login2 = new Login("username", "password", "email@id.com", "8958807064");
        //Datastore datastore = MorphiaClient.getDataStore("way");
        //datastore.ensureIndexes(UserDetail.class);
        //System.out.println(datastore.createQuery(UserDetail.class).field("username").equal("hellboy_86").get());
//        datastore.save(login);
//        datastore.save(login2);
//        //System.out.println(login.getObjectId());
//        List<Login> list = datastore.createQuery(Login.class).field("username").equal(login.getUsername()).asList();
//        for (Login login1 : list)
//            System.out.println(login1.get_id() + " " + login1.getUsername());
    }
}