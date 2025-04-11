import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;


import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


// item, vendingmachine, viewitems, registeritem, selectitem, insertmoney, 
class Item{
    int code;
    String name;
    int price;
    int quantity;
    
    public Item(int code , String name , int price , int quantity){
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

class vendingmachine{
    Map<Integer, Item> inventory;
    int nextitemcode;
    Item currentselection;
    int currentamountpaid;
    
    public vendingmachine(){
        inventory = new HashMap<>();
        nextitemcode = 1;
        currentselection = null;
        currentamountpaid = 0;
    }
    
    public String viewitems(){
        if(inventory.isEmpty()){
            return "No items available";
        }
        
        StringBuilder sb = new StringBuilder();
        for(Item item : inventory.values()){
            sb.append("Code: ").append(item.code)
            .append("Name: ").append(item.name)
            .append("Price: ").append(item.price)
            .append("Quantity: ").append(item.quantity).append("\n");
        }
        
        return sb.toString().trim();
    }
    
    public String registeritem(String name , int price , int quantity){
        Item newitem = new Item(nextitemcode, name, price, quantity);
        inventory.put(nextitemcode , newitem);
        
        String output = "Item added , item_code: " + nextitemcode;
        
        return output;
    }
    
    public String selectitem(int itemcode){
        if(!inventory.containsKey(itemcode)){
            return "Wrong item code";
        }
        
        Item item = inventory.get(itemcode);
        
        if(item.quantity <= 0){
            return "Not available right now";
        }
        
        currentselection = item;
        currentamountpaid = 0;
        
        return "You selected: "+ item.name + "($" + item.price + ")";
    }
    
    public String insertmoney(int amount){
        if(currentselection == null){
            return "No item selected";
        }
        currentamountpaid += amount;
        
        if(currentamountpaid < currentselection.price){
            int remaining = currentselection.price - currentamountpaid;
            
            return "Payemnt recieved: $" + amount + ". Remaing amount: $" + remaining;
        }
        else{
            int change = currentamountpaid - currentselection.price;
            
            currentselection.quantity -= 1;
            
            String output = "Payemnt recieved: $" + amount + ". Dispensing " + currentselection.name;
            if(change > 0){
                output += ". Remaing change: $" + change;
            }
            currentselection = null;
            currentamountpaid = 0;
            return output;
        }
    }
}
class Result {

    /*
     * Complete the 'vend' function below.
     *
     * The function accepts STRING_ARRAY input_args as parameter.
     */

    public static void vend(List<String> input_args) {
    // Write your code here
    vendingmachine vm = new vendingmachine();
    for(String commandline : input_args){
        String[] tokens = commandline.split(" ");
        
        if(tokens[0].equalsIgnoreCase("VIEW_ITEMS")){
            System.out.println(vm.viewitems());
        }
        else if(tokens[0].equalsIgnoreCase("REGISTER_ITEM")){
            String name = tokens[1];
            int price = Integer.parseInt(tokens[2]);
            int quantity = Integer.parseInt(tokens[3]);
            
            System.out.println(vm.registeritem(name, price, quantity));
        }
        else if(tokens[0].equalsIgnoreCase("SELECT_ITEM")){
            int itemcode = Integer.parseInt(tokens[1]);
            
            System.out.println(vm.selectitem(itemcode));
        }
        else if(tokens[0].equalsIgnoreCase("INSERT_MONEY")){
            int amount = Integer.parseInt(tokens[1]);
            
            System.out.println(vm.insertmoney(amount));
        }
        else{
            System.out.println("Invalid");
        }
    }
    
    

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        
        List<String> commads = new ArrayList<>();
        commads.add("VIEW_ITEMS");
        commads.add("REGISTER_ITEM Cola 35 5");
        commads.add("SELECT_ITEM 1");
        commads.add("INSERT_MONEY 20");
        commads.add("INSERT_MONEY 20");
        Result v = new Result();
        v.vend(commads);
        
    }
}
