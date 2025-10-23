package racingcar;

import java.util.ArrayList;
import java.util.List;

import racingcar.entity.Car;
import racingcar.entity.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
	private final InputView inputView;
	private final OutputView outputView;

	public RacingGame(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		Cars cars = createCars();
		int racingCount = inputView.readRacingCount();

		playRacing(cars, racingCount);
		announceWinners(cars);
	}

	private Cars createCars() {
		List<String> carNames = inputView.readCarNames();
		List<Car> carList = new ArrayList<>();

		for (String name : carNames) {
			carList.add(new Car(name));
		}

		return new Cars(carList);
	}

	private void playRacing(Cars cars, int racingCount) {
		outputView.printResultMessage();

		for (int i = 0; i < racingCount; i++) {
			playRound(cars);
		}
	}

	private void playRound(Cars cars) {
		cars.moveAll();
		outputView.printRoundResult(cars.getCarInfos());
	}

	private void announceWinners(Cars cars) {
		List<String> winners = cars.findWinnerNames();
		outputView.printWinners(winners);
	}
}
