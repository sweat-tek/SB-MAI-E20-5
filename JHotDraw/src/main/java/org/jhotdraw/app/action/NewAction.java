/*
 * @(#)NewAction.java  1.3  2007-11-30
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

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import org.jhotdraw.gui.Worker;
import org.jhotdraw.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.*;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.app.View;

/**
 * Creates a new view.
 *
 * @author Werner Randelshofer
 * @version 1.3 2007-11-30 Call method clear on a worker thread. 
 * <br>1.2 2006-02-22 Support for multiple open id added.
 * <br>1.1.1 2005-07-14 Make view explicitly visible after creating it.
 * <br>1.1 2005-07-09 Place new view relative to current one.
 * <br>1.0  04 January 2005  Created.
 */
public class NewAction extends AbstractApplicationAction {
    public final static String ID = "file.new";
    
    /** Creates a new instance. */
    public NewAction(Application app) {
        super(app);
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        labels.configureAction(this, ID);
    }

    @FeatureEntryPoint(JHotDrawFeatures.MANAGE_DRAWINGS)
    public void actionPerformed(ActionEvent evt) {
        Application app = getApplication();
        int multipleOpeningId = getMultipleOpeningId(app);
        createNewView(app, multipleOpeningId);
    }

    private void createNewView(Application app, int multipleOpeningId){
        final View newView = app.createView();
        newView.setMultipleOpenId(multipleOpeningId);
        app.add(newView);
        newView.execute(newView::clear);
        app.show(newView);
    }

    private int getMultipleOpeningId(Application app){
        IntStream multipleOpeningIds = app.views().stream().flatMapToInt(v -> IntStream.of(v.getMultipleOpenId()));
        return multipleOpeningIds.max().orElse(1);
    }
}
