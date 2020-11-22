/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import org.jhotdraw.app.action.CopyAction;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Gamborg
 */
public class CopyActionUnitTest {
    
    public CopyActionUnitTest() {
    }

    @Test
    public void testID() {
        CopyAction ca = new CopyAction();
        String ID = ca.ID;
        String editCopy = "edit.copy";
        Assert.assertEquals(ID,editCopy);
    }

   
}
