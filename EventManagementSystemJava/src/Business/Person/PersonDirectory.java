/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author nitin
 */
public class PersonDirectory {
    private ArrayList<Person> personList;
    private int id = 1;
    
    public PersonDirectory(){
        personList = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }
    public Person createPerson(String name){
        Person newPerson = new Person(name, id++);
        personList.add(newPerson);
        return newPerson;
    }
    
    public Person getPersonById(int id){
        for(Person person : personList){
            if(person.getId() == id){
                return person;
            }
        }
        return null;
    }
}
