/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Model.CourseSchedule;

/**
 *
 * @author snehayenduri
 */
public enum SemesterEnum {
    Fall2021("Fall2021"), Spring2021("Spring2021"), Fall2022("Fall2022"), Spring2022("Spring2022"), Fall2023("Fall2023");
    private String value;
    SemesterEnum (String value){
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    
}
