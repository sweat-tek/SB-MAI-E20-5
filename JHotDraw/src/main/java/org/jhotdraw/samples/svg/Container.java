/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg;

import java.awt.Component;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.prefs.Preferences;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author kasper
 */
public class Container implements ContainerListener {

    private javax.swing.JPanel toolsPane;
    private Preferences prefs;

    public Container(JPanel toolsPane, Preferences prefs) {
        this.toolsPane = toolsPane;
        this.prefs = prefs;
    }

    @Override
    public void componentAdded(ContainerEvent e) {
        int i = 0;
        for (Component c : toolsPane.getComponents()) {
            if (c instanceof JToolBar) {
                JToolBar tb = (JToolBar) c;
                prefs.putInt("toolBarIndex." + tb.getName(), i);
                i++;
            }
        }
    }

    @Override
    public void componentRemoved(ContainerEvent e) {
    }
}
