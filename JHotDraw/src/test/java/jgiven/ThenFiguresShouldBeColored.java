/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgiven;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.Color;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.BezierFigure;
import static org.junit.Assert.assertEquals;

public class ThenFiguresShouldBeColored extends Stage<ThenFiguresShouldBeColored> {
    
    @ExpectedScenarioState
    BezierFigure bf;
    
    
    public ThenFiguresShouldBeColored figuresAreColored() {
        assertEquals(bf.getAttribute(AttributeKeys.FILL_COLOR), Color.blue);
        return self();
    }
}
