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
import java.util.Random;
/**
 *
 * @author Dragneel
 */
public class memorypuzzlepanel extends javax.swing.JPanel implements ActionListener{
    
    /**
     * Creates new form memorypuzzlepanel
     */
    memorybutton memory[][]=new memorybutton[4][7];
    int mem[][]=new int[4][7];
    int images[]=new int[14];
    Random randomgenerator=new Random();
    Border buttonborder = new LineBorder(Color.black, 1);
    int turn=1,onerow=-1,onecol=-1,tworow=-1,twocol=-1;
    int moves=0,correct=0;
    public static boolean win=false;
    public memorypuzzlepanel() {
        initComponents();
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<7;j++)
            {
                memory[i][j]=new memorybutton(i,j);
                mem[i][j]=0;
                memory[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/bluetile.jpg")));
                memory[i][j].setBorder(buttonborder);
                memory[i][j].addActionListener(this);
                gamepanel.add(memory[i][j]);
            }
        }
        for(int i=0;i<14;i++) images[i]=0;
        
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<7;j++)
            {
                int random=randomgenerator.nextInt(14);
                if(images[random]<2)
                {
                    images[random]++;
                    mem[i][j]=random;
                    memory[i][j].setopen(false);
                    memory[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/bluetile.jpg")));
                }
                else j--;
            }
        }
      
    }
    public void flip(int row,int col)
    {
        if(turn==1)
        {
            memory[row][col].setopen(true);
            correct++;
            if(tworow!=-1)
            {
                if(mem[onerow][onecol]!=mem[tworow][twocol])
                {
                    memory[onerow][onecol].setIcon(new javax.swing.ImageIcon(getClass().getResource("/bluetile.jpg")));
                    memory[tworow][twocol].setIcon(new javax.swing.ImageIcon(getClass().getResource("/bluetile.jpg")));
                    memory[onerow][onecol].setopen(false);
                    memory[tworow][twocol].setopen(false);
                    correct-=2;
                }
            }
            onerow=row; onecol=col;
            if(mem[row][col]==0)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon1.gif")));
            if(mem[row][col]==1)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon2.gif")));
            if(mem[row][col]==2)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon3.gif")));
            if(mem[row][col]==3)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon4.gif")));
            if(mem[row][col]==4)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon5.gif")));
            if(mem[row][col]==5)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon6.gif")));
            if(mem[row][col]==6)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon7.gif")));
            if(mem[row][col]==7)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon8.gif")));
            if(mem[row][col]==8)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon9.gif")));
            if(mem[row][col]==9)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon10.gif")));
            if(mem[row][col]==10)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon11.gif")));
            if(mem[row][col]==11)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon12.gif")));
            if(mem[row][col]==12)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon13.gif")));
            if(mem[row][col]==13)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon14.gif")));
            turn=2;
        }
        else
        {
            correct++;
            tworow=row; twocol=col;
            memory[row][col].setopen(true);
            if(mem[row][col]==0)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon1.gif")));
            if(mem[row][col]==1)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon2.gif")));
            if(mem[row][col]==2)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon3.gif")));
            if(mem[row][col]==3)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon4.gif")));
            if(mem[row][col]==4)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon5.gif")));
            if(mem[row][col]==5)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon6.gif")));
            if(mem[row][col]==6)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon7.gif")));
            if(mem[row][col]==7)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon8.gif")));
            if(mem[row][col]==8)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon9.gif")));
            if(mem[row][col]==9)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon10.gif")));
            if(mem[row][col]==10)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon11.gif")));
            if(mem[row][col]==11)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon12.gif")));
            if(mem[row][col]==12)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon13.gif")));
            if(mem[row][col]==13)memory[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/myicon14.gif")));
            turn=1;
        }
        moves++;
        moveslabel.setText("MOVES: "+String.valueOf(moves));
        if(correct==28)
        {
            if(moves<=60){
            JOptionPane.showMessageDialog(null,"CONGRATULATIONS!! You have solved the puzlle\nClick NEXT button to proceed further");
            win=true;
            startpanel.completetimelabel[startpanel.completetimeindex+1].setText(String.valueOf(startpanel.hour)+":"+String.format("%02d",startpanel.minute)+":"+String.format("%02d",startpanel.seconds));
            startpanel.bar[startpanel.currentpanel].setIcon(new javax.swing.ImageIcon(getClass().getResource("/blacktile.jpg")));
            }
            else
            {
                JOptionPane.showMessageDialog(null,"You have to solve the puzzle with 60 moves\nClick NEW button to play again");
            }
        }
    }
    public void actionPerformed(ActionEvent evt)
    {
        memorybutton but=(memorybutton)evt.getSource();
        if(but.getopen()==false) flip(but.getrow(),but.getcol());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Instructionbutton = new javax.swing.JButton();
        gamepanel = new javax.swing.JPanel();
        namelabel = new javax.swing.JLabel();
        newbutton = new javax.swing.JButton();
        moveslabel = new javax.swing.JLabel();
        backimagelabel = new javax.swing.JLabel();

        setLayout(null);

        Instructionbutton.setBackground(new java.awt.Color(255, 255, 255));
        Instructionbutton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Instructionbutton.setForeground(new java.awt.Color(102, 0, 0));
        Instructionbutton.setText("Instructions");
        Instructionbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstructionbuttonActionPerformed(evt);
            }
        });
        add(Instructionbutton);
        Instructionbutton.setBounds(20, 249, 140, 31);

        gamepanel.setLayout(new java.awt.GridLayout(4, 7));
        add(gamepanel);
        gamepanel.setBounds(180, 80, 600, 510);

        namelabel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        namelabel.setForeground(new java.awt.Color(0, 204, 51));
        namelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namelabel.setText("MEMORY PUZZLE");
        add(namelabel);
        namelabel.setBounds(180, 10, 600, 60);

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
        newbutton.setBounds(20, 170, 140, 30);

        moveslabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        moveslabel.setForeground(new java.awt.Color(102, 0, 0));
        moveslabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        moveslabel.setText("MOVES: 0");
        add(moveslabel);
        moveslabel.setBounds(20, 440, 150, 40);

        backimagelabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memoryback.jpg"))); // NOI18N
        add(backimagelabel);
        backimagelabel.setBounds(0, 0, 820, 620);
    }// </editor-fold>//GEN-END:initComponents

    private void newbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newbuttonActionPerformed
        for(int i=0;i<14;i++) images[i]=0;
        moves=0; correct=0; tworow=-1; twocol=-1; onerow=-1; onecol=-1; turn=1; 
        moveslabel.setText("MOVES: "+String.valueOf(moves));
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<7;j++)
            {
                int random=randomgenerator.nextInt(14);
                if(images[random]<2)
                {
                    images[random]++;
                    mem[i][j]=random;
                    memory[i][j].setopen(false);
                    memory[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/bluetile.jpg")));
                }
                else j--;
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_newbuttonActionPerformed

    private void InstructionbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstructionbuttonActionPerformed
        JOptionPane.showMessageDialog(null,"* There are 28 cards containing 14 pairs of images.\n"
                                            +"* You have to find all the pairs.\n"
                                            +"* To pass the level, you have to solve the puzzle within 60 MOVES.\n"
        );
        // TODO add your handling code here:
    }//GEN-LAST:event_InstructionbuttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Instructionbutton;
    private javax.swing.JLabel backimagelabel;
    public static javax.swing.JPanel gamepanel;
    private javax.swing.JLabel moveslabel;
    public static javax.swing.JLabel namelabel;
    private javax.swing.JButton newbutton;
    // End of variables declaration//GEN-END:variables
}
