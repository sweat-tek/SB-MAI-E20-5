package org.jhotdraw.app.action;

import org.jhotdraw.app.Application;
import org.jhotdraw.app.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

import static junit.framework.TestCase.fail;
import static org.mockito.Mockito.*;

;

public abstract class AbstractSaveBeforeActionTest extends AbstractActionTest {

    public Class<AbstractSaveBeforeAction> actionClass;
    public AbstractSaveBeforeAction action;

    public AbstractSaveBeforeActionTest(AbstractSaveBeforeAction action){
        this.actionClass = (Class<AbstractSaveBeforeAction>) action.getClass();
    }

    @Before
    public void setUpActionClass(){
        try {
            action = actionClass.getConstructor(Application.class).newInstance(mockApplication);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            fail();
        }
    }

    @After
    public void tearDownActionClass(){
        action = null;
    }

    @Test
    public void testActionPerformedViewNotEnabled(){
        View view = mock(View.class);
        doReturn(false).when(view).isEnabled();
        doReturn(view).when(mockApplication).getActiveView();
        action.actionPerformed(null);
        verify(view, times(0)).getComponent();
    }

    @Test
    public void testActionPerformedViewEnabled(){
        AbstractSaveBeforeAction mockedAction =  mock(action.getClass());
        View view = mock(View.class);
        doReturn(true).when(view).isEnabled();
        doReturn(view).when(mockedAction).getActiveView();
        doCallRealMethod().when(mockedAction).saveIfUnsavedChanges(any());
        doCallRealMethod().when(mockedAction).returnFocusToOrigin();
        doCallRealMethod().when(mockedAction).actionPerformed(any());
        JComponent c = mock(JComponent.class);
        doReturn(null).when(c).getParent();
        doReturn(c).when(view).getComponent();
        mockedAction.actionPerformed(null);
        verify(mockedAction).saveIfUnsavedChanges(view);
    }

    @Test
    public void testSaveIfUnsavedChangesHasUnsaved(){
        AbstractSaveBeforeAction mockedAction =  mock(action.getClass());
        View view = mock(View.class);
        doReturn(true).when(view).hasUnsavedChanges();
        doCallRealMethod().when(mockedAction).saveIfUnsavedChanges(view);
        mockedAction.saveIfUnsavedChanges(view);
        verify(mockedAction).showSavePromt(view);
    }

    @Test
    public void testSaveIfUnsavedChangesHasNoUnsaved(){
        AbstractSaveBeforeAction mockedAction =  mock(action.getClass());
        View view = mock(View.class);
        doReturn(false).when(view).hasUnsavedChanges();
        doCallRealMethod().when(mockedAction).saveIfUnsavedChanges(view);
        mockedAction.saveIfUnsavedChanges(view);
        verify(mockedAction).doIt(view);
    }

    @Test
    public void testReturnFocusToOriginNull(){
        AbstractSaveBeforeAction mockedAction =  mock(action.getClass());
        doCallRealMethod().when(mockedAction).returnFocusToOrigin();
        mockedAction.oldFocusOwner = null;
        mockedAction.returnFocusToOrigin();
    }

    @Test
    public void testReturnFocusToOriginNotNull(){
        AbstractSaveBeforeAction mockedAction =  mock(action.getClass());
        doCallRealMethod().when(mockedAction).returnFocusToOrigin();
        Component c = mock(Component.class);
        mockedAction.oldFocusOwner = c;
        mockedAction.returnFocusToOrigin();
        verify(c).requestFocus();
    }

}
