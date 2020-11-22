/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import org.jhotdraw.samples.svg.figures.SVGEllipseFigure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author John
 */
public class SVGEllipseFigureTest
{


    public SVGEllipseFigureTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void clone_createIdenticalClone()
    {
        SVGEllipseFigure ellipseFigure = new SVGEllipseFigure(2, 3, 4, 5);
        SVGEllipseFigure ellipseClone;

        ellipseClone = ellipseFigure.clone();

        //Asserts that the dimensions of the two objects are the same
        assertEquals(ellipseClone.getWidth(), ellipseFigure.getWidth(), 0);
        assertEquals(ellipseClone.getHeight(), ellipseFigure.getHeight(), 0);
        //Asserts that the objects are not the same
        assertNotSame(ellipseClone, ellipseFigure);
    }

}