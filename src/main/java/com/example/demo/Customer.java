package com.example.demo;

public class Customer {

	private String name;
    private int roleID;

    public Customer(String name, int roleID) {
        this.name = name;
        this.roleID = roleID;
    }
   public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
    
    @Override
    public String toString() {
        return "Customer{" +  "name=" + name + ", roleID=" + roleID + '}';
    }    
}
