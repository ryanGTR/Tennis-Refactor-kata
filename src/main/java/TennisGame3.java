import static java.lang.Math.abs;

public class TennisGame3 implements TennisGame {

	private final String[] scoreLookup = new String[] {"Love", "Fifteen", "Thirty", "Forty"};
	private int secondPlayerScoreTimes;
	private int firstPlayerScoreTimes;
	private String firstPlayerName;
	private String secondPlayerName;
	private String score;

	public TennisGame3(String firstPlayerName, String secondPlayerName) {
		this.firstPlayerName = firstPlayerName;
		this.secondPlayerName = secondPlayerName;
	}

	public String getScore() {
		return isScore()
								? isSameScore() ? sameScore() : scoreDifferent()
								: isDeuce() ? deuce() : isAdv() ? advState() : winState();
	}

	private String scoreDifferent() {
		return scoreLookup[firstPlayerScoreTimes] + "-" + scoreLookup[secondPlayerScoreTimes];
	}

	private String sameScore() {
		return scoreLookup[firstPlayerScoreTimes] + "-All";
	}

	private boolean isScore() {
		return firstPlayerScoreTimes < 4 && secondPlayerScoreTimes < 4 && !(isDeuce());
	}

	private boolean isAdv() {
		return abs(firstPlayerScoreTimes - secondPlayerScoreTimes) == 1;
	}

	private String winState() {
		return "Win for " + getAdvPlayer();
	}

	private String advState() {
		return "Advantage " + getAdvPlayer();
	}

	private String getAdvPlayer() {
		return firstPlayerScoreTimes > secondPlayerScoreTimes ? firstPlayerName : secondPlayerName;
	}

	private String deuce() {
		return "Deuce";
	}

	private boolean isDeuce() {
		return isSameScore() && firstPlayerScoreTimes >= 3;
	}

	private boolean isSameScore() {
		return firstPlayerScoreTimes == secondPlayerScoreTimes;
	}

	public void wonPoint(String playerName) {
		if (playerName == "player1") this.firstPlayerScoreTimes += 1;
		else this.secondPlayerScoreTimes += 1;
	}
}
