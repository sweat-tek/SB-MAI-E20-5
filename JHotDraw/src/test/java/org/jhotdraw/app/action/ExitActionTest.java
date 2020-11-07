package org.jhotdraw.app.action;

import org.jhotdraw.app.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ExitActionTest extends AbstractSaveBeforeActionTest {

    private ExitAction exitAction;

    public ExitActionTest() {
        super(new ExitAction(null));
    }

    @Before
    public void setUp() {
        exitAction = new ExitAction(mockApplication);
    }

    @After
    public void tearDown(){
        exitAction = null;
    }

    @Test
    @Override
    public void testActionPerformedViewNotEnabled(){
        doReturn(false).when(mockApplication).isEnabled();
        action.actionPerformed(null);
        verify(mockApplication, times(0)).setEnabled(false);
    }

    @Test
    @Override
    public void testActionPerformedViewEnabled(){
        ExitAction mockAction = mock(ExitAction.class);
        mockAction.app = mockApplication;
        doReturn(true).when(mockApplication).isEnabled();
        doCallRealMethod().when(mockAction).actionPerformed(any());
        mockAction.actionPerformed(null);
        verify(mockAction).SaveAndCloseIfUnsaved();
    }
}
