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
public class tiktacktoepanel extends javax.swing.JPanel implements ActionListener {

    /**
     * Creates new form tiktacktoepanel
     */
    JButton box[]=new JButton[9]; //contains the status of all the O and X
    Border buttonborder = new LineBorder(Color.black, 1);
    int marked[]=new int[9]; //0 means not marked, 1 means O marked and 2 means X marked
    int mark=1,count=0,win=0,youscore=0,computerscore=0,totalgames=0; //mark=1 denotes O and mark=2 denoted X
    Random randomGenerator=new Random();
    public static boolean winner=false;
    void markcondition(int index) //checks whether the button to be marked is already marked or not
    {
        if(marked[index]==0)
        {
            marked[index]=mark;
            setmark(index); //mark the given button with O or X
            if(win==0) computerturn(); //computer will make its turn if player has not won
        }
    }
    void setmark(int index) //this function will mark the given index with O or X
    {
       count++;
       if(mark==1)
       {
            box[index].setText("O");
            box[index].setForeground(Color.green);
            box[index].setFont(new Font("Arial", Font.PLAIN,50));
            mark=2;
       }
       else if(mark==2)
       {
            box[index].setText("X");
            box[index].setForeground(Color.red);
            box[index].setFont(new Font("Arial", Font.PLAIN,50));
            mark=1;
       }
        wincheck();
    }
    void setend() //marks all the remaining buttons and makes win=1;
    {
        for(int i=0;i<9;i++) marked[i]=1;
        win=1;
    }
    void wincheck() //checls who won, and if noone has won makes the game draw
    {
        if(((box[0].getText()).compareTo("O")==0 && (box[1].getText()).compareTo("O")==0 && (box[2].getText()).compareTo("O")==0) || ((box[0].getText()).compareTo("X")==0 && (box[1].getText()).compareTo("X")==0 && (box[2].getText()).compareTo("X")==0) )
        {
            winresult();
            setend();
        }
        else if(((box[3].getText()).compareTo("O")==0 && (box[4].getText()).compareTo("O")==0 && (box[5].getText()).compareTo("O")==0) || ((box[3].getText()).compareTo("X")==0 && (box[4].getText()).compareTo("X")==0 && (box[5].getText()).compareTo("X")==0)  )
        {
            winresult();
            setend();
        }
        else if(((box[6].getText()).compareTo("O")==0 && (box[7].getText()).compareTo("O")==0 && (box[8].getText()).compareTo("O")==0) || ((box[6].getText()).compareTo("X")==0 && (box[7].getText()).compareTo("X")==0 && (box[8].getText()).compareTo("X")==0) )
        {
            winresult();
            setend();
        }
        else if(((box[0].getText()).compareTo("O")==0 && (box[3].getText()).compareTo("O")==0 && (box[6].getText()).compareTo("O")==0) || ((box[0].getText()).compareTo("X")==0 && (box[3].getText()).compareTo("X")==0 && (box[6].getText()).compareTo("X")==0) )
        {
            winresult();
            setend();
        }
        else if(((box[1].getText()).compareTo("O")==0 && (box[4].getText()).compareTo("O")==0 && (box[7].getText()).compareTo("O")==0) || ((box[1].getText()).compareTo("X")==0 && (box[4].getText()).compareTo("X")==0 && (box[7].getText()).compareTo("X")==0))
        {
            winresult();
            setend();
        }
        else if(((box[2].getText()).compareTo("O")==0 && (box[5].getText()).compareTo("O")==0 && (box[8].getText()).compareTo("O")==0) || ((box[2].getText()).compareTo("X")==0 && (box[5].getText()).compareTo("X")==0 && (box[8].getText()).compareTo("X")==0) )
        {
            winresult();
            setend();
        }
        else if(((box[0].getText()).compareTo("O")==0 && (box[4].getText()).compareTo("O")==0 && (box[8].getText()).compareTo("O")==0) || ((box[0].getText()).compareTo("X")==0 && (box[4].getText()).compareTo("X")==0 && (box[8].getText()).compareTo("X")==0)  )
        {
            winresult();
            setend();
        }
        else if(((box[2].getText()).compareTo("O")==0 && (box[4].getText()).compareTo("O")==0 && (box[6].getText()).compareTo("O")==0) || ((box[2].getText()).compareTo("X")==0 && (box[4].getText()).compareTo("X")==0 && (box[6].getText()).compareTo("X")==0)  )
        {
            winresult();
            setend();
        }
        else
        {
            if (count==9)
            {
                winnerlabel.setText("Draw");
                win=1;                            
                totalgames++;
                //resultl.setForeground(Color.white);                             
            }
            
        }
    }
    void winresult() //changes the points and the label depending upon the winner
    {
        if(mark==2)
        {
            winnerlabel.setText("YOU WIN");
            youscore++;
            youscorelabel.setText(String.valueOf(youscore));
        }
        else if(mark==1)
        {
            winnerlabel.setText("COMPUTER WINS");
            computerscore++;
            computerscorelabel.setText(String.valueOf(computerscore));
            //resultl.setForeground(Color.red);
        }
        totalgames++;
        win=1;
        if(youscore-computerscore>=3)
        {
            winner=true;
            JOptionPane.showMessageDialog(null,"CONGRATULATIONS!!! You have solved the puzzle.\nClick on NEXT button to proceed to the next level.");
            startpanel.completetimelabel[startpanel.completetimeindex+1].setText(String.valueOf(startpanel.hour)+":"+String.format("%02d",startpanel.minute)+":"+String.format("%02d",startpanel.seconds));
            startpanel.bar[startpanel.currentpanel].setIcon(new javax.swing.ImageIcon(getClass().getResource("/blacktile.jpg")));
        }
    }
    void computerturn()
    {
        int index=0;
        int random=randomGenerator.nextInt(9);
        if(count==0 && marked[4]==0) index=4;
        else if(count==1 && marked[4]==0)   index=4;
        else if(count==1 && marked[4]==1) 
        {
            random=randomGenerator.nextInt(4);
            if(random==0 && marked[0]==0) index=0;
            else if(random==1 && marked[2]==0 ) index=2;
            else if(random==2 && marked[6]==0) index=6;
            else if(random==3 && marked[8]==0) index=8;
        }
       
         
        else if(marked[0]==2 && marked[1]==2 && marked[2]==0) index=2;
        else if(marked[0]==2 && marked[2]==2 && marked[1]==0 ) index=1;
        else if(marked[1]==2 && marked[2]==2 && marked[0]==0) index=0;
        else if(marked[3]==2 && marked[4]==2 && marked[5]==0) index=5;
        else if(marked[3]==2 && marked[5]==2 && marked[4]==0) index=4;
        else if(marked[4]==2 && marked[5]==2 && marked[3]==0) index=3;
        else if(marked[6]==2 && marked[7]==2 && marked[8]==0) index=8;
        else if(marked[6]==2 && marked[8]==2 && marked[7]==0) index=7;
        else if(marked[7]==2 && marked[8]==2 && marked[6]==0) index=6;
        
        else if(marked[0]==2 && marked[3]==2 && marked[6]==0) index=6;
        else if(marked[0]==2 && marked[6]==2 && marked[3]==0) index=3;
        else if(marked[3]==2 && marked[6]==2 && marked[0]==0) index=0;
        else if(marked[1]==2 && marked[4]==2 && marked[7]==0) index=7;
        else if(marked[1]==2 && marked[7]==2 && marked[4]==0) index=4;
        else if(marked[4]==2 && marked[7]==2 && marked[1]==0) index=1;
        else if(marked[2]==2 && marked[5]==2 && marked[8]==0) index=8;
        else if(marked[2]==2 && marked[8]==2 && marked[5]==0) index=5;
        else if(marked[5]==2 && marked[8]==2 && marked[2]==0) index=2;
        
        else if(marked[0]==2 && marked[4]==2 && marked[8]==0) index=8;
        else if(marked[0]==2 && marked[8]==2 && marked[4]==0) index=4;
        else if(marked[4]==2 && marked[8]==2 && marked[0]==0) index=0;
        else if(marked[2]==2 && marked[4]==2 && marked[6]==0) index=6;
        else if(marked[2]==2 && marked[6]==2 && marked[4]==0) index=4;
        else if(marked[4]==2 && marked[6]==2 && marked[2]==0) index=2;
        //other winning
        else if(marked[0]==1 && marked[1]==1 && marked[2]==0) index=2;
        else if(marked[0]==1 && marked[2]==1 && marked[1]==0 ) index=1;
        else if(marked[1]==1 && marked[2]==1 && marked[0]==0) index=0;
        else if(marked[3]==1 && marked[4]==1 && marked[5]==0) index=5;
        else if(marked[3]==1 && marked[5]==1 && marked[4]==0) index=4;
        else if(marked[4]==1 && marked[5]==1 && marked[3]==0) index=3;
        else if(marked[6]==1 && marked[7]==1 && marked[8]==0) index=8;
        else if(marked[6]==1 && marked[8]==1 && marked[7]==0) index=7;
        else if(marked[7]==1 && marked[8]==1 && marked[6]==0) index=6;
        
        else if(marked[0]==1 && marked[3]==1 && marked[6]==0) index=6;
        else if(marked[0]==1 && marked[6]==1 && marked[3]==0) index=3;
        else if(marked[3]==1 && marked[6]==1 && marked[0]==0) index=0;
        else if(marked[1]==1 && marked[4]==1 && marked[7]==0) index=7;
        else if(marked[1]==1 && marked[7]==1 && marked[4]==0) index=4;
        else if(marked[4]==1 && marked[7]==1 && marked[1]==0) index=1;
        else if(marked[2]==1 && marked[5]==1 && marked[8]==0) index=8;
        else if(marked[2]==1 && marked[8]==1 && marked[5]==0) index=5;
        else if(marked[5]==1 && marked[8]==1 && marked[2]==0) index=2;
        
        else if(marked[0]==1 && marked[4]==1 && marked[8]==0) index=8;
        else if(marked[0]==1 && marked[8]==1 && marked[4]==0) index=4;
        else if(marked[4]==1 && marked[8]==1 && marked[0]==0) index=0;
        else if(marked[2]==1 && marked[4]==1 && marked[6]==0) index=6;
        else if(marked[2]==1 && marked[6]==1 && marked[4]==0) index=4;
        else if(marked[4]==1 && marked[6]==1 && marked[2]==0) index=2;
        
        else if(count==3) 
        {
            while(marked[random]!=0)
            {
                random=randomGenerator.nextInt(4);
                if(random==0) random=1;
                else if(random==1) random=3;
                else if(random==2) random=5;
                else if(random==3) random=7;
                //System.out.println("random number generated"+random);
            }
             index=random;
        }
        else
        {
            while(marked[random]!=0)
            {
                random=randomGenerator.nextInt(9);
            }
            index=random;
        }
        marked[index]=mark;
        setmark(index);
    }
    public tiktacktoepanel() {
        initComponents();
        markpanel.setLayout(new GridLayout(3,3));
        for(int i=0;i<box.length;i++)
        {
            box[i]=new JButton("");
            box[i].setFont(new Font("Arial", Font.PLAIN, 40));
            markpanel.add(box[i]);
            box[i].setBackground(Color.white);
            box[i].setFocusable(false);
            box[i].setBorder(buttonborder);
            box[i].addActionListener(this);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void actionPerformed(ActionEvent evt)
    {
        if(box[0]==evt.getSource())   markcondition(0);  //checks the condition to mark, if satisfied marks thhe button
        if(box[1]==evt.getSource())   markcondition(1);
        if(box[2]==evt.getSource())   markcondition(2);
        if(box[3]==evt.getSource())   markcondition(3);
        if(box[4]==evt.getSource())   markcondition(4);
        if(box[5]==evt.getSource())   markcondition(5);
        if(box[6]==evt.getSource())   markcondition(6);
        if(box[7]==evt.getSource())   markcondition(7);
        if(box[8]==evt.getSource())   markcondition(8);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        namelabel = new javax.swing.JLabel();
        newbutton = new javax.swing.JButton();
        resetbutton = new javax.swing.JButton();
        gamepanel = new javax.swing.JPanel();
        infopanel = new javax.swing.JPanel();
        scorepanel = new javax.swing.JPanel();
        youlabel = new javax.swing.JLabel();
        youscorelabel = new javax.swing.JLabel();
        computerlabel = new javax.swing.JLabel();
        computerscorelabel = new javax.swing.JLabel();
        winnerlabel = new javax.swing.JLabel();
        markpanel = new javax.swing.JPanel();
        instructionbutton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        namelabel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        namelabel.setForeground(new java.awt.Color(0, 255, 204));
        namelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namelabel.setText("TIC TACK TOE");
        add(namelabel);
        namelabel.setBounds(200, 20, 510, 50);

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
        newbutton.setBounds(30, 220, 140, 30);

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
        resetbutton.setBounds(30, 300, 140, 30);

        gamepanel.setLayout(null);

        infopanel.setBackground(new java.awt.Color(0, 0, 0));
        infopanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        infopanel.setLayout(new java.awt.GridLayout(2, 1));

        scorepanel.setBackground(new java.awt.Color(0, 0, 0));
        scorepanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        scorepanel.setLayout(null);

        youlabel.setBackground(new java.awt.Color(255, 255, 255));
        youlabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        youlabel.setForeground(new java.awt.Color(255, 255, 255));
        youlabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        youlabel.setText("YOU:");
        scorepanel.add(youlabel);
        youlabel.setBounds(10, 0, 127, 50);

        youscorelabel.setBackground(new java.awt.Color(255, 255, 255));
        youscorelabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        youscorelabel.setForeground(new java.awt.Color(255, 255, 255));
        youscorelabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        youscorelabel.setText("0");
        scorepanel.add(youscorelabel);
        youscorelabel.setBounds(150, 0, 80, 50);

        computerlabel.setBackground(new java.awt.Color(255, 255, 255));
        computerlabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        computerlabel.setForeground(new java.awt.Color(255, 255, 255));
        computerlabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        computerlabel.setText("COMPUTER:");
        scorepanel.add(computerlabel);
        computerlabel.setBounds(240, 0, 160, 50);

        computerscorelabel.setBackground(new java.awt.Color(255, 255, 255));
        computerscorelabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        computerscorelabel.setForeground(new java.awt.Color(255, 255, 255));
        computerscorelabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        computerscorelabel.setText("0");
        scorepanel.add(computerscorelabel);
        computerscorelabel.setBounds(410, 0, 70, 50);

        infopanel.add(scorepanel);

        winnerlabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        winnerlabel.setForeground(new java.awt.Color(255, 255, 255));
        winnerlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infopanel.add(winnerlabel);

        gamepanel.add(infopanel);
        infopanel.setBounds(0, 0, 510, 110);

        markpanel.setLayout(new java.awt.GridLayout(1, 0));
        gamepanel.add(markpanel);
        markpanel.setBounds(0, 110, 510, 330);

        add(gamepanel);
        gamepanel.setBounds(200, 100, 510, 440);

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
        instructionbutton.setBounds(30, 380, 140, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/level2back.jpg"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 820, 620);
    }// </editor-fold>//GEN-END:initComponents

    private void newbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newbuttonActionPerformed
        if(win==1)
        {
            winnerlabel.setText("");
            win=0; count=0;
            for(int i=0;i<9;i++)
            {
                box[i].setText("");
                marked[i]=0;
            }
            if(mark==2) computerturn();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_newbuttonActionPerformed

    private void resetbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbuttonActionPerformed
           if(totalgames>=30)
           {
                int a=JOptionPane.showConfirmDialog(resetbutton,"This will reset the score. Are you sure?");
                if(a==JOptionPane.YES_OPTION)
                {
                    winnerlabel.setText("");
                   win=0; count=0; mark=1;
                   for(int i=0;i<9;i++)
                   {
                       box[i].setText("");
                       marked[i]=0;
                   }
                   youscore=0; computerscore=0; 
                  youscorelabel.setText(String.valueOf(youscore));
                  computerscorelabel.setText(String.valueOf(computerscore)); 
                  totalgames=0;
                }     
           }
           else
           {
               JOptionPane.showMessageDialog(null,"You have played only "+totalgames+" games.\nYou have to play atleast 30 games to reset the score.\n");
           }
           // TODO add your handling code here:
    }//GEN-LAST:event_resetbuttonActionPerformed

    private void instructionbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructionbuttonActionPerformed
        JOptionPane.showMessageDialog(null,"* NEW button will create a new game without changing the scores.\n"
                                            +"* NEW button will create a new game only if the current game is completed.\n"
                                            +"* RESET button will make score of both sides equal to zero.\n"
                                            +"* You can reset only after playing atleast 30 games after previous reset.\n"
                                            +"* To win the puzzle, you have to get a LEAD of 3 POINTS than the computer.\n"                                            
        );
        // TODO add your handling code here:
    }//GEN-LAST:event_instructionbuttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel computerlabel;
    private javax.swing.JLabel computerscorelabel;
    private javax.swing.JPanel gamepanel;
    private javax.swing.JPanel infopanel;
    private javax.swing.JButton instructionbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel markpanel;
    public static javax.swing.JLabel namelabel;
    private javax.swing.JButton newbutton;
    private javax.swing.JButton resetbutton;
    private javax.swing.JPanel scorepanel;
    private javax.swing.JLabel winnerlabel;
    private javax.swing.JLabel youlabel;
    private javax.swing.JLabel youscorelabel;
    // End of variables declaration//GEN-END:variables
}
