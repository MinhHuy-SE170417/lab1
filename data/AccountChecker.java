/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import tools.MyTool;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class AccountChecker {
    private String accFile; 
    private static String SEPARATOR = ",";
    public AccountChecker(){
        setupAccFile();
    }
    private void setupAccFile(){
        Config cR = new Config();
        accFile = cR.getAccountFile();
    }
    public boolean check (Account acc){
        List<String> lines = MyTool.readLinesFromFile(accFile);
        for(String line : lines){
            String[] parts = line.split(this.SEPARATOR);
            if(parts.length<3) return false;
            if(parts[0].equalsIgnoreCase(acc.getAccName()) &&
               parts[1].equals(acc.getPwd()) &&
               parts[2].equalsIgnoreCase(acc.getRole()))
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        AccountChecker aChk = new AccountChecker();
        Account acc = new Account("E002", "34567890", "BOSS");
        boolean valid = aChk.check(acc);
        System.out.println(valid);
        acc = new Account("E001", "567007632", "ACC-1");
        valid = aChk.check(acc);
        System.out.println(valid);
        acc = new Account("E003", "626263232", "ACC-2");
        valid = aChk.check(acc);
        System.out.println(valid);
    }
}
