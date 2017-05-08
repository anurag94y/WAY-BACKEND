package app;

import com.codahale.metrics.health.HealthCheck;
import com.mongodb.DB;
import db.helper.MongoDBJDBC;

public class WayHealthCheck extends HealthCheck {

    public WayHealthCheck() {
    }

    @Override
    protected Result check() throws Exception {
        try {
            DB healthCheck = MongoDBJDBC.getDB("way");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}
