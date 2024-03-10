
public class TennisGame1 implements TennisGame {

    private final static String[] SCORE_TEXT = {"Love", "Fifteen", "Thirty", "Forty"};

    private int m_score1 = 0;
    private int m_score2 = 0;

    public TennisGame1() {
    }

    public void wonPoint(String playerName) {
        if ("player1".equals(playerName))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1 == m_score2) {
            return scoreToTextWhenEquals();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return scoreToText4orMore();
        } else {
            return scoreToTextNotEqualsAndLessThan4();
        }
    }

    private String scoreToTextWhenEquals() {

        if(m_score1 <= 2){
            return SCORE_TEXT[m_score1] + "-All";
        }else{
            return "Deuce";
        }
        
    }

    private String scoreToText4orMore() {
        int scoreDiff = m_score1 - m_score2;
        if (scoreDiff == 1)
            return "Advantage player1";
        else if (scoreDiff == -1)
            return "Advantage player2";
        else if (scoreDiff >= 2)
            return "Win for player1";
        else
            return "Win for player2";
    }

    private String scoreToTextNotEqualsAndLessThan4() {
        return SCORE_TEXT[m_score1] + "-" + SCORE_TEXT[m_score2];
    }

}
