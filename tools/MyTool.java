/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Calendar;
import data.DealerList;
/**
 *
 * @author ASUS
 */
public class MyTool {
    public static final Scanner sc = new Scanner(System.in);
    public static boolean validStr(String str, String regEx){
        if(str.matches(regEx)) return true;
        return false;
    }
    public static boolean validPassword(String str, int minLen){
        if(str.length()<minLen) return false;
        return str.matches(".*[a-zA-Z]+.") &&
                str.matches(".*[\\d]+.*") &&
                str.matches(".*[\\W]+.*");  
    }
    public static Date parseDate(String dateStr, String dateFormat){
        SimpleDateFormat dF = (SimpleDateFormat)SimpleDateFormat.getInstance();
        dF.applyPattern(dateFormat);
        try{
            long t = dF.parse(dateStr).getTime();
            return new Date(t);
            
        }
        catch(ParseException e){
            System.out.println(e);
        }
        return null;
    }
    public static String dateToStr(Date date, String dateFormat ){
        date = Calendar.getInstance().getTime();
        SimpleDateFormat dF = new SimpleDateFormat("yyyy-mm-dd");
        dF.applyPattern(dateFormat);
        String strDate = dateFormat.formatted(date);
        System.out.println(strDate);
        return strDate;
    }
    public static String readNonBlank(String message){
        String input = "";
        do{
            System.out.println(message+":");
            input = sc.nextLine().trim();
        }
        while(input.isEmpty());
        return input;
    }
    public static String readPattern(String message, String pattern){
        String input = "";
        boolean valid; 
        do{
            System.out.println(message+":");
            input = sc.nextLine().trim();
            valid = validStr(input, pattern);
        }
        while (!valid);
        return input;
    }
    public static boolean readBool(String message){
        String input;
        System.out.println(message + "[Y/N]:");
        input = sc.nextLine().trim();
        if(input.isEmpty()) return false;
        char c = Character.toUpperCase(input.charAt(0));
        return (c=='Y');
    }
    public static List<String> readLinesFromFile(String fileName){

    }
    public static void writeFile(String fileName, List list){
        try{
            File file = new File(fileName);
            FileWriter output = new FileWriter(file);
            PrintWriter pw = new PrintWriter(output);
            output.write(fileName);
        }
    }  
    public static void main(String[] args) {
        
    }
}
