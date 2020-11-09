package org.jhotdraw.samples.svg.figures;

import org.jhotdraw.draw.DrawingView;
import org.junit.Assert;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.mockito.Mockito.*;

public class SVGBezierFigureTest {

    SVGPathFigure mockPathFigure;
    SVGBezierFigure mockSVGBezierFigure;

    @org.junit.Before
    public void setUp() {
        mockSVGBezierFigure = mock(SVGBezierFigure.class, RETURNS_DEEP_STUBS);
        mockPathFigure = mock(SVGPathFigure.class);
    }

    @org.junit.Test
    public void applyInverseTransformToPoint() {
        Point2D.Double point = new Point2D.Double(1.1, 2.2);
        Point2D.Double p;
        try {
            Method method = SVGBezierFigure.class.getDeclaredMethod("applyInverseTransformToPoint", Point2D.Double.class);
            method.setAccessible(true);
            p = (Point2D.Double) method.invoke(new SVGBezierFigure(false), point);
            Assert.assertEquals(p, point);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void handleMouseClickCase1() {
        //Data points
        DrawingView mockDrawingView = mock(DrawingView.class);
        MouseEvent mockMouseEvent = mock(MouseEvent.class);
        Point2D.Double mockP = mock(Point2D.Double.class);
        when(mockSVGBezierFigure.handleMouseClick(any(), any(), any())).thenCallRealMethod();

        //Single click
        when(mockMouseEvent.getClickCount()).thenReturn(1);
        Assert.assertFalse("handleMouseClick incorrectly handled single click", mockSVGBezierFigure.handleMouseClick(mockP, mockMouseEvent, mockDrawingView));
    }

    @org.junit.Test
    public void handleMouseClickCase2() {
        //Data points
        DrawingView mockDrawingView = mock(DrawingView.class);
        MouseEvent mockMouseEvent = mock(MouseEvent.class);
        Point2D.Double mockP = mock(Point2D.Double.class);
        when(mockSVGBezierFigure.handleMouseClick(any(), any(), any())).thenCallRealMethod();
        //TODO: Make this work - verify(mockSVGBezierFigure).willChange();
        //Double click
        when(mockMouseEvent.getClickCount()).thenReturn(2);
        when(mockDrawingView.getScaleFactor()).thenReturn(1d);
        when(mockSVGBezierFigure.splitSegment(mockP, 5f)).thenReturn(-1);
        Assert.assertFalse("handleMouseClick incorrectly handled splitting", mockSVGBezierFigure.handleMouseClick(mockP, mockMouseEvent, mockDrawingView));
    }

    @org.junit.Test
    public void handleMouseClickCase3() {
        //Data points
        DrawingView mockDrawingView = mock(DrawingView.class);
        MouseEvent mockMouseEvent = mock(MouseEvent.class);
        Point2D.Double mockP = mock(Point2D.Double.class);
        when(mockSVGBezierFigure.handleMouseClick(any(), any(), any())).thenCallRealMethod();
        //TODO: Make this work - verify(mockSVGBezierFigure).willChange();
        //Double click
        when(mockMouseEvent.getClickCount()).thenReturn(2);
        when(mockDrawingView.getScaleFactor()).thenReturn(1d);
        Assert.assertTrue("handleMouseClick incorrectly handled splitting", mockSVGBezierFigure.handleMouseClick(mockP, mockMouseEvent, mockDrawingView));
    }

}