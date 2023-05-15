import inventory.Inventory;
import inventory.exceptions.FullStorageException;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String newObject = "";

        System.out.println("Ingresa la capacidad de tu inventario: ");
        int capacity = Integer.parseInt(input.nextLine()); //nextInt has problems with EOL
        Inventory inv = new Inventory(capacity);
        boolean salir=false;
        do{

            int opcion=menu();
            switch (opcion){
                case 1:try {
                    System.out.println("Ingresa un objeto a tu inventario: ");
                    newObject = input.nextLine();
                    inv.setItem(newObject);

                } catch (FullStorageException e) {
                    // HERE you can do something with the exception :)
                    System.err.println(e.getMessage());
                }
                    break;
                case 2:inv.loadItemsFromFile("pets");
                    break;
                case 3:inv.listar();
                break;
                case 4:
                    System.out.println("Salió");
                    salir=true;
                    break;
            }

        }
        while (!salir);

        //TODO Borrar Elementos del inventario, Añadir Elementos a través de un archivo externo y manejar excepciones
        // como FileNotFoundException, también crear validaciones por medio de Excepciones personalizadas

    }

    public static int menu(){
        Scanner sc= new Scanner(System.in);
        int option=0;
       do {
           option=0;
           System.out.println("1: añadir item");
           System.out.println("2 Listar:");
           System.out.println("3 Cargar Items");
           System.out.println("4 Salir");
           try {
               option = sc.nextInt();
           } catch (NumberFormatException e) {
               System.out.println("Opción no valida");
           }
       }while(option<1 || option>4);
       return option;

    }
}