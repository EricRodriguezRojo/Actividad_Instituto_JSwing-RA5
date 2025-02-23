/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
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

    public static void main(String[] args) {
        ArrayList<Student> records = new ArrayList();
        int opc;
        boolean exit = false;
        createFile();
        
        do{
            opc = menu();
            
            switch(opc) {
                case 1: NewStudent(records); break;
                case 2: StudentList(); break;
                case 3: DeleteStudent(records); break;
                case 4: SearchStudentDni(); break;
                case 5: exit = true;
            }
        }while(!exit);
        
    }
    
    public static int menu(){

        int opc;
        
        do{
            Scanner sc = new Scanner(System.in);
            
            System.out.println("==============================");
            System.out.println(" Student Registration Manager ");
            System.out.println("==============================");
            System.out.println("[1] Create new student in the register");
            System.out.println("[2] list of registered students");
            System.out.println("[3] Delete a student from the register");
            System.out.println("[4] Search for a student by their DNI");
            System.out.println("[5] Exit");
            
            System.out.print("Select an option: ");
            opc = sc.nextInt();
            
        }while(opc != 1 && opc != 2 && opc != 3 && opc != 4 && opc != 5);
        
        return opc;
        
    }
    
    public static void createFile(){
        
        Manager.FileManager.createFile();

    }
    
    public static void NewStudent(ArrayList<Student> records){
        
        Student student = Manager.StudentManager.createStudent();
        records.add(student);
            
        FileManager.overWriteFile(records);

    }
    
    public static void StudentList(){
        
       FileManager.showFileData();
       
    }
    public static void SearchStudentDni(){

        String dni = StudentManager.AskDni();
        
        FileManager.showByDni(dni);
    }
    
    public static void DeleteStudent(ArrayList<Student> records) {
        
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
        
        FileManager.overWriteFile(records);
        
    }
    
}

    

