package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.database.CourseDataBase;
import com.database.GradeDataBase;
import com.model.User;
import com.utils.FileUtils;

public class MainView {	
	public MainView(User loginUser,CourseDataBase courseData,GradeDataBase gradeData) {	
		
		JFrame jf=new JFrame("学习之旅系统");
		JMenuBar jmb=new JMenuBar();
		JMenu a1=new JMenu("我的记录");		
		JMenu a2=new JMenu("导出");
		JMenu a3=new JMenu("退出系统");
		jmb.add(a1);jmb.add(a2);jmb.add(a3);
		
		JMenuItem jmi0=new JMenuItem("添加课程");
		jmi0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddCourseView(courseData,loginUser);
			}			
		});
		JMenuItem jmi1=new JMenuItem("我的课程");
		jmi1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyCourseView(courseData);
			}			
		});
		JMenuItem jmi2=new JMenuItem("我的成绩");
		jmi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyGradeView(gradeData);
				
			}			
		});
		JMenuItem jmi3=new JMenuItem("导出课程");
		jmi3.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = FileUtils.exportCourse(courseData);
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		JMenuItem jmi4=new JMenuItem("导出成绩");
		jmi4.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = FileUtils.exportGrade(gradeData);
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		JMenuItem jmi5=new JMenuItem("退出");
		jmi5.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		a1.add(jmi0);a1.add(jmi1);a1.add(jmi2);
		a2.add(jmi3);a2.add(jmi4);
		a3.add(jmi5);
		jf.setJMenuBar(jmb);
		jf.setBounds(300,150,800, 400);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
