package assertions;

import models.FailListModel;

import static utils.SerchingIntoList.messageIntoListSearching;

public class ErrorListAssertions extends AbstractAssertions {
    private FailListModel actual;



    public ErrorListAssertions(FailListModel actual) {
        super(actual);
        this.actual = actual;
    }

    public ErrorListAssertions hasNotExistErrorMessage(String expected) {
        messageIntoListSearching(actual, expected);
        return this;
    }


}
