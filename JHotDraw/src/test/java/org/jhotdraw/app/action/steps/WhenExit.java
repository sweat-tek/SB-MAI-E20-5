package org.jhotdraw.app.action.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.action.ExitAction;

import java.security.Permission;

public class WhenExit extends Stage<WhenExit> {

    @ExpectedScenarioState
    Application app;

    @ProvidedScenarioState
    Exception exception;

    public WhenExit the_user_clicks_the_exit_button(){
        SecurityManager original = System.getSecurityManager();
        System.setSecurityManager(securityManager);

        try {
            new ExitAction(app).actionPerformed(null);
        } catch (Exception e){
            exception = e;
        }

        System.setSecurityManager(original);
        return this;
    }

    private SecurityManager securityManager = new SecurityManager() {
        public void checkPermission(Permission permission) {}
        public void checkExit(int status) {
            if (status == 0) {
                throw new SecurityException("System.exit attempted and blocked.");
            }
        }
    };
}
