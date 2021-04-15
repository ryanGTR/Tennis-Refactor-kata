import static java.lang.Math.abs;

public class TennisGame1 implements TennisGame {

	private int player1Score = 0;
	private int player2Score = 0;
	private String player1Name;
	private String player2Name;

	public TennisGame1(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public void wonPoint(String playerName) {
		if (playerName == "player1") {
			player1Score += 1;
		} else {
			player2Score += 1;
		}
	}

	public String getScore() {

		if (player1Score == player2Score) {
			if (player1Score >= 3) {
				return "Deuce";
			}
			return translateScore(player1Score) + "-All";
		}

		if (player1Score >= 4 || player2Score >= 4) {
			String advPlayer = player1Score > player2Score ? player1Name : player2Name;
			if (abs(player1Score - player2Score) == 1) {
				return "Advantage " + advPlayer;
			}

			if (abs(player1Score - player2Score) >= 2) {
				return "Win for " + advPlayer;
			}
		}

		String score = "";
		int tempScore = 0;
		for (int i = 1; i < 3; i++) {
			if (i == 1) {
				tempScore = player1Score;
			} else {
				score += "-";
				tempScore = player2Score;
			}
			score += translateScore(tempScore);
		}
		return score;
	}

	private String translateScore(int tempScore) {
		String score = "";
		switch (tempScore) {
			case 0:
				score = "Love";
				break;
			case 1:
				score = "Fifteen";
				break;
			case 2:
				score = "Thirty";
				break;
			case 3:
				score = "Forty";
				break;
		}
		return score;
	}
}
