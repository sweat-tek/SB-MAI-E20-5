/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.Color;
import static org.jhotdraw.draw.AttributeKeys.CANVAS_FILL_COLOR;
import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.draw.Drawing;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author kasper
 */
public class IfCanvasIsWhite extends Stage<IfCanvasIsWhite> {

    @ExpectedScenarioState
    public Drawing drawing;

    @BeforeStage
    private void before() {
        drawing = new DefaultDrawing();
    }

    IfCanvasIsWhite NewCanvasWithFillColorWhite() {
        assertTrue(CANVAS_FILL_COLOR.get(drawing) == Color.white);
        return this;
    }
}
