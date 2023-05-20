package com.database;

import java.util.ArrayList;

import com.model.Grade;
import com.model.User;
import com.utils.FileUtils;

public class GradeDataBase {
	
	public ArrayList<Grade> gradeArray = new ArrayList<Grade>();
	public double GPA = 0.0;
	public GradeDataBase(User user) {
		//��ʼ������
		ArrayList<Grade> initArray = FileUtils.importGrade();
		double totalCredit = 0.0;
		double gpaBase = 0.0;
		//ɾѡ����Ϊ��ǰ��¼�û�
		for (Grade g : initArray) {
			if (g.getUserId() == user.getUserId()) {
				//�����ܳɼ�
				g.setTotalGrade(Double.valueOf(g.getRegularGrade()) + Double.valueOf(g.getFinalExamGrade())*0.7);
				//�����ܿγ̳ɼ�*ѧ��
				gpaBase += g.getTotalGrade()*Double.valueOf(g.getCredit());
				//��ѧ��
				totalCredit +=  Double.valueOf(g.getCredit());
				gradeArray.add(g);
			}
		}
		GPA = gpaBase/totalCredit;
	}

	// ��ѯ��¼�û��Ŀγ���Ϣ
	public void SelAllQinshi(String[][] s) {
		for (int i = 0; i < gradeArray.size(); i++) {
			s[i][0] = Integer.toString(i+1); // ���
			s[i][1] = gradeArray.get(i).getCourse();
			s[i][2] = gradeArray.get(i).getCredit();
			s[i][3] = gradeArray.get(i).getSemester();
			s[i][4] = gradeArray.get(i).getAttribute();
			s[i][5] = gradeArray.get(i).getRegularGrade();
			s[i][6] = gradeArray.get(i).getFinalExamGrade();
			//����һλС��
			s[i][7] =String.format("%.1f",gradeArray.get(i).getTotalGrade());
		}
	}

}
