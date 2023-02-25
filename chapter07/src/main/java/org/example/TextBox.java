package org.example;

public class TextBox extends Shape{
    public String getText() {
        return null;
    }

    public void draw(Graphics g) {
        g.drawText(getText());
    }
}
