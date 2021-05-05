
import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;


/** <description of class DrawShape>
 * draws a shape on the graphics page
 */

public class DrawShape{
    private double shapeSize = 50;
    private boolean oval = false;
    public boolean rectangle = false;
    public DrawShape(){
    UI.initialise();
    UI.addButton("Quit", UI::quit);
    }

    public void doMouse(String action, double x, double y) {
        
        if (action.equals("clicked")) {
            if (oval == true) {
                UI.fillOval(x-(shapeSize/2), y-(shapeSize/2), shapeSize, shapeSize);
            }
            if (rectangle == true) {
                UI.fillRect(x-(shapeSize/2), y-(shapeSize/2), shapeSize, shapeSize);
            }
        }
    }

    /**
     * make a random colour
     */
    private void changeColor() {
        Color col = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
        UI.setColor(col);
    }
    
    private void doCircle() {
        oval = true;
        rectangle = false;
    }
    
    private void doRectangle() {
        rectangle = true;
        oval = true;
    }
    
    /**
     * Set size
     */
    public void setSize(double size) {
        this.shapeSize = size;
    }
    
    public static void main(String[] args){
        final int SIZEMIN = 1;
        final int SIZEMAX = 100;
        final int SIZEINIT = 50;
        
        DrawShape obj = new DrawShape();
        UI.addButton("Circle", obj::doCircle);
        UI.addButton("Rectangle", obj::doRectangle);
        UI.addButton("Change Color", obj::changeColor);
        UI.setMouseListener(obj::doMouse);
        UI.addSlider("Circle Size", SIZEMIN, SIZEMAX, SIZEINIT, obj::setSize);
    }

}

