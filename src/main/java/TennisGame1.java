public class TennisGame1 implements TennisGame {

	private int player1ScoreTimes = 0;
	private int player2ScoreTimes = 0;
	private String player1Name;
	private String player2Name;

	public TennisGame1(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public void wonPoint(String playerName) {
		if (playerName == "player1")
			player1ScoreTimes += 1;
		else
			player2ScoreTimes += 1;
	}

	public String getScore() {
		String score = "";
		int tempScore=0;
		if (isTie())
		{
			if (player1ScoreTimes == 0) {
				score = "Love-All";
			} else if (player1ScoreTimes == 1) {
				score = "Fifteen-All";
			} else if (player1ScoreTimes == 2) {
				score = "Thirty-All";
			} else {
				score = "Deuce";
			}
		}
		else if (player1ScoreTimes >=4 || player2ScoreTimes >=4)
		{
			int minusResult = player1ScoreTimes - player2ScoreTimes;
			if (minusResult==1) score ="Advantage player1";
			else if (minusResult ==-1) score ="Advantage player2";
			else if (minusResult>=2) score = "Win for player1";
			else score ="Win for player2";
		}
		else
		{
			for (int i=1; i<3; i++)
			{
				if (i==1) tempScore = player1ScoreTimes;
				else { score+="-"; tempScore = player2ScoreTimes;}
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
		}
		return score;
	}

	private boolean isTie() {
		return player1ScoreTimes == player2ScoreTimes;
	}
}
