
import javax.swing.*;
import java.util.Scanner;

public class Main {
    public final String alphabet[] = {"a","b","c", "d","e", "f","g", "h",
            "i", "j","k", "l","m", "n","o", "p",
            "q", "r","s", "t","u", "v","w", "x", "y", "z"};

    public String[][] creationMatrix(int rows, int columns){
        String alphabetMatrix[][];
        alphabetMatrix = new String[rows][columns];
        return alphabetMatrix;
    };

    public String[][] puttingData(String[][] array){
        int rows = array.length;
        int columns = array[0].length;
        int counter = 0;
        for (int x = 0; x< rows; x++){
            for (int j= 0;j < columns; j++){
                array[x][j] = alphabet[counter];
                counter++;
            };
        };
        return array;
    };

    public String[] separator(String response, int rows, int columns){
        String array[];
        array = new String[rows];
        int jumps = 0;
        String elementSeparator = "";
        for (int x = 0; x < rows; x++){
            elementSeparator = response.substring((jumps),(columns + jumps));
            array[x] = elementSeparator+",";
            jumps += columns;
        }
        return array;
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------+");
        System.out.println("--------Alphabet----------+");
        System.out.println("--------------------------+");
        System.out.println("Ingrese el numero de filas");
        int rows = Integer.parseInt(sc.next());
        System.out.println("Ingrese el numero de columnas");
        int columns = Integer.parseInt(sc.next());

        String alphabetMatrixWithData[][];
        alphabetMatrixWithData = new String[rows][columns];
        Main mainClass = new Main();
        String stringResponse = "";
        try {
            for (int x = 0; x < rows; x++){
                for (int j = 0;j < columns; j++){
                    alphabetMatrixWithData[x][j] = mainClass.puttingData(mainClass.creationMatrix(rows,columns))[x][j];
                    stringResponse += alphabetMatrixWithData[x][j];
                }
            }
            for(int x = 0; x < rows; x++ ){
                System.out.println(mainClass.separator(stringResponse, rows, columns)[x]);
            }
        }
        catch (Exception e) {
            System.out.println("La estas cagando estas metiendo mas filas y columnas que tiene el abecedario");
        }
    }
}
