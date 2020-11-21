
package org.jhotdraw.draw;
import java.util.HashMap;
import com.tngtech.jgiven.junit.ScenarioTest;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGTextAreaFigure;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author mkkl
 */
public class GivenDrawingView extends Stage<GivenDrawingView> {

    @ProvidedScenarioState
    protected DefaultDrawingView defaultDrawingView;  
    
    public GivenDrawingView drawing() {
        
        defaultDrawingView = new DefaultDrawingView();
        DefaultDrawing drawing = mock(DefaultDrawing.class);
        Mockito.when(drawing.findFigureInside(any())).thenReturn(new SVGTextAreaFigure());
        Mockito.when(drawing.getDrawingArea()).thenReturn(new Rectangle2D.Double(10,15,20,25));
        defaultDrawingView.setDrawing(drawing);
       
        return self();
    }
    
}
