package org.murasaki.battleship;

import com.spun.swing.Paintable;
import com.spun.swing.SwingUtils;
import org.lambda.actions.Action0;

import java.awt.*;

class GuiBoard extends Board implements Paintable {

    private static final int CELL_SIZE = 40;

    @Override
    public Dimension getSize() {
        return new Dimension(CELL_SIZE * SIZE + 1, CELL_SIZE * SIZE + 1);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, CELL_SIZE * SIZE, CELL_SIZE * SIZE);
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                paintCell(x, y, graphics);
            }
        }
    }

    void paintCell(int x, int y, Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.drawRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        Ship ship = getShipAt(new Coordinate(x, y));
        if (ship != null) {
            drawCell(x, y, graphics, Color.GRAY, ship.name().substring(0, 1));
        }
    }

    private void drawCell(int x, int y, Graphics g, Color color, String text) {
        g.setColor(color);
        g.fillRect(x * CELL_SIZE + 1, y * CELL_SIZE + 1, CELL_SIZE - 1, CELL_SIZE - 1);
        g.setColor(Color.BLACK);
        SwingUtils.drawCenteredString(g, text, x * CELL_SIZE + CELL_SIZE / 2, y * CELL_SIZE + CELL_SIZE / 2);
    }

    @Override
    public void registerRepaint(Action0 repaint) {
    }
}
