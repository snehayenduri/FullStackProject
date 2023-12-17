/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author nitin
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseDirectory;
    private int id=1;

    public EnterpriseDirectory() {
        enterpriseDirectory = new ArrayList<>();
    }
    
    public Enterprise addEnterprise(int enterpriseID, String enterpriseName){
        Enterprise e = new Enterprise(enterpriseID, enterpriseName) {};
        enterpriseDirectory.add(e);
        return e;
    }

    public ArrayList<Enterprise> getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(ArrayList<Enterprise> enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }
   
}
