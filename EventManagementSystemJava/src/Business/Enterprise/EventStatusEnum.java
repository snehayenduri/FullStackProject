    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
     */
    package Business.Enterprise;

    /**
     *
     * @author snehayenduri
     */
    public enum EventStatusEnum {
        Created("Created"), Accepted("Accepted"), Requested("Requested"), InProgress("InProgress"), Done("Done"), Managing("Managing");

        private String value; 

        EventStatusEnum(String value){
            this.value = value;
        }
    }
