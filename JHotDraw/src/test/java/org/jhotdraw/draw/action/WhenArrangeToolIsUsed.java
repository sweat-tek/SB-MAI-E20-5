/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;

/**
 *
 * @author Rami
 */
public class WhenArrangeToolIsUsed extends Stage<WhenArrangeToolIsUsed> {

    @ExpectedScenarioState
    QuadTreeDrawing quadTreeDrawing;
    @ExpectedScenarioState
    Figure fig1;

    public WhenArrangeToolIsUsed arrangeToolIsUsed() {
        performArrange();
        return this;
    }

    public void performArrange() {
        
        quadTreeDrawing.bringToFront(fig1);
    }
}
