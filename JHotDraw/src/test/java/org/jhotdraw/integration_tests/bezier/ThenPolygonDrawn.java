package org.jhotdraw.integration_tests.bezier;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.geom.BezierPath;

import static org.assertj.core.api.Assertions.assertThat;

public class ThenPolygonDrawn extends Stage<ThenPolygonDrawn> {
    @ExpectedScenarioState
    BezierPath figure;

    public ThenPolygonDrawn the_polygon_figure_created(){
        //Assert that it is not only a path but a closed figure
        assertThat(figure.isClosed()).isTrue();
        return this;
    }

}
