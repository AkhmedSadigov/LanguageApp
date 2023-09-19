package menu;

import util.FileUtility;

import java.util.Map;
import java.util.Scanner;
public class Menu {
    private static final Map<String, String> result;

    static {
        try {
            result = FileUtility.readFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void menu() {
        try{
            Scanner sc=new Scanner(System.in);
            System.out.print("Menu:\n" +
                    "1. Start\n" +
                    "2. Exit\n" +
                    "Please write number of process: ");
            int processNumber=sc.nextInt();
            if(processNumber==1 || processNumber==2){
                if(processNumber==1){
                    start();
                }else {
                    System.exit(0);
                }
            }else{
                System.out.println("Please enter valid number!");
                menu();
            }
        }catch (Exception exception){
            System.out.println("Enter number of process!");
            menu();
        }

    }

    private static void start(){
        System.out.println("Welcome to Language Program.\n" +
                "Please select should question be asked in English or in Azerbaijan language?\n" +
                "1. English\n" +
                "2. Azerbaijan");
        operation();
    }
    private static void operation() {
        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("Write number of operation: ");
            int decision = sc.nextInt();
            if (decision == 1 || decision == 2) {
                while (result.entrySet().iterator().hasNext()) {
                    if (decision == 1) {
                        operationEng();
                    } else {
                        operationAz();
                    }
                }
            } else {
                System.out.println("Please enter valid operation!");
                operation();
            }
        }
        catch (Exception ex){
            System.out.println("Enter valid answer!");
            operation();
        }

    }
    private static void operationEng() {
        for (Map.Entry<String, String> entry : result.entrySet()) {
            int loops=0;
            int maxAttempts=3;
            if(loops<result.size()){
            while (true) {
                Scanner sc2 = new Scanner(System.in);
                System.out.println("What is translation of " + entry.getKey());
                String answer = sc2.nextLine();
                if (answer.equalsIgnoreCase(entry.getValue())) {
                    System.out.println("True");
                    loops++;
                    break;
                } else {
                    System.out.println("False.");
                    maxAttempts--;
                }

                if(maxAttempts==0){
                    System.out.println("Answer should be - "+entry.getValue());
                    loops++;
                    break;
                }
              }
            }
        }
        System.out.println("Words finished. Thanks for participate!");
        menu();
    }
    private static void operationAz () {
        for (Map.Entry<String, String> entry : result.entrySet()) {
            int loops=0;
            int maxAttempts=3;
            if(loops<result.size()){
                while (true) {
                    Scanner sc3 = new Scanner(System.in);
                    System.out.println(entry.getValue() + " - bu sozun tercumesi nedir?");
                    String answer = sc3.nextLine();
                    if (answer.equalsIgnoreCase(entry.getKey())) {
                        System.out.println("Dogrudur.");
                        loops++;
                        break;
                    } else {
                        System.out.println("Yanlisdir.");
                        maxAttempts--;
                    }

                    if(maxAttempts==0){
                        System.out.println("Cavab bu olmali idi - "+entry.getKey());
                        loops++;
                        break;
                    }
                }
            }

        }
        System.out.println("Sozler bitdi. Istirak ucun tesekkur edirik!");
        menu();
    }
}
