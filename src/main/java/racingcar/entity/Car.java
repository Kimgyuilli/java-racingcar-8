package racingcar.entity;

public class Car {
	private final String name;
	private int position;

	public Car(String name) {
		validateName(name);
		this.name = name;
		this.position = 0;
	}

	private void validateName(String name) {
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException("자동차 이름은 빈 칸일 수 없습니다.");
		}
		if (name.length() > 5) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
		}
	}

	public void move(int randomValue) {
		if (randomValue >= 4) {
			position++;
		}
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
