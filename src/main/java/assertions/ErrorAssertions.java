package assertions;

import models.FailModel;

import static utils.SerchingIntoList.messageSearching;

public class ErrorAssertions extends AbstractAssertions {
    private FailModel actual;

    public ErrorAssertions(FailModel actual) {
        super(actual);
        this.actual = actual;
    }

    public ErrorAssertions hasBadInputErrorMessage(String expected) {
        messageSearching(actual, expected);
        return this;

    }

}
