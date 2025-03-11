/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import main.StudentRegister;
import model.Student;

/**
 *
 * @author erpys
 */
public class FileManager {
    
    public static void startRecords(){
        
        try  {
            FileReader fileread = new FileReader("records.txt");
            BufferedReader br = new BufferedReader(fileread);

            String line;
            
            for (line = br.readLine(); line != null ; line = br.readLine()) {
                
                String[] datos = line.split(";");
                String name = datos[0];
                String lastname = datos[1];
                int age = Integer.valueOf(datos[2]); 
                String course = datos[3];
                String dni = datos[4];
                
                Student student = new Student(name, lastname, age, course, dni);
                StudentRegister.records.add(student);

             }
        } catch (IOException e) {
            System.out.println("Error reading file!");
            System.out.println("");
        }  
        
    }
    
    
    public static void createFile() {
        
        try {
            File file = new File("records.txt");
            if (file.createNewFile()) {
                System.out.println("File created! :)");
            } else {
                System.out.println("The file already exists! :)");
            }
        } catch (IOException e) {
            System.out.println("The error occurred while trying to create the file! :(");
        }
    }
    
    
    public static void overWriteFile() {
        System.out.println("prueba");
        try (FileWriter wr = new FileWriter("records.txt")) {
            String br = System.lineSeparator();
            
            for(Student studentfor : StudentRegister.records){
                wr.write(studentfor.getName() +";"+ studentfor.getLastname()+";"+ studentfor.getAge() +";"+ studentfor.getCourse() +";"+ studentfor.getDni() + br);
            }
            System.out.println(""); 
            
        } catch (IOException e) {
            
            System.err.println("Error writing the file!");
            System.out.println("");
            
        }
    }
    
    
    public static void showFileData(){
        
        boolean doit = false;
        try  {
             FileReader fileread = new FileReader("records.txt");
             BufferedReader br = new BufferedReader(fileread);

             String line;


             int cont = 1;
             for (line = br.readLine(); line != null ; line = br.readLine()) {

                String[] fields = line.split(";");

                System.out.println("------------");
                System.out.println("  Alumno " + cont);
                System.out.println("------------");
                System.out.println("Name: " + fields[0]);
                System.out.println("Last Name: " + fields[1]);
                System.out.println("Age: " + fields[2]);
                System.out.println("Class: " + fields[3]);
                System.out.println("Dni: " + fields[4]);
                System.out.println("");
                cont++;
                doit = true;
             }
        } catch (IOException e) {
            System.out.println("Error reading file!");
            System.out.println("");
        }  
        if (!doit) {
            System.out.println("There are no students to show.!");
            System.out.println("");
        }
        
    }
    
    
    public static void showByDni(String dni) {
        
        try {
            FileReader fileread = new FileReader("records.txt");
            BufferedReader br = new BufferedReader(fileread);   
            
            String line;
            boolean doit = false;
            
            for (line = br.readLine(); line != null ; line = br.readLine()) {
                String[] fields = line.split(";");
                
                if (dni.equalsIgnoreCase(fields[4])){
                    System.out.println("-----------");
                    System.out.println("  Alumno ");
                    System.out.println("-----------");
                    System.out.println("Name: " + fields[0]);
                    System.out.println("Last Name: " + fields[1]);
                    System.out.println("Age: " + fields[2]);
                    System.out.println("Class: " + fields[3]);
                    System.out.println("Dni: " + fields[4]);
                    System.out.println("");
                    doit = true;
                    break;
                }
            }
            
            if (!doit){
                System.out.println("This DNI doesn't exist!");
                System.out.println("");
            }
            
        } catch(IOException e){
            System.out.println("Error reading file!");
        }
    }
    
}

    

