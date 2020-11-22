package org.jhotdraw.app.action.steps;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.View;

import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class GivenApplication extends Stage<GivenApplication> {
    @ProvidedScenarioState
    Application app = mock(Application.class);

    public GivenApplication the_application_is_running(){
        doReturn(true).when(app).isEnabled();
        doNothing().when(app).setEnabled(anyBoolean());
        doNothing().when(app).stop();
        return this;
    }

    public GivenApplication the_application_has_open_windows(){
        View v = mock(View.class);
        doReturn(false).when(v).hasUnsavedChanges();
        doReturn(true).when(v).isEnabled();
        List<View> views = new ArrayList<>();
        views.add(v);
        doReturn(views).when(app).views();
        return this;
    }
}
