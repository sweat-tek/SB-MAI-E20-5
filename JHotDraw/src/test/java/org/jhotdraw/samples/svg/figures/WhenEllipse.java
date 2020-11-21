package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.*;
import org.jhotdraw.draw.*;

public class WhenEllipse extends Stage<WhenEllipse>
{
    @ExpectedScenarioState
    private DrawingEditor editor;
    @ProvidedScenarioState
    Figure ellipse;

    WhenEllipse ellipseisCreated(){
        ellipse = new SVGEllipseFigure(2, 3, 4, 5);
        editor.getActiveView().getDrawing().add(ellipse);
        return this;
    }
}
