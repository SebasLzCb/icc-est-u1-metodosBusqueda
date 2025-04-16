package views;
import java.util.Scanner;
public class ShowConsole {
    private Scanner scanner;

    public ShowConsole(){
        this.scanner = new Scanner(System.in);
        showBanner();
    }
    public void showBanner(){
        System.out.println("***Metodos de Busqueda***");
    }
}
