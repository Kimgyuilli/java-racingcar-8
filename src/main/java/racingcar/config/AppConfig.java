package racingcar.config;

import racingcar.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
	private final RacingGame racingGame;

	public AppConfig() {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		racingGame = new RacingGame(inputView, outputView);
	}

	public RacingGame getRacingGame() {
		return racingGame;
	}
}
