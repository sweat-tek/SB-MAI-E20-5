/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import com.tngtech.jgiven.junit.ScenarioTest;


/**
 *
 * @author RasmusThomsen
 */
public class ImageAcceptanceTest extends ScenarioTest<GivenAnImageFile, 
                                        WhenInserted, ThenImageIsLoaded>  {
    
    @Test
    public void insertImageTest() {
        given().anImage();
        when().imageIsInserted();
        then().imageIsInJhotdraw();
    }
}
