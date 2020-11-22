package org.jhotdraw.integration_tests.bezier;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;


import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class GivenPolygonPoints extends Stage<GivenPolygonPoints> {

    @ProvidedScenarioState
    Point2D.Double[] fourPointPolygonCoordinates = new Point2D.Double[4];

    public GivenPolygonPoints first_point(){
        fourPointPolygonCoordinates[0] = new Point2D.Double(10d, 10d);
        return this;
    }
    public GivenPolygonPoints second_point(){
        fourPointPolygonCoordinates[1] = new Point2D.Double(20d, 10d);
        return this;
    }
    public GivenPolygonPoints third_point(){
        fourPointPolygonCoordinates[2] = new Point2D.Double(20d, 20d);
        return this;
    }
    public GivenPolygonPoints fourth_point(){
        fourPointPolygonCoordinates[3] = new Point2D.Double(10d, 20d);
        return this;
    }

}
