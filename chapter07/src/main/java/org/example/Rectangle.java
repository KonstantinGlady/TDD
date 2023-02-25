package org.example;

public class Rectangle extends Shape {
    public int getHeight() {
        return 0;
    }

    public int getWidth() {
        return 0;
    }

    public void draw(Graphics g) {
        for (int row = 0;
             row < getHeight();
             row++) {
            g.drawLine(0, getWidth());
        }
    }
}
