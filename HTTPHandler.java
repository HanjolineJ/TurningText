import org.eclipse.jetty.server.handler.AbstractHandler;

import java.io.IOException;
import java.util.*;

//keep
public class HTTPHandler extends AbstractHandler {

    Queue<String> playerqueue = new LinkedList<>();
    Queue<String> judgequeue = new LinkedList<>();

    @Override

    public void handle(String target, org.eclipse.jetty.server.Request baseRequest, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.io.IOException, javax.servlet.ServletException {
        // make sure it's a post request
        Map<String, Game> games = new HashMap<String, Game>();

        if (!request.getMethod().equals("POST")) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(javax.servlet.http.HttpServletResponse.SC_OK);
            baseRequest.setHandled(true);
            response.getWriter().println("Wrong request method");
            return;
        }

        String from = request.getParameter("From");
        String body = request.getParameter("Body");
        System.out.println("From: " + from);
        System.out.println("Body: " + body);

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(javax.servlet.http.HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);

        if (games.containsKey(from)) {
            Game game = games.get(from);
            //String judgePhoneNumber = game.getJudgePhoneNumber();
            //String playerPhoneNumber = game.getPlayerPhoneNumber();
        } else if (body.equals("judge")) {
            if(playerqueue.isEmpty()) {
                judgequeue.add(from);
            } else {
                String playerPhoneNumber = playerqueue.remove();
                Game game = new Game(from, playerPhoneNumber);
                games.put(from, game);
                games.put(playerPhoneNumber, game);
                OpenAI.chatGPT( "You are the judge, in this game you will be given a prompt" +
                        " and a response from the player. You will then decide if the response is good or bad.");
            }
            System.out.println("You are the judge." + "You will be added to a queue to wait for a response from the player.");
            String msg = OpenAI.chatGPT(body);
            SMSSender.sendSMS(msg, from);
            System.out.println("ChatGPT response: " + OpenAI.chatGPT(from));
        } else if (body.equals("player")) {
            System.out.println("You are the player.");
            SMSSender.sendSMS("You are the player.", from);
            if(judgequeue.isEmpty()) {
                playerqueue.add(from);
                //add chatgpt to queue

            } else {
                String judgePhoneNumber = judgequeue.remove();
                Game game = new Game(judgePhoneNumber, from);
                games.put(from, game);
                games.put(judgePhoneNumber, game);
                OpenAI.chatGPT("You are the player, in this game you will be given a prompt" +
                        " and you will have to respond with a good or bad response.");
            }
        } else {
            System.out.println("Do you want to be a player or a judge");
            SMSSender.sendSMS("Do you want to be a player or a judge", from);
        }
    }
}
