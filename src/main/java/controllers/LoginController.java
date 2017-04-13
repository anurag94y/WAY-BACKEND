package controllers;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import db.dao.LoginDAO;
import db.helper.MorphiaClient;
import db.model.Login;
import lombok.extern.slf4j.Slf4j;
import org.mongodb.morphia.Datastore;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by anurag.yadav on 4/12/17.
 */
@Slf4j
@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginController {

    @GET
    @Timed
    public String login(@QueryParam("username") String username, @QueryParam("password") String password) {
        try {
            LoginDAO loginDAO = new LoginDAO();
            Login userDetails = loginDAO.getLoginDetail(username, password);
            if (userDetails != null) {
                return "{\"status\" : \"Logged\"}";
            } else {
                return "{\"status\" : \"Not present\"}";
            }
        } catch (Exception e) {
            //log.debug(e.getClass().getName() + " " + e.getMessage());
            return "{\"status\" : \"Error Occurred\"}";
        }
    }
}
