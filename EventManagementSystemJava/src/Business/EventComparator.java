/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Business.Enterprise.Event;
import java.util.Comparator;

/**
 *
 * @author nitin
 */
public class EventComparator implements Comparator<Event>{

    @Override
    public int compare(Event o1, Event o2) {
      return Integer.compare(o2.getAcceptedGuestList().size(),o1.getAcceptedGuestList().size());
    }
    
}
