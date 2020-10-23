package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.entity.StaticEntity;

import java.awt.*;
import java.util.Random;

public class Footprint extends StaticEntity {

    public Footprint(int x, int y) {
        setDimension(4,4);
        teleport(x, y);
    }

    @Override
    public void draw(Buffer buffer) {
        Color color = new Color(getRandomValue(), getRandomValue(), getRandomValue());
        buffer.drawRectangle(x, y, width, height, color);
    }

    private int getRandomValue() {
        return (new Random()).nextInt(256);
    }
}
