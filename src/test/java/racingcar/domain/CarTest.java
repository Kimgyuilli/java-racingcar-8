package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

	@Test
	@DisplayName("정상적인 이름으로 자동차를 생성한다")
	void createCarWithValidName() {
		// given & when
		Car car = new Car("pobi");

		// then
		assertThat(car.getName()).isEqualTo("pobi");
		assertThat(car.getPosition()).isZero();
	}

	@Test
	@DisplayName("null 이름으로 자동차 생성 시 예외가 발생한다")
	void createCarWithNullName() {
		// when & then
		assertThatThrownBy(() -> new Car(null))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 이름은 빈 칸일 수 없습니다");
	}

	@Test
	@DisplayName("빈 문자열 이름으로 자동차 생성 시 예외가 발생한다")
	void createCarWithEmptyName() {
		// when & then
		assertThatThrownBy(() -> new Car(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 이름은 빈 칸일 수 없습니다");
	}

	@ParameterizedTest
	@ValueSource(strings = {" ", "  ", "   "})
	@DisplayName("공백만 있는 이름으로 자동차 생성 시 예외가 발생한다")
	void createCarWithBlankName(String name) {
		// when & then
		assertThatThrownBy(() -> new Car(name))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 이름은 빈 칸일 수 없습니다");
	}

	@Test
	@DisplayName("5자를 초과하는 이름으로 자동차 생성 시 예외가 발생한다")
	void createCarWithTooLongName() {
		// when & then
		assertThatThrownBy(() -> new Car("kimgyuilli"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차 이름은 5자 이하만 가능합니다");
	}

	@Test
	@DisplayName("이동 조건을 만족하면 자동차가 전진한다")
	void moveForward() {
		// given
		Car car = new Car("pobi");

		// when
		car.tryMove(4);

		// then
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	@DisplayName("이동 조건을 만족하지 않으면 자동차가 정지한다")
	void stop() {
		// given
		Car car = new Car("pobi");

		// when
		car.tryMove(3);

		// then
		assertThat(car.getPosition()).isZero();
	}

	@Test
	@DisplayName("여러 번 시도하면 위치가 누적된다")
	void moveMultipleTimes() {
		// given
		Car car = new Car("pobi");

		// when
		car.tryMove(4);
		car.tryMove(5);
		car.tryMove(3);
		car.tryMove(9);

		// then
		assertThat(car.getPosition()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	@DisplayName("랜덤 값이 4 이상이면 자동차가 전진한다")
	void tryMoveWhenValueIsGreaterThanOrEqualTo4(int randomValue) {
		// given
		Car car = new Car("pobi");

		// when
		car.tryMove(randomValue);

		// then
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3})
	@DisplayName("랜덤 값이 4 미만이면 자동차가 정지한다")
	void tryMoveWhenValueIsLessThan4(int randomValue) {
		// given
		Car car = new Car("pobi");

		// when
		car.tryMove(randomValue);

		// then
		assertThat(car.getPosition()).isZero();
	}
}
