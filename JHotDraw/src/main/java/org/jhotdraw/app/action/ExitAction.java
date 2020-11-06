/*
 * @(#)ExitAction.java  1.0  04 January 2005
 *
 * Copyright (c) 1996-2006 by the original authors of JHotDraw
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
import org.jhotdraw.gui.*;
import org.jhotdraw.gui.Worker;
import org.jhotdraw.gui.event.*;
import org.jhotdraw.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

import org.jhotdraw.app.Application;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.app.View;
/**
 * Exits the application after letting the user review all unsaved views.
 *
 * @author  Werner Randelshofer
 * @version 1.0  04 January 2005  Created.
 */
public class ExitAction extends AbstractSaveBeforeAction {
    public final static String ID = "application.exit";

    /** Creates a new instance. */
    public ExitAction(Application app) {
        super(app);
        labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        labels.configureAction(this, ID);
    }

    @FeatureEntryPoint(JHotDrawFeatures.MANAGE_DRAWINGS)
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (!app.isEnabled()) {
            return;
        }
        app.setEnabled(false);
        List<View> unsavedViews = getUnsavedViews();
        List<View> unsavedAndEnabledViews = unsavedViews
                .stream()
                .filter(View::isEnabled)
                .collect(Collectors.toList());
        if(shouldSaveAndClose()){
            saveAndClose(unsavedAndEnabledViews);
        } else {
            app.setEnabled(true);
        }
    }

    protected boolean shouldSaveAndClose(){
        List<View> unsavedViews = getUnsavedViews();
        List<View> unsavedAndEnabledViews = unsavedViews
                .stream()
                .filter(View::isEnabled)
                .collect(Collectors.toList());
        return unsavedViews.isEmpty() || !unsavedAndEnabledViews.isEmpty();
    }

    protected void saveAndClose(List<View> unsavedAndEnabledViews){
        if (unsavedAndEnabledViews.isEmpty()){
            doExit();
        } else {
            for (View p : unsavedAndEnabledViews){
                p.setEnabled(false);
                showSavePromt(p);
            }
        }
    }

    protected void doExit() {
        getApplication().stop();
        System.exit(0);
    }

    protected List<View> getUnsavedViews(){
        Stream<View> views = getApplication().views().stream();
        Stream<View> viewsWithUnsavedChanges = views.filter(View::hasUnsavedChanges);
        return viewsWithUnsavedChanges.collect(Collectors.toList());
    }

    @Override
    protected void doIt(View view) {
        if (view != null && view.getApplication() != null) {
            view.getApplication().dispose(view);
        }
        if (getUnsavedViews().isEmpty()){
            doExit();
        }
    }
}
