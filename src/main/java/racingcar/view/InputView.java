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
		return Arrays.stream(input.split(","))
			.map(String::trim)
			.toList();
	}

	public int readRacingCount() {
		System.out.println("시도할 횟수는 몇 회인가요?");
		String input = Console.readLine();
		return parseRacingCount(input);
	}

	private int parseRacingCount(String input) {
		try {
			int count = Integer.parseInt(input);
			validateRacingCount(count);
			return count;
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
