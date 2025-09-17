/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Shevaag
 */
class Manager extends User {
    public Manager(String username, String password) {
        super(username, password, "Manager");
    }

    @Override
    public void accessDashboard() {
        new ManagerDashboard().setVisible(true);
        System.out.println("Manager logged in.");
    }
    
    @Override
    public void performRoleAction() {
        System.out.println("Manager can create user accounts.");
    }
}


