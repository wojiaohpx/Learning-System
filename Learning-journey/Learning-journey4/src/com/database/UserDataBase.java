package com.database;

import java.util.ArrayList;

import com.model.User;

public class UserDataBase {
		// �������ݼ��еĸ����б�
		public ArrayList<User> userarray = new ArrayList<User>();
		// ���幹�췽�������û��б�����ʼ��
		public UserDataBase(){
			userarray.add(new User(1,"liming","111"));
			userarray.add(new User(2,"zhangdong","111"));
		}
}
