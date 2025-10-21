package racingcar;

import racingcar.config.AppConfig;

public class Application {
	public static void main(String[] args) {
		AppConfig config = new AppConfig();
		RacingGame racingGame = config.getRacingGame();
		racingGame.run();
	}
}
