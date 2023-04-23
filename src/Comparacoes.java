import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Player {

    String name;
    Integer score;

    public Player(String name, Integer score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player a, Player b) {
        if (a.score.equals(b.score)) {
            return a.name.compareTo(b.name);
        }
        return (a.score > b.score) ? -1 : 1;
    }
}

public class Comparacoes {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int qtd = scan.nextInt();
        Player[] player = new Player[qtd];
        Checker checker = new Checker();
        scan.nextLine();
        for (int i = 0; i < qtd; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
        Arrays.sort(player, checker);
        Arrays.stream(player).forEach(p -> System.out.println(p.name + " " + p.score));
    }
}