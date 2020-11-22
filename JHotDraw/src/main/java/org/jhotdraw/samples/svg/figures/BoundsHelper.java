package org.jhotdraw.samples.svg.figures;

import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.Gradient;

import java.awt.geom.*;

import static org.jhotdraw.samples.svg.SVGAttributeKeys.FILL_GRADIENT;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.STROKE_GRADIENT;

class BoundsHelper
{
    static void addBounds(Figure figure, AffineTransform tx)
    {
        Point2D.Double anchor = figure.getStartPoint();
        Point2D.Double lead = figure.getEndPoint();
        figure.setBounds((Point2D.Double) tx.transform(anchor, anchor), (Point2D.Double) tx.transform(lead, lead));
        if (FILL_GRADIENT.get(figure) != null && !FILL_GRADIENT.get(figure).isRelativeToFigureBounds())
        {
            Gradient g = FILL_GRADIENT.getClone(figure);
            g.transform(tx);
            FILL_GRADIENT.basicSet(figure, g);
        }
        if (STROKE_GRADIENT.get(figure) != null && !STROKE_GRADIENT.get(figure).isRelativeToFigureBounds())
        {
            Gradient g = STROKE_GRADIENT.getClone(figure);
            g.transform(tx);
            STROKE_GRADIENT.basicSet(figure, g);
        }
    }
}
