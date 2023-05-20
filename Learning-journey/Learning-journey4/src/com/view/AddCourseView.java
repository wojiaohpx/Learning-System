package com.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.database.CourseDataBase;
import com.model.Course;
import com.model.User;
import com.utils.FileUtils;

public class AddCourseView {
	public static Course c = null;
	
	public AddCourseView(CourseDataBase cdb,User u) {
		JFrame jf=new JFrame("新增课程");
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setLayout(new GridLayout(7,2));
		JLabel jl1=new JLabel("Course : ",SwingConstants.RIGHT);
		JTextField jt1=new JTextField(15);
		JLabel jl2=new JLabel("Teacher : ",SwingConstants.RIGHT);
		JTextField jt2=new JTextField(15);
		JLabel jl3=new JLabel("TotalCreditHours : ",SwingConstants.RIGHT);
		JTextField jt3=new JTextField(15);
		JLabel jl4=new JLabel("Credit : ",SwingConstants.RIGHT);
		JTextField jt4=new JTextField(15);
		JLabel jl5=new JLabel("Semester : ",SwingConstants.RIGHT);
		JTextField jt5=new JTextField(15);
		JLabel jl6=new JLabel("Attribute : ",SwingConstants.RIGHT);
		JTextField jt6=new JTextField(15);
		
		JButton jb1=new JButton("Add");
		
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = new Course(u.getUserId(),jt1.getText(),jt2.getText(),jt3.getText()
						,jt4.getText(),jt5.getText(),jt6.getText());
				cdb.courseArray.add(c);
				FileUtils.addCourse(c);
				JOptionPane.showMessageDialog(null,"新增成功");
				jt1.setText("");jt2.setText("");jt3.setText("");jt4.setText("");jt5.setText("");jt6.setText("");
				jt1.setFocusable(true);
			}
		});
		JButton jb2=new JButton("关闭");
		jb2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
			}
		});
		jf.add(jl1);jf.add(jt1);
		jf.add(jl2);jf.add(jt2);
		jf.add(jl3);jf.add(jt3);
		jf.add(jl4);jf.add(jt4);
		jf.add(jl5);jf.add(jt5);
		jf.add(jl6);jf.add(jt6);
		jf.add(jb1);jf.add(jb2);
		jf.setBounds(500,200,400, 200);
		
		jf.setVisible(true);
	}
}
