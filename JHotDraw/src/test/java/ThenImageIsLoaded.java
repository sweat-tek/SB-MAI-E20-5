
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.io.File;
import org.jhotdraw.samples.svg.figures.SVGImageFigure;
import static org.junit.Assert.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RasmusThomsen
 */
public class ThenImageIsLoaded extends Stage<ThenImageIsLoaded> {
        
        @ExpectedScenarioState
        SVGImageFigure sif;
        
        public ThenImageIsLoaded imageIsInJhotdraw() {
            assertNotNull(sif.getImageData());
            return this;
        }
    }
