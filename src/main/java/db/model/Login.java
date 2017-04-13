package db.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;
import org.mongodb.morphia.utils.IndexDirection;

/**
 * Created by anurag.yadav on 4/12/17.
 */

@Entity("login_details")
public class Login {
    @Id
    private ObjectId _id;
    @Indexed(value= IndexDirection.ASC, name="login_username_indx", unique=true)
    private String username;
    private String password;
    private String emailId;
    @Indexed(value= IndexDirection.ASC, name="login_mobnumber_indx", unique=true)
    private String mobileNumber;

    public Login() {}

    public Login(String username, String password, String emailId, String mobileNumber) {
        this.username = username;
        this.password = password;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }
}
