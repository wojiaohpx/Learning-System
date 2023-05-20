package com.database;

import java.util.ArrayList;

import com.model.User;

public class UserDataBase {
		// 定义数据集中的各种列表
		public ArrayList<User> userarray = new ArrayList<User>();
		// 定义构造方法：对用户列表做初始化
		public UserDataBase(){
			userarray.add(new User(1,"liming","111"));
			userarray.add(new User(2,"zhangdong","111"));
		}
}
