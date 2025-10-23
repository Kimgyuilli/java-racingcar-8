package racingcar.view;

import java.util.List;

import racingcar.domain.CarDto;

public class OutputView {
	public void printResultMessage() {
		System.out.println();
		System.out.println("실행 결과");
	}

	public void printRoundResult(List<CarDto> cars) {
		for (CarDto car : cars) {
			printCarPosition(car);
		}
		System.out.println();
	}

	private void printCarPosition(CarDto car) {
		System.out.println(car.name() + " : " + generatePositionDisplay(car.position()));
	}

	private String generatePositionDisplay(int position) {
		return "-".repeat(position);
	}

	public void printWinners(List<String> winners) {
		System.out.println("최종 우승자 : " + String.join(", ", winners));
	}
}
