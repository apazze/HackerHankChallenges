import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        //List<Integer> arr = Arrays.asList(5, 1, 2, 3, 4, 5, 1);

        //String findNumber = findNumber(arr, 1);

        //List<Integer> oddNumber = oddNumber(1, 100000);

        //Scanner();

        //Printf();

        //Tabuada();

        //LacosPow();

    }

    private static void LacosPow() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // Qtd de querys - entradas
        List<List<Integer>> queries = new ArrayList<>();

        if (t >= 0 && t <= 500) {
            for (int i = 0; i < t; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int n = in.nextInt();
                queries.add(List.of(a, b, n));
                Arrays.asList(a, b, n);
            }
            in.close();
        }

        for (int i = 0; i < queries.size(); i++) {
            int a = queries.get(i).get(0);
            int b = queries.get(i).get(1);
            int n = queries.get(i).get(2);

            if ((a >= 0 && a <= 50) && (b >= 0 && b <= 50) && (n >= 0 && n <= 15)) {
                int soma = a;
                for (int x = 0; x < n; x++) {
                    soma += pow(2, x) * b;
                    System.out.print(soma + " ");
                }
            }
            System.out.println();
        }
    }

    private static void Tabuada() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        if (N >= 2 && N <= 20) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(N + " x " + i + " = " + N * i);
            }
        }

        bufferedReader.close();
    }

    private static void Printf() {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();

            System.out.printf("%-15s", s1);
            System.out.printf("%03d", x);
            System.out.println();
        }
        System.out.println("================================");

    }

    private static void Scanner() {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        double d = scanner.nextDouble();
        scanner.nextLine();
        String s = scanner.nextLine();

        System.out.println("Int: " + i);
        System.out.println("Double: " + d);
        System.out.println("String: " + s);
    }

    public static String findNumber(List<Integer> arr, int k) {
        String resultado = "NO";
        if ((k >= 1 && k <= 100000) && (arr.size() >= 1 && arr.size() <= 1000000000)) {
            for (int i = 1; i < arr.size() - 1; i++) {
                if (arr.get(i) == k) {
                    resultado = "YES";
                }
            }
        }

        return resultado;
    }

    public static List<Integer> oddNumber(int l, int r) {
        List<Integer> arr = new ArrayList<>();
        if ((l >= 1 && l <= 100000) && (r >= 1 && r <= 100000)) {
            if (l < r) {
                for (int i = l; i <= r; i++) {
                    if (i % 2 == 1) {
                        arr.add(i);
                    }
                }
            }
        }
        return arr;
    }
}