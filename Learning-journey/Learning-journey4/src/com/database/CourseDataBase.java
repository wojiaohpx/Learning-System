package com.database;

import java.util.ArrayList;

import com.model.Course;
import com.model.User;
import com.utils.FileUtils;

public class CourseDataBase {
	
	public ArrayList<Course> courseArray = new ArrayList<Course>();

	public CourseDataBase(User user) {
		//初始化数据
		ArrayList<Course> initArray = FileUtils.importCourse();
		//删选数据为当前登录用户
		for (Course c : initArray) {
			if (c.getUserId() == user.getUserId()) {
				courseArray.add(c);
			}
		}
	}

	// 查询登录用户的课程信息
	public void SelAllQinshi(String[][] s) {
		for (int i = 0; i < courseArray.size(); i++) {
			s[i][0] = Integer.toString(i+1); // 序号
			s[i][1] = courseArray.get(i).getCourse();
			s[i][2] = courseArray.get(i).getTeacher();
			s[i][3] = courseArray.get(i).getTotalCreditHours();
			s[i][4] = courseArray.get(i).getCredit();
			s[i][5] = courseArray.get(i).getSemester();
			s[i][6] = courseArray.get(i).getAttribute();
		}
	}

}
