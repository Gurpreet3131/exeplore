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
 * @author Dragneel/Gurpreet Singh
 */
public class puzzle4x4panel extends javax.swing.JPanel implements ActionListener {

    /**
     * Creates new form puzzle4x4panel
     */
    JButton number[][]=new JButton[4][4]; //contains the numbers in jumbled form
    int moves=0,flag,random,row,column;
    int a[][]=new int[4][4]; //it will contain the random generate numbers
    Random randomGenerator=new Random();
    String temp; //to swap "" and the number
    Border buttonborder = new LineBorder(Color.black, 1);
    int inversion=0;
    public static boolean win=false;
    public void puzzleGenerate() //it will generate a random puzzle
    {
        inversion=0;
       
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
            {
                if(i==3 && j==3) break;
                a[i][j]=0;
            }
        
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                flag=0;
                if(i==3 && j==3) break;
                random=randomGenerator.nextInt(16);
                if(random==0) 
                {
                    j--;
                    continue;
                }
                else
                {
                    for(int k=0;k<4;k++)
                    {
                        for(int l=0;l<4;l++)
                        {
                            if(random==a[k][l])
                            {
                                flag=1;
                            }
                        }
                    }
                }
                if(flag==1) j--;
                else a[i][j]=random;
            }
        } 
        int forinversion[]=new int[15],index=0;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(i==3 && j==3 ) break;
                forinversion[index++]=a[i][j];
            }
        }
        for(int i=0;i<14;i++)
        {
            for(int j=i+1;j<15;j++)
            {
                if(forinversion[i]>forinversion[j]) inversion++;
            }
        }
        if(inversion%2!=0) puzzleGenerate();
    }
    
    public void wincheck()
    {
           int count=0,flag2=0;
           for(int i=0;i<4;i++)
           {
               for(int j=0;j<4;j++)
               {
                   if(i==3 && j==3) break;
                   count++;
                   if(String.valueOf(count).compareTo(number[i][j].getText())!=0)
                   {
                       
                       flag2=1; break; //checking if the numbers are arranged in ascnding order or not
                   }
               }
               if(flag2==1) break;
           }
           if(flag2==1 || moves>150)
           {
               JOptionPane.showMessageDialog(submitbutton,"You have to solve the puzzle within 150 MOVES");
           }
           else if(flag2==0)
           {
               win=true;
               JOptionPane.showMessageDialog(submitbutton,"Congratulations!!!, you have solved the puzzle\nClick NEXT button to proceed to the next level");
               startpanel.completetimelabel[startpanel.completetimeindex+1].setText(String.valueOf(startpanel.hour)+":"+String.format("%02d",startpanel.minute)+":"+String.format("%02d",startpanel.seconds));
               startpanel.bar[startpanel.currentpanel].setIcon(new javax.swing.ImageIcon(getClass().getResource("/blacktile.jpg")));
           }
      
    }
     public void downswap(int row,int column)
    {
         if(number[row+1][column].getText()=="")  //down
            {
                temp= number[row][column].getText();
                number[row][column].setText("");
                number[row+1][column].setText(temp);
                moves++;
                scorelabel.setText(Integer.toString(moves));
            }
    }
    public void upswap(int row,int column)
    {
        if(number[row-1][column].getText()=="")  //up
            {
                temp= number[row][column].getText();
                number[row][column].setText("");
                number[row-1][column].setText(temp);
                moves++;
                scorelabel.setText(Integer.toString(moves));
            }    
    }
    public void rightswap(int row,int column)
    {
        if(number[row][column+1].getText()=="")  //right
            {
                temp= number[row][column].getText();
                number[row][column].setText("");
                number[row][column+1].setText(temp);
                moves++;
                scorelabel.setText(Integer.toString(moves));
            }
    }
    public void leftswap(int row,int column)
    {
        if(number[row][column-1].getText()=="")  //left
            {
                temp= number[row][column].getText();
                number[row][column].setText("");
                number[row][column-1].setText(temp);
                moves++;
                scorelabel.setText(Integer.toString(moves));
            }
    }
    
    
    public puzzle4x4panel() {
        initComponents();
        puzzleGenerate();
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                   if(i==3 && j==3)
                   {
                       number[i][j]=new JButton("");
                   }
                   else 
                   {
                       number[i][j]=new JButton(String.valueOf(a[i][j]));
                   }
                   number[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                   number[i][j].setBackground(Color.LIGHT_GRAY);
                   number[i][j].setFocusable(false);
                   number[i][j].setBorder(buttonborder);
                   number[i][j].addActionListener(this);
                   puzzle4x4panel.add(number[i][j]);
            }
        }
        column=3;row=3;
        
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        puzzle4x4namelabel = new javax.swing.JLabel();
        newbutton = new javax.swing.JButton();
        gamepanel = new javax.swing.JPanel();
        puzzle4x4panel = new javax.swing.JPanel();
        moveslabel = new javax.swing.JLabel();
        scorelabel = new javax.swing.JLabel();
        submitbutton = new javax.swing.JButton();
        instructionbutton = new javax.swing.JButton();
        imagelabel = new javax.swing.JLabel();

        setLayout(null);

        puzzle4x4namelabel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        puzzle4x4namelabel.setForeground(new java.awt.Color(255, 51, 153));
        puzzle4x4namelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puzzle4x4namelabel.setText("4x4 PUZZLE");
        add(puzzle4x4namelabel);
        puzzle4x4namelabel.setBounds(190, 30, 490, 50);

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
        newbutton.setBounds(30, 170, 140, 30);

        gamepanel.setBackground(new java.awt.Color(0, 0, 0));
        gamepanel.setLayout(null);

        puzzle4x4panel.setLayout(new java.awt.GridLayout(4, 4));
        gamepanel.add(puzzle4x4panel);
        puzzle4x4panel.setBounds(0, 50, 490, 390);

        moveslabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        moveslabel.setForeground(new java.awt.Color(255, 255, 255));
        moveslabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        moveslabel.setText("MOVES:");
        gamepanel.add(moveslabel);
        moveslabel.setBounds(40, 0, 240, 50);

        scorelabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        scorelabel.setForeground(new java.awt.Color(255, 255, 255));
        scorelabel.setText("0");
        gamepanel.add(scorelabel);
        scorelabel.setBounds(290, 0, 200, 50);

        add(gamepanel);
        gamepanel.setBounds(190, 100, 490, 490);

        submitbutton.setBackground(new java.awt.Color(255, 255, 255));
        submitbutton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        submitbutton.setForeground(new java.awt.Color(102, 0, 0));
        submitbutton.setText("Submit");
        submitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitbuttonActionPerformed(evt);
            }
        });
        add(submitbutton);
        submitbutton.setBounds(30, 250, 140, 30);

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
        instructionbutton.setBounds(30, 330, 140, 30);

        imagelabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/level3back.jpg"))); // NOI18N
        add(imagelabel);
        imagelabel.setBounds(0, 0, 820, 620);
    }// </editor-fold>//GEN-END:initComponents

    private void newbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newbuttonActionPerformed
           moves=0;
           scorelabel.setText(Integer.toString(moves));
           for(int i=0;i<4;i++)
           {
               for(int j=0;j<4;j++)
               {
                   a[i][j]=0;
               }
           }
           puzzleGenerate();
           for(int i=0;i<4;i++)
           {
               for(int j=0;j<4;j++)
               {
                   if(i==3 && j==3)
                   {
                       number[i][j].setText(String.valueOf(""));
                   }
                   else
                   {
                       number[i][j].setText(String.valueOf(a[i][j]));
                   }
               }
           }// TODO add your handling code here:
    }//GEN-LAST:event_newbuttonActionPerformed

    private void submitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitbuttonActionPerformed
            wincheck();        // TODO add your handling code here:
    }//GEN-LAST:event_submitbuttonActionPerformed

    private void instructionbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructionbuttonActionPerformed
        JOptionPane.showMessageDialog(null,"* 15 numbers are arranged randomly in 4x4 grid.\n"
                                            +"* You have to arrange all the numbers in ascending order.\n"
                                            +"* Click on a number to slide it to the empty space.\n"
                                            +"* Click on submit button when the numbers are arranged in ascending order.\n"
                                            +"* To start a new game, click on the NEW button.\n"
                                            +"* To pass the level, you have to solve the puzzle within 150 MOVES.\n"
        );
        // TODO add your handling code here:
    }//GEN-LAST:event_instructionbuttonActionPerformed

    public void actionPerformed(ActionEvent evt)
    {
        //number[0][0]
        if(number[0][0]==evt.getSource())
        {
            
            row=0;column=0;
            downswap(row,column);
            rightswap(row,column);
            
        }
        //number[0][1]
        if(number[0][1]==evt.getSource())
        {
            row=0;column=1;
            leftswap(row,column);
            downswap(row,column);
            rightswap(row,column);
        }
        if(number[0][2]==evt.getSource())
        {
            row=0;column=2;
            leftswap(row,column);
            downswap(row,column);
            rightswap(row,column);
        }
        if(number[0][3]==evt.getSource())
        {
            row=0;column=3;
            leftswap(row,column);
            downswap(row,column);
        }
        if(number[1][0]==evt.getSource())
        {
            row=1;column=0;
            upswap(row,column);
            downswap(row,column);
            rightswap(row,column);
        }
        if(number[1][1]==evt.getSource())
        {
            row=1;column=1;
            upswap(row,column);
            downswap(row,column);
            rightswap(row,column);
            leftswap(row,column);
        }
        if(number[1][2]==evt.getSource())
        {
            row=1;column=2;
            upswap(row,column);
            downswap(row,column);
            rightswap(row,column);
            leftswap(row,column);
        }
        if(number[1][3]==evt.getSource())
        {
            row=1;column=3;
            upswap(row,column);
            downswap(row,column);
            leftswap(row,column);
        }
        if(number[2][0]==evt.getSource())
        {
            row=2;column=0;
            upswap(row,column);
            downswap(row,column);
            rightswap(row,column);
        }
        if(number[2][1]==evt.getSource())
        {
            row=2;column=1;
             upswap(row,column);
            downswap(row,column);
            rightswap(row,column);
            leftswap(row,column);
        }
        if(number[2][2]==evt.getSource())
        {
            row=2;column=2;
            upswap(row,column);
            downswap(row,column);
            rightswap(row,column);
            leftswap(row,column);
        }
        if(number[2][3]==evt.getSource())
        {
            row=2;column=3;
            upswap(row,column);
            downswap(row,column);
            leftswap(row,column);
           
        }
        if(number[3][0]==evt.getSource())
        {
            row=3;column=0;
            upswap(row,column);
            rightswap(row,column);
        }
        if(number[3][1]==evt.getSource())
        {
            row=3;column=1;   
            upswap(row,column);
            rightswap(row,column);
            leftswap(row,column);
        }
        if(number[3][2]==evt.getSource())
        {
            row=3;column=2;
            upswap(row,column);
            rightswap(row,column);
            leftswap(row,column);
        }
        if(number[3][3]==evt.getSource())
        {
            row=3;column=3;
            upswap(row,column);
            leftswap(row,column);   
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gamepanel;
    private javax.swing.JLabel imagelabel;
    private javax.swing.JButton instructionbutton;
    private javax.swing.JLabel moveslabel;
    private javax.swing.JButton newbutton;
    public static javax.swing.JLabel puzzle4x4namelabel;
    private javax.swing.JPanel puzzle4x4panel;
    private javax.swing.JLabel scorelabel;
    private javax.swing.JButton submitbutton;
    // End of variables declaration//GEN-END:variables
}
