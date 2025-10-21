package racingcar.view;

import java.util.List;

import racingcar.entity.Car;

public class OutputView {
	public void printResultMessage() {
		System.out.println();
		System.out.println("실행 결과");
	}

	public void printRoundResult(List<Car> cars) {
		for (Car car : cars) {
			printCarPosition(car);
		}
		System.out.println();
	}

	private void printCarPosition(Car car) {
		System.out.println(car.getName() + " : " + generatePositionDisplay(car.getPosition()));
	}

	private String generatePositionDisplay(int position) {
		return "-".repeat(position);
	}

	public void printWinners(List<String> winners) {
		System.out.println("최종 우승자 : " + String.join(", ", winners));
	}
}
