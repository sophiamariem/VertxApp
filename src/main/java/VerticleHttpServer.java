import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;

public class VerticleHttpServer extends AbstractVerticle {
    private HttpServer httpServer;

    @Override
    public void start(Future<Void> future) {
        httpServer = vertx.createHttpServer()
                .requestHandler(r -> r.response()
                        .setStatusCode(200)
                        .end("Hello world!"))
                .listen(8080, result -> {
                    if (result.succeeded()) {
                        System.out.println("Request completed!");
                        future.complete();
                    } else {
                        Throwable cause = result.cause();
                        future.fail(cause);
                        System.out.println(String.format("Error occurred: %s", cause.getMessage()));
                    }
                });
    }

    public HttpServer getHttpServer() {
        return httpServer;
    }

}
