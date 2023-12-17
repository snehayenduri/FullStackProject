package Model.Persona;

import Model.People.Person;
import Model.People.PersonDirectory;
import java.util.ArrayList;
/**
 *
 * @author nitin
 */
public class UserDirectory {

    ArrayList<User> userList;

    public UserDirectory() {

        userList = new ArrayList();

    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public User newUserAccount(Person p) {

        User sp = new User(p);
        userList.add(sp);
        return sp;
    }

    public User findStudent(String id) {

        for (User sp : userList) {

         //   if (sp.isMatch(id)) {
         //       return sp;
         //   }
        }
            return null; //not found after going through the whole list
         }
    
    public void populateUsers(PersonDirectory personDirectory){
        for (int i = 1; i <= 10; i++) {
            String userId = "u_" + i;
            String password = "p_" + i;
            User user = new User(personDirectory.findPerson(i));
            user.setPassword(Validations.passwordHashing(password));
            user.setPlatformID(i);
            user.setRole("Professor");
            user.setUserID(userId);
  
            userList.add(user);
        }
        
        for (int i = 11; i <= 30; i++) {
            String userId = "u_" + i;
            String password = "p_" + i;
            User user = new User(personDirectory.findPerson(i));
            user.setPassword(Validations.passwordHashing(password));
            user.setPlatformID(i);
            user.setRole("Student");
            user.setUserID(userId);
  
            userList.add(user);
        }
    }
    
}
