/* Based on the ecs 100 template
 * Code for ??
 * Name:
 * Date:
 */


import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;
import javax.swing.JColorChooser;

/** <description of class LineDrawer>
 * Let the user draw lines on graphics pane with the mouse
 */
public class LineDrawer{
    //fields
    private double startX, startY; //fields to remember the pressed position
    private double endX, endY; // Fields remember release position
    
    private Color currentColor = Color.black;
    
    public LineDrawer(){
    UI.initialise();
    UI.addButton("Quit", UI::quit);
    }
    
    /**
     * Colour chooser
     */
    public void doChooseColor() {
        this.currentColor = JColorChooser.showDialog(null, "Choose Color", this.currentColor);
        UI.setColor(this.currentColor);
    }
    
    /**
     * mouse actioner
     */
    public void doMouse(String action, double x, double y) {
        if (action.equals("pressed")) {
            this.startX = x;
            this.startY = y;
        }
        else if (action.equals("released")) {
            UI.drawLine(this.startX, this.startY, x, y);
        }
    }

    public static void main(String[] args){
        LineDrawer obj = new LineDrawer();
        UI.setLineWidth(10);
        UI.setMouseListener(obj::doMouse);
        UI.addButton("Color", obj::doChooseColor);
    }

}

