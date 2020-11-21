package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.*;

public class ThenEllipseOnCanvas extends Stage<ThenEllipseOnCanvas>
{
    @ExpectedScenarioState
    private DrawingEditor editor;
    @ExpectedScenarioState
    private Figure ellipse;

    ThenEllipseOnCanvas ellipseIsOnCanvas(){
        editor.getActiveView().getDrawing().add(ellipse);
        return this;
    }
}
