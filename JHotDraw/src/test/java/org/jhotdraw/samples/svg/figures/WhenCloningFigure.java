/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DrawingEditor;

/**
 *
 * @author rodsur
 */
public class WhenCloningFigure extends Stage<WhenCloningFigure>{
    
    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;
    
    @ProvidedScenarioState
    private SVGRectFigure selectedFigure;

    @BeforeStage
    public void before() {
        if (editor.getActiveView().getDrawing().getChildren().get(0) instanceof SVGRectFigure){
            selectedFigure = (SVGRectFigure)editor.getActiveView().getDrawing().getChildren().get(0);
        }
    }
    
    public WhenCloningFigure cloningFigure() {
        editor.getActiveView().getDrawing().add(selectedFigure.clone());        
        return this;
    }
    
    
                
                
}
