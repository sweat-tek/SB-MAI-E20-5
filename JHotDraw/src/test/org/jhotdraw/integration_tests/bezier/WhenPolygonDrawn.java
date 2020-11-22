package org.jhotdraw.integration_tests.bezier;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.geom.BezierPath;
import org.jhotdraw.samples.svg.PathTool;
import org.jhotdraw.samples.svg.figures.SVGBezierFigure;
import org.jhotdraw.samples.svg.figures.SVGPathFigure;
import org.junit.Assert;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenPolygonDrawn extends Stage<WhenPolygonDrawn> {
    @ExpectedScenarioState
    Point2D.Double p1;
    @ExpectedScenarioState
    Point2D.Double p2;
    @ExpectedScenarioState
    Point2D.Double p3;
    @ExpectedScenarioState
    Point2D.Double p4;

    @ProvidedScenarioState
    BezierPath figure = new BezierPath();

    public WhenPolygonDrawn polygon_drawn(){
        //Ensure that the constructor for BezierPath does not return null
        assertThat(figure).isNotNull();
        //Add points
        List<Point2D.Double> listOfPoints = new ArrayList<>();
        listOfPoints.add(p1);
        listOfPoints.add(p2);
        listOfPoints.add(p3);
        listOfPoints.add(p4);
        for (Point2D.Double point : listOfPoints) {
            figure.addPoint(point.getX(), point.getY());
        }
        figure.setClosed(true);
        return this;
    }
}
