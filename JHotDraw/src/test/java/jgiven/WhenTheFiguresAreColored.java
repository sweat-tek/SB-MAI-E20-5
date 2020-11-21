/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgiven;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.Color;
import java.util.HashMap;
import java.util.Set;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.action.AttributeAction;
import org.jhotdraw.draw.action.EditorColorChooserAction;

public class WhenTheFiguresAreColored extends Stage<WhenTheFiguresAreColored> {
    
        @ExpectedScenarioState
        DefaultDrawingEditor dde = new DefaultDrawingEditor();
        
        @ExpectedScenarioState
        Set<Figure> figureSet;
        
    public WhenTheFiguresAreColored colorFigures() {
        //Imitating choosing a color form the colorChooser
        HashMap<AttributeKey, Object> attr = new HashMap<AttributeKey, Object>();
        attr.put(AttributeKeys.FILL_COLOR, Color.blue);
        
        //Making an editor to conduct the coloring of the figure
        AttributeAction editorColorChooserAction = new EditorColorChooserAction(dde, AttributeKeys.FILL_COLOR);
        editorColorChooserAction.applyAttributesTo(attr, figureSet);
        
        return self();
    }
}
