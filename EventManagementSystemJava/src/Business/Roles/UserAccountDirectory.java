/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Roles;

import Business.Person.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nitin
 */
public class UserAccountDirectory {
    List<UserAccount> userAccountList;
    public UserAccountDirectory(){
        userAccountList = new ArrayList<>();
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    public UserAccount getUserByID(int id){
        for(UserAccount userAccount: userAccountList){
            if(userAccount.getPerson().getId()==id){
                return userAccount;
            }
        }
        return null;
    }
        
    public UserAccount createUserAccount(String username, String password, Person person, Role role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setPerson(person);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }

    public List<UserAccount> getUserAccountList() {
        return userAccountList;
    }

    public void setUserAccountList(List<UserAccount> userAccountList) {
        this.userAccountList = userAccountList;
    }
    
    public void deleteUser(UserAccount userAccount){
        userAccountList.remove(userAccount);
    }
    
}
