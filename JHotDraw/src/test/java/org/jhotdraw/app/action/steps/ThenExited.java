package org.jhotdraw.app.action.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import static org.assertj.core.api.Assertions.assertThat;

public class ThenExited extends Stage<ThenExited> {
    @ExpectedScenarioState
    Exception exception;

    public void the_application_is_exited(){
        assertThat(exception instanceof SecurityException);
        assertThat(exception.getMessage().equals("System.exit attempted and blocked."));
        System.setSecurityManager(null);
    }
}
