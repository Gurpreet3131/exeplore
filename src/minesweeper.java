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
public class minesweeper extends javax.swing.JPanel implements ActionListener,MouseListener {

    /**
     * Creates new form minesweeper
     */
    BombButton mine[][]=new BombButton[16][16]; //40 mines in 16x16
    int countflag=0,totalcount=0;
    Random randomGenerator=new Random();
    boolean loose=false;
    public static boolean win=false;
    
    void minefieldgenerate()
    {
        int random,random2;
        loose=false; 
        int count=0;
        countflag=0;    totalcount=0;
        flagcountlabel.setText(String.valueOf(countflag));
        for(int i=0;i<16;i++)
            for(int j=0;j<16;j++)
            {
                mine[i][j].setfieldvalue(0);
                mine[i][j].setflagged(false);
                mine[i][j].setpressed(false);
            }
        
        
        while(count<40)
        {
            random=randomGenerator.nextInt(16);
            random2=randomGenerator.nextInt(16);
            if(mine[random][random2].getfieldvalue()==0)
            {
                mine[random][random2].setfieldvalue(-1);
                count++;
            }
            
        }
        for(int i=0;i<16;i++)
        {
            for(int j=0;j<16;j++)
            {
                if(mine[i][j].getfieldvalue()==-1) continue;
                if(i>0 && mine[i-1][j].getfieldvalue()==-1) mine[i][j].setfieldvalue(mine[i][j].getfieldvalue()+1);  //up
                if(i>0 && j>0 && mine[i-1][j-1].getfieldvalue()==-1) mine[i][j].setfieldvalue(mine[i][j].getfieldvalue()+1); //upleft
                if(i>0 && j<15 && mine[i-1][j+1].getfieldvalue()==-1) mine[i][j].setfieldvalue(mine[i][j].getfieldvalue()+1); //upright
                if(j>0 && mine[i][j-1].getfieldvalue()==-1) mine[i][j].setfieldvalue(mine[i][j].getfieldvalue()+1); //left
                if(j<15 && mine[i][j+1].getfieldvalue()==-1) mine[i][j].setfieldvalue(mine[i][j].getfieldvalue()+1); //right
                if(i<15 && mine[i+1][j].getfieldvalue()==-1) mine[i][j].setfieldvalue(mine[i][j].getfieldvalue()+1); //down
                if(i<15 && j>0 && mine[i+1][j-1].getfieldvalue()==-1) mine[i][j].setfieldvalue(mine[i][j].getfieldvalue()+1); //downleft
                if(i<15 && j<15 && mine[i+1][j+1].getfieldvalue()==-1) mine[i][j].setfieldvalue(mine[i][j].getfieldvalue()+1); //downright
            }
        }  
    }
    void minecellresult(int row,int col)
    {
        if(loose==true || win==true) return;
        if(mine[row][col].getflagged()==false && mine[row][col].getpressed()==false)
        {
            mine[row][col].setpressed(true);
            totalcount++;
            if(mine[row][col].getfieldvalue()==0)
            {
                mine[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/emptymine.jpg")));
                if(row>0) minecellresult(row-1,col); //up
                if(row>0 && col>0)  minecellresult(row-1,col-1); //upleft
                if(row>0 && col<15) minecellresult(row-1,col+1); //upright
                if(col>0) minecellresult(row,col-1); //left
                if(col<15) minecellresult(row,col+1); //right
                if(row<15) minecellresult(row+1,col); //down
                if(row<15 && col>0) minecellresult(row+1,col-1); //downleft
                if(row<15 && col<15) minecellresult(row+1,col+1); //downright
            }
            else if(mine[row][col].getfieldvalue()==1) mine[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/mine1.jpg")));
            else if(mine[row][col].getfieldvalue()==2) mine[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/mine2.jpg")));
            else if(mine[row][col].getfieldvalue()==3) mine[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/mine3.jpg")));
            else if(mine[row][col].getfieldvalue()==4) mine[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/mine4.jpg")));
            else if(mine[row][col].getfieldvalue()==5) mine[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/mine5.jpg")));
            else if(mine[row][col].getfieldvalue()==6) mine[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/mine6.jpg")));
            else if(mine[row][col].getfieldvalue()==7) mine[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/mine7.jpg")));
            else if(mine[row][col].getfieldvalue()==8) mine[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/mine8.jpg")));
            else if(mine[row][col].getfieldvalue()==-1) 
            {
                loose=true;
                mine[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/redbomb.jpg")));
                for(int i=0;i<16;i++)
                {
                    for(int j=0;j<16;j++)
                    {
                        if(i==row && j==col) continue;
                        if(mine[i][j].getfieldvalue()==-1)
                        {
                            mine[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/bomb.jpg")));
                        }
                        else if(mine[i][j].getfieldvalue()!=-1 && mine[i][j].getflagged()==true)
                        {
                            mine[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/crossbomb.jpg")));
                        }
                    }
                }
                totalcount--;
                JOptionPane.showMessageDialog(null,"YOU LOST\nClick NEW button to try again");
            }
            //bomb edit and rec
        }
    }
    void setflagimage(int row,int col)
    {
        if(win==true || loose==true) return;
        if(mine[row][col].getflagged()==false && mine[row][col].getpressed()==false) 
        {
            mine[row][col].setflagged(true);
            countflag++; //totalcount++;
            flagcountlabel.setText(String.valueOf(countflag));
            mine[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/bombflag.jpg")));
        }
        else if(mine[row][col].getflagged()==true && mine[row][col].getpressed()==false)
        {
            mine[row][col].setflagged(false);
            countflag--; //totalcount--;
            flagcountlabel.setText(String.valueOf(countflag));
            mine[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/minetile.jpg")));
        }
    }
    void wincheck()
    {
        if(totalcount==216)
        {
            win=true;
            JOptionPane.showMessageDialog(null,"Congratulations!!! You have solved the puzzle\nClick NEXT button to proceed to the next level");
            startpanel.completetimelabel[startpanel.completetimeindex+1].setText(String.valueOf(startpanel.hour)+":"+String.format("%02d",startpanel.minute)+":"+String.format("%02d",startpanel.seconds));
            startpanel.bar[startpanel.currentpanel].setIcon(new javax.swing.ImageIcon(getClass().getResource("/blacktile.jpg")));
        }
    }
    public minesweeper() {
        initComponents();
        
        minepanel.setLayout(new GridLayout(16,16));
        for(int i=0;i<16;i++)
        {
            for(int j=0;j<16;j++)
            {
                mine[i][j]=new BombButton(i,j);
                minepanel.add(mine[i][j]);
                mine[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/minetile.jpg")));
                mine[i][j].setBackground(Color.LIGHT_GRAY);
                mine[i][j].addActionListener(this);
                mine[i][j].addMouseListener(this);
            }
        }
        minefieldgenerate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void actionPerformed(ActionEvent evt)
    {       
        BombButton but=(BombButton)evt.getSource();
        minecellresult(but.getrow(),but.getcol());
        wincheck(); 
    }
    public void mouseClicked(MouseEvent e)  {
        BombButton but=(BombButton)e.getSource();
        if (e.getButton() == e.BUTTON3)                  // || e.getModifiers() == 4)
        {
            setflagimage(but.getrow(),but.getcol());
            wincheck();
            
        }
    }

	//These functions are included for the mouse listener... But i dont use them for actions
	public void mouseEntered(MouseEvent e)  { }
	public void mouseExited(MouseEvent e)   { }
	public void mousePressed(MouseEvent e)  { }
	public void mouseReleased(MouseEvent e) { }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        namelabel = new javax.swing.JLabel();
        minepanel = new javax.swing.JPanel();
        newbutton = new javax.swing.JButton();
        flagimagelabel = new javax.swing.JLabel();
        flagcountlabel = new javax.swing.JLabel();
        instructionbutton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        namelabel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        namelabel.setForeground(new java.awt.Color(255, 0, 255));
        namelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namelabel.setText("MINESWEEPER");
        add(namelabel);
        namelabel.setBounds(210, 10, 520, 60);

        minepanel.setLayout(new java.awt.GridLayout(16, 16));
        add(minepanel);
        minepanel.setBounds(210, 100, 520, 490);

        newbutton.setBackground(new java.awt.Color(255, 255, 255));
        newbutton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        newbutton.setForeground(new java.awt.Color(102, 0, 0));
        newbutton.setText("New");
        newbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newbuttonActionPerformed(evt);
            }
        });
        add(newbutton);
        newbutton.setBounds(30, 190, 150, 30);

        flagimagelabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        flagimagelabel.setForeground(new java.awt.Color(255, 255, 255));
        flagimagelabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BombFlag.gif"))); // NOI18N
        flagimagelabel.setText("=");
        add(flagimagelabel);
        flagimagelabel.setBounds(110, 415, 50, 25);

        flagcountlabel.setBackground(new java.awt.Color(204, 204, 204));
        flagcountlabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        flagcountlabel.setForeground(new java.awt.Color(255, 255, 255));
        flagcountlabel.setText("0");
        flagcountlabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(flagcountlabel);
        flagcountlabel.setBounds(160, 410, 34, 30);

        instructionbutton.setBackground(new java.awt.Color(255, 255, 255));
        instructionbutton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        instructionbutton.setForeground(new java.awt.Color(102, 0, 0));
        instructionbutton.setText("Instructions");
        instructionbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructionbuttonActionPerformed(evt);
            }
        });
        add(instructionbutton);
        instructionbutton.setBounds(30, 280, 150, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mineback.jpg"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 820, 620);
    }// </editor-fold>//GEN-END:initComponents

    private void newbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newbuttonActionPerformed
        minefieldgenerate(); 
        for(int i=0;i<16;i++)
        {
            for(int j=0;j<16;j++)
            {
                mine[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/minetile.jpg")));
                mine[i][j].setEnabled(true);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_newbuttonActionPerformed

    private void instructionbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructionbuttonActionPerformed
        JOptionPane.showMessageDialog(null,"* There are 256 cells out of which 40 cells contain bomb.\n"
                                            +"* You have to open all the cells not containing the bomb by left-clicking on the cell.\n"
                                            +"* The number displayed in a cell denotes the number of bombs present in the adjacent 8 cells.\n"
                                            +"* You can mark a cell with a flag by right-clicking on the cell.\n"
                                            +"* One wrong move and you have to start the game again by clicking on the NEW button\n"
        );
        // TODO add your handling code here:
    }//GEN-LAST:event_instructionbuttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel flagcountlabel;
    private javax.swing.JLabel flagimagelabel;
    private javax.swing.JButton instructionbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel minepanel;
    public static javax.swing.JLabel namelabel;
    private javax.swing.JButton newbutton;
    // End of variables declaration//GEN-END:variables
}
