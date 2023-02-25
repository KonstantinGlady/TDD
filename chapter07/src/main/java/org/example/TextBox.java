package org.example;

public class TextBox implements Shape{
    public String getText() {
        return null;
    }

    public void draw(Graphics g) {
        g.drawText(getText());
    }
}
