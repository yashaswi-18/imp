package day4.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.dao.CourseDao;
import day4.bean.Course;
import day4.dao.DaoCourseInterface;

/**
 * Servlet implementation class CreateNewCourseServlet
 */
@WebServlet("/CreateNewCourse")
public class CreateNewCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String c_id = request.getParameter("courseId");
		String c_title = request.getParameter("courseTitle");
		String c_duration = request.getParameter("courseDuration");
		String c_provider = request.getParameter("courseProvider");
		String c_fees = request.getParameter("courseFees");

		
		//Converting the Strings into Integers as required
		int course_id = Integer.parseInt(c_id);
		int course_duration = Integer.parseInt(c_duration);
		int course_fees = Integer.parseInt(c_fees);

		//System.out.println(course_id + " " + c_title + " " + course_duration + " " + c_provider + " " + course_fees);
		
		Course co = new Course(course_id, c_title, course_duration, c_provider,course_fees);
		DaoCourseInterface<Course,Integer> idao = new CourseDao();
		idao.create(co);
		out.println("<h2>Course created successfully..</h2>");
	}

}
