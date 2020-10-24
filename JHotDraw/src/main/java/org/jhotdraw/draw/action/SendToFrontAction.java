/*
 * @(#)SendToFrontAction.java  2.0  2008-05-30
 *
 * Copyright (c) 2003-2008 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */
package org.jhotdraw.draw.action;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import org.jhotdraw.util.*;
import javax.swing.*;
import java.util.*;
import javax.swing.undo.*;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.draw.*;

/**
 * ToFrontAction.
 *
 * @author Werner Randelshofer
 * @version 2.0 2008-05-30 Renamed from MoveToFrontAction to SendToFrontAction
 * for consistency with the API of Drawing.
 * <br>1.0 24. November 2003 Created.
 */
public class SendToFrontAction extends AbstractSelectedAction {

    public static String ID = "edit.bringToFront";

    /**
     * Creates a new instance.
     */
    public SendToFrontAction(DrawingEditor editor) {
        super(editor);
        labels.configureAction(this, ID);
    }

    @FeatureEntryPoint(JHotDrawFeatures.ARRANGE)
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        final DrawingView view = getView();
        final LinkedList<Figure> figures = new LinkedList<Figure>(view.getSelectedFigures());
        sendToFront(view, figures);
        fireUndoableEditHappened(setupUndoableEditOverrides(view, figures));
    }

    public AbstractUndoableEdit setupUndoableEditOverrides(DrawingView view, Collection figures) {
        AbstractUndoableEdit undoableEdit = new AbstractUndoableEdit() {
            @Override
            public String getPresentationName() {
                System.out.println("Undoable Edit from send to front, label: " + ID + " " + labels.getTextProperty(ID));
                return labels.getTextProperty(ID);
            }

            @Override
            public void redo() throws CannotRedoException {
                super.redo();
                SendToFrontAction.sendToFront(view, figures);
            }

            @Override
            public void undo() throws CannotUndoException {
                super.undo();
                SendToBackAction.sendToBack(view, figures);
            }
        };
        return undoableEdit;
    }

    public static void sendToFront(DrawingView view, Collection<Figure> figures) {
        Drawing drawing = view.getDrawing();
        Iterator i = drawing.sort(figures).iterator();
        while (i.hasNext()) {
            Figure figure = (Figure) i.next();
            drawing.bringToFront(figure);
        }
    }

}
