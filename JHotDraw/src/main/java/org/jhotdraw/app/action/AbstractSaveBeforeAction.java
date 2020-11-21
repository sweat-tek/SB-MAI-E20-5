/*
 * @(#)AbstractSaveBeforeAction.java  2.0  2006-06-15
 *
 * Copyright (c) 1996-2007 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */
package org.jhotdraw.app.action;

import org.jhotdraw.gui.Worker;
import org.jhotdraw.io.*;
import org.jhotdraw.gui.*;
import org.jhotdraw.gui.event.*;
import org.jhotdraw.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.View;

/**
 * Base class for actions that can only be safely performed when a 
 * {@link org.jhotdraw.app.View} has no unsaved changes.
 * <p>
 * If the view has no unsaved changes, method doIt is invoked immediately.
 * If unsaved changes are present, a dialog is shown asking whether the user
 * wants to discard the changes, cancel or save the changes before doing it.
 * If the user chooses to discard the chanegs, toIt is invoked immediately.
 * If the user chooses to cancel, the action is aborted.
 * If the user chooses to save the changes, the view is saved, and doIt
 * is only invoked after the view was successfully saved.
 *
 * @author  Werner Randelshofer
 * @version 2.0 2006-06-15 Reworked. 
 * <br>1.2 2006-05-19 Make filename acceptable by ExtensionFileFilter.
 * <br>1.1 2006-05-03 Localized messages.
 * <br>1.0 27. September 2005 Created.
 */
public abstract class AbstractSaveBeforeAction extends AbstractViewAction {

    protected Component oldFocusOwner;
    protected ResourceBundleUtil labels;
    protected Application app;
    protected final String LABEL_SAVE_OPTION = "file.saveBefore.saveOption.text";
    protected final String LABEL_CANCEL_OPTION = "file.saveBefore.cancelOption.text";
    protected final String LABEL_DONT_SAVE_OPTION = "file.saveBefore.dontSaveOption.text";

    /** Creates a new instance. */
    public AbstractSaveBeforeAction(Application app) {
        super(app);
        this.app = app;
    }

    public void actionPerformed(ActionEvent evt) {
        labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        final View p = getActiveView();
        if (!p.isEnabled()) {
            return;
        }
        Window wAncestor = SwingUtilities.getWindowAncestor(p.getComponent());
        oldFocusOwner = (wAncestor == null) ? null : wAncestor.getFocusOwner();
        p.setEnabled(false);
        saveIfUnsavedChanges(p);
        p.setEnabled(true);
        returnFocusToOrigin();
    }

    protected void saveIfUnsavedChanges(View p){
        if (p.hasUnsavedChanges()) {
            showSavePromt(p);
        } else {
            doIt(p);
        }
    }

    protected void returnFocusToOrigin(){
        if (oldFocusOwner != null) {
            oldFocusOwner.requestFocus();
        }
    }

    protected JOptionPane getSavePromtPane(){
        JOptionPane pane = new JOptionPane(
                "<html>" + UIManager.getString("OptionPane.css") +
                        labels.getString("file.saveBefore.doYouWantToSave.message"),
                JOptionPane.WARNING_MESSAGE);
        Object[] options = {
                labels.getString(LABEL_SAVE_OPTION),
                labels.getString(LABEL_CANCEL_OPTION),
                labels.getString(LABEL_DONT_SAVE_OPTION)
        };
        pane.setOptions(options);
        pane.setInitialValue(options[0]);
        pane.putClientProperty("Quaqua.OptionPane.destructiveOption", 2);
        return pane;
    }

    protected void showSavePromt(View p){
        JSheet.showSheet(getSavePromtPane(), p.getComponent(), new SaveBeforeOptionSheetListener(p));
    }

    protected void saveChanges(final View p) {
        if (p.getFile() == null) {
            JFileChooser fileChooser = p.getSaveChooser();
            JSheet.showSaveSheet(fileChooser, p.getComponent(), new SaveLocationSheetListener(p));
        } else {
            saveToFile(p, p.getFile());
        }
    }

    protected void saveToFile(final View p, final File file) {
        p.execute(new SaveFileWorker(p, file));
    }

    protected void fileSaved(View p, File file, Object value) {
        if (value == null) {
            p.setFile(file);
            p.markChangesAsSaved();
            doIt(p);
        } else {
            showErrorPrompt(file, value);
        }
        p.setEnabled(true);
        returnFocusToOrigin();
    }

    protected void showErrorPrompt(File file, Object value){
        String message;
        if ((value instanceof Throwable) && ((Throwable) value).getMessage() != null) {
            message = ((Throwable) value).getMessage();
        } else {
            message = value.toString();
        }
        String promptMessage = "<html>" + UIManager.getString("OptionPane.css") +
                "<b>" + labels.getFormatted("file.saveBefore.couldntSave.message", file.getName()) + "</b><br>" +
                ((message == null) ? "" : message);
        JSheet.showMessageSheet(getActiveView().getComponent(), promptMessage, JOptionPane.ERROR_MESSAGE);
    }

    protected abstract void doIt(View p);

    protected class SaveBeforeOptionSheetListener implements SheetListener {
        private final View p;

        public SaveBeforeOptionSheetListener(View p) {
            this.p = p;
        }

        public void optionSelected(SheetEvent evt) {
            Object value = evt.getValue();
            if (value instanceof String){
                parseLabel((String) value);
            } else {
                p.setEnabled(true);
            }
        }

        private void parseLabel(String value){
            if (value.equals(labels.getString(LABEL_CANCEL_OPTION))) {
                p.setEnabled(true);
            } else if (value.equals(labels.getString(LABEL_DONT_SAVE_OPTION))) {
                doIt(p);
                p.setEnabled(true);
            } else if (value.equals(labels.getString(LABEL_SAVE_OPTION))) {
                saveChanges(p);
            }
        }

    }

    protected class SaveLocationSheetListener implements SheetListener {
        private final View p;

        public SaveLocationSheetListener(View p) {
            this.p = p;
        }

        public void optionSelected(final SheetEvent evt) {
            if (evt.getOption() == JFileChooser.APPROVE_OPTION) {
                final File file = getSelectedFile(evt);
                saveToFile(p, file);
            } else {
                p.setEnabled(true);
                returnFocusToOrigin();
            }
        }

        private File getSelectedFile(SheetEvent evt){
            if (evt.getFileChooser().getFileFilter() instanceof ExtensionFileFilter) {
                return ((ExtensionFileFilter) evt.getFileChooser().getFileFilter()).makeAcceptable(evt.getFileChooser().getSelectedFile());
            } else {
                return evt.getFileChooser().getSelectedFile();
            }
        }
    }

    private class SaveFileWorker extends Worker {

        private final View p;
        private final File file;

        public SaveFileWorker(View p, File file) {
            this.p = p;
            this.file = file;
        }

        public Object construct() {
            try {
                p.write(file);
                return null;
            } catch (IOException e) {
                return e;
            }
        }

        public void finished(Object value) {
            fileSaved(p, file, value);
        }
    }
}
