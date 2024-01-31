/*
import java.io.IOException;
import java.util.Scanner;

public class Twilio {
    public static String chatGPT(String prompt){
        try {
            return ( "ChatGPT response: " + AI.chatGPT(prompt));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //return chatgpt msg response
    public static void receiveSMS(String msg){
        Scanner scanner = new Scanner(System.in);
        System.out.println( scanner + "ChatGPT response: " + Twilio.chatGPT(msg));

    }
    public static void sendSMS(String phoneNumber, String msg){
        System.out.println("Sending message to " + phoneNumber + ": " + msg);
    }
}


 */