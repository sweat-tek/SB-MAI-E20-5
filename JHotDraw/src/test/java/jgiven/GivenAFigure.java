/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgiven;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.util.HashSet;
import java.util.Set;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;

public class GivenAFigure extends Stage<GivenAFigure> {
    
        //Instantiating the EditorColorChooserAction class
        @ProvidedScenarioState
        DefaultDrawingEditor dde = new DefaultDrawingEditor();
        
        @ProvidedScenarioState
        Set<Figure> figureSet;
        
        @ProvidedScenarioState
        BezierFigure bf;
        
    
    public GivenAFigure aFigure() {
        
        //It needs a view
        DrawingView drawingView = new DefaultDrawingView();
        //The view needs a drawing
        Drawing drawing = new DefaultDrawing();
        drawingView.setDrawing(drawing);
        
        //Applying the active view
        dde.setActiveView(drawingView);
        
        //Imitating selected figure
        bf = new BezierFigure();
        figureSet = new HashSet<>();
        figureSet.add(bf);
        return self();
    }
}
