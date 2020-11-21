package org.jhotdraw.app.action;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.jhotdraw.app.action.steps.GivenApplication;
import org.jhotdraw.app.action.steps.ThenExited;
import org.jhotdraw.app.action.steps.WhenExit;
import org.junit.Test;

public class ExitApplicationScenarioTest extends ScenarioTest<GivenApplication, WhenExit, ThenExited> {
    @Test
    public void the_application_with_open_windows_can_be_exited() {
        given().the_application_is_running().
                and().the_application_has_open_windows();
        when().the_user_clicks_the_exit_button();
        then().the_application_is_exited();
    }
}
