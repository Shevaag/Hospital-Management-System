/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Shevaag
 */
class Cashier extends User {
    public Cashier(String username, String password) {
        super(username, password, "Cashier");
    }

    @Override
    public void accessDashboard() {
        new CashierDashboard().setVisible(true);
        System.out.println("Cashier logged in.");
    }
    
    @Override
    public void performRoleAction() {
        System.out.println("Cashier can process payments.");
    }
}


