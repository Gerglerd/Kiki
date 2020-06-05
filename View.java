package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

class View extends JPanel {
    Model model;

    static BufferedImage background_image = null;
    static BufferedImage gameover_image = null;
    static BufferedImage house_image = null;

    View(Model m) {
        model = m;
        if (background_image == null)
            background_image = loadImage("images/background2.jpg");
        if (gameover_image == null)
            gameover_image = loadImage("images/gameover.png");
        if (house_image == null)
            house_image = loadImage("images/house.png");
    }

    public void paintComponent(Graphics graphics) {
        graphics.drawImage(background_image, 0, 0, null);
        graphics.drawImage(house_image, 8000 - model.CamPos(), 285, null);

        for (int i = 0; i < model.sprites.size(); i++) {
            Sprite sprite = model.sprites.get(i);
            sprite.draw(graphics);
        }
        if (!model.kiki.alive){
            graphics.drawImage(gameover_image,0,0, 800, 600, null);
        }
        graphics.drawString("Bread: " + model.kiki.bread_amount, 20,20);
        graphics.drawString("Lives: " + model.kiki.lives, 20, 40);
    }

    private BufferedImage loadImage(String imFile) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(imFile));
        }

        catch(Exception e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
        return image;
    }
}
