
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sanji
 */
public class CourseQueries {
    private static Connection connection;
    private static ArrayList<String> faculty = new ArrayList<String>();
    private static PreparedStatement addCourse;
    private static PreparedStatement getAllCourses;
    private static PreparedStatement getAllCourseCodes;
    private static PreparedStatement getCourseSeats;
    
    private static ResultSet resultSet;
    
    public static void addCourse(CourseEntry course) //string Name)
    {
        connection = DBConnection.getConnection();
        try
        {
            addCourse = connection.prepareStatement("insert into app.course (semester,coursecode,description,seats) values (?,?,?,?)");
            addCourse.setString(1,course.getSemester());
            addCourse.setString(2,course.getCourseCode());
            addCourse.setString(3,course.getCourseDescription());
            addCourse.setString(4,String.valueOf(course.getSeats()));
            
            
            addCourse.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    public static ArrayList<CourseEntry> getAllCourses(String Semester){
        connection = DBConnection.getConnection();
        ArrayList<CourseEntry> courses = new ArrayList<CourseEntry>();
        
        
        try{
            getAllCourses = connection.prepareStatement("select coursecode,description, seats from app.course where semester = (?) order by coursecode");
            getAllCourses.setString(1,Semester);
            resultSet = getAllCourses.executeQuery();
             while(resultSet.next())
            {
                //courses.add(resultSet.getString(1));
                int seats = Integer.valueOf(resultSet.getString(3));
                CourseEntry course = new CourseEntry("fall 22",resultSet.getString(1),resultSet.getString(2),seats);
                courses.add(course);
            }
            
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return courses;
    }
    public static ArrayList<String> getAllCourseCodes(String Semester){
        connection = DBConnection.getConnection();
        ArrayList<String> courseCodes = new ArrayList<String>();
        
        
        try{
            getAllCourseCodes = connection.prepareStatement("select coursecode from app.course where semester = (?) order by coursecode");
            getAllCourseCodes.setString(1,Semester);
            resultSet = getAllCourseCodes.executeQuery();
             while(resultSet.next())
            {
                courseCodes.add(resultSet.getString(1));
                
                
                
            }
            
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return courseCodes;
    }
     public static int getCourseSeats(String Semester, String courseCode){
        connection = DBConnection.getConnection();
        int seats =0;
        
        
        try{
            getCourseSeats = connection.prepareStatement("select seats from app.course where semester = (?) and coursecode =(?)");
            getCourseSeats.setString(1,Semester);
            getCourseSeats.setString(2,courseCode);
            resultSet = getCourseSeats.executeQuery();
            
            while(resultSet.next()){
                seats = resultSet.getInt(1);
            }
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return seats;
    }
    
    
}
  