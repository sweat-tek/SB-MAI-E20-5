package org.jhotdraw.app.action;

import org.jhotdraw.app.Application;
import org.junit.After;
import org.junit.Before;

import java.beans.PropertyChangeListener;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

public class AbstractActionTest {

    public Application mockApplication;

    @Before
    public void setUpApplication() {
        mockApplication = mock(Application.class);
        doNothing().when(mockApplication).addPropertyChangeListener(any(PropertyChangeListener.class));
    }

    @After
    public void tearDownApplication() {
        mockApplication = null;
    }
}
