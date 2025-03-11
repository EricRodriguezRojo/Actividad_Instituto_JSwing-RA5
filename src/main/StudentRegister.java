    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import JSwings.Home;
import Manager.FileManager;
import Manager.StudentManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Student;

/**
 *
 * @author erpys
 */
public class StudentRegister     {

    public static ArrayList<Student> records = new ArrayList();
    
    public static void main(String[] args) {
        createFile();
        startRecords();
        
        Home home = new Home();
        home.setVisible(true);

    }
    

    
    public static void startRecords() {
        
        Manager.FileManager.startRecords();
       
    }
    
    public static void createFile(){
        
        Manager.FileManager.createFile();

    }
    
    public static void NewStudent(){
        
        Student student = Manager.StudentManager.createStudent();
        records.add(student);
            
        FileManager.overWriteFile();

    }
    
    public static void StudentList(){
        
       FileManager.showFileData();
       
    }
    public static void SearchStudentDni(){

        String dni = StudentManager.AskDni();
        
        FileManager.showByDni(dni);
    }
    
    public static void DeleteStudent() {
        
        FileManager.showFileData();
        
        String dni = StudentManager.AskDni();
        
        boolean doitfor = false;
        for(Student student : records) {

            if (dni.equalsIgnoreCase(student.getDni())) {
                records.remove(student);
                doitfor = true;
                break;
            }
        }
        
        if (doitfor == false) {
            System.out.println("This DNI doesn't exist!");
        }else{
            System.out.println("The student was eliminated successfully!");
        }
        
        FileManager.overWriteFile();
        
    }
    
}

    

