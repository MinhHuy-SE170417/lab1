/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import java.util.List;
import tools.MyTool;
/**
 *
 * @author ASUS
 */
public class Config {
    private static final String CONFIG_FILE = "DealerData/config.txt";
    private String accountFile;
    private String dealerFile;
    private String deliveryFile;
    
    public Config(){
        readData();
    }
    private void readData(){
        List<String> lines = MyTool.readLinesFromFile((CONFIG_FILE));
        for(String line : lines){
            line = line.toUpperCase();
            String[] parts = line.split(":");
            if(line.indexOf("ACCOUNT")>=0)
                accountFile = "DealerData/" + parts[1].trim();
            else if(line.indexOf("DEALER")>=0)
                dealerFile = "DealerData/" + parts[1].trim();
            else if(line.indexOf("Deliver")>=0)
                deliveryFile = "DealerData/" + parts[1].trim();
        }
    }

    public String getAccountFile() {
        return accountFile;
    }

    public String getDealerFile() {
        return dealerFile;
    }

    public String getDeliveryFile() {
        return deliveryFile;
    }
    
}
