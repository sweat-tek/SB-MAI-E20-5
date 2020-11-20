/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.QuadTreeDrawing;

/**
 *
 * @author rodsur
 */
public class GivenFigureToClone extends Stage<GivenFigureToClone>{
    
    @ProvidedScenarioState
    private DrawingEditor editor;
    
    @BeforeStage
    private void before(){
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
    }
    
    GivenFigureToClone someSelectedFigure(){
        SVGRectFigure f1 = new SVGRectFigure(6, 6, 3, 3);
        editor.getActiveView().getDrawing().add(f1);
        return this;
    }
    
}
