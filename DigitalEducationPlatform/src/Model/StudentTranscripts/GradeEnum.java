/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package StudentTranscripts;

/**
 *
 * @author snehayenduri
 */
public enum GradeEnum {
    A, A_, B, B_, F;

    @Override
    public String toString() {
      
        return switch (this) {
            case A -> "A";
            case A_ -> "A-";
            case B -> "B";
            case B_ -> "B-";
            case F -> "F";
            default -> null;
        };
    }
    
    
}
