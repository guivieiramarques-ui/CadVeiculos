import java.util.Scanner;

public class Input {
    private static Scanner ler = new Scanner(System.in);

    public static String lerTexto(String msg) {
        System.out.print(msg);
        return ler.nextLine();
    }

    public static int lerInt(String msg) {
        System.out.print(msg);
        int num = ler.nextInt();
        ler.nextLine(); 
        return num;
    }
}