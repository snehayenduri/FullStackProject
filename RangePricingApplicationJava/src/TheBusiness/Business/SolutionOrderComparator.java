/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TheBusiness.Business;

import TheBusiness.SolutionOrders.SolutionOrder;
import java.util.Comparator;

/**
 *
 * @author nitin
 */
public class SolutionOrderComparator implements Comparator<SolutionOrder>{

    @Override
    public int compare(SolutionOrder o1, SolutionOrder o2) {
        return Integer.compare(o1.getActualPrice()-o1.getTargetPrice(), o2.getActualPrice()-o2.getTargetPrice());
    }
    
}
