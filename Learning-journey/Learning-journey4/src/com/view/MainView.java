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
		
		JFrame jf=new JFrame("ѧϰ֮��ϵͳ");
		JMenuBar jmb=new JMenuBar();
		JMenu a1=new JMenu("�ҵļ�¼");		
		JMenu a2=new JMenu("����");
		JMenu a3=new JMenu("�˳�ϵͳ");
		jmb.add(a1);jmb.add(a2);jmb.add(a3);
		
		JMenuItem jmi0=new JMenuItem("��ӿγ�");
		jmi0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddCourseView(courseData,loginUser);
			}			
		});
		JMenuItem jmi1=new JMenuItem("�ҵĿγ�");
		jmi1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyCourseView(courseData);
			}			
		});
		JMenuItem jmi2=new JMenuItem("�ҵĳɼ�");
		jmi2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyGradeView(gradeData);
				
			}			
		});
		JMenuItem jmi3=new JMenuItem("�����γ�");
		jmi3.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = FileUtils.exportCourse(courseData);
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		JMenuItem jmi4=new JMenuItem("�����ɼ�");
		jmi4.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = FileUtils.exportGrade(gradeData);
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		JMenuItem jmi5=new JMenuItem("�˳�");
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
