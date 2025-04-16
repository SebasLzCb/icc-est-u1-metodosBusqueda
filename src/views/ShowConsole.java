package views;
import java.util.Scanner;

public class ShowConsole {
    private Scanner scanner;

    public ShowConsole(){
        this.scanner = new Scanner(System.in);
        showBanner();
    }

    public void showBanner(){
        System.out.println("*** Métodos de Búsqueda ***");
    }

    public int inputCode(){
        System.out.print("Ingrese código: ");
        int code = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del salto de línea
        return code;
    }

    public String inputName(){
        System.out.print("Ingrese nombre: ");
        return scanner.nextLine();
    }

    public void showMessage(String message){
        System.out.println(message);
    }
}
