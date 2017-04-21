package app;

import controllers.FriendController;
import controllers.LocationController;
import controllers.LoginController;
import controllers.RegisterController;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by anurag.yadav on 4/13/17.
 */
public class WayApplication extends Application<WayConfiguration> {
    public static void main(String[] args) throws Exception {
        new WayApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap bootstrap) {
        super.initialize(bootstrap);
    }

    @Override
    public void run(WayConfiguration wayConfiguration, Environment environment) throws Exception {
        final LoginController login = new LoginController();
        final RegisterController register = new RegisterController();
        final LocationController location = new LocationController();
        final FriendController friend = new FriendController();
        environment.jersey().register(login);
        environment.jersey().register(register);
        environment.jersey().register(location);
        environment.jersey().register(friend);
    }


//    @Override
//    public void run(HelloWorldConfiguration configuration,
//                    Environment environment) {
//        final HelloWorldResource resource = new HelloWorldResource(configuration.getTemplate(),
//                configuration.getDefaultName());
//        final LoginController login = new LoginController();
//        final RegisterController setLocationDetail = new RegisterController();
//        final LocationController location = new LocationController();
//        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
//        environment.healthChecks().setLocationDetail("template", healthCheck);
//        environment.jersey().setLocationDetail(resource);
//        environment.jersey().setLocationDetail(login);
//        environment.jersey().setLocationDetail(setLocationDetail);
//        environment.jersey().setLocationDetail(location);
//    }

}