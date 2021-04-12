import java.util.HashMap;

import static java.lang.Math.abs;

public class TennisGame1 implements TennisGame {

	private final HashMap<Integer, String> scoreLookup =
							new HashMap<Integer, String>() {
								{
									put(0, "Love");
									put(1, "Fifteen");
									put(2, "Thirty");
									put(3, "Forty");
								}
							};
	private final int tempScore = 0;
	private final String firstPlayerName;
	private final String secondPlayerName;
	private int firstPlayerScoreTimes = 0;
	private int secondPlayerScoreTimes = 0;
	private String score = "";

	public TennisGame1(String firstPlayerName, String secondPlayerName) {
		this.firstPlayerName = firstPlayerName;
		this.secondPlayerName = secondPlayerName;
	}

	public void wonPoint(String playerName) {
		if (playerName == "player1") firstPlayerScoreTimes += 1;
		else secondPlayerScoreTimes += 1;
	}

	public String getScore() {
		if (isSameScore()) {
			score = isDeuce() ? getDeuce() : getSameScore();
		} else if (isReadyForGamePoint()) {
			score = isAdv() ? advState() : isWin() ? winState() : "";
		} else {
			score = scoreDifferent();
		}
		return score;
	}

	private String scoreDifferent() {
		int tempScore1;
		for (int i = 1; i < 3; i++) {
			if (i == 1) tempScore1 = firstPlayerScoreTimes;
			else {
				score += "-";
				tempScore1 = secondPlayerScoreTimes;
			}
			score += scoreLookup.get(tempScore1);
		}
		return score;
	}

	private String winState() {
		return "Win for " + getAdvPlayer();
	}

	private String advState() {
		return "Advantage " + getAdvPlayer();
	}

	private boolean isWin() {
		return abs(pointRange()) >= 2;
	}

	private boolean isAdv() {
		return abs(pointRange()) == 1;
	}

	private String getSameScore() {
		return scoreLookup.get(firstPlayerScoreTimes) + "-All";
	}

	private String getDeuce() {
		return "Deuce";
	}

	private boolean isDeuce() {
		return firstPlayerScoreTimes >= 3;
	}

	private boolean isSameScore() {
		return firstPlayerScoreTimes == secondPlayerScoreTimes;
	}

	private boolean isReadyForGamePoint() {
		return firstPlayerScoreTimes >= 4 || secondPlayerScoreTimes >= 4;
	}

	private int pointRange() {
		return firstPlayerScoreTimes - secondPlayerScoreTimes;
	}

	private String getAdvPlayer() {
		return firstPlayerScoreTimes > secondPlayerScoreTimes ? "player1" : "player2";
	}
}
