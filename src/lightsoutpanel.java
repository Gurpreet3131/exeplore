/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;
/**
 *
 * @author Dragneel
 */
public class lightsoutpanel extends javax.swing.JPanel implements ActionListener {

    /**
     * Creates new form lightsoutpanel
     */
    JButton toggle[][]=new JButton[5][6];
    boolean lighton[][]=new boolean[5][6];
    boolean resetlighton[][]=new boolean[5][6];
    Random randomGenerator=new Random();
    Border buttonborder = new LineBorder(Color.black, 1);
    public static boolean win=false;
    
    void generate() //to generate the lights on pattern randomly
    {
        int random;
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<6;j++)
            {
                random=randomGenerator.nextInt(2);
                if(random==1) lighton[i][j]=true;
                else lighton[i][j]=false;
                resetlighton[i][j]=lighton[i][j];
            }
        }
    }
    public lightsoutpanel() {
        initComponents();
        lightpanel.setLayout(new GridLayout(5,6));
        generate();
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<6;j++)
            {
                toggle[i][j]=new JButton("");
                lightpanel.add(toggle[i][j]);
                toggle[i][j].setFocusable(false);
                toggle[i][j].setBorder(buttonborder);
                toggle[i][j].addActionListener(this);   
                if(lighton[i][j]==true) 
                    toggle[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/bluetile.jpg")));
                else
                    toggle[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/blacktile.jpg")));
            }
        }
    }
    void togglelight(int row,int col)
    {
        if(lighton[row][col]==true) lighton[row][col]=false;
        else lighton[row][col]=true;
        if(row>0) 
        {
            if(lighton[row-1][col]==true) lighton[row-1][col]=false;
            else lighton[row-1][col]=true;
        }
        if(row<4)
        {
            if(lighton[row+1][col]==true) lighton[row+1][col]=false;
            else lighton[row+1][col]=true;
        }
        if(col>0) 
        {
            if(lighton[row][col-1]==true) lighton[row][col-1]=false;
            else lighton[row][col-1]=true;
        }
        if(col<5)
        {
            if(lighton[row][col+1]==true) lighton[row][col+1]=false;
            else lighton[row][col+1]=true;
        }
        setlight();
        wincheck();
    }
    void setlight()
    {
        for(int i=0;i<5;i++)
            {
                for(int j=0;j<6;j++)
                {
                    if(lighton[i][j]==true) 
                         toggle[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/bluetile.jpg")));
                    else
                         toggle[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/blacktile.jpg")));
                }
            }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void wincheck()
    {
        int count=0;
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<6;j++)
            {
                if(lighton[i][j]==false) count++;
            }
        }
        if(count==30)
        {
            win=true;
            JOptionPane.showMessageDialog(null,"CONGRATULATIONS!!! You have solved all the puzzle.\nClick on NEXT or FINISH button to end this game.");
            startpanel.completetimelabel[startpanel.completetimeindex+1].setText(String.valueOf(startpanel.hour)+":"+String.format("%02d",startpanel.minute)+":"+String.format("%02d",startpanel.seconds));
            startpanel.bar[startpanel.currentpanel].setIcon(new javax.swing.ImageIcon(getClass().getResource("/blacktile.jpg")));
        }                                        
    }
    public void actionPerformed(ActionEvent evt)
    {
        if(toggle[0][0]==evt.getSource()) togglelight(0,0);
        if(toggle[0][1]==evt.getSource()) togglelight(0,1);
        if(toggle[0][2]==evt.getSource()) togglelight(0,2);
        if(toggle[0][3]==evt.getSource()) togglelight(0,3);
        if(toggle[0][4]==evt.getSource()) togglelight(0,4);
        if(toggle[0][5]==evt.getSource()) togglelight(0,5);
        if(toggle[1][0]==evt.getSource()) togglelight(1,0);
        if(toggle[1][1]==evt.getSource()) togglelight(1,1);
        if(toggle[1][2]==evt.getSource()) togglelight(1,2);
        if(toggle[1][3]==evt.getSource()) togglelight(1,3);
        if(toggle[1][4]==evt.getSource()) togglelight(1,4);
        if(toggle[1][5]==evt.getSource()) togglelight(1,5);
        if(toggle[2][0]==evt.getSource()) togglelight(2,0);
        if(toggle[2][1]==evt.getSource()) togglelight(2,1);
        if(toggle[2][2]==evt.getSource()) togglelight(2,2);
        if(toggle[2][3]==evt.getSource()) togglelight(2,3);
        if(toggle[2][4]==evt.getSource()) togglelight(2,4);
        if(toggle[2][5]==evt.getSource()) togglelight(2,5);
        if(toggle[3][0]==evt.getSource()) togglelight(3,0);
        if(toggle[3][1]==evt.getSource()) togglelight(3,1);
        if(toggle[3][2]==evt.getSource()) togglelight(3,2);
        if(toggle[3][3]==evt.getSource()) togglelight(3,3);
        if(toggle[3][4]==evt.getSource()) togglelight(3,4);
        if(toggle[3][5]==evt.getSource()) togglelight(3,5);
        if(toggle[4][0]==evt.getSource()) togglelight(4,0);
        if(toggle[4][1]==evt.getSource()) togglelight(4,1);
        if(toggle[4][2]==evt.getSource()) togglelight(4,2);
        if(toggle[4][3]==evt.getSource()) togglelight(4,3);
        if(toggle[4][4]==evt.getSource()) togglelight(4,4);
        if(toggle[4][5]==evt.getSource()) togglelight(4,5);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        namelabel = new javax.swing.JLabel();
        lightpanel = new javax.swing.JPanel();
        newbutton = new javax.swing.JButton();
        resetbutton = new javax.swing.JButton();
        instructionbutton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        namelabel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        namelabel.setForeground(new java.awt.Color(0, 255, 204));
        namelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namelabel.setText("LIGHTS OUT!!");
        add(namelabel);
        namelabel.setBounds(200, 10, 560, 50);

        lightpanel.setLayout(new java.awt.GridLayout(5, 5));
        add(lightpanel);
        lightpanel.setBounds(200, 70, 560, 520);

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
        newbutton.setBounds(30, 160, 140, 31);

        resetbutton.setBackground(new java.awt.Color(255, 255, 255));
        resetbutton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        resetbutton.setForeground(new java.awt.Color(102, 0, 0));
        resetbutton.setText("Reset");
        resetbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbuttonActionPerformed(evt);
            }
        });
        add(resetbutton);
        resetbutton.setBounds(30, 250, 140, 30);

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
        instructionbutton.setBounds(30, 340, 140, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lightsoutback.jpg"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 820, 620);
    }// </editor-fold>//GEN-END:initComponents

    private void newbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newbuttonActionPerformed
            generate();
            setlight();
            // TODO add your handling code here:
    }//GEN-LAST:event_newbuttonActionPerformed

    private void resetbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbuttonActionPerformed
            for(int i=0;i<5;i++)
            {
                for(int j=0;j<6;j++)
                {
                    lighton[i][j]=resetlighton[i][j];
                    if(lighton[i][j]==true) 
                         toggle[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/bluetile.jpg")));
                    else
                         toggle[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/blacktile.jpg")));
                }
            }    // TODO add your handling code here:
    }//GEN-LAST:event_resetbuttonActionPerformed

    private void instructionbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructionbuttonActionPerformed
        JOptionPane.showMessageDialog(null,"* Blue tile indicate that light in ON.\n"
                                            +"* Black tile indicates that light is OFF.\n"
                                            +"* Clicking on a tile will toggle its state and will also toggle the state of its 4 adjacent tiles.\n"
                                            +"* You have to turn all the lights OFF.\n"
                                            +"* NEW button will restart the game with new pattern of lights.\n"
                                            +"* RESET button will bring you to the initial state of the current instance.\n"                                            
        );
        // TODO add your handling code here:
    }//GEN-LAST:event_instructionbuttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton instructionbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel lightpanel;
    public static javax.swing.JLabel namelabel;
    private javax.swing.JButton newbutton;
    private javax.swing.JButton resetbutton;
    // End of variables declaration//GEN-END:variables
}