/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
/**
 *
 * @author Dragneel
 */
public class memorybutton extends JButton
{
    int row,col;
    boolean open;
    public memorybutton(int r,int c)
    {
        row=r;
        col=c;
        open=false;
    }
    int getrow()
    {
        return row;
    }
    int getcol()
    {
        return col;
    }
    boolean getopen()
    {
        return open;
    }
    void setrow(int r)
    {
        row=r;
    }
    void setcol(int c)
    {
        col=c;
    }
    void setopen(boolean b)
    {
        open=b;
    }
}
