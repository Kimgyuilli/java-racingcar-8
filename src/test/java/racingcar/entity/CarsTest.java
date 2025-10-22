package racingcar.entity;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarsTest {

	@Nested
	@DisplayName("우승자 찾기")
	class FindWinners {

		@Test
		@DisplayName("단독 우승자를 찾는다")
		void findSingleWinner() {
			// given
			Car car1 = new Car("pobi");
			Car car2 = new Car("woni");
			Car car3 = new Car("jun");

			car1.move(true);
			car1.move(true);
			car1.move(true);  // position: 3

			car2.move(true);
			car2.move(true);  // position: 2

			car3.move(true);  // position: 1

			Cars cars = new Cars(List.of(car1, car2, car3));

			// when
			List<String> winners = cars.findWinnerNames();

			// then
			assertThat(winners).hasSize(1);
			assertThat(winners).containsExactly("pobi");
		}

		@Test
		@DisplayName("공동 우승자를 찾는다 - 2명")
		void findTwoWinners() {
			// given
			Car car1 = new Car("pobi");
			Car car2 = new Car("woni");
			Car car3 = new Car("jun");

			car1.move(true);
			car1.move(true);
			car1.move(true);  // position: 3

			car2.move(true);
			car2.move(true);
			car2.move(true);  // position: 3

			car3.move(true);  // position: 1

			Cars cars = new Cars(List.of(car1, car2, car3));

			// when
			List<String> winners = cars.findWinnerNames();

			// then
			assertThat(winners).hasSize(2);
			assertThat(winners).containsExactlyInAnyOrder("pobi", "woni");
		}

		@Test
		@DisplayName("모든 자동차가 같은 위치면 모두 우승자다")
		void findAllWinnersWhenAllCarsHaveSamePosition() {
			// given
			Car car1 = new Car("pobi");
			Car car2 = new Car("woni");
			Car car3 = new Car("jun");

			car1.move(true);
			car1.move(true);  // position: 2

			car2.move(true);
			car2.move(true);  // position: 2

			car3.move(true);
			car3.move(true);  // position: 2

			Cars cars = new Cars(List.of(car1, car2, car3));

			// when
			List<String> winners = cars.findWinnerNames();

			// then
			assertThat(winners).hasSize(3);
			assertThat(winners).containsExactlyInAnyOrder("pobi", "woni", "jun");
		}

		@Test
		@DisplayName("아무도 움직이지 않으면 모두 우승자다")
		void findAllWinnersWhenNoCarsMove() {
			// given
			Car car1 = new Car("pobi");
			Car car2 = new Car("woni");
			Car car3 = new Car("jun");

			Cars cars = new Cars(List.of(car1, car2, car3));

			// when
			List<String> winners = cars.findWinnerNames();

			// then
			assertThat(winners).hasSize(3);
			assertThat(winners).containsExactlyInAnyOrder("pobi", "woni", "jun");
		}
	}
}
