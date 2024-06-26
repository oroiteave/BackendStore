package backendTests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import online_store.entities.User;
import online_store.entities.impl.DefaultUser;
import online_store.util.Validator;
import online_store.util.impl.DefaultValidator;

public class ValidatorTest {

	private Validator testInstance;
	private User user;
	
	@BeforeEach
	void setUp() {
		testInstance = new DefaultValidator();
	}

	@Test
	void shouldValidateFirstNameWithoutAnyNumbersWithLatinCharsOnly() {
		user = new DefaultUser("Oroi", "Teave", "password", "email@email.com");

		assertTrue(testInstance.isValid(user));
	}

	@Test
	void shouldFailValidationFirstNameWithDigits() {
		user = new DefaultUser("Oroi1", "Teave", "password", "email@email.com");
		assertFalse(testInstance.isValid(user));
	}

	@Test
	void shouldValidateLastNameWithoutAnyNumbersWithLatinCharsOnly() {
		user = new DefaultUser("Oroi", "Teave", "password", "email@email.com");

		assertTrue(testInstance.isValid(user));
	}

	@Test
	void shouldFailValidationLastNameWithDigits() {
		user = new DefaultUser("Oroi", "Teave1", "password", "email@email.com");
		assertFalse(testInstance.isValid(user));
	}

	@Test
	void shouldValidateEmailWithAtCharacter() {
		user = new DefaultUser("Oroi", "Teave", "password", "email@email.com");

		assertTrue(testInstance.isValid(user));
	}

	@Test
	void shouldFailValidationEmailWithoutAtCharacter() {
		user = new DefaultUser("Oroi", "Teave", "password", "email-email.com");

		assertFalse(testInstance.isValid(user));
	}
}
