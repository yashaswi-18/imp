package day4.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import day4.bean.Course;
import day4.utils.JDBCUtilsCourse;

public class CourseDao implements DaoCourseInterface<Course, Integer> {

	@Override
	public Collection<Course> getAll() {
		// TODO Auto-generated method stub
		Collection<Course> allCourses = new ArrayList<>();

		String sqlQuery = "select courseId , title, duration ,provider,fees from Course ";
		
		try(
			Connection conn = JDBCUtilsCourse.buildConnection();
			Statement stmt =conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);
		){
			while(rs.next())
			{
				//reading the value
				int courseId = rs.getInt(1);
				String title = rs.getString(2);//title
				int duration = rs.getInt(3);
				String provider = rs.getString(4);
				int fees = rs.getInt(5);

			//populating restaurant object based upon the values fetch from the records
				Course currentBook = new Course(courseId , title, duration ,provider,fees);
				allCourses.add(currentBook);
			}
		
	}
	catch(Exception ex)
	{
			ex.printStackTrace();
	}	
	return allCourses;
	
	}

	@Override
	public Course getOne(Integer id) {
          Course foundCourse = null;
		
		try(
				Connection conn = JDBCUtilsCourse.buildConnection();

				){
			String sqlQuery = "select courseId , title, duration ,provider,fees from Course where courseId=?";
            PreparedStatement pstmt =conn.prepareStatement(sqlQuery);
            pstmt.setInt(1, id);  //1-index , id 5 it is actual value
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next())
            {
            	int courseId = rs.getInt(1);
				String title = rs.getString(2);//title
				int duration = rs.getInt(3);
				String provider = rs.getString(4);
				int fees = rs.getInt(5);
				
				foundCourse = new Course(courseId , title, duration ,provider,fees);
            }
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return foundCourse;
	}

	@Override
	public void create(Course newCourse) {
		String sqlQuery ="insert into Course(courseId,title, duration ,provider,fees) values (?,?,?,?,?)";
		try(
				Connection conn =JDBCUtilsCourse.buildConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
				){
		
			
			
			int courseId = newCourse.getCourseId();
			String title = newCourse.getTitle();
			int duration = newCourse.getDuration();
			String provider = newCourse.getProvider();
			int fees =newCourse.getFees();
			
			pstmt.setInt(1, courseId);
			pstmt.setString(2, title);
			pstmt.setInt(3, duration);
			pstmt.setString(4, provider);
			pstmt.setInt(5, fees);
			
			int count = pstmt.executeUpdate();
			System.out.println(count + " record inserted");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

	@Override
	public void update(Course modifiedCourse) {
		String sqlQuery = "update Course set title=?, duration=? ,provider=?,fees=? where courseId=? ";
		try(
				Connection conn =JDBCUtilsCourse.buildConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
				){
			
			
			String title = modifiedCourse.getTitle();
			int duration = modifiedCourse.getDuration();
			String provider = modifiedCourse.getProvider();
			int fees =modifiedCourse.getFees();
			int courseId = modifiedCourse.getCourseId();
			
			//substituting the values for unknown parameters
			
			pstmt.setString(1, title);
			pstmt.setInt(2, duration);
			pstmt.setString(3, provider);
			pstmt.setInt(4, fees);
			pstmt.setInt(5, courseId);
			
			int count =pstmt.executeUpdate();
			System.out.println(count+ " record updated");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteOne(Integer id) {
String sqlQuery ="delete from Course where courseId = ?";
		
		try(
				Connection conn =JDBCUtilsCourse.buildConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
				){
			
			//substituting the values for unknown parameters
			pstmt.setInt(1, id);
		
			
			int count = pstmt.executeUpdate();
			System.out.println(count + " record deleted");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	

}
