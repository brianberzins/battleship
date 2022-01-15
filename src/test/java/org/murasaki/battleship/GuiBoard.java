package org.murasaki.battleship;

import com.spun.swing.Paintable;
import com.spun.swing.SwingUtils;
import org.lambda.actions.Action0;

import java.awt.*;

class GuiBoard extends Board implements Paintable {

    private static final int CELL_SIZE = 40;

    @Override
    public Dimension getSize() {
        return new Dimension(CELL_SIZE * (SIZE + 1) + 1, CELL_SIZE * (SIZE + 1) + 1);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, CELL_SIZE * (SIZE + 1), CELL_SIZE * (SIZE + 1));
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                paintCell(x, y, graphics);
            }
        }
        drawFiredUponCoordinates(graphics, firedUponCoordinates);
        labelAxis(graphics);
    }

    void drawFiredUponCoordinates(Graphics graphics, java.util.List<Coordinate> coordinates) {
        graphics.setColor(Color.RED);
        Font previousFont = graphics.getFont();
        graphics.setFont(new Font("default", Font.BOLD, previousFont.getSize() * 2));
        for (Coordinate coordinate : coordinates) {
            SwingUtils.drawCenteredString(graphics, "X", (coordinate.x + 1) * CELL_SIZE + CELL_SIZE / 2, (coordinate.y + 1) * CELL_SIZE + CELL_SIZE / 2);
        }
        graphics.setFont(previousFont);
    }

    void labelAxis(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        for (int i = 0; i < SIZE; i++) {
            SwingUtils.drawCenteredString(graphics, String.valueOf(i), (i + 1) * CELL_SIZE + CELL_SIZE / 2, CELL_SIZE / 2);
            SwingUtils.drawCenteredString(graphics, String.valueOf(i), CELL_SIZE / 2, (i + 1) * CELL_SIZE + CELL_SIZE / 2);
        }
    }

    void paintCell(int x, int y, Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.drawRect((x + 1) * CELL_SIZE, (y + 1) * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        Ship ship = getShipAt(new Coordinate(x, y));
        if (ship != null) {
            drawCell(x, y, graphics, ship.name().substring(0, 1));
        }
    }

    private void drawCell(int x, int y, Graphics g, String text) {
        g.setColor(Color.GRAY);
        g.fillRect((x + 1) * CELL_SIZE + 1, (y + 1) * CELL_SIZE + 1, CELL_SIZE - 1, CELL_SIZE - 1);
        g.setColor(Color.BLACK);
        SwingUtils.drawCenteredString(g, text, (x + 1) * CELL_SIZE + CELL_SIZE / 2, (y + 1) * CELL_SIZE + CELL_SIZE / 2);
    }

    @Override
    public void registerRepaint(Action0 repaint) {
    }
}
