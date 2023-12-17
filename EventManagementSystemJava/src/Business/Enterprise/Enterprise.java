/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

/**
 *
 * @author nitin
 */
//why abstract? and where are we extending this
public abstract class Enterprise {
    private int enterpriseID;
    private String enterpriseName;

    public Enterprise(int enterpriseID, String enterpriseName) {
        this.enterpriseID = enterpriseID;
        this.enterpriseName = enterpriseName;
    }
    
    public int getEnterpriseID() {
        return enterpriseID;
    }

    public void setEnterpriseID(int enterpriseID) {
        this.enterpriseID = enterpriseID;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
    
   
}
