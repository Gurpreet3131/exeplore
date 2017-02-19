/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.* ;
/**
 *
 * @author Dragneel
 */
public class BombButton extends JButton {
    
    private boolean flagged,pressed;
    int fieldvalue,row,col;
    
    public BombButton(int r,int c)
    {
        row=r;
        col=c;
        flagged=false;
        fieldvalue=0;
        pressed=false;
    }
    
    int getrow() { 
        return row;
    }
    int getcol(){
        return col;
    }
    boolean getflagged(){
        return flagged;
    }
    int getfieldvalue(){
        return fieldvalue;
    }
    boolean getpressed(){
        return pressed;
    }
            
    void setpressed(boolean bool)
    {
        pressed=bool;
    }
    void setrow(int r){
        row=r;
    }
    void setcol(int c){
        col=c;
    }
    void setfieldvalue(int value){
        fieldvalue=value;
    }
    void setflagged(boolean bool){
        flagged=bool;
    }
            
    
}
