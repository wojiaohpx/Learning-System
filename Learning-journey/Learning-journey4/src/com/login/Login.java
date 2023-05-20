package com.login;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.database.CourseDataBase;
import com.database.GradeDataBase;
import com.database.UserDataBase;
import com.model.User;
import com.view.MainView;


public class Login {
	// 定义数据类型对象，即该系统数据集列表对象
	UserDataBase userdata = new UserDataBase();
	CourseDataBase coursedata = null;
	GradeDataBase gradedata = null;
	public Login() {
		// 创建窗体
		JFrame jf = new JFrame("登录");
		jf.setBounds(300, 300,500,200);
		// 窗体布局设置
		jf.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
		// 定义控件
		JLabel jl1 = new JLabel("用户名：");
		JLabel jl2 = new JLabel("密    码：");
		JTextField nametxt = new JTextField(20);
		JPasswordField passwordtxt = new JPasswordField(20);
		JButton jb1 = new JButton("确定");	
		JButton jb2 = new JButton("退出");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER,30,0));
		// 将控件添加到面板
		jp1.add(jl1);jp1.add(nametxt);
		jp2.add(jl2);jp2.add(passwordtxt);
		jp3.add(jb1);jp3.add(jb2);
		// 将面板添加到窗体
		jf.add(jp1);jf.add(jp2);jf.add(jp3);
		
		// 设置窗体可见		
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 事件
		// 确定按钮
		jb1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 定义登录窗体的用户名及密码变量
				String name = nametxt.getText();
				String pass = new String(passwordtxt.getPassword());	// char[] 转为 String
				// 判断用户名及密码是否正确
				int i;
				for(i=0;i<userdata.userarray.size();i++){
					User u = userdata.userarray.get(i);
					if (u.getName().equals(name.trim()) && u.getPassword().equals(pass.trim())){
						JOptionPane.showMessageDialog(null, "登录成功");
						coursedata = new CourseDataBase(u);
						gradedata = new GradeDataBase(u);
						new MainView(u,coursedata,gradedata);
						jf.dispose();
						break;
					}
				}
				if(i==userdata.userarray.size()){
					JOptionPane.showMessageDialog(null, "用户名或密码不正确", "提示", JOptionPane.ERROR_MESSAGE);					
				}
			}
		});
		// 退出按钮
		jb2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});		
	}

	public static void main(String[] args) {
		// 创建Login对象，即启动登录界面
		new Login();
	}

}
