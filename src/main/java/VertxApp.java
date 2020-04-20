import io.vertx.core.Vertx;

public class VertxApp {

    public static void main(String[] args) throws InterruptedException {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new SimpleVerticle(),
                result -> System.out.println(SimpleVerticle.class + " deployed"));

        vertx.deployVerticle(new VerticleListener("ListenerA"));
        vertx.deployVerticle(new VerticleListener("ListenerB"));

        Thread.sleep(3000);
        vertx.deployVerticle(new VerticleConsumer(),
                result -> System.out.println(VerticleConsumer.class + " deployed"));

        vertx.deployVerticle(new VerticleHttpServer(),
                result -> System.out.println(VerticleHttpServer.class + " deployed"));

        vertx.deployVerticle(new VerticleRouter(),
                result -> System.out.println(VerticleRouter.class + " deployed"));
    }

}