
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
public class ScheduleQueries {
    private static Connection connection;
    private static PreparedStatement addScheduleEntry;
    private static ResultSet resultSet;
    private static PreparedStatement  getScheduledStudentCount;
    private static PreparedStatement getScheduleByStudent;
    
    public static void  addScheduleEntry(ScheduleEntry entry){
        connection = DBConnection.getConnection();
        try
        {
            addScheduleEntry = connection.prepareStatement("insert into app.schedule (semester,coursecode,studentid,status,timestamp) values (?,?,?,?,?)");
            addScheduleEntry.setString(1,entry.getSemester());
            addScheduleEntry.setString(2,entry.getCourseCode());
            addScheduleEntry.setString(3,entry.getStudentID());
            addScheduleEntry.setString(4,entry.getStatus());
            addScheduleEntry.setString(5,String.valueOf(entry.getTimeStamp()));
            
            
            
            
            
            addScheduleEntry.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    public static int getScheduledStudentCount(String semester, String courseCode){
        connection = DBConnection.getConnection();
        int count = 0;
        
        
        try{
            getScheduledStudentCount = connection.prepareStatement("select count(studentID) from app.schedule where semester = (?) and courseCode = (?)");
            getScheduledStudentCount .setString(1,semester);
            getScheduledStudentCount .setString(2,courseCode);
            resultSet = getScheduledStudentCount.executeQuery();
            while(resultSet.next()){
                count = resultSet.getInt(1);
            }
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return count;
        
        
    }
    public static ArrayList<ScheduleEntry> getScheduleByStudent(String semester, String studentID){
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> entry = new ArrayList<ScheduleEntry>();
        
        try{
            getScheduleByStudent = connection.prepareStatement("select semester,coursecode,studentid,status,timestamp from app.schedule where semester = (?) and studentid =(?) order by timestamp");
            getScheduleByStudent.setString(1,semester);
            getScheduleByStudent.setString(2,studentID);
            resultSet = getScheduleByStudent.executeQuery();
            while(resultSet.next()){
               
                ScheduleEntry student = new ScheduleEntry(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getTimestamp(5));
                entry.add(student);
                System.out.println(resultSet.getString(4));
            }
            
            }
            
        
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return entry;
    }
    
}
