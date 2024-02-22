
public class TennisGame2 implements TennisGame
{
    public int player1Point = 0;
    public int player2Point = 0;
    
    public String p1res = "";
    public String p2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (player1Point == player2Point && player1Point < 4)
        {
            score = getScoreForEqualPointLessThanFour(player1Point, player2Point);
        }
        if (player1Point==player2Point && player1Point>=3)
            score = "Deuce";
        
        if (player1Point > 0 && player2Point==0)
        {
            score = getScoreForP1(player1Point, player2Point);
        }
        if (player2Point > 0 && player1Point==0)
        {
            score = getScoreForP2(player1Point, player2Point);
        }
        if (player1Point>player2Point && player1Point < 4)
        {
            score = getScoreForP1GreaterP2AndScoreLess4(player1Point, player2Point);
        }
        if (player2Point>player1Point && player2Point < 4)
        {
            score = getScoreForP1GreaterP2AndScoreGreater4(player1Point, player2Point);
        }
        
        if (player1Point > player2Point && player2Point >= 3)
        {
            score = "Advantage player1";
        }
        
        if (player2Point > player1Point && player1Point >= 3)
        {
            score = "Advantage player2";
        }
        
        if (player1Point>=4 && player2Point>=0 && (player1Point-player2Point)>=2)
        {
            score = "Win for player1";
        }
        if (player2Point>=4 && player1Point>=0 && (player2Point-player1Point)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }
    //score for players had same point and point < 4
    public String getScoreForEqualPointLessThanFour(int player1Point, int player2Point){
        String score = "";
        if (player1Point==0)
            score = "Love";
        if (player1Point==1)
            score = "Fifteen";
        if (player1Point==2)
            score = "Thirty";
        score += "-All";
        return score;
    }
    //score when player 1 has point > 0 and player 2 has point = 0
    public String getScoreForP1(int player1Point, int player2Point){
        String score = "";
        if (player1Point==1)
            p1res = "Fifteen";
        if (player1Point==2)
            p1res = "Thirty";
        if (player1Point==3)
            p1res = "Forty";

        p2res = "Love";
        score = p1res + "-" + p2res;
        return score;
    }
    //score when player 2 has point > 0 and player 1 has point = 0
    public String getScoreForP2(int player1Point, int player2Point){
        String score = "";
        if (player2Point==1)
            p2res = "Fifteen";
        if (player2Point==2)
            p2res = "Thirty";
        if (player2Point==3)
            p2res = "Forty";

        p1res = "Love";
        score = p1res + "-" + p2res;
        return score;
    }
    //score when p1 has point greater than p2 and point < 4
    public String getScoreForP1GreaterP2AndScoreLess4(int player1Point, int player2Point){
        String score = "";
        if (player1Point==2)
            p1res="Thirty";
        if (player1Point==3)
            p1res="Forty";
        if (player2Point==1)
            p2res="Fifteen";
        if (player2Point==2)
            p2res="Thirty";
        score = p1res + "-" + p2res;
        return score;
    }
    //score when p2 has point greater than p1 and point < 4
    public String getScoreForP1GreaterP2AndScoreGreater4(int player1Point, int player2Point){
        String score = "";
        if (player2Point==2)
            p2res="Thirty";
        if (player2Point==3)
            p2res="Forty";
        if (player1Point==1)
            p1res="Fifteen";
        if (player1Point==2)
            p1res="Thirty";
        score = p1res + "-" + p2res;
        return score;
    }
    public void SetP1Score(int number){
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
    }
    
    public void SetP2Score(int number){
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
    }
    public void P1Score(){
        player1Point++;
    }
    public void P2Score(){
        player2Point++;
    }
    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}