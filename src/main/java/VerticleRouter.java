import api.TestOutput;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.impl.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import java.time.LocalDateTime;

public class VerticleRouter extends AbstractVerticle {

    @Override
    public void start(Future<Void> future) {
        Router router = Router.router(vertx);
        router.get("/test").handler(this::getTestResponse);

        vertx.createHttpServer()
                .requestHandler(router)
                .listen(8080,
                        result -> {
                            if (result.succeeded()) {
                                future.complete();
                            } else {
                                future.fail(result.cause());
                            }
                        });
    }

    private void getTestResponse(RoutingContext routingContext) {
        LocalDateTime now = LocalDateTime.now();
        TestOutput output = new TestOutput(now, "test " + now);

        routingContext.response()
                .putHeader("content-type", "application/json")
                .setStatusCode(200)
                .end(Json.encodePrettily(output));
    }

}
