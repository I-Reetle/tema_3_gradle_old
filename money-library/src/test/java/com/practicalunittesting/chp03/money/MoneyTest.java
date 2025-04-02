package com.practicalunittesting.chp03.money;

import org.junit.jupiter.api.Test;
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

public class MoneyTest {

	@Test
	public void constructorShouldSetAmountAndCurrency() {
		Money money = new Money(10, "USD");
		//Assert.assertEquals(10, money.getAmount());
		//assertEquals(15, money.getAmount());
		assertThat(money.getAmount())
				.withFailMessage("wrong amount of money")
				.isEqualTo(10);
		assertThat(money.getCurrency())
				.isEqualTo("USD");
	}

	private static Stream<Arguments> getMoney() {
		return Stream.of(
				arguments(new Money(4, "USD"), new Money(3, "USD"), 7),
				arguments(new Money(1, "EUR"), new Money(4, "EUR"), 5),
				arguments(new Money(1234, "CHF"), new Money(234, "CHF"), 1468)
		);
	}

	@ParameterizedTest
	@MethodSource("getMoney")
	public void shouldAddSameCurrencies(Money a, Money b, int expectedResult) {
		Money result = a.add(b);
		assertThat(result.getAmount()).isEqualTo(expectedResult);
	}

}
