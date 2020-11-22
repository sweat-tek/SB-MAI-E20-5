/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Collection;
import org.jhotdraw.draw.ConnectionFigure;
import org.jhotdraw.draw.Connector;
import org.jhotdraw.draw.Handle;
import org.jhotdraw.geom.Dimension2DDouble;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rodsur
 */
public class SVGRectFigureTest {
    
    public SVGRectFigureTest() {
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

    /**
     * Test of clone method, of class SVGRectFigure.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        SVGRectFigure instance = new SVGRectFigure(8, 6, 6.5, 3.3);
        SVGRectFigure expResult = instance;
        SVGRectFigure result = instance.clone();
        assertNotEquals(expResult, result);
        assertTrue(expResult.getHeight() == result.getHeight());
        assertTrue(expResult.getWidth() == result.getWidth());
        assertTrue(expResult.getX() == result.getX());
        assertTrue(expResult.getY() == result.getY());
    }
}
