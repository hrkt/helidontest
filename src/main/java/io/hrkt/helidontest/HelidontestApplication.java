package io.hrkt.helidontest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;

public class HelidontestApplication {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        
        int port = 8080;
        
        ServerConfiguration configuration = ServerConfiguration.builder().port(port).build();
        Routing routing = Routing.builder()
                .any((req, res) -> res.send("It works!")).build();
        WebServer webServer = WebServer
                .create(configuration, routing)
                .start().toCompletableFuture().get(10, TimeUnit.SECONDS);

        System.out.println(
                "Server started at: http://localhost:" + webServer.port());
    }

}
