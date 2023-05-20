package com.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.database.GradeDataBase;
import com.model.User;

public class MyGradeView {
	public MyGradeView(GradeDataBase gradedata) {
		JFrame jf=new JFrame("My Grade");		
		JLabel jl1 = new JLabel("GPA:");
		JLabel jl2 = new JLabel(String.format("%.1f",gradedata.GPA));
		String[] s= {"Order","Course","Credit","Semester","Attribute","RegularGrade","FinalExamGrade","TotalGrade"};
		String[][] s2=new String[gradedata.gradeArray.size()][8];	// 定义二维数组用于JTable展示
		gradedata.SelAllQinshi(s2);
		JTable jt=new JTable(s2,s);
		JScrollPane jsp=new JScrollPane(jt);
		JPanel jp = new JPanel();
		jp.add(jl1);
		jp.add(jl2);
		jf.setLayout(new BorderLayout());
		jf.add(jp,BorderLayout.NORTH);
		jf.add(jsp,BorderLayout.CENTER);
		jf.setBounds(300,150,800,500);
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyGradeView(new GradeDataBase(new User()));
	}
}
