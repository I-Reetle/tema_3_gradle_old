package com.practicalunittesting.chp03.money;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Practical Unit Testing with JUnit and Mockito - source code for examples.
 * Visit http://practicalunittesting.com for more information.
 *
 * @author Tomek Kaczanowski
 */
public class MoneyIAETest {

	private final static int VALID_AMOUNT = 5;
	private final static String VALID_CURRENCY = "USD";

	private static Stream<Integer> getInvalidAmount() {
		return Stream.of(-12387, -5, -1);
	}

	@ParameterizedTest
	@MethodSource("getInvalidAmount")
	public void constructorShouldThrowIAEForInvalidAmount(Integer invalidAmount) {
		assertThatThrownBy(() -> new Money(invalidAmount, VALID_CURRENCY))
				.isInstanceOf(IllegalArgumentException.class);
	}

	private static Stream<String> getInvalidCurrency() {
		return Stream.of(null, "");
		// does not work with $(null, ""); - maybe fixed in newer JUnitParams
	}

	@ParameterizedTest
	@MethodSource("getInvalidCurrency")
	public void constructorShouldThrowIAEForInvalidCurrency(String invalidCurrency) {
		assertThatThrownBy(() -> new Money(VALID_AMOUNT, invalidCurrency))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
