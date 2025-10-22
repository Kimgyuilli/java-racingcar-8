package racingcar.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public List<String> readCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String input = Console.readLine();
		return parseCarNames(input);
	}

	private List<String> parseCarNames(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
		}

		List<String> names = Arrays.stream(input.split(","))
			.map(String::trim)
			.filter(name -> !name.isEmpty())
			.toList();

		if (names.isEmpty()) {
			throw new IllegalArgumentException("최소 1대의 자동차가 필요합니다.");
		}

		return names;
	}

	public int readRacingCount() {
		System.out.println("시도할 횟수는 몇 회인가요?");
		try {
			int input = Integer.parseInt(Console.readLine());
			validateRacingCount(input);
			return input;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
		}
	}

	private void validateRacingCount(int count) {
		if (count <= 0) {
			throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
		}
	}
}
