import com.codahale.metrics.health.HealthCheck;
import com.mongodb.DB;
import db.helper.MongoDBJDBC;

public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
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
