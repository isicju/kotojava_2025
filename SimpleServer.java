import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.security.SecureRandom;

public class SimpleServer {
    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(80), 0);
            server.createContext("/", new RandomNumberHandler());
            server.start();
            System.out.println("Server started on port 80");
        } catch (Exception e) {
            System.out.println("Server failed to start " + e.getMessage());
        }
    }

    static class RandomNumberHandler implements HttpHandler {
        private final SecureRandom random = new SecureRandom();

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "random number is " + random.nextInt(1000);
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }
}