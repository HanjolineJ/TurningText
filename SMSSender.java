import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
//keep
public class SMSSender {
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_ACCOUNT_TOKEN");

    public static void sendSMS(String msg, String to) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber(to), // to
                        new PhoneNumber("+18449343655"), // from
                        msg)
                .create();

        System.out.println(message.getSid());
    }
    //receive sms from phonenumber


    /*
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
     */
}