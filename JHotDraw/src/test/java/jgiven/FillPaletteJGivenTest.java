/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgiven;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class FillPaletteJGivenTest
        extends ScenarioTest<GivenAFigure, WhenTheFiguresAreColored, ThenFiguresShouldBeColored> {
    
    
    @Test
    public void figureIsColored() {
        given().aFigure();
        when().colorFigures();
        then().figuresAreColored();
    }
}
