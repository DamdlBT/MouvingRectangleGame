package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.Game;
import cegepst.engine.controls.MovementController;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MovingRectangleGame extends Game {

    private Player player;
    private Player player2;
    private GameController controller;
    private GameController controller2;
    private ArrayList<Footprint> footprints;

    public MovingRectangleGame() {
        controller = new GameController();
        controller2 = new GameController();
        controller2.setUpKey(KeyEvent.VK_W);
        controller2.setDownKey(KeyEvent.VK_S);
        controller2.setLeftKey(KeyEvent.VK_A);
        controller2.setRightKey(KeyEvent.VK_D);

        player = new Player(controller,100,100, Color.red);
        player2 = new Player(controller2,250,250, Color.green);
        footprints = new ArrayList<>();
        super.addKeyListener(controller); // Viens de Game
        super.addKeyListener(controller2);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void conclude() {

    }

    @Override
    public void update() {
        if(controller.isQuitPressed()) {
            super.stop();
        }
        player.update();
        player2.update();
        if (controller.isMoving() || controller2.isMoving()) {
            footprints.add(player.layFootPrint());
            footprints.add(player2.layFootPrint());
        }
    }

    @Override
    public void draw(Buffer buffer) {
        for (Footprint footprint : footprints) {
            footprint.draw(buffer);
        }
        player.draw(buffer);
        player2.draw(buffer);
    }
}
