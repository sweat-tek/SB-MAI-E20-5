package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class CreateEllipseTest extends ScenarioTest<GivenCanvas, WhenEllipse,
        ThenEllipseOnCanvas>
{
    @Test
    public void ellipseDrawingTest()

    {
        System.out.println("Acceptance test for drawing an ellipse");

        given().canvasIsEmpty();
        when().ellipseisCreated();
        then().ellipseIsOnCanvas();
    }

}
