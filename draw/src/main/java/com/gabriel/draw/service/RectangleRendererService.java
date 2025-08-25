package com.gabriel.draw.service;

import com.gabriel.draw.model.Rectangle;
import com.gabriel.drawfx.service.RendererService;
import com.gabriel.drawfx.model.Shape;

import java.awt.*;


public class RectangleRendererService implements RendererService {

    @Override
    public void render(Graphics g, Shape shape, boolean xor) {
        Rectangle rectangle = (Rectangle) shape;

        Point start = rectangle.getLocation();
        Point end = rectangle.getEnd();

        int x = Math.min(start.x, end.x);
        int y = Math.min(start.y, end.y);
        int width = Math.abs(end.x - start.x);
        int height = Math.abs(end.y - start.y);

        g.setColor(rectangle.getColor());

        if (xor) {
            g.setXORMode(Color.WHITE);
        } else {
            g.setPaintMode();
        }

        g.drawRect(x, y, width, height);
    }
}