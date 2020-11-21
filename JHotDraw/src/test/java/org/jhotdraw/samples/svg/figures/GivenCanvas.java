package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.*;
import org.jhotdraw.draw.*;
import static org.junit.Assert.*;

public class GivenCanvas extends Stage<GivenCanvas>
{
    @ProvidedScenarioState
    private DrawingEditor editor;

    @BeforeStage
    private void before() {
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
    }

    GivenCanvas canvasIsEmpty() {
        editor.getActiveView().getDrawing().removeAllChildren();
        assertTrue(editor.getActiveView().getDrawing().getChildCount() == 0);
        return this;
    }
}
