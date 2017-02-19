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
 * @author Dragneel/Gurpreet Singh
 */
public class sudokupanel extends javax.swing.JPanel {
    
    /**
     * Creates new form sudokupanel
     */
    JPanel subgrid[]=new JPanel[9];
    Border fieldborder = new LineBorder(Color.black, 1);
    Border subgridborder = new LineBorder(Color.black, 2);
    JTextField t[][]=new JTextField[9][9]; //no.of boxxes , rows in box , column in box
    int color[][]=new int[9][9]; //0 white, 1 red , 2 is green
    public static boolean win=false;
    
    boolean correctstatus[]=new boolean[9];
    void horizontalcheck()
    {
        //horizontal check 
        int horizontal[][]=new int[9][10]; //counts the number of times a digit appears in a row
        int row=0;
        for(int i=0;i<3;i++) //first three rows
        {
            for(int j=0;j<9;j++)
            {
               if(j!=0 && j%3==0) row++;
               int digit=Integer.parseInt(t[i][j].getText());
                horizontal[row][digit]++;
                if(horizontal[row][digit]==1 && correctstatus[row]==true)  ;
                else correctstatus[row]=false;
                    
            }
            row=0;
        }
        row=0;
        for(int i=0;i<3;i++) //first three rows marking color
        {
            for(int j=0;j<9;j++)
            {
               if(j!=0 && j%3==0) row++;
               if(correctstatus[row]==false)
               {
                       if(horizontal[row][Integer.parseInt(t[i][j].getText())]>1)
                       {
                            color[i][j]=1;
                            t[i][j].setBackground(new Color(255,0,0));
                       }
                       else
                       {
                           if(color[i][j]==0)
                           {
                               color[i][j]=2;
                               t[i][j].setBackground(new Color(0,255,0));
                           }
                           
                       }
               }
               else
               {
                    if(color[i][j]==0)
                    {
                        color[i][j]=2;
                        t[i][j].setBackground(new Color(0,255,0));
                    }
               }
            }
            row=0;
        }
        
        
        row=3;
        for(int i=3;i<6;i++) //3-5 rows
        {
            for(int j=0;j<9;j++)
            {
               if(j!=0 && j%3==0) row++;
               int digit=Integer.parseInt(t[i][j].getText());
               horizontal[row][digit]++;
                if(horizontal[row][digit]==1 && correctstatus[row]==true)  ;
                else correctstatus[row]=false;
            }
            row=3;
        }
        row=3;
        for(int i=3;i<6;i++) //3-5 rows marking color
        {
            for(int j=0;j<9;j++)
            {
               if(j!=0 && j%3==0) row++;
               if(correctstatus[row]==false)
               {
                   
                       if(horizontal[row][Integer.parseInt(t[i][j].getText())]>1)
                       {
                            color[i][j]=1;
                            t[i][j].setBackground(new Color(255,0,0));
                       }
                       else
                       {
                           if(color[i][j]==0)
                           {
                               color[i][j]=2;
                               t[i][j].setBackground(new Color(0,255,0));
                           }
                       }
               }
               else
               {
                    if(color[i][j]==0)
                    {
                        color[i][j]=2;
                        t[i][j].setBackground(new Color(0,255,0));
                    }
               }
            }
            row=3;
        }
        
        
        row=6;
        for(int i=6;i<9;i++) //6-8 rows
        {
            for(int j=0;j<9;j++)
            {
               if(j!=0 && j%3==0) row++;
               int digit=Integer.parseInt(t[i][j].getText());
               horizontal[row][digit]++;
                if(horizontal[row][digit]==1 && correctstatus[row]==true)  ;
                else correctstatus[row]=false;
            }
            row=6;
        }
        row=6;
        for(int i=6;i<9;i++) //6-8 rows marking color
        {
            for(int j=0;j<9;j++)
            {
               if(j!=0 && j%3==0) row++;
               if(correctstatus[row]==false)
               {
                  
                       if(horizontal[row][Integer.parseInt(t[i][j].getText())]>1)
                       {
                            color[i][j]=1;
                            t[i][j].setBackground(new Color(255,0,0));
                       }
                       else
                       {
                           if(color[i][j]==0)
                           {
                               color[i][j]=2;
                               t[i][j].setBackground(new Color(0,255,0));
                           }
                       }
               }
               else
               {
                    if(color[i][j]==0) 
                    {
                        color[i][j]=2;
                        t[i][j].setBackground(new Color(0,255,0));
                    }
               }
            }
            row=6;
        }      
    }
    void verticalcheck()
    {
        //vertical check 
        int vertical[][]=new int[9][10]; //counts the number of times a digit appears in a column
        int col=0;
        for(int i=0;i<9;i++) //first three col
        {
            col=0;
            for(int j=0;j<9;j++)
            {
               if(j%3==0 && j!=0) col=0; 
               int digit=Integer.parseInt(t[i][j].getText());
               vertical[col][digit]++;
               if(vertical[col][digit]==1 && correctstatus[col]==true);
               else correctstatus[col]=false;
               col++;
            }
            i+=2;
        }
        col=0;
        for(int i=0;i<9;i++) //first three col marking color
        {
            col=0;
            for(int j=0;j<9;j++)
            {
               if(j%3==0 && j!=0) col=0; 
               if(correctstatus[col]==false)
               {
                        if(vertical[col][Integer.parseInt(t[i][j].getText())]>1)
                        {
                            color[i][j]=1;
                            t[i][j].setBackground(new Color(255,0,0));
                        }
                        else
                        {
                            if(color[i][j]==0)
                           {
                               color[i][j]=2;
                               t[i][j].setBackground(new Color(0,255,0));
                           }
                        }
               }
               else
               {
                    if(color[i][j]==0)
                    {
                        color[i][j]=2;
                        t[i][j].setBackground(new Color(0,255,0));
                    }
               }
               col++;
               
            }
            i+=2;
        }
        
        col=3;
        for(int i=1;i<9;i++) //col 3-5
        {
            col=3;
            for(int j=0;j<9;j++)
            {
               if(j%3==0 && j!=0) col=3; 
               int digit=Integer.parseInt(t[i][j].getText());
               vertical[col][digit]++;
               if(vertical[col][digit]==1 && correctstatus[col]==true);
               else correctstatus[col]=false;
               col++;
            }
            i+=2;
        }
        col=3;
        for(int i=1;i<9;i++) //3-5 col marking color
        {
            col=3;
            for(int j=0;j<9;j++)
            {
               if(j%3==0 && j!=0) col=3;
               if(correctstatus[col]==false)
               {
                        if(vertical[col][Integer.parseInt(t[i][j].getText())]>1)
                        {
                            color[i][j]=1;
                            t[i][j].setBackground(new Color(255,0,0));
                        }
                        else
                        {
                            if(color[i][j]==0)
                           {
                               color[i][j]=2;
                               t[i][j].setBackground(new Color(0,255,0));
                           }
                        }
               }
               else
               {
                   
                   if(color[i][j]==0)
                   {
                       color[i][j]=2;
                       t[i][j].setBackground(new Color(0,255,0));
                   }
               }
               col++;
            }
            i+=2;
        }
        
        col=6;
        for(int i=2;i<9;i++) //6-9 col
        {
            col=6;
            for(int j=0;j<9;j++)
            {
               if(j%3==0 && j!=0) col=6; 
                int digit=Integer.parseInt(t[i][j].getText());
               vertical[col][digit]++;
               if(vertical[col][digit]==1 && correctstatus[col]==true);
               else correctstatus[col]=false;
               col++;
            }
            i+=2;
        }
        col=6;
        for(int i=2;i<9;i++) //6-8 col marking color
        {
            col=6;
            for(int j=0;j<9;j++)
            {
               if(j%3==0 && j!=0) col=6; 
               if(correctstatus[col]==false)
               {
                        if(vertical[col][Integer.parseInt(t[i][j].getText())]>1)
                        {
                            color[i][j]=1;
                            t[i][j].setBackground(new Color(255,0,0));
                        }
                        else
                        {
                            if(color[i][j]==0)
                           {
                               color[i][j]=2;
                               t[i][j].setBackground(new Color(0,255,0));
                           }
                        }
               }
               else
               {
                    if(color[i][j]==0)
                    {
                        color[i][j]=2;
                        t[i][j].setBackground(new Color(0,255,0));
                    }
               }
               col++;
            }
            i+=2;
        }
       
    }
    void boxcheck()
    {
        int box[][]=new int[9][10]; //contains the count of number of times digit occurs in a box
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                int digit=Integer.parseInt(t[i][j].getText());
                box[i][digit]++;
                if(box[i][digit]==1 && correctstatus[i]==true); 
                else correctstatus[i]=false;
            }
        }
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(correctstatus[i]==false)
                {
                    if(box[i][Integer.parseInt(t[i][j].getText())]>1)
                    {
                        color[i][j]=1; //red
                        t[i][j].setBackground(new Color(255, 0, 0));
                    }
                    else
                    {
                        if(color[i][j]==0)
                        {
                            color[i][j]=2; //green
                            t[i][j].setBackground(new Color(0, 255, 0));
                        }
                    }
                }
                else
                {
                    if(color[i][j]==0)
                    {
                        color[i][j]=2; //green
                        t[i][j].setBackground(new Color(0, 255, 0));
                    }
                }
            }   
        }
    }
    boolean checkvaliddigit() //check for all numbers to be between 1 and 9
    {
        boolean valid=true;
        for(int i=0;i<9;i++)   //make color of all tile set to zero that is white
        {
            for(int j=0;j<9;j++)
            {
                String digit=(t[i][j].getText());
                if(digit.compareTo("")==0) digit=" "; //to make string length at least one else except will occur while accessing 0 index
                if(digit.charAt(0)>='1' && digit.charAt(0)<='9' && digit.length()==1)
                {
                    color[i][j]=0;
                    t[i][j].setBackground(new Color(255,255,255));
                    continue;
                }//0 is white
                else 
                {
                    valid=false; 
                    color[i][j]=3;
                    t[i][j].setBackground(new Color(0,0,255));
                }
            }
        }
        if(valid==false) JOptionPane.showMessageDialog(checkbutton,"Invalid digit");
        return valid;
    }
    
    boolean wincheck() //will check if the puzzle is solved or not
    {
        int count=0;
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(color[i][j]==2) count++;
            }
        }
        if(count==81) win=true;
        else win=false;
        return win;
    }
    //check if the solution is correct or not. If correct change pop optionpane to change level else mark wrong entries with 
    //red color and correct entries with green color
    void checksolution()   
    {
        //first of all check whether all the numbers are between 1 and 9 or not
        boolean valid=checkvaliddigit();
        if(valid==false) return;
        
        for(int i=0;i<9;i++)   //make color of all tile set to zero that is white
        {
            for(int j=0;j<9;j++)
            {
                color[i][j]=0; //0 is white
            }
        }
        //horizontal check 
        for(int i=0;i<9;i++) correctstatus[i]=true;
        horizontalcheck();
        //vertical check
        for(int i=0;i<9;i++) correctstatus[i]=true;
        verticalcheck();
        //boxcheck
        for(int i=0;i<9;i++) correctstatus[i]=true;
        boxcheck();
        
        if(wincheck()) 
        {
            win=true;
            JOptionPane.showMessageDialog(checkbutton,"CONGRATULATION!!! You have solved the puzzle\nClick NEXT button to proceed to the next level");
            startpanel.completetimelabel[startpanel.completetimeindex+1].setText(String.valueOf(startpanel.hour)+":"+String.format("%02d",startpanel.minute)+":"+String.format("%02d",startpanel.seconds));
            startpanel.bar[startpanel.currentpanel].setIcon(new javax.swing.ImageIcon(getClass().getResource("/blacktile.jpg")));
        }
        else JOptionPane.showMessageDialog(checkbutton,"Wrong Solution");
    }
    void whitetextfields()
    {
       for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                color[i][j]=0;
                t[i][j].setBackground(new Color(255, 255, 255));
            }
        } 
    }
    
    void resetpuzzle() //will reset the game as new game
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                    t[i][j].setText("");
            }
        }
        t[0][2].setText("2");
        t[0][2].setEditable(false);
        t[0][2].setForeground(Color.BLUE);
        
       t[0][8].setText("6");
       t[0][8].setEditable(false);
       t[0][8].setForeground(Color.BLUE);
        
       t[1][3].setText("9");
       t[1][3].setEditable(false);
       t[1][3].setForeground(Color.BLUE);
       
       t[1][7].setText("3");
       t[1][7].setEditable(false);
       t[1][7].setForeground(Color.BLUE);
        
       t[1][8].setText("2");
       t[1][8].setEditable(false);
       t[1][8].setForeground(Color.BLUE);
    
       t[2][3].setText("8");
       t[2][3].setEditable(false);
       t[2][3].setForeground(Color.BLUE);
       
       t[2][4].setText("5");
       t[2][4].setEditable(false);
       t[2][4].setForeground(Color.BLUE);
       
       t[3][0].setText("9");
       t[3][0].setEditable(false);
       t[3][0].setForeground(Color.BLUE);
       
       t[3][1].setText("8");
       t[3][1].setEditable(false);
       t[3][1].setForeground(Color.BLUE);
       
       t[3][4].setText("1");
       t[3][4].setEditable(false);
       t[3][4].setForeground(Color.BLUE);
       
       t[4][0].setText("7");
       t[4][0].setEditable(false);
       t[4][0].setForeground(Color.BLUE);
       
       t[4][3].setText("3");
       t[4][3].setEditable(false);
       t[4][3].setForeground(Color.BLUE);
       
       t[4][5].setText("4");
       t[4][5].setEditable(false);
       t[4][5].setForeground(Color.BLUE);
       
       t[4][8].setText("1");
       t[4][8].setEditable(false);
       t[4][8].setForeground(Color.BLUE);
       
       t[5][4].setText("7");
       t[5][4].setEditable(false);
       t[5][4].setForeground(Color.BLUE);
       
       t[5][7].setText("3");
       t[5][7].setEditable(false);
       t[5][7].setForeground(Color.BLUE);
       
       t[5][8].setText("8");
       t[5][8].setEditable(false);
       t[5][8].setForeground(Color.BLUE);
       
       t[6][4].setText("6");
       t[6][4].setEditable(false);
       t[6][4].setForeground(Color.BLUE);
       
       t[6][5].setText("1");
       t[6][5].setEditable(false);
       t[6][5].setForeground(Color.BLUE);
       
       t[7][0].setText("6");
       t[7][0].setEditable(false);
       t[7][0].setForeground(Color.BLUE);
       
       t[7][1].setText("1");
       t[7][1].setEditable(false);
       t[7][1].setForeground(Color.BLUE);
       
       t[7][5].setText("5");
       t[7][5].setEditable(false);
       t[7][5].setForeground(Color.BLUE);
       
       t[8][0].setText("4");
       t[8][0].setEditable(false);
       t[8][0].setForeground(Color.BLUE);
       
       t[8][6].setText("3");
       t[8][6].setEditable(false);
       t[8][6].setForeground(Color.BLUE);
    }
    
    public sudokupanel() {
        initComponents();
        sudoku.setLayout(new GridLayout(3,3));
        for(int i=0;i<9;i++)
        {
            subgrid[i]=new JPanel();
            subgrid[i].setLayout(new GridLayout(3,3));
            subgrid[i].setBorder(subgridborder);
            sudoku.add(subgrid[i]);
        }
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                {
                    t[i][j]=new JTextField(5);
                    t[i][j].setText("");
                    t[i][j].setFont(new Font("Arial", Font.PLAIN, 30));
                    subgrid[i].add(t[i][j]);
                    t[i][j].setHorizontalAlignment(JTextField.CENTER);
                    t[i][j].setBorder(fieldborder);
                }
            }
        }
        
        resetpuzzle();
       
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clearbutton = new javax.swing.JButton();
        checkbutton = new javax.swing.JButton();
        sudoku = new javax.swing.JPanel();
        resetbutton = new javax.swing.JButton();
        sudokunamelabel = new javax.swing.JLabel();
        instructionbutton = new javax.swing.JButton();
        imagelabel = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(820, 580));
        setPreferredSize(new java.awt.Dimension(820, 580));
        setLayout(null);

        clearbutton.setBackground(new java.awt.Color(255, 255, 255));
        clearbutton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        clearbutton.setForeground(new java.awt.Color(102, 0, 0));
        clearbutton.setText("ClearColor");
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });
        add(clearbutton);
        clearbutton.setBounds(20, 250, 140, 31);

        checkbutton.setBackground(new java.awt.Color(255, 255, 255));
        checkbutton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        checkbutton.setForeground(new java.awt.Color(102, 0, 0));
        checkbutton.setText("Check");
        checkbutton.setFocusable(false);
        checkbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbuttonActionPerformed(evt);
            }
        });
        add(checkbutton);
        checkbutton.setBounds(20, 170, 140, 30);

        javax.swing.GroupLayout sudokuLayout = new javax.swing.GroupLayout(sudoku);
        sudoku.setLayout(sudokuLayout);
        sudokuLayout.setHorizontalGroup(
            sudokuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        sudokuLayout.setVerticalGroup(
            sudokuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        add(sudoku);
        sudoku.setBounds(190, 70, 570, 540);

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
        resetbutton.setBounds(20, 330, 140, 31);

        sudokunamelabel.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        sudokunamelabel.setForeground(new java.awt.Color(0, 255, 204));
        sudokunamelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sudokunamelabel.setText("SUDOKU");
        add(sudokunamelabel);
        sudokunamelabel.setBounds(190, 10, 570, 60);

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
        instructionbutton.setBounds(20, 400, 140, 30);

        imagelabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/level1back.jpg"))); // NOI18N
        add(imagelabel);
        imagelabel.setBounds(0, 0, 820, 620);
    }// </editor-fold>//GEN-END:initComponents

    private void checkbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbuttonActionPerformed
            checksolution();
        // TODO add your handling code here:
    }//GEN-LAST:event_checkbuttonActionPerformed

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
            whitetextfields();
        // TODO add your handling code here:
    }//GEN-LAST:event_clearbuttonActionPerformed

    private void resetbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbuttonActionPerformed
        int a=JOptionPane.showConfirmDialog(resetbutton,"This will restart this puzzle\nAre you sure to continue?");
        if(a==JOptionPane.YES_OPTION)
        {
            resetpuzzle();
        }    
    }//GEN-LAST:event_resetbuttonActionPerformed

    private void instructionbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructionbuttonActionPerformed
        JOptionPane.showMessageDialog(null,"* Place the numbers such that each row,column and 3x3 box contains different numbers from 1 to 9.\n"
                                            +"* Some numbers are already fixed and cannot be changed.\n"
                                            +"* All the fields should contain a single digit number(1 to 9).\n"
                                            +"* After filling all the fields click on CHECK button to check your solution.\n"
                                            +"* Green color indicates that field is correctly filled.\n"
                                            +"* Red color indicates that field is incorrectly filled.\n"
                                            +"* Blue color indicates that field contains invalid digit.\n"
                                            +"* Click on CLEARCOLOR button to make the color of all fields white.\n"
                                            +"* RESET button will restart this puzzle by making all non-fixed fields blank.\n"
        );
        // TODO add your handling code here:
    }//GEN-LAST:event_instructionbuttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkbutton;
    private javax.swing.JButton clearbutton;
    private javax.swing.JLabel imagelabel;
    private javax.swing.JButton instructionbutton;
    private javax.swing.JButton resetbutton;
    private javax.swing.JPanel sudoku;
    public static javax.swing.JLabel sudokunamelabel;
    // End of variables declaration//GEN-END:variables
}
