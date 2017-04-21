package controllers;

import com.codahale.metrics.annotation.Timed;
import com.google.gson.Gson;
import db.dao.LocationDAO;
import db.dao.LoginDAO;
import db.dao.UserDetailDAO;
import db.model.Location;
import db.model.Login;
import db.model.UserDetail;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by anurag.yadav on 4/13/17.
 */
@Path("/location")
@Produces(MediaType.APPLICATION_JSON)
public class LocationController {
    @POST
    @Timed
    public String setLocationDetail(String locationDetailJson) {
        try {
            LocationDAO userDetailDAO = new LocationDAO();
            Location locationDetail = new Gson().fromJson(locationDetailJson, Location.class);
            userDetailDAO.setLocationDetail(locationDetail);
            return "{\"status\": \"Location updated successfully\"}";
        } catch (Exception e) {
            return "{\"status\": \"Error occured while updating\"}";
        }
    }

    @GET
    @Timed
    public String getLocationDetail(@QueryParam("username") String username) {
        try {
            LocationDAO locationDAO = new LocationDAO();
            Location location = locationDAO.getLocationDetail(username);
            if (location != null) {
                return new Gson().toJson(location).toString();
            } else {
                return "{\"status\" : \"Location is not present for this Username\"}";
            }
        } catch (Exception e) {
            //log.debug(e.getClass().getName() + " " + e.getMessage());
            return "{\"status\" : \"Error occured while getting location for Username\"}";
        }
    }

    @PUT
    @Timed
    public String updateLocationDetail(String locationDetailJson) {
        try {
            LocationDAO userDetailDAO = new LocationDAO();
            Location locationDetail = new Gson().fromJson(locationDetailJson, Location.class);
            userDetailDAO.updateLocationDetail(locationDetail);
            return "{\"status\": \"Location updated successfully\"}";
        } catch (Exception e) {
            return "{\"status\": \"Error occured while updating\"}";
        }
    }

}
