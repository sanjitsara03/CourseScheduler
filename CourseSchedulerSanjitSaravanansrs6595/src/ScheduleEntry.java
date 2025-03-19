


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sanji
 */
public class ScheduleEntry {
    private String semester;
    private String courseCode;
    private String StudentID;
    private String Status;
    java.sql.Timestamp timeStamp;
   
    
    public ScheduleEntry(String semester, String courseCode, String StudentID,String Status,java.sql.Timestamp timeStamp){
        this.semester = semester;
        this.courseCode = courseCode;
        this.StudentID = StudentID;
        this.Status = Status;
        this.timeStamp = timeStamp;
    }
    
    public String getSemester(){
        return semester;
    }
    
    public String getCourseCode(){
        return courseCode;
    }
    
    public String getStudentID(){
        return StudentID;
        
    }
    public String getStatus(){
        return Status;
    }
    public java.sql.Timestamp getTimeStamp(){
        return timeStamp;
    }
    
}
