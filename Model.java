package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Model {
    Controller controller;
    Kiki kiki;
    boolean gameover = false;
    boolean UpKey = false;
    boolean RightKey = false;
    boolean LeftKey = false;
    ArrayList<Sprite> sprites;

    Model() {
        sprites = new ArrayList<Sprite>();
        //Game map
        sprites.add(new Cloud(300, 150, this));
        sprites.add(new Tube(400, 380, this));
        sprites.add(new Cloud(400, 50, this));
        sprites.add(new Tube(600, 305, this));
        sprites.add(new Monster(800, 400, this));
        sprites.add(new Tube(900, 205, this));
        sprites.add(new Monster(1000, 400, this));
        sprites.add(new Cloud(1100, 50, this));
        sprites.add(new Tube(1200, 305, this));
        sprites.add(new Bread(1210, 200, this));
        sprites.add(new Monster(1300, 400, this));
        sprites.add(new Cloud(1450, 170, this));
        sprites.add(new Monster(1600, 400, this));
        sprites.add(new Tube(1900, 205, this));
        sprites.add(new Monster(2000, 400, this));
        sprites.add(new Cloud(2050, 100, this));
        sprites.add(new Monster(2100, 400, this));
        sprites.add(new Tube(2300, 275, this));
        sprites.add(new Bread(2305, 220, this));
        sprites.add(new Tube(2800, 340, this));
        sprites.add(new Bread(2805, 290, this));
        sprites.add(new Tube(2950, 340, this));
        sprites.add(new Bread(2955, 290, this));
        sprites.add(new Tube(3100, 340, this));
        sprites.add(new Bread(3105, 290, this));
        sprites.add(new Tube(3400, 300, this));
        sprites.add(new Monster(3500, 400, this));
        sprites.add(new Cloud(3600, 200, this));
        sprites.add(new Tube(4000, 340, this));
        sprites.add(new Monster(4200, 400, this));
        sprites.add(new Bread(4200, 200, this));
        sprites.add(new Monster(4500, 400, this));
        sprites.add(new Bread(4500, 200, this));
        sprites.add(new Monster(4800, 400, this));
        sprites.add(new Bread(4800, 200, this));
        sprites.add(new Monster(5100, 400, this));
        sprites.add(new Bread(5100, 200, this));
        sprites.add(new Tube(5300, 360, this));
        sprites.add(new Tube(5500, 310, this));
        sprites.add(new Bread(5605, 380, this));
        sprites.add(new Tube(5700, 260, this));
        sprites.add(new Tube(5900, 210, this));
        sprites.add(new Monster(6100, 400, this));
        sprites.add(new Tube(6300, 210, this));
        sprites.add(new Tube(6500, 260, this));
        sprites.add(new Tube(6700, 310, this));

        kiki = new Kiki(this);
        sprites.add(kiki);
    }

    public void Update(){
        for(int i = 0; i < sprites.size(); i++) {
            Sprite sprite = sprites.get(i);
            sprite.update();
        }
        if (!this.kiki.alive)
            gameover = true;
    }

    int CamPos() {
        return kiki.x - 200;
    }

    public void setController(Controller c) {
        controller = c;
    }

}
