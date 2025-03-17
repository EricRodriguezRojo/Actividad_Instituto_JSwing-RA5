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
import javax.swing.UIManager;
import model.Student;

/**
 *
 * @author erpys
 */
public class StudentRegister     {

    public static ArrayList<Student> records = new ArrayList();
    
    public static void main(String[] args) {
        Manager.FileManager.createFile();
        Manager.FileManager.startRecords();
       
        Home home = new Home();
        home.setVisible(true);
        
    }
    
}
