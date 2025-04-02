package com.practicalunittesting.chp03.money;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Practical Unit Testing with JUnit and Mockito - source code for examples.
 * Visit http://practicalunittesting.com for more information.
 *
 * @author Tomek Kaczanowski
 */
public class MoneyParameterizedTest {

	private static Stream<Arguments> getMoney() {
		return Stream.of(
				arguments(10, "USD"),
				arguments(20, "EUR")
		);
	}

	@ParameterizedTest
	@MethodSource("getMoney")
	public void constructorShouldSetAmountAndCurrency(int amount, String currency) {
		Money money = new Money(amount, currency);
		assertThat(money.getAmount()).isEqualTo(amount);
		assertThat(money.getCurrency()).isEqualTo(currency);
	}

}




































