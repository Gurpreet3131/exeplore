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
public class queenbutton extends JButton
{
    int value,row,col;
    public queenbutton(int r,int c)
    {
        row=r; 
        col=c;
        value=0;
    }
    int getrow() 
    {
        return row;
    }
    int getcol()
    {
        return col;
    }
    int getvalue()
    {
        return value;
    }
    void setrow(int r)
    {
        row=r;
    }
    void setcol(int c)
    {
        col=c;
    }
    void setvalue(int val)
    {
        value=val;
    }
}
