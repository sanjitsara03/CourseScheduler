/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sanji
 */
public class CourseEntry {
    private String Semester;
    private String CourseCode;
    private String CourseDescription;
    private int Seats;
    
    public CourseEntry(String Semester, String CourseCode, String CourseDescription, int Seats){
        this.Semester = Semester;
        this.CourseCode = CourseCode;
        this.CourseDescription = CourseDescription;
        this.Seats = Seats;
    }
    
    public String getSemester(){
        return Semester;
    }
    
    public String getCourseCode(){
        return CourseCode;
    }
    
    public String getCourseDescription(){
        return CourseDescription;
        
    }
    public int getSeats(){
        return Seats;
    }
}
