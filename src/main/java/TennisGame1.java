import static java.lang.Math.abs;

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
			if (isDeuce()) {
				return "Deuce";
			}
			return sameScore(score);
		}
		if (isAdv()) {
			return "Advantage " + advPlayer();
		}
		if (isWin()) {
			return "Win for " + advPlayer();
		}

//		if (player1ScoreTimes != player2ScoreTimes) {
//			for (int i = 1; i < 3; i++) {
//				if (i == 1) {
//					tempScore = player1ScoreTimes;
//				} else {
//					score += "-";
//					tempScore = player2ScoreTimes;
//				}
//				String tempMessage = "";
//				tempMessage = translateScore(tempScore);
//				score += tempMessage;
//			}
//		}
		return translateScore(player1ScoreTimes)+ "-" + translateScore(player2ScoreTimes);
//		return score;
	}

	private boolean isWin() {
		return isReadyForGamePoint() && abs(player1ScoreTimes - player2ScoreTimes) >= 2;
	}

	private boolean isAdv() {
		return isReadyForGamePoint() && abs(player1ScoreTimes - player2ScoreTimes) == 1;
	}

	private String advPlayer() {
		return player1ScoreTimes> player2ScoreTimes ? "player1" : "player2";
	}

	private boolean isReadyForGamePoint() {
		return player1ScoreTimes >= 4 || player2ScoreTimes >= 4;
	}

	private boolean isDeuce() {
		return isTie() && player1ScoreTimes >= 3;
	}

	private String sameScore(String score) {
		return translateScore(player1ScoreTimes) + "-All";
	}

	private String translateScore(int player1ScoreTimes) {
		return player1ScoreTimes <= 3 ? scoreLookup.get(player1ScoreTimes) : "";
	}

	private boolean isTie() {
		return player1ScoreTimes == player2ScoreTimes;
	}
}
