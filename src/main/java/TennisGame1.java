
public class TennisGame1 implements TennisGame {
    
    private int mScore1 = 0;
    private int mScore2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            mScore1 += 1;
        else
            mScore2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (mScore1==mScore2) {
            score = getEqualScore(mScore1);
        }
        else if (mScore1>=4 || mScore2>=4) {
            score = getScoreGreaterThanFour(mScore1, mScore2);
        }
        else
        {
           score = getNormalScore(mScore1, mScore2);
        }
        return score;
    }
    // pour les scores égaux des deux joueurs
    public String getEqualScore(int mScore){
        String score;
        switch (mScore)
        {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }
    //pour les scores supérieur ou égale à 4
    public String getScoreGreaterThanFour(int mScore1, int mScore2){
        String advantage = "Advantage player";
        String win = "Win for player";
        String score;
        int minusResult = mScore1-mScore2;
        if (minusResult==1) score =advantage + "1";
        else if (minusResult ==-1) score =advantage + "2";
        else if (minusResult>=2) score = win +  "1";
        else score =win + "2";
        return score;
    }
    //les score normale tel que 0, 1, 2 et 3
    public String getNormalScore(int mScore1, int mScore2){
        String score = "";
        int tempScore = 0;
        for (int i=1; i<3; i++)
        {
            if (i==1) tempScore = mScore1;
            else { score+="-"; tempScore = mScore2;}
            switch(tempScore)
            {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
            }
        }
        return score;
    }
}
