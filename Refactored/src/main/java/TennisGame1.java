
public class TennisGame1 implements TennisGame {

    private final static String[] SCORE_TEXT = {"Love", "Fifteen", "Thirty", "Forty"};

    private int m_score1 = 0;
    private int m_score2 = 0;

    public TennisGame1() {
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
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
            String score;
            switch (m_score1) {
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
        
    }

    private String scoreToText4orMore() {
        String score;
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1)
            score = "Advantage player1";
        else if (minusResult == -1)
            score = "Advantage player2";
        else if (minusResult >= 2)
            score = "Win for player1";
        else
            score = "Win for player2";
        return score;
    }

    private String scoreToTextNotEqualsAndLessThan4() {
        return SCORE_TEXT[m_score1] + "-" + SCORE_TEXT[m_score2];
    }

}
