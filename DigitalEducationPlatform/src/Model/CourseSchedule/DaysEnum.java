/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Model.CourseSchedule;

/**
 *
 * @author snehayenduri
 */
public enum DaysEnum {
    Monday("Monday"), Tuesday("Tuesday"), Wednesday("Wednesday"), Thursday("Thursday"), Friday("Friday"), Saturday("Saturday"), Sunday("Sunday");
    private String val;
    private DaysEnum(String val){
        this.val =val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
    
}
