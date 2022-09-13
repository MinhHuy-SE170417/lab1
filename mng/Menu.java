/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mng;
import data.Account;
import data.AccountChecker;
import data.Dealer;
import java.util.ArrayList;
import tools.MyTool;
import data.DealerList;
import java.util.Collection;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class Menu extends ArrayList<String> {
    Account acc = null; 
    boolean cont = false; 
    boolean valid = false; 
    public Menu(){
        super();
    }
    
    public Menu(String[] items){
        super();
        for(String item : items) this.add(item);
    }
    public static void main(String[] args) {
        do{
            AccountChecker accChk = new AccountChecker();
            acc = LogIn.inputAccount();
            valid = accChk.check(acc);
            if(!valid)
                cont = MyTool.readBool("Invalid account. Try again.");
            if(!valid && !cont) System.exit(0);
        }
        while(cont);
        LogIn loginObj = new LogIn(acc);
        if(acc.getRole().equalsIgnoreCase("ACC-1")){
            String[] options = {"Add new Dealer", "Search a Dealer", "Remove a Dealer", "Update a Dealer", "Print all Dealers", "Print continuing Dealers", "Print uncontinuing Dealers", "Write to file"};
            Menu menu = new Menu (options);
            DealerList dList = new DealerList(loginObj);
            dList.initWithFile();
            int choice = 0;
            do{
        }
    }
}

    