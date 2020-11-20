/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;

/**
 *
 * @author Rami
 */
public class GivenTwoOrMoreFigures extends Stage<GivenTwoOrMoreFigures>{
    
    @ProvidedScenarioState
    QuadTreeDrawing quadTreeDrawing;
    @ProvidedScenarioState
    Figure fig1;
    
    public GivenTwoOrMoreFigures twoOrMoreFigures(){
        createFigures();
        return this;
    }
    
    private QuadTreeDrawing createFigures(){
        quadTreeDrawing = new QuadTreeDrawing();
        fig1 = new SVGRectFigure();
        Figure fig2 = new SVGRectFigure();
        Figure fig3 = new SVGRectFigure();
        
        quadTreeDrawing.basicAdd(fig1);
        quadTreeDrawing.basicAdd(fig2);
        quadTreeDrawing.basicAdd(fig3);
        
        return quadTreeDrawing;
    }
}

