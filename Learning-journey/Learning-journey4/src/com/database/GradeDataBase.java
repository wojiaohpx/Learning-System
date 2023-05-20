package com.database;

import java.util.ArrayList;

import com.model.Grade;
import com.model.User;
import com.utils.FileUtils;

public class GradeDataBase {
	
	public ArrayList<Grade> gradeArray = new ArrayList<Grade>();
	public double GPA = 0.0;
	public GradeDataBase(User user) {
		//初始化数据
		ArrayList<Grade> initArray = FileUtils.importGrade();
		double totalCredit = 0.0;
		double gpaBase = 0.0;
		//删选数据为当前登录用户
		for (Grade g : initArray) {
			if (g.getUserId() == user.getUserId()) {
				//计算总成绩
				g.setTotalGrade(Double.valueOf(g.getRegularGrade()) + Double.valueOf(g.getFinalExamGrade())*0.7);
				//计算总课程成绩*学分
				gpaBase += g.getTotalGrade()*Double.valueOf(g.getCredit());
				//总学分
				totalCredit +=  Double.valueOf(g.getCredit());
				gradeArray.add(g);
			}
		}
		GPA = gpaBase/totalCredit;
	}

	// 查询登录用户的课程信息
	public void SelAllQinshi(String[][] s) {
		for (int i = 0; i < gradeArray.size(); i++) {
			s[i][0] = Integer.toString(i+1); // 序号
			s[i][1] = gradeArray.get(i).getCourse();
			s[i][2] = gradeArray.get(i).getCredit();
			s[i][3] = gradeArray.get(i).getSemester();
			s[i][4] = gradeArray.get(i).getAttribute();
			s[i][5] = gradeArray.get(i).getRegularGrade();
			s[i][6] = gradeArray.get(i).getFinalExamGrade();
			//保留一位小数
			s[i][7] =String.format("%.1f",gradeArray.get(i).getTotalGrade());
		}
	}

}
