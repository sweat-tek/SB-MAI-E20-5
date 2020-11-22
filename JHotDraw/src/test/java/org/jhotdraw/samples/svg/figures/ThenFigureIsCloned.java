/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author rodsur
 */
class ThenFigureIsCloned extends Stage<ThenFigureIsCloned> {

    @ExpectedScenarioState
    private DrawingEditor editor;

    ThenFigureIsCloned figureIsCloned() {

        if (editor.getActiveView().getDrawing().getChildren().get(0) instanceof SVGRectFigure
                && editor.getActiveView().getDrawing().getChildren().get(1) instanceof SVGRectFigure) {
            SVGRectFigure f1 = (SVGRectFigure) editor.getActiveView().getDrawing().getChildren().get(0);
            SVGRectFigure f2 = (SVGRectFigure) editor.getActiveView().getDrawing().getChildren().get(1);
            assertTrue(figuresAreEqual(f1, f2));
            return this;
        }
        assertTrue(false);
        return this;
        
    }

    private boolean figuresAreEqual(SVGRectFigure f1, SVGRectFigure f2) {
        return (f1 != f2 && f1.getHeight() == f2.getHeight() && f1.getWidth() == f2.getWidth() && f1.getX() == f2.getX() && f1.getY() == f2.getY());
    }
}
