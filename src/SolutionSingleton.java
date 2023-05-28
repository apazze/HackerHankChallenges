import java.util.Scanner;

/**
 * "O padrão singleton é um padrão de design que restringe a instanciação de uma classe a um objeto.
 * Isso é útil quando exatamente um objeto é necessário para coordenar ações no sistema."
 */


class Singleton{
    private Singleton(){
        System.out.println("Hello I am a singleton! Let me say "+str+" to you");
    }

    public String str = new Scanner(System.in).nextLine();
    private static Singleton instance = null;

    public static Singleton getSingleInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
public class SolutionSingleton {

    public static void main(String[] args) {
        Singleton obj = Singleton.getSingleInstance();
    }
}
