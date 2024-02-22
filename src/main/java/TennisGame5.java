import java.util.HashMap;
import java.util.Map;

public class TennisGame5 implements TennisGame {

    private final String player1Name;
    private final String player2Name;
    private int player1Score;
    private int player2Score;

    public TennisGame5(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score++;
        else if (playerName.equals("player2"))
            player2Score++;
        else
            throw new IllegalArgumentException("Invalid player name.");
    }

    @Override
    public String getScore() {
        int player1ScoreVar = player1Score;
        int player2ScoreVar = player2Score;

        while (player1ScoreVar > 4 || player2ScoreVar > 4) {
            player1ScoreVar--;
            player2ScoreVar--;
        }

        var lookup = new HashMap<Map.Entry, String>();
        lookup = getHashScoreTable();

        var entry = Map.entry(player1ScoreVar, player2ScoreVar);
        if (lookup.containsKey(entry)) {
            return lookup.get(entry);
        } else {
            throw new IllegalArgumentException("Invalid score.");
        }
    }
    //this function return new  hash map contains points and their scores
    public HashMap<Map.Entry, String> getHashScoreTable(){
        HashMap<Map.Entry, String> lookup = new HashMap<>();
        lookup.put(Map.entry(0, 0), "Love-All");
        lookup.put(Map.entry(0, 1), "Love-Fifteen");
        lookup.put(Map.entry(0, 2), "Love-Thirty");
        lookup.put(Map.entry(0, 3), "Love-Forty");
        lookup.put(Map.entry(0, 4), "Win for player2");
        lookup.put(Map.entry(1, 0), "Fifteen-Love");
        lookup.put(Map.entry(1, 1), "Fifteen-All");
        lookup.put(Map.entry(1, 2), "Fifteen-Thirty");
        lookup.put(Map.entry(1, 3), "Fifteen-Forty");
        lookup.put(Map.entry(1, 4), "Win for player2");
        lookup.put(Map.entry(2, 0), "Thirty-Love");
        lookup.put(Map.entry(2, 1), "Thirty-Fifteen");
        lookup.put(Map.entry(2, 2), "Thirty-All");
        lookup.put(Map.entry(2, 3), "Thirty-Forty");
        lookup.put(Map.entry(2, 4), "Win for player2");
        lookup.put(Map.entry(3, 0), "Forty-Love");
        lookup.put(Map.entry(3, 1), "Forty-Fifteen");
        lookup.put(Map.entry(3, 2), "Forty-Thirty");
        lookup.put(Map.entry(3, 3), "Deuce");
        lookup.put(Map.entry(3, 4), "Advantage player2");
        lookup.put(Map.entry(4, 0), "Win for player1");
        lookup.put(Map.entry(4, 1), "Win for player1");
        lookup.put(Map.entry(4, 2), "Win for player1");
        lookup.put(Map.entry(4, 3), "Advantage player1");
        lookup.put(Map.entry(4, 4), "Deuce");
        return lookup;
    }

}
