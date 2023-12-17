/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.CourseSchedule;

import java.time.LocalTime;

/**
 *
 * @author snehayenduri
 */
public class ScheduleFromTo {
    
    LocalTime from;
    LocalTime to;
    DaysEnum day;

    public LocalTime getFrom() {
        return from;
    }

    public void setFrom(int hour, int minute) {
        this.from = LocalTime.of(hour, minute);
    }

    public DaysEnum getDay() {
        return day;
    }

    public void setDay(DaysEnum day) {
        this.day = day;
    }
    
    public LocalTime getTo() {
        return to;
    }

    public void setTo(int hour, int minute) {
        this.to = LocalTime.of(hour, minute);
    }
    
    

    @Override
    public String toString() {
        return day.getVal()+" " + from + "-" + to;
    }
    
}
