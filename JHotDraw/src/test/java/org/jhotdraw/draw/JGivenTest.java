
package org.jhotdraw.draw;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author mkkl
 */
public class JGivenTest extends ScenarioTest<GivenDrawingView, WhenIClickOnDrawing, ThenISeeTextArea> {
    
    @Test
    public void testTextArea(){
       given().drawing();
       when().iClickOnDrawing();
       then().iSeeTextArea();
    }
}
