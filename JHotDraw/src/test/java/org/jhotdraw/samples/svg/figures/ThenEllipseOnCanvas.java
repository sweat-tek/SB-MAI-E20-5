package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.*;
import static org.junit.Assert.*;

public class ThenEllipseOnCanvas extends Stage<ThenEllipseOnCanvas>
{
    @ExpectedScenarioState
    private DrawingEditor editor;
    @ExpectedScenarioState
    private Figure ellipse;

    ThenEllipseOnCanvas ellipseIsOnCanvas(){
        assertTrue(editor.getActiveView().getDrawing().getChild(0) == ellipse);
        return this;
    }
}
