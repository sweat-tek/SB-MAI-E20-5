package org.jhotdraw.integration_tests.bezier;

import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.samples.svg.PathTool;
import org.jhotdraw.samples.svg.figures.SVGBezierFigure;
import org.jhotdraw.samples.svg.figures.SVGPathFigure;

import java.util.HashMap;

public class scribbleTest extends ScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutcome> {

    PathTool scribbleTool = getScribbleTool();



    private PathTool getScribbleTool(){
        HashMap<AttributeKey, Object> attributes = new HashMap<>();
        attributes.put(AttributeKeys.FILL_COLOR, null);
        attributes.put(AttributeKeys.CLOSED, false);
        return new PathTool(new SVGPathFigure(), new SVGBezierFigure(false), attributes);
    }
}
