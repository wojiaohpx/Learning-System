package com.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import com.database.CourseDataBase;
import com.database.GradeDataBase;
import com.model.Course;
import com.model.Grade;

public class FileUtils {
	//导出文件根目录
	public static String fileUrlRoot = "D:\\";
	/**
	 * 导入课程
	 * @return
	 */
	public static ArrayList<Course> importCourse() {
		ArrayList<Course> list = new ArrayList<Course>();
		String[] dataSplit = null;
		try {  
            File file = new File("data/course.txt");  
            BufferedReader bufread;  
            String read;  
            bufread = new BufferedReader(new FileReader(file));  
            while ((read = bufread.readLine()) != null) {  
            	dataSplit = read.split(",");
            	list.add(new Course(Integer.valueOf(dataSplit[0]),dataSplit[1],dataSplit[2],dataSplit[3],dataSplit[4],
            			dataSplit[5],dataSplit[06]));
            } 
            bufread.close();  
        } catch (FileNotFoundException ex) {  
            ex.printStackTrace();  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        }  
		return list;
	}
	public static void addCourse(Course c) {
		try {
			File file = new File("data/course.txt"); 
			BufferedWriter out = null;                                                   
	        try {                                                                        
	             out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));                              
	             out.write("\r\n"+c.toString());                                                      
	         } catch (Exception e) {                                                     
	             e.printStackTrace();                                                    
	         } finally {                                                                 
	            try {                                                                    
	                 out.close();                                                        
	             } catch (IOException e) {                                               
	                 e.printStackTrace();                                                
	             }                                                                       
	         }   
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 导入成绩
	 * @return
	 */
	public static ArrayList<Grade> importGrade() {
		ArrayList<Grade> list = new ArrayList<Grade>();
		String[] dataSplit = null;
		try {  
            File file = new File("data/grade.txt");  
            BufferedReader bufread;  
            String read;  
            bufread = new BufferedReader(new FileReader(file));  
            while ((read = bufread.readLine()) != null) {  
            	dataSplit = read.split(",");
            	list.add(new Grade(Integer.valueOf(dataSplit[0]),dataSplit[1],dataSplit[2],dataSplit[3],dataSplit[4],
            			dataSplit[5],dataSplit[6]));
            } 
            bufread.close();  
        } catch (FileNotFoundException ex) {  
            ex.printStackTrace();  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        }  
		return list;
	}
	

	// 导出课程
	public static String exportCourse(CourseDataBase courseData) {
		BufferedWriter bufferedWriter = null;
		try {
			File file = new File(fileUrlRoot + "course.txt");
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
			for (Course c : courseData.courseArray) { 
				bufferedWriter.write(c.getCourse() + "," +c.getTeacher() + "," +c.getTotalCreditHours()+ "," +c.getCredit()
				+ "," +c.getSemester()+ "," +c.getAttribute()+ "\r\n"); 
			}
			bufferedWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "导出成功！文件路径：" + fileUrlRoot + "course.txt";
	}

	// 导出成绩
	public static String exportGrade(GradeDataBase gradeData) {
		BufferedWriter bufferedWriter = null;
		try {
			File file = new File(fileUrlRoot + "grade.txt");
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
			for (Grade g : gradeData.gradeArray) { 
				bufferedWriter.write(g.getCourse() + "," +g.getCredit() + "," +g.getSemester()+ "," +g.getAttribute()
				+ "," +g.getRegularGrade()+ "," +g.getFinalExamGrade()+ "," +String.format("%.1f",g.getTotalGrade())+ "\r\n"); 
			}
			bufferedWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "导出成功！文件路径：" + fileUrlRoot + "grade.txt";
	}
}
