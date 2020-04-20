import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class VerticleConsumer extends AbstractVerticle {

    @Override
    public void start(Future<Void> startFuture) {
        vertx.eventBus().publish("foo", "publisher_consumer");
        vertx.eventBus().send("foo", "sender_consumer");
    }
}