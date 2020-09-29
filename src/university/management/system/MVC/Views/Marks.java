/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.management.system.MVC.Views;
import university.management.system.MVC.Models.courseMarks;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Marks extends JFrame{

   JTextArea t1;
   JPanel p1;
   
   public Marks(){}
   public Marks(String str){
       setSize(500,600);
       setLayout(new BorderLayout());
       
       p1 = new JPanel();

       t1 = new JTextArea(50,15);
       JScrollPane jsp = new JScrollPane(t1);
       t1.setFont(new Font("Senserif",Font.ITALIC,18));
       
       add(p1,"North");
       
       add(jsp,"Center");
       
       setLocation(450,200);
       mark(str);
   }
   
   public void mark(String s){
    try{
           courseMarks cm=new courseMarks();

           t1.setText("\tResult of Examination\n\nSubject\n");

           String sql="select * from subject where rollno="+s;

           ResultSet rs1 = cm.getMarks(sql);
           if(rs1.next()){
               t1.append("\n\t"+rs1.getString("subject1"));
               t1.append("\n\t"+rs1.getString("subject2"));
               t1.append("\n\t"+rs1.getString("subject3"));
               t1.append("\n\t"+rs1.getString("subject4"));
               t1.append("\n\t"+rs1.getString("subject5"));
               t1.append("\n-----------------------------------------");
               t1.append("\n");
           }

           String sql2="select * from marks where rollno="+s;
           
           ResultSet rs2 = cm.getMarks(sql2);
           if(rs2.next()){
               t1.append("\nMarks\n\n\t"+rs2.getString("marks1"));
               t1.append("\n\t"+rs2.getString("marks2"));
               t1.append("\n\t"+rs2.getString("marks3"));
               t1.append("\n\t"+rs2.getString("marks4"));
               t1.append("\n\t"+rs2.getString("marks5"));
               t1.append("\n-----------------------------------------");
               t1.append("\n");
           }
         
       }catch(Exception e){
           e.printStackTrace();
       }
   }
   
   public static void main(String[] args){
       new Marks().setVisible(true);
   }
}