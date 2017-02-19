/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
/**
 *
 * @author Dragneel
 */
public class colorbutton extends JButton
{
    int row,col,color;
    public colorbutton(int r,int c)
    {
        row=r; 
        col=c;
        color=-1;
    }
    int getrow()
    {
        return row;
    }
    int getcol()
    {
        return col;
    }
    int getcolor()
    {
        return color;
    }
    void setrow(int r)
    {
        row=r;
    }
    void setcol(int c)
    {
        col=c;
    }
    void setcolor(int col)
    {
        color=col;
    }
}
