package controllers;

import com.codahale.metrics.annotation.Timed;
import com.google.gson.Gson;
import db.dao.FriendDAO;
import db.dao.LocationDAO;
import db.dao.LoginDAO;
import db.dao.UserDetailDAO;
import db.model.Friend;
import db.model.Location;
import db.model.Login;
import db.model.UserDetail;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anurag.yadav on 4/13/17.
 */
@Path("/register")
@Produces(MediaType.APPLICATION_JSON)
public class RegisterController {

    @POST
    @Timed
    public String register(String userDetailJson) {
        try {
            UserDetailDAO userDetailDAO = new UserDetailDAO();
            UserDetail userDetail = new Gson().fromJson(userDetailJson, UserDetail.class);
            userDetailDAO.setUserDetail(userDetail);
            LoginDAO loginDAO = new LoginDAO();
            Login loginDetail = new Gson().fromJson(userDetailJson, Login.class);
            System.out.println(loginDetail);
            loginDAO.setLoginDetail(loginDetail);
            FriendDAO friendDAO = new FriendDAO();
            friendDAO.setFriendDetail(new Friend(userDetail.getUsername(), new ArrayList<String>()));
            LocationDAO locationDAO = new LocationDAO();
            locationDAO.setLocationDetail(new Location(loginDetail.getUsername(), 12.941585, 77.631109));
            return "{\"status\": \"registered\"}";
        } catch (Exception e) {
            return "{\"status\": \"unable to setUserDetail\"}";
        }
    }

    @GET
    @Timed
    public String getUserDetail(@QueryParam("username") String username) {
        try {
            UserDetailDAO userDAO = new UserDetailDAO();
            UserDetail userDetails = userDAO.getUserDetail(username);
            if (userDetails != null) {
                return new Gson().toJson(userDetails).toString();
            } else {
                return "{\"status\" : \"Detail is not present for this Username\"}";
            }
        } catch (Exception e) {
            //log.debug(e.getClass().getName() + " " + e.getMessage());
            return "{\"status\" : \"Error occured while getting detail for Username\"}";
        }
    }
}
