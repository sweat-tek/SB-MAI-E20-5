/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.Color;
import static org.jhotdraw.draw.AttributeKeys.CANVAS_FILL_COLOR;
import org.jhotdraw.draw.Drawing;

/**
 *
 * @author kasper
 */
public class CanvasChangeColorToBlue extends Stage<CanvasChangeColorToBlue> {

    
    @ProvidedScenarioState
    private Drawing drawing;


    CanvasChangeColorToBlue canvasChangeToBlue() {
        CANVAS_FILL_COLOR.set(drawing, Color.blue);
        return this;
    }
}
