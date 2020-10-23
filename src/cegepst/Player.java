package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.entity.ControllableEntity;

import java.awt.*;

public class Player extends ControllableEntity {

    public Player(InputHandler inputHandler) {
        super(inputHandler);
        super.setDimension(30,30);
        super.teleport(100,100);
        super.setSpeed(4);
    }

    public Footprint layFootPrint() {
        return new Footprint(x, y);
    }

    @Override
    public void update() {
        moveAccordingToHandler();
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, Color.RED);
    }
}
