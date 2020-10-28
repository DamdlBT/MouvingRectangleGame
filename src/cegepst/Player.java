package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.controls.MovementController;
import cegepst.engine.entity.ControllableEntity;

import java.awt.*;

public class Player extends ControllableEntity {

    private Color color;

    public Player(GameController controller, int x, int y, Color color) {
        super(controller);
        this.color = color;
        super.setDimension(30,30);
        super.teleport(x,y);
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
        buffer.drawRectangle(x, y, width, height, color);
    }
}
