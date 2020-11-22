package org.jhotdraw.draw;

import java.awt.event.MouseEvent;

import static org.junit.jupiter.api.Assertions.*;

class SelectionToolTest {

    @org.junit.jupiter.api.Test
    void mouseClicked() {
        SelectionTool tool = new SelectionTool();
        MouseEvent event = new MouseEvent();
        tool.mouseClicked(event);
    }
}