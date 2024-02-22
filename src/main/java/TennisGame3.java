
public class TennisGame3 implements TennisGame {
    
    private int player2Point;
    private int player1Point;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (player1Point < 4 && player2Point < 4 && !(player1Point + player2Point == 6)) {
            String[] scoreTable = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            String score = scoreTable[player1Point];
            if (player1Point == player2Point) {
                return score + "-All";
            } else {
                return score + "-" + scoreTable[player2Point];
            }
        }
        if (player1Point == player2Point) {
            return "Deuce";
        }
        String score;
        if(player1Point > player2Point){
            score = player1Name;
        }
        else{
            score = player2Name;
        }
        if ((player1Point - player2Point) * (player1Point - player2Point) == 1) {
            return "Advantage " + score;
        }
        else {
            return "Win for " + score;
        }
    }


    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.player1Point += 1;
        else
            this.player2Point += 1;
        
    }

}
