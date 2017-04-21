package controllers;

import com.codahale.metrics.annotation.Timed;
import com.google.gson.Gson;
import db.dao.FriendDAO;
import db.model.Friend;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by anurag.yadav on 4/14/17.
 */
@Path("/friend")
@Produces(MediaType.APPLICATION_JSON)
public class FriendController {

    @POST
    @Timed
    public String addFriend(String friendDetailJson) {
        try {
            FriendDAO friendDAO = new FriendDAO();
            Friend friendDetail = new Gson().fromJson(friendDetailJson, Friend.class);
            friendDAO.setFriendDetail(friendDetail);
            return "{\"status\": \"Friend added successfully\"}";
        } catch (Exception e) {
            return "{\"status\": \"Error occured while updating\"}";
        }
    }

    @GET
    @Timed
    public String getFriend(@QueryParam("username") String username) {
        try {
            FriendDAO friendDAO = new FriendDAO();
            Friend friend = friendDAO.getFriendDetail(username);
            if (friend != null) {
                return new Gson().toJson(friend).toString();
            } else {
                return "{\"status\" : \"Friends are not present for this Username\"}";
            }
        } catch (Exception e) {
            //log.debug(e.getClass().getName() + " " + e.getMessage());
            return "{\"status\" : \"Error occured while getting location for Username\"}";
        }
    }

    @PUT
    @Timed
    public String updateFriend(String friendDetail) {
        try {
            JSONObject jsonObject = new JSONObject(friendDetail);
            String username = new Gson().fromJson(jsonObject.getString("friend"), String.class);
            List<String> friendList = (List<String>) jsonObject.getJSONArray("list");
            FriendDAO friendDAO = new FriendDAO();
            friendDAO.addFriendDetail(username, friendList);
            return "{\"status\": \"Friend added successfully\"}";
        } catch (Exception e) {
            //log.debug(e.getClass().getName() + " " + e.getMessage());
            return "{\"status\" : \"Error occured while getting location for Username\"}";
        }
    }
}
