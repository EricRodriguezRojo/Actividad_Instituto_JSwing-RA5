/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import model.Student;

/**
 *
 * @author erpys
 */
public class StudentManager {
    
    public static Student createStudent(){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter the last name: ");
        String lastname  = sc.nextLine();
        
        System.out.print("Enter the age: ");
        int age = sc.nextInt();
        
        System.out.print("Enter the course: ");
        String courserror  = sc.nextLine();
        String course  = sc.nextLine();
        
        System.out.print("Enter the DNI: ");
        String dni  = sc.nextLine();
        
        Student student = new Student(name, lastname, age, course, dni);
        
        return student;
    }
    
    
    public static String AskDni() {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the DNI of the student: ");
        String dni = sc.nextLine();
        
        return dni;
    }
    
    
    public static void showFileData(){
        
        boolean doit = false;
        try  {
             FileReader fileread = new FileReader("records.txt");
             BufferedReader br = new BufferedReader(fileread);

             String line = br.readLine();

             int cont = 1;
             while ( line != null) {

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
                
                line = br.readLine();
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
            
            String line = br.readLine();
            boolean doit = false;
            
            while(line != null) {
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
                line = br.readLine();
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
