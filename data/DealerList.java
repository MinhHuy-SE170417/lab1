/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;
import java.util.ListIterator;
import tools.MyTool;
import mng.LogIn;
/**
 *
 * @author ASUS
 */
public class DealerList extends ArrayList<Dealer> {
    LogIn loginObj = null;
    private static final String PHONEPATTERN = "\\d{9} |\\d{11}";
    private String dataFile = "";
    boolean changed = false; 
    String ID;
    String name; 
    String addr;
    String phone;
    boolean continuing=true;
    boolean codeDupplicated = false;
    int pos;
    Dealer d;
    ListIterator li = null;

    public DealerList(LogIn loginObj) {
        this.pos = pos;
        this.d = d;
    }

    private void loadDealerFromFile(){
        MyTool.readLinesFromFile(fileName);
    }
    public void initWithFile(){
        Config cR= new Config();
        dataFile = cR.getDealerFile();
        loadDealerFromFile();
    }

    private int searchDealer(String ID){
        boolean found = false;
        if(this.size()==0) System.out.println("Empty list");
        else{
            ID = MyTool.sc.nextLine();
            int N = this.size();
            for(int i = 0; i<N; i++){
                if(this.get(i).getID().equals(ID)) return i;
            }
        }
                if(!found) 
                    System.out.println("Not found");
        return -1;
    }
    
    public void searchDealer(){
        ID = MyTool.sc.nextLine();
        pos = searchDealer(ID);
        if(pos<0) System.out.println("Not found");
        else System.out.println(pos);
    }
    
    public void addDealer(){
        do{
            ID = MyTool.readPattern("ID of new dealer: ", Dealer.ID_FORMAT);
            ID = ID.toUpperCase();
            pos = searchDealer(ID);
            if(pos>=0) System.out.println("ID is dupplicated");
        }
        while(pos>=0);
        name = MyTool.readNonBlank("Name of new dealer:").toUpperCase();
        addr = MyTool.readNonBlank("Address of new dealer:");
        phone = MyTool.readPattern("Phone number: ", Dealer.PHONE_FORMAT);
        continuing = true;
        d = new Dealer(ID, name, addr, phone, continuing);
        this.add(d);
        System.out.println("New dealer added");  
    }
    
    public void removeDealer(){
        do{ 
            ID = MyTool.readPattern("Enter ID to remove:", Dealer.ID_FORMAT);
            pos = searchDealer(ID);
            if(pos<0) System.out.println("Not found");
            else{
                this.remove(d);
                System.out.println("Removed");
                continuing = false; 
                changed = true;
            }
        }
        while(continuing = true);
    }
    
    public void updateDealer(){
        System.out.println("Dealer's ID needs updating: ");
        ID = MyTool.sc.nextLine();
        pos = searchDealer(ID);
        if(pos<0) System.out.println("Not found");
        else {
            Dealer d = this.get(pos);
            String newName = "";
            System.out.println("Enter new name: ");
            newName = MyTool.sc.nextLine().trim().toUpperCase();
            if(!newName.isEmpty()){
                d.setName(newName);
                changed = true; 
            }
            String newAddr = "";
            System.out.println("Enter new address: ");
            newAddr = MyTool.sc.nextLine().trim().toUpperCase();
            if(!newAddr.isEmpty()){
                d.setAddr(newAddr);
                changed = true;
            }
            String newPhone = "";
            System.out.println("Enter new phone number: ");
            newPhone = MyTool.sc.nextLine().trim();
            if(!newPhone.isEmpty()){
                d.setPhone(newPhone);
                changed = true;
            }
        }
    }
    
    public void printAllDealers(){
        if(this.isEmpty()) System.out.println("Empty list");
        else System.out.println(this);
    }
    
    public void printContinuingDealers(){
        ArrayList al = new ArrayList();
        int N = this.size();
        for(int i = 0; i<N; i++){
            if(continuing == true){
               al.add(this.get(i).getID());
            }
            System.out.println(al);
        }
    
    }
    
    public void printUncontinuingDealers(){
        ArrayList al = new ArrayList();
        int N = this.size();
        for(int i = 0; i<N; i++){
            if(continuing == false){
               al.add(this.get(i).getID());
            }
            System.out.println(al);
        }
    
    }
    
    public void writeDealerToFile(){
        if(changed){
            MyTool.writeFile(dataFile, this);
            changed = false;
        }
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public boolean isChanged() {
        return changed;
    }

}
