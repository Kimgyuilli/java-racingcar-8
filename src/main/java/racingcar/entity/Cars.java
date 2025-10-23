package racingcar.entity;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		if (cars == null || cars.isEmpty()) {
			throw new IllegalArgumentException("최소 1대의 자동차가 필요합니다.");
		}
		this.cars = new ArrayList<>(cars);
	}

	public void moveAll() {
		for (Car car : cars) {
			int randomValue = Randoms.pickNumberInRange(0, 9);
			car.move(Car.shouldMove(randomValue));
		}
	}

	public List<String> findWinnerNames() {
		int maxPosition = findMaxPosition();
		return getCarNamesAtPosition(maxPosition);
	}

	public List<CarDto> getCarInfos() {
		return cars.stream()
			.map(car -> new CarDto(car.getName(), car.getPosition()))
			.toList();
	}

	private int findMaxPosition() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);
	}

	private List<String> getCarNamesAtPosition(int position) {
		return cars.stream()
			.filter(car -> car.getPosition() == position)
			.map(Car::getName)
			.toList();
	}
}
