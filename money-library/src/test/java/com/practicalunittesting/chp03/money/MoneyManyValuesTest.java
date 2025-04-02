package com.practicalunittesting.chp03.money;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Practical Unit Testing with JUnit and Mockito - source code for examples.
 * Visit http://practicalunittesting.com for more information.
 *
 * @author Tomek Kaczanowski
 */
public class MoneyManyValuesTest {

	@Test
	public void testConstructor() {
		Money money = new Money(10, "USD");
		assertThat(money.getAmount()).isEqualTo(10);
		assertThat(money.getCurrency()).isEqualTo("USD");

		money = new Money(20, "EUR");
		assertThat(money.getAmount()).isEqualTo(20);
		assertThat(money.getCurrency()).isEqualTo("EUR");
	}

}
