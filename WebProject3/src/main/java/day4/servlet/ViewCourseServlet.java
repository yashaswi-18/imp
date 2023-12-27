package day4.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.bean.Course;
import day4.dao.CourseDao;
import day4.dao.DaoCourseInterface;

/**
 * Servlet implementation class ViewCourseServlet
 */
@WebServlet("/ViewCourseServlet")
public class ViewCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String courseIdString = request.getParameter("courseId");

       
            int courseId = Integer.parseInt(courseIdString);
            
    		DaoCourseInterface<Course,Integer> idao = new CourseDao();

            Course course = idao.getOne(courseId);

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            if (course != null) {
              
                out.println("<h2 style='color:purple'>Course Details</h2>");
                out.println("<p>Course ID: " + course.getCourseId() + "</p>");
                out.println("<p>Course Name: " + course.getTitle()+ "</p>");
                out.println("<p>Provider: " + course.getProvider() + "</p>");
                out.println("<p>Fees: " + course.getFees() + "</p>");
            } else {
                out.println("<h2 style='color:red'>Enter valid Course ID , try again.</h2>");
            }
	}

}
