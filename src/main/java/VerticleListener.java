import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class VerticleListener extends AbstractVerticle {
    private final String name;

    public VerticleListener(String name) {
        this.name = name;
    }

    @Override
    public void start(Future<Void> startFuture) {
        vertx.eventBus().consumer("foo", message ->
                System.out.println(String.format("received message with body: %s", message.body())));
    }

    public String getName() {
        return name;
    }
}
