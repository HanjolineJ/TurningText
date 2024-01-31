public class Game {
    private String judgePhoneNumber;
    private String playerPhoneNumber;
    public Game(String judgePhoneNumber, String playerPhoneNumber){
        this.judgePhoneNumber = judgePhoneNumber;
        this.playerPhoneNumber = playerPhoneNumber;
    }
    public String getJudgePhoneNumber(){
        return this.judgePhoneNumber;
    }
    public String getPlayerPhoneNumber(){
        return this.playerPhoneNumber;
    }

}
