/*
import org.eclipse.jetty.server.Server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(80);
        server.setHandler(new HTTPHandler());
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);
        try {
            Timer timer = new Timer(String.valueOf(300));
            System.out.println("Lets play a game! Do you want to be the judge or player.");
            scanner.nextLine();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
            //System.out.println(AI.chatGPT("Lets play a game! Ask me if I want to be the judge or player."));
            //Twilio.receiveSMS(scanner.nextLine());

            //} catch (IOException e) {
            //System.out.println("Error: " + e.getMessage());
            // }

            HashMap<String, Game> games = new HashMap<String, Game>();
            HTTPHandler.handle(games, "+15555555555", "do you want to be the judge or player?");
            EventHandler.handleEvent(games, "+15555555555", " Hello, my name is John. What is your name?");

            //now player and chatgpt talk to eacher other, player  first


    }
}
// does human respond to chatgpt response?
// tell me judge or player, then add queues



 */