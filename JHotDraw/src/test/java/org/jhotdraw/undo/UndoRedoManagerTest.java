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

/**
 *
 * @author ahashmathivathan
 */
public class UndoRedoManagerTest {

    @Test
    public void testUndo() {
        System.out.println("undo");
        UndoRedoManager instance = new UndoRedoManager();
        instance.undo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of redo method, of class UndoRedoManager.
     */
    @Test
    public void testRedo() {
        System.out.println("redo");
        UndoRedoManager instance = new UndoRedoManager();
        instance.redo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
