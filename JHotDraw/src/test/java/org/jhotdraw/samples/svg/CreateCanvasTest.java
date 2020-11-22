/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author kasper
 */
public class CreateCanvasTest extends ScenarioTest<IfCanvasIsWhite, CanvasChangeColorToBlue, ThenCanvasIsBlue> {

    @Test
    public void CanvasTest() {
        System.out.println("Acceptance test for changing background color");

        given().NewCanvasWithFillColorWhite();
        when().canvasChangeToBlue();
        then().canvasIsBlue();
    }

}
