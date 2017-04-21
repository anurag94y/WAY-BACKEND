import controllers.FriendController;
import controllers.LocationController;
import controllers.LoginController;
import controllers.RegisterController;
import db.model.Friend;
import db.model.Location;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(configuration.getTemplate(),
                configuration.getDefaultName());
        final LoginController login = new LoginController();
        final RegisterController register = new RegisterController();
        final LocationController location = new LocationController();
        final FriendController friend = new FriendController();
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
        environment.jersey().register(login);
        environment.jersey().register(register);
        environment.jersey().register(location);
        environment.jersey().register(friend);
    }

}
