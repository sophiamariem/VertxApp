import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class SimpleVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> startFuture) {
        System.out.println("Started!");
        startFuture.complete();
    }

    @Override
    public void stop(Future stopFuture) {
        System.out.println("Stopped!");
    }

}