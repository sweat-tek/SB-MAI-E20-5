
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RasmusThomsen
 */
public class GivenAnImageFile extends Stage<GivenAnImageFile> {

    @ProvidedScenarioState
    File file;
    
    public GivenAnImageFile anImage() {
            String path = "src/test/Ressources/ER.jpg"; 
            file = new File(path);
            file = new File(file.getAbsolutePath());
            return this;
        }
    }
