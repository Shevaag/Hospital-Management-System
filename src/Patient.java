/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Shevaag
 */
public class Patient {
    private String name;
    private int age;
    private String category;

    public Patient(String name, int age, String category) {
        this.name = name;
        this.age = age;
        this.category = category;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return name + "," + age + "," + category;
    }

    public void saveToFile(String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(this.toString());
            bw.newLine();
            System.out.println("Patient written to file: " + this.toString()); 
        } catch (IOException e) {
            System.out.println("Error saving patient: " + e.getMessage());
        }
    }

    public static List<Patient> readFromFile(String filePath) {
        List<Patient> patients = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return patients;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    patients.add(new Patient(data[0].trim(), Integer.parseInt(data[1].trim()), data[2].trim()));
                } else {
                    System.out.println("Skipping invalid entry: " + line);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading patient file: " + e.getMessage());
        }
        return patients;
    }
}
