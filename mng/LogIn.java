/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mng;
import data.Account;
import data.AccountChecker;
import data.DealerList;
import tools.MyTool;

/**
 *
 * @author ASUS
 */
public class LogIn {
    private Account acc = null;

    public LogIn(Account acc) {
        this.acc = acc; 
    }
    
    public static Account inputAccount(){
        String accName, pwd, role;
        accName = MyTool.sc.nextLine();
        pwd = MyTool.sc.nextLine();
        role = MyTool.sc.nextLine();
        Account acc = new Account(accName, pwd, role);
        
        return acc;
    }

    public Account getAcc() {
        return acc;
    }
    
    
    
    }

