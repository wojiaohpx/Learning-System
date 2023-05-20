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
	// �����������Ͷ��󣬼���ϵͳ���ݼ��б����
	UserDataBase userdata = new UserDataBase();
	CourseDataBase coursedata = null;
	GradeDataBase gradedata = null;
	public Login() {
		// ��������
		JFrame jf = new JFrame("��¼");
		jf.setBounds(300, 300,500,200);
		// ���岼������
		jf.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
		// ����ؼ�
		JLabel jl1 = new JLabel("�û�����");
		JLabel jl2 = new JLabel("��    �룺");
		JTextField nametxt = new JTextField(20);
		JPasswordField passwordtxt = new JPasswordField(20);
		JButton jb1 = new JButton("ȷ��");	
		JButton jb2 = new JButton("�˳�");
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER,30,0));
		// ���ؼ���ӵ����
		jp1.add(jl1);jp1.add(nametxt);
		jp2.add(jl2);jp2.add(passwordtxt);
		jp3.add(jb1);jp3.add(jb2);
		// �������ӵ�����
		jf.add(jp1);jf.add(jp2);jf.add(jp3);
		
		// ���ô���ɼ�		
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �¼�
		// ȷ����ť
		jb1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// �����¼������û������������
				String name = nametxt.getText();
				String pass = new String(passwordtxt.getPassword());	// char[] תΪ String
				// �ж��û����������Ƿ���ȷ
				int i;
				for(i=0;i<userdata.userarray.size();i++){
					User u = userdata.userarray.get(i);
					if (u.getName().equals(name.trim()) && u.getPassword().equals(pass.trim())){
						JOptionPane.showMessageDialog(null, "��¼�ɹ�");
						coursedata = new CourseDataBase(u);
						gradedata = new GradeDataBase(u);
						new MainView(u,coursedata,gradedata);
						jf.dispose();
						break;
					}
				}
				if(i==userdata.userarray.size()){
					JOptionPane.showMessageDialog(null, "�û��������벻��ȷ", "��ʾ", JOptionPane.ERROR_MESSAGE);					
				}
			}
		});
		// �˳���ť
		jb2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});		
	}

	public static void main(String[] args) {
		// ����Login���󣬼�������¼����
		new Login();
	}

}
