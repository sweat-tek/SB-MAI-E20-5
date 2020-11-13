/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import java.util.ArrayList;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rami
 */
public class SendToFrontActionTest {


    public SendToFrontActionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void bringingFigureToFront() {
        //Here i prepare what is responsible for arranging my figures.
        QuadTreeDrawing qtd = new QuadTreeDrawing();
        
        //I then create to SVGRectFigures here. The dimensions does not matter as I am only interrested
        //in the object reference and because the childrens list does not care about dimensions.
        Figure fig1 = new SVGRectFigure();
        Figure fig2 = new SVGRectFigure();
        Figure fig3 = new SVGRectFigure();
        //fig1  is added first meaning that fig2 will be added on top and therefore being the one in front.
        qtd.basicAdd(fig1);
        qtd.basicAdd(fig2);
        qtd.basicAdd(fig3);
        
        //Before bringing fig1 to the front
        assertTrue(qtd.getChildren().indexOf(fig1) == 0);

        //Now I call the method responsible for sending the figure to the front
        qtd.bringToFront(fig1);
        //After the call I assert that the figure has inded be placed in the front.
        //After bringing fig1 to the front
        assertTrue(qtd.getChildren().indexOf(fig1) == qtd.getChildren().size() - 1);
    }

}


