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
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import main.StudentRegister;
import static main.StudentRegister.records;
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
    
    
    public static boolean showFileData(JTextArea LJshowlist){
        
        boolean doit = false;
        try  {
             FileReader fileread = new FileReader("records.txt");
             BufferedReader br = new BufferedReader(fileread);
             String jump = System.lineSeparator();
             String line;


            int cont = 1;
            LJshowlist.setText(""); // Limpia el JTextArea antes de mostrar datos nuevos

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");

                LJshowlist.append("                ----------------------" + jump);
                LJshowlist.append("                      Alumno " + cont + jump);
                LJshowlist.append("                ----------------------" + jump);
                LJshowlist.append("                Name: " + fields[0] + jump);
                LJshowlist.append("                Last Name: " + fields[1] + jump);
                LJshowlist.append("                Age: " + fields[2] + jump);
                LJshowlist.append("                Class: " + fields[3] + jump);
                LJshowlist.append("                Dni: " + fields[4] + jump);
                LJshowlist.append(jump);

                cont++;
                doit = true;
             }
        } catch (IOException e) {
            System.out.println("Error reading file!");
            System.out.println("");
        }  
        
        return doit;
    }
    
    
    public static boolean showByDni(String dni, JTextArea SJshowStudent) {
        SJshowStudent.setText("");
        boolean doit = false;
        try {
            FileReader fileread = new FileReader("records.txt");
            BufferedReader br = new BufferedReader(fileread);   
            String jump = System.lineSeparator();
            String line;
            
            for (line = br.readLine(); line != null ; line = br.readLine()) {
                String[] fields = line.split(";");
                
                if (dni.equalsIgnoreCase(fields[4])){
                    SJshowStudent.append("                    ----------------------" + jump);
                    SJshowStudent.append("                        Alumno " + jump);
                    SJshowStudent.append("                    ----------------------" + jump);
                    SJshowStudent.append("                    Name: " + fields[0] + jump);
                    SJshowStudent.append("                    Last Name: " + fields[1] + jump);
                    SJshowStudent.append("                    Age: " + fields[2] + jump);
                    SJshowStudent.append("                    Class: " + fields[3] + jump);
                    SJshowStudent.append("                    Dni: " + fields[4] + jump);
                    SJshowStudent.append(jump);
                    
                    
                    doit = true;
                    return true;
                    
                }
            }
            
            
        } catch(IOException e){
            System.out.println("Error reading file!");
        }
        
        return doit;
    }
    public static boolean DeleteStudent(String dni) {
        boolean doit = false;
        for(Student student : records) {

            if (dni.equalsIgnoreCase(student.getDni())) {
                records.remove(student);
                doit = true;
                break;
            }
        }
        overWriteFile();
        return doit;
    }
    
   
    
}

    

