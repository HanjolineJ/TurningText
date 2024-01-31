

import org.eclipse.jetty.server.Server;

//keep
public class HTTPServer {
    public static void main(String[] args) {
        Server server = new Server(80);
        server.setHandler(new HTTPHandler());
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

