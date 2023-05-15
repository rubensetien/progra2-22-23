package inventory;



import inventory.exceptions.FullStorageException;

import java.io.*;
import java.util.ArrayList;

public class Inventory implements  IInventory{
    int capacity = 0;
    ArrayList<String> items;

    /**
     * @param capacity  The number of items that the inventory can handle
     */

    public Inventory(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<String>();
    }
    public Inventory() {
        this.capacity = 10;
        this.items = new ArrayList<String>();
    }
    /**
     * AddItem method lets you add a new item to the inventory
     *
     * @param val       The String value that you want to add to inventory
     * @exception FullStorageException  If the number of items has reached the capacity of the inventory
     */
    @Override
    public void setItem(String val) throws FullStorageException {
        if(hasAvailableStorage()){
            this.items.add(val);
        }
        else {
            throw new FullStorageException("No space left");
        }
    }

    /**
     * getItems method gives you the actual items in the inventory
     *
     * @return          Returns an ArrayList of the actual state of the inventory
     */
    @Override
    public ArrayList<String> getItems() {
        return this.items;
    }

    private Boolean hasAvailableStorage(){
        return this.items.size() < this.capacity ? true: false;
    }

    public void addItem(String item) throws FullStorageException {
        if(hasAvailableStorage()){//if(this.items.size()<capacity){
            this.items.add(item);

        }else {
            throw new FullStorageException("Capacidad excedida");
        }
    }

    public void listar(){
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }


    }

    public void loadList(ArrayList<String> items2){
        for (String i:items2){
            try {
                this.addItem(i);
            } catch (FullStorageException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void loadItemsFromFile (String nameFile){

        File f =new File(nameFile);
        if(f.exists()){
            try {
                BufferedReader br=new BufferedReader(new FileReader(f));
                String linea="";
                while((linea=br.readLine())!=null){
                    addItem(linea);

                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (FullStorageException e) {
                throw new RuntimeException(e);
            }
        }

    }

}