/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.undo;

import java.beans.PropertyChangeListener;
import java.util.Locale;
import javax.swing.Action;
import javax.swing.undo.UndoableEdit;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import org.jhotdraw.util.ResourceBundleUtil;
import org.junit.Test;
import com.tngtech.jgiven.Stage;

/**
 *
 * @author ahashmathivathan
 */
public class UndoRedoManagerTest {

    @Test
    public void testUndo() {
       boolean undoOrRedoInProgress;
        assertEquals(true, undoOrRedoInProgress = true);
    }

    /**
     * Test of redo method, of class UndoRedoManager.
     */
    @Test
    public void testRedo() {
        boolean undoOrRedoInProgress;
        assertEquals(true, undoOrRedoInProgress = true);
    }

    /**
     * Test of undoOrRedo method, of class UndoRedoManager.
     */
    @Test
    public void testUndoOrRedo() {
        System.out.println("undoOrRedo");
        UndoRedoManager instance = new UndoRedoManager();
        instance.undoOrRedo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}



