/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappipbird;

import java.util.Random;

/**
 *
 * @author SE140779
 */
public class PairColumn {
    public static int HIGHT = 1100;
    Column top;
    Column bottom;
    int plainSpace = 100;
    int pos = 0;
    boolean pointed = false;

    public PairColumn(Column top, Column bottom, int position) {
        this.top = top;
        this.bottom = bottom;
        pos = position;
        reSizeCol();
    }
    
    public PairColumn(Column top, Column bottom, int position, int hight) {
        this.top = top;
        this.bottom = bottom;
        this.HIGHT = hight;
        pos = position;
        reSizeCol();
    }
    
    public void moveCol(int n){
        top.x -= n;
        bottom.x -= n;
    }
    
    public void setPos(int n){
        top.x = n;
        bottom.x = n;
    }
    
    public int getCurrentPos(){
        return top.x;
    }

    void resetColPos() {
        top.x = pos;
        bottom.x = pos;
        pointed = false;
    }

    public void reSizeCol() {
        top.y = 0;
        Random r = new Random();
        top.width = r.nextInt(30) + 90;
        bottom.width = top.width;
        pointed = false;
        top.height = r.nextInt(300) + 200;
        plainSpace = r.nextInt(100) + 150;
        bottom.height = HIGHT - plainSpace - top.height;
        bottom.y = HIGHT - bottom.height;
    }
    
}
