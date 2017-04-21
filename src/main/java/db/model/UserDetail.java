package db.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.utils.IndexDirection;

import java.util.List;

/**
 * Created by anurag.yadav on 4/13/17.
 */

@Entity("user_details")

public class UserDetail {
    @Id
    private ObjectId _id;
    @Indexed(value= IndexDirection.ASC, name="register_username_indx", unique=true)
    private String username;
    private String password;
    private String emailId;
    @Indexed(value= IndexDirection.ASC, name="register_mobile_indx", unique=true)
    private String mobileNumber;
    private String firstName;
    private String lastName;

    public UserDetail() {}

    public UserDetail(String username, String password, String emailId, String mobileNumber, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
