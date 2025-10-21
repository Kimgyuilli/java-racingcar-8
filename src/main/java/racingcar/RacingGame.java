package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.entity.Car;
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
		List<Car> cars = createCars();
		int racingCount = inputView.readRacingCount();

		playRacing(cars, racingCount);
		announceWinners(cars);
	}

	private List<Car> createCars() {
		List<String> carNames = inputView.readCarNames();
		List<Car> cars = new ArrayList<>();

		for (String name : carNames) {
			cars.add(new Car(name));
		}

		return cars;
	}

	private void playRacing(List<Car> cars, int racingCount) {
		outputView.printResultMessage();

		for (int i = 0; i < racingCount; i++) {
			playRound(cars);
		}
	}

	private void playRound(List<Car> cars) {
		for (Car car : cars) {
			int randomValue = Randoms.pickNumberInRange(0, 9);
			car.move(randomValue);
		}
		outputView.printRoundResult(cars);
	}

	private void announceWinners(List<Car> cars) {
		List<String> winners = findWinners(cars);
		outputView.printWinners(winners);
	}

	private List<String> findWinners(List<Car> cars) {
		int maxPosition = findMaxPosition(cars);
		return getCarNamesAtPosition(cars, maxPosition);
	}

	private int findMaxPosition(List<Car> cars) {
		int maxPosition = 0;

		for (Car car : cars) {
			if (car.getPosition() > maxPosition) {
				maxPosition = car.getPosition();
			}
		}

		return maxPosition;
	}

	private List<String> getCarNamesAtPosition(List<Car> cars, int position) {
		List<String> winners = new ArrayList<>();

		for (Car car : cars) {
			if (car.getPosition() == position) {
				winners.add(car.getName());
			}
		}

		return winners;
	}
}
