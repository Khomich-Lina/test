package org.example.assertions;

import org.assertj.core.api.AbstractAssert;
import org.example.factory.PlayerModel;

import java.util.ArrayList;
import java.util.List;

public class PlayerModelAssertion extends AbstractAssert<PlayerModelAssertion, PlayerModel> {

    private final List<String> errors = new ArrayList<>();

    public PlayerModelAssertion(PlayerModel actual) {
        super(actual, PlayerModelAssertion.class);
    }

    public static PlayerModelAssertion assertThat(PlayerModel actual) {
        return new PlayerModelAssertion(actual);
    }

    public PlayerModelAssertion hasIdField() {
        isNotNull();
        if (actual.getId() == null) {
            errors.add("Expected id to be present but was null");
        }
        return this;
    }

    public PlayerModelAssertion hasAge(int expectedAge) {
        isNotNull();
        if (!isEqual(actual.getAge(), expectedAge)) {
            errors.add(String.format("Expected age: <%s> but was: <%s>", expectedAge, actual.getAge()));
        }
        return this;
    }


    public PlayerModelAssertion isEqualTo(PlayerModel expected) {
        isNotNull();

        assertFieldEquals("age", actual.getAge(), expected.getAge());
        assertFieldEquals("gender", actual.getGender(), expected.getGender());
        assertFieldEquals("login", actual.getLogin(), expected.getLogin());
        assertFieldEquals("password", actual.getPassword(), expected.getPassword());
        assertFieldEquals("role", actual.getRole(), expected.getRole());
        assertFieldEquals("screenName", actual.getScreenName(), expected.getScreenName());

        if (!errors.isEmpty()) {
            failWithMessage("Found the following errors: %s", String.join(", ", errors));
        }

        return this;
    }

    private void assertFieldEquals(String fieldName, Object actualValue, Object expectedValue) {
        if (!isEqual(actualValue, expectedValue)) {
            errors.add(String.format("Expected %s: <%s> but was: <%s>", fieldName, expectedValue, actualValue));
        }
    }

    private boolean isEqual(Object actualValue, Object expectedValue) {
        // Check if both values are null or equal
        return (actualValue == null && expectedValue == null) || (actualValue != null && actualValue.equals(expectedValue));
    }
}
