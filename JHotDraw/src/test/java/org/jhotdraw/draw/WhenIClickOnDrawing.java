
package org.jhotdraw.draw;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.event.MouseEvent;
import org.jhotdraw.samples.svg.figures.SVGTextAreaFigure;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

/**
 *
 * @author mkkl
 */
public class WhenIClickOnDrawing extends Stage<WhenIClickOnDrawing> {

    @ProvidedScenarioState
    protected TextHolderFigure textfigure;
    protected TextAreaCreationTool textAreaTool;
    protected FloatingTextArea textarea;

    @ExpectedScenarioState
    protected DefaultDrawingView defaultDrawingView;

    public WhenIClickOnDrawing iClickOnDrawing() {
        textAreaTool = new TextAreaCreationTool(new SVGTextAreaFigure());
        DefaultDrawingEditor editor = mock(DefaultDrawingEditor.class);
        Mockito.when(editor.getActiveView()).thenReturn(defaultDrawingView);
        Mockito.when(editor.findView(any())).thenReturn(defaultDrawingView);
        textAreaTool.editor = editor;
        textAreaTool.setToolDoneAfterCreation(true);
        textAreaTool.setRubberbandColor(Color.BLACK);
        textAreaTool.mousePressed(getMouseEvent(10, 10));
        return self();
    }

    private MouseEvent getMouseEvent(int x, int y) {
        MouseEvent mouseEventMock = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEventMock.getPoint()).thenReturn(new Point(x, y));
        Mockito.when(mouseEventMock.getY()).thenReturn(y);
        Mockito.when(mouseEventMock.getX()).thenReturn(x);
        Mockito.when(mouseEventMock.getSource()).thenReturn(defaultDrawingView);
        //Mockito.when(defaultDrawingView.viewToDrawing(new Point(x,y))).thenReturn(new Point2D.Double(x,y));
        return mouseEventMock;
    }
}