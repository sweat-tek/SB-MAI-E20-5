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
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Rami
 */
public class ThenFiguresAreArranged extends Stage<ThenFiguresAreArranged> {
    @ExpectedScenarioState
    QuadTreeDrawing quadTreeDrawing;
    @ExpectedScenarioState
    Figure fig1;
    
    public ThenFiguresAreArranged figuresAreArranged(){
        assertTrue(quadTreeDrawing.getChildren().indexOf(fig1) == quadTreeDrawing.getChildren().size() - 1);
        return this;
    }
}


