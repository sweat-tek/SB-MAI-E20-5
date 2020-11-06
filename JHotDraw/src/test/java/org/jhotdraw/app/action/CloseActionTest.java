package org.jhotdraw.app.action;

import org.jhotdraw.app.Application;
import org.jhotdraw.app.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.beans.PropertyChangeListener;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CloseActionTest extends AbstractSaveBeforeActionTest{

    CloseAction closeAction;

    @Before
    public void setUp() {
        closeAction = new CloseAction(mockApplication);
    }

    @After
    public void tearDown(){
        closeAction = null;
    }

    @Test
    public void testDoItNull(){
        closeAction.doIt(null);
    }

    @Test
    public void testDoItApplicationNull(){
        View view = mock(View.class);
        doReturn(null).when(view).getApplication();
        closeAction.doIt(view);
    }

    @Test
    public void testDoIt(){
        View view = mock(View.class);
        doNothing().when(mockApplication).dispose(view);
        doReturn(mockApplication).when(view).getApplication();
        closeAction.doIt(view);
        verify(mockApplication).dispose(view);
    }
}
