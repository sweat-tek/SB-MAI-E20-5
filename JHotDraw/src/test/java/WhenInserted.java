
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jhotdraw.samples.svg.figures.SVGImageFigure;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RasmusThomsen
 */
public class WhenInserted extends Stage<WhenInserted> {
        
        @ProvidedScenarioState
        SVGImageFigure sif;
        
        @ExpectedScenarioState
        File file;
        
        public WhenInserted imageIsInserted() {
            sif = new SVGImageFigure();
            try {
                sif.loadImage(file);
            } catch (IOException ex) {
                Logger.getLogger(WhenInserted.class.getName()).log(Level.SEVERE, null, ex);
            }
            return this;
        }
    }
