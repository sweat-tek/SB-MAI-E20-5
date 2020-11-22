package org.jhotdraw.app.action;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.View;
import org.jhotdraw.gui.Worker;
import org.junit.*;

import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class NewActionTest extends AbstractActionTest {
    private NewAction newAction;

    @Before
    public void setUp() {
        newAction = new NewAction(mockApplication);
    }

    @After
    public void tearDown(){
        newAction = null;
    }

    @Test
    public void testGetMultipleOpeningIdEmpty() {
        doReturn(new ArrayList<View>()).when(mockApplication).views();
        try {
            Method method = NewAction.class.getDeclaredMethod("getMultipleOpeningId", Application.class);
            method.setAccessible(true);
            int multipleOpeningId = (int) method.invoke(newAction, mockApplication);
            assertEquals(1, multipleOpeningId);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetMultipleOpeningIdFilled() {
        Collection<View> views = new ArrayList<>();
        View view1 = mock(View.class);
        doReturn(1).when(view1).getMultipleOpenId();
        View view2 = mock(View.class);
        doReturn(2).when(view2).getMultipleOpenId();
        View view3 = mock(View.class);
        doReturn(3).when(view3).getMultipleOpenId();
        views.add(view1);
        views.add(view2);
        views.add(view3);
        doReturn(views).when(mockApplication).views();
        try {
            Method method = NewAction.class.getDeclaredMethod("getMultipleOpeningId", Application.class);
            method.setAccessible(true);
            int multipleOpeningId = (int) method.invoke(newAction, mockApplication);
            assertEquals(3, multipleOpeningId);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testCreateNewView(){
        View view = mock(View.class);
        doNothing().when(view).setMultipleOpenId(1);
        doNothing().when(view).execute(any(Worker.class));
        doNothing().when(view).clear();
        doReturn(view).when(mockApplication).createView();
        doNothing().when(mockApplication).add(view);
        doNothing().when(mockApplication).show(view);

        try {
            Method method = NewAction.class.getDeclaredMethod("createNewView", Application.class, int.class);
            method.setAccessible(true);
            method.invoke(newAction, mockApplication, 1);

            verify(mockApplication).createView();
            verify(view).setMultipleOpenId(1);
            verify(mockApplication).add(view);
            verify(view).execute(any());
            verify(mockApplication).show(view);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            fail(e.getMessage());
        }
    }
}
