package com.company;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.*;

public class Controller implements ActionListener, KeyListener {

    View view;
    Model model;
    boolean keyLeft;
    boolean keyRight;
    boolean keyUp;
    boolean keyDown;

    Controller(Model m) {
        model = m;
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_D:
                keyRight = true;
                break;
            case KeyEvent.VK_W:
                keyUp = true;
                break;
            case KeyEvent.VK_A:
                keyLeft = true;
                break;
            case KeyEvent.VK_S:
                keyDown = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_D:
                keyRight = false;
                break;
            case KeyEvent.VK_A:
                keyLeft = false;
                break;
            case KeyEvent.VK_W:
                keyUp = false;
                break;
            case KeyEvent.VK_S:
                keyDown = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    void Update() {
        model.kiki.kikiPastPosition();

        if (keyRight) {
            model.kiki.x += 8;
            model.kiki.moveRight = true;
            model.kiki.moveLeft = false;
            model.RightKey = true;
        }
        if (keyLeft) {
            model.kiki.x -= 8;
            model.kiki.moveLeft = true;
            model.kiki.moveRight = false;
            model.LeftKey = true;
        }
        if (keyUp) {
            model.kiki.jump();
            model.UpKey = true;
        }
    }

    void setView(View v) {
        view = v;
    }
}
