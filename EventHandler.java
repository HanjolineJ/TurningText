/*
import java.io.IOException;
import java.util.*;


public class EventHandler {
    public static void handleEvent(Map<String, Game> games, String phoneNumber, String msg) {
        if (games.containsKey(phoneNumber)) {
            Game game = games.get(phoneNumber);
            String judgePhoneNumber = game.getJudgePhoneNumber();
            String playerPhoneNumber = game.getPlayerPhoneNumber();

            if (phoneNumber.equals("judge" + judgePhoneNumber)) {
                System.out.println("Judge is sending a message:" + msg);
                //String judge = judgePhoneNumber;
                //add a timer to timeout chatgpt to person if taking too long
                System.out.println(" You will be added to a queue to wait for a response from the player.");
                //Queue <String> queue = LinkedList<String>();
                //queue.add(judgePhoneNumber);
                //System.out.print(Arrays.toString(queue.toArray()));
                //System.out.println("ChatGPT response: " + Twilio.chatGPT(msg));
                try {
                    Timer timer = new Timer(String.valueOf(300));
                    System.out.println("ChatGPT response: " + AI.chatGPT(msg) + timer);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (phoneNumber.equals("player" + playerPhoneNumber)){

                System.out.println("Player is sending a message:" + msg);
            }
        }
    }
}
        /*
        }else{
            if (msg.equals ("play")) {
                Game game = new Game(phoneNumber, null);
                games.put(phoneNumber, game);
                Twilio.sendSMS(phoneNumber, "judge send 'play' to start a game");
            } else {
                Twilio.sendSMS(phoneNumber, "player send 'play' to start a game");


            }

        }
    }
}
*/
// add a queue to chatgpt response

