package racingcar.domain;

public class Car {
	private static final int MAX_NAME_LENGTH = 5;
	private static final int MOVE_THRESHOLD = 4;

	private final String name;
	private int position;

	public Car(String name) {
		validateName(name);
		this.name = name;
		this.position = 0;
	}

	public void tryMove(int randomValue) {
		if (randomValue >= MOVE_THRESHOLD) {
			position++;
		}
	}

	private void validateName(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("자동차 이름은 빈 칸일 수 없습니다.");
		}
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
		}
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
