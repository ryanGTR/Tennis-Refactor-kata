import java.util.HashMap;

public class TennisGame1 implements TennisGame {

	private final HashMap<Integer, String> scoreLookup = new HashMap<Integer, String>() {{
		put(0, "Love");
		put(1, "Fifteen");
		put(2, "Thirty");
		put(3, "Forty");
	}};
	private int player1ScoreTimes = 0;
	private int player2ScoreTimes = 0;
	private String player1Name;
	private String player2Name;

	public TennisGame1(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public void wonPoint(String playerName) {
		if (playerName == "player1") {
			player1ScoreTimes += 1;
		} else {
			player2ScoreTimes += 1;
		}
	}

	public String getScore() {
		String score = "";
		int tempScore = 0;
		if (isTie()) {
			score = sameScore(score);
			if (isDeuce()) {
				score = "Deuce";
			}
		} else if (player1ScoreTimes >= 4 || player2ScoreTimes >= 4) {
			int minusResult = player1ScoreTimes - player2ScoreTimes;
			if (minusResult == 1) {
				score = "Advantage player1";
			} else if (minusResult == -1) {
				score = "Advantage player2";
			} else if (minusResult >= 2) {
				score = "Win for player1";
			} else {
				score = "Win for player2";
			}
		} else {
			for (int i = 1; i < 3; i++) {
				if (i == 1) {
					tempScore = player1ScoreTimes;
				} else {
					score += "-";
					tempScore = player2ScoreTimes;
				}
				String tempMessage = "";
				tempMessage = translateScore(tempMessage, tempScore);
				score += tempMessage;
			}
		}
		return score;
	}

	private boolean isDeuce() {
		return isTie() && player1ScoreTimes >= 3;
	}

	private String sameScore(String score) {
		return translateScore(score, player1ScoreTimes) + "-All";
	}

	private String translateScore(String score, int player1ScoreTimes) {
		if (player1ScoreTimes <= 3) {
			score = scoreLookup.get(player1ScoreTimes);
		}
		return score;
	}

	private boolean isTie() {
		return player1ScoreTimes == player2ScoreTimes;
	}
}
