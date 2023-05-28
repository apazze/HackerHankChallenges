import java.util.Arrays;
import java.util.Scanner;

class Arithmetic {
}
class Adder extends Arithmetic{

}
//class Inheritance {
//    public static void main(String[] args) {
//        Adder adder = new Adder();
//        System.out.println(adder.getClass().getSuperclass().getName());
//    }
//}

interface AdvancedArithmetic{
    int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic{

    public MyCalculator(){
        System.out.println("I implemented: "+ Arrays.stream(this.getClass().getInterfaces()).findFirst().get().getName());
    }

    public int divisor_sum(int n){
        int res = 0;
        for (int i = n; i>0; i--){
            if(n%i == 0) res+=i;
        }
        return res;
    }
}

//public class Solution {
//
//    public static void main(String[] args) {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Scanner sc = new Scanner(System.in);
//        MyCalculator my = new MyCalculator();
//        System.out.println(my.divisor_sum(sc.nextInt()));
//
//    }
//}



/**
 * Uma classe abstrata Java é uma classe que não pode ser instanciada. Isso significa que você não pode criar novas instâncias de uma classe abstrata. Funciona como base para subclasses. Você deve aprender sobre Java Inheritance antes de tentar este desafio.
 *
 * Segue um exemplo de classe abstrata:
 *
 *  classe  abstrata Livro {
 *     String  title ;
 *     abstract  void  setTitle ( String  s );
 *     String  getTitle (){
 *         return  title ;
 *     }
 * }
 * Se você tentar criar uma instância dessa classe como a linha a seguir, receberá um erro:
 *
 * Livro  new_novel = novo  Livro ();
 * Você tem que criar outra classe que estenda a classe abstrata. Em seguida, você pode criar uma instância da nova classe.
 *
 * Observe que o método setTitle também é abstrato e não possui corpo. Isso significa que você deve implementar o corpo desse método na classe filha.
 */

/**
 *
 * Uma interface Java pode conter apenas assinaturas de método e campos. A interface pode ser usada para atingir o polimorfismo
 *
 */

/**
 *
 * Quando um método em uma subclasse substitui um método na superclasse, ainda é possível chamar o método substituído usando a palavra-chave super . Se você escrever super.func() para chamar a função func() , ela chamará o método que foi definido na superclasse.
 */

class Cycle{
    String getWhoami() {
        return "Hello I am a motorcycle, I am a cycle with an engine.\nMy ancestor is a cycle who is a vehicle with pedals.";
    }
}

class Motorcycle extends Cycle{
    @Override
    String getWhoami() {
        return super.getWhoami();
    }
}

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Motorcycle moto = new Motorcycle();
        System.out.println(moto.getWhoami());
    }
}