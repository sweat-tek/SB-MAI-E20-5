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
    Point2D.Double[] fourPointPolygonCoordinates;

    @ProvidedScenarioState
    BezierPath figure = new BezierPath();

    public WhenPolygonDrawn polygon_drawn(){
        //Ensure that the constructor for BezierPath does not return null
        assertThat(figure).isNotNull();
        //Add points
        for (int i = 0; i < 4; i++){
            figure.addPoint(fourPointPolygonCoordinates[i].getX(), fourPointPolygonCoordinates[i].getY());
        }
        assertThat(figure.size()).isNotZero();
        figure.setClosed(true);
        return this;
    }
}
