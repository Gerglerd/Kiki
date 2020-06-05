package com.company;

import java.awt.Toolkit;
import javax.swing.*;

public class Main extends JFrame {

    Model model;
    View view;
    Controller controller;

    public Main() {
        model = new Model();
        controller = new Controller(model);
        view = new View(model);
        controller.setView(view);
        model.setController(controller);
        controller.setView(view);

        this.addKeyListener(controller);
        this.setSize(800, 600);
        this.setFocusable(true);
        this.getContentPane().add(view);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void run(){
        while(true){
            controller.Update();
            model.Update();
            view.repaint();
            Toolkit.getDefaultToolkit().sync();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
    public static void main(String[] args) {
        Main m = new Main();
        m.run();
    }
}
