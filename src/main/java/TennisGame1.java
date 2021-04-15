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

		if (isDeuce()) {
			return deuce();
		}
		if (isSameScore()) {
			return sameScore();
		}

		if (isAdv()) {
			return advState();
		}
		if (isWin()) {
			return winState();
		}

		return scoreDifferent();

	}

	private String scoreDifferent() {
		return translateScore(player1Score) + "-" + translateScore(player2Score);
	}

	private String winState() {
		return "Win for " + getAdvPlayer();
	}

	private String advState() {
		return "Advantage " + getAdvPlayer();
	}

	private boolean isWin() {
		return isReadyForGamePoint() && abs(player1Score - player2Score) >= 2;
	}

	private boolean isAdv() {
		return isReadyForGamePoint() && abs(player1Score - player2Score) == 1;
	}

	private String getAdvPlayer() {
		return player1Score > player2Score ? player1Name : player2Name;
	}

	private boolean isReadyForGamePoint() {
		return player1Score >= 4 || player2Score >= 4;
	}

	private String sameScore() {
		return translateScore(player1Score) + "-All";
	}

	private String deuce() {
		return "Deuce";
	}

	private boolean isDeuce() {
		return isSameScore() && player1Score >= 3;
	}

	private boolean isSameScore() {
		return player1Score == player2Score;
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
