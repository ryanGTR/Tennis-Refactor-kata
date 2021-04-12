import java.util.HashMap;

import static java.lang.Math.abs;

public class TennisGame2 implements TennisGame {
	private final HashMap<Integer, String> scoreLookup =
							new HashMap<Integer, String>() {
								{
									put(1, "Fifteen");
									put(2, "Thirty");
									put(3, "Forty");
									put(0, "Love");
								}
							};
	private final String firstPlayerName;
	private final String secondPlayerName;
	public int firstPlayerScoreTimes = 0;
	public int secondPlayerScoreTimes = 0;
	private String score = "";

	public TennisGame2(String firstPlayerName, String secondPlayerName) {
		this.firstPlayerName = firstPlayerName;
		this.secondPlayerName = secondPlayerName;
	}

	public String getScore() {
		if (isSameScore()) {
			score = isDeuce() ? "Deuce" : sameScore();
		}
		if (isScoreDifferent()) {
			score = showScoreMessage();
		}

		if (isAdv()) {
			score = advState();
		}

		if (isWin()) {
			score = winState();
		}

		return score;
	}

	private String winState() {
		return "Win for " + advPlayer();
	}

	private String advState() {
		return "Advantage " + advPlayer();
	}

	private boolean isWin() {
		return (firstPlayerScoreTimes >= 4 || secondPlayerScoreTimes >= 4)
								&& abs(firstPlayerScoreTimes - secondPlayerScoreTimes) >= 2;
	}

	private String advPlayer() {
		return firstPlayerScoreTimes > secondPlayerScoreTimes ? "player1" : "player2";
	}

	private boolean isAdv() {
		return (firstPlayerScoreTimes > 3 || secondPlayerScoreTimes > 3)
								&& abs(firstPlayerScoreTimes - secondPlayerScoreTimes) == 1;
	}

	private boolean isScoreDifferent() {
		return firstPlayerScoreTimes != secondPlayerScoreTimes;
	}

	private boolean isDeuce() {
		return firstPlayerScoreTimes >= 3;
	}

	private String sameScore() {
		return scoreLookup.get(firstPlayerScoreTimes) + "-All";
	}

	private boolean isSameScore() {
		return firstPlayerScoreTimes == secondPlayerScoreTimes;
	}

	private String showScoreMessage() {
		return scoreLookup.get(firstPlayerScoreTimes) + "-" + scoreLookup.get(secondPlayerScoreTimes);
	}

	public void wonPoint(String player) {
		if (player == "player1") firstPlayerScoreTimes++;
		else secondPlayerScoreTimes++;
	}
}
