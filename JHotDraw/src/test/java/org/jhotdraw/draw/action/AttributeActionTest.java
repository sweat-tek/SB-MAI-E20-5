/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.DefaultDrawing;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 *
 * @author joach
 */
public class AttributeActionTest {
    
    public AttributeActionTest() {
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

    //Specifically applying color
    @Test
    public void testApplyAttributesTo() {
        //Instantiating the EditorColorChooserAction class
        DefaultDrawingEditor dde = new DefaultDrawingEditor();
        //It needs a view
        DrawingView drawingView = new DefaultDrawingView();
        //The view needs a drawing
        Drawing drawing = new DefaultDrawing();
        drawingView.setDrawing(drawing);
        
        //Applying the active view
        dde.setActiveView(drawingView);

        AttributeAction editorColorChooserAction = new EditorColorChooserAction(dde, AttributeKeys.FILL_COLOR);
        
        //Imitating choosing a color form the colorChooser
        HashMap<AttributeKey, Object> attr = new HashMap<AttributeKey, Object>();
        attr.put(AttributeKeys.FILL_COLOR, Color.blue);
        
        //Imitating selected figures
        BezierFigure bf = new BezierFigure();
        Set<Figure> figureSet = Set.of(bf);
       
        editorColorChooserAction.applyAttributesTo(attr, figureSet);
        //assertEquals(true, true);
        assertEquals(bf.getAttribute(AttributeKeys.FILL_COLOR), Color.blue);
        
        
      
    }

 
    
}
