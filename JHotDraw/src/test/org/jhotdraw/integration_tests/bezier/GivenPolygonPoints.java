package org.jhotdraw.integration_tests.bezier;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import java.awt.geom.Point2D;

public class GivenPolygonPoints extends Stage<GivenPolygonPoints> {

    @ProvidedScenarioState
    Point2D.Double p1;
    @ProvidedScenarioState
    Point2D.Double p2;
    @ProvidedScenarioState
    Point2D.Double p3;
    @ProvidedScenarioState
    Point2D.Double p4;

    public GivenPolygonPoints first_point(){
        p1 = new Point2D.Double(10d, 10d);
        return this;
    }
    public GivenPolygonPoints second_point(){
        p2 = new Point2D.Double(20d, 10d);
        return this;
    }
    public GivenPolygonPoints third_point(){
        p3 = new Point2D.Double(20d, 20d);
        return this;
    }
    public GivenPolygonPoints fourth_point(){
        p4 = new Point2D.Double(10d, 20d);
        return this;
    }

}
