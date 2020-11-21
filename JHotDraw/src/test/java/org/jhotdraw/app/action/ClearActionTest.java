package org.jhotdraw.app.action;

import org.jhotdraw.app.AbstractApplication;
import org.jhotdraw.app.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ClearActionTest extends AbstractSaveBeforeActionTest {

    private ClearAction clearAction;

    public ClearActionTest() {
        super(new CloseAction(null));
    }

    @Before
    public void setUp() {
        clearAction = new ClearAction(mockApplication);
    }

    @After
    public void tearDown(){
        clearAction = null;
    }

    @Test
    public void testDoIt(){
        View view = mock(View.class);
        clearAction.doIt(view);
        verify(view).setEnabled(false);
        verify(view).execute(any(AbstractApplication.ClearViewWorker.class));
    }

}
