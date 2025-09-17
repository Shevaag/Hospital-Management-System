/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class User {
    private String username;
    private String password;
    private String role;

    public User(String username, String password, String role) {
        this.username = username.trim();
        this.password = password.trim();
        this.role = role.trim();
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

    @Override
    public String toString() {
        return username + "," + password + "," + role;
    }

    public void saveToFile(String filePath) {
        try (FileWriter fw = new FileWriter(filePath, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            pw.println(this.toString());
            System.out.println("User written to file: " + this.toString());
        } catch (IOException e) {
            System.out.println("Error saving user: " + e.getMessage());
        }
    }

    public static List<User> readFromFile(String filePath) {
        List<User> users = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return users;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    users.add(new User(data[0].trim(), data[1].trim(), data[2].trim()));
                } else {
                    System.out.println("Skipping invalid entry: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user file: " + e.getMessage());
        }
        return users;
    }
    
    public void accessDashboard() {
        System.out.println("Accessing default user dashboard...");
    }
    
    public void performRoleAction() {
        System.out.println("Performing default user actions.");
    }
}




