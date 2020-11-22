
package org.jhotdraw.draw;
import java.awt.Component;
import org.mockito.BDDMockito.Then;
import static org.assertj.core.api.Assertions.assertThat;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

/**
 *
 * @author mkkl
 */
public class ThenISeeTextArea extends Stage<ThenISeeTextArea> {
    
    @ExpectedScenarioState
    protected DefaultDrawingView defaultDrawingView;
    
    public ThenISeeTextArea iSeeTextArea() {
        Component component = defaultDrawingView.getComponent();
        assertThat(component).isNotNull();
        return self();
    }
}