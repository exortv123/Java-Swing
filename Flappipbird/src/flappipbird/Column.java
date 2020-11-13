/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappipbird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import sun.java2d.loops.FillRect;

/**
 *
 * @author USER
 */
public class Column extends Rectangle{
    Color color;
    int firstPos;

    public Column(Color color, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.color = color;
    }
    public  void drawColumn(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
        
        
    }
    
    public void moveBack(){
        x = 1800;
    }
}
