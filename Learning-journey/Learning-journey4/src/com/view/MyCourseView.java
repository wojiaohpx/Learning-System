package com.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.database.CourseDataBase;

public class MyCourseView {
	public MyCourseView(CourseDataBase coursedata) {
		JFrame jf=new JFrame("我的课程");		
		String[] s= {"Order","Course","Teacher","TotalCreditHours","Credit","Semester","Attribute"};
		String[][] s2=new String[coursedata.courseArray.size()][7];	// 定义二维数组用于JTable展示
		coursedata.SelAllQinshi(s2);
		JTable jt=new JTable(s2,s);
		JScrollPane jsp=new JScrollPane(jt);
		jf.getContentPane().add(jsp,BorderLayout.CENTER);
		jf.add(jsp);
		jf.setBounds(300,150,800,500);
		jf.setVisible(true);
	}
}
