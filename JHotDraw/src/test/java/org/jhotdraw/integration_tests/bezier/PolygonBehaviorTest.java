package org.jhotdraw.integration_tests.bezier;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class PolygonBehaviorTest extends ScenarioTest<GivenPolygonPoints, WhenPolygonDrawn, ThenPolygonDrawn> {

    @Test
    public void points_made_into_closed_path(){
        given().first_point()
                .and()
                .second_point()
                .and()
                .third_point()
                .and()
                .fourth_point();

        when().polygon_drawn();

        then().the_polygon_figure_created();
    }
}
