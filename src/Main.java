import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Permission;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Pattern;

import static java.lang.Math.pow;
import static java.util.Calendar.LONG_STANDALONE;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");

        //List<Integer> arr = Arrays.asList(5, 1, 2, 3, 4, 5, 1);

        //String findNumber = findNumber(arr, 1);

        //List<Integer> oddNumber = oddNumber(1, 100000);

        //Scanner();

        //Printf();

        //Tabuada();

        //LacosPow();

        //PrimitiveDataTypes();

        //EOF();

        //DiaDaSemana();

        //Payment();

        //Sha256();

        //Palindromo();

        //Anagramas();

        //Split();

    }

    private static void Split() {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
        String[] split = s.trim().split("[,.!?'@_] *| +");

        List<String> arr = new ArrayList<>();
        for (String s1 : split){
            if(!s1.isEmpty()){
                arr.add(s1);
            }
        }
        System.out.println(arr.size());
        for (String s2 : arr) System.out.println(s2);
    }

    private static void Anagramas() {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();

        boolean ret;

        if (a.length() != b.length()) {
            ret = false;
        }
//        else {
//            char[] arr1 = a.toLowerCase().toCharArray();
//            char[] arr2 = b.toLowerCase().toCharArray();
//            Arrays.sort(arr1);
//            Arrays.sort(arr2);
//            ret = Arrays.equals(arr1, arr2);
//        }

        // Outra forma "comparando e comendo as letras de b" sem sort

        else {
            //a.toLowerCase(); // Imutável! Armazenar em outra variavel

            String s1 = a.toLowerCase();
            String s2 = b.toLowerCase();

            for (int i = 0; i < s1.length(); i++) {
                for (int j = 0; j < s2.length(); j++) {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        String aux = s2.substring(0, j);
                        String aux2 = s2.substring(j + 1);

                        s2 = aux + aux2;

                        break;
                    }
                }
            }
            ret = s2.length() == 0 ? true : false;
        }
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }

    private static void Palindromo() {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        String invertido = new StringBuilder(A).reverse().toString();

        System.out.println((invertido.equals(A)) ? "Yes" : "No");
    }

    private static void Sha256() throws NoSuchAlgorithmException {
        Scanner in = new Scanner(System.in);
        String text = in.next();

        StringBuffer sb = new StringBuffer();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(text.getBytes());
        byte byteData[] = digest.digest();

        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        System.out.println(sb.toString());
    }

    private static void Payment() {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        String india = NumberFormat.getCurrencyInstance(new Locale("en", "in")).format(payment);
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }

    private static void DiaDaSemana() throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        int month = Integer.parseInt(firstMultipleInput[0]);
//
//        int day = Integer.parseInt(firstMultipleInput[1]);
//
//        int year = Integer.parseInt(firstMultipleInput[2]);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, 2, 23); // month -1
        String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, LONG_STANDALONE, Locale.US).trim();
        dayOfWeek.toUpperCase();

//        bufferedWriter.write(res);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }

    private void ParserString() {
        DoNotTerminate doNotTerminate = new DoNotTerminate();
        doNotTerminate.forbidExit();

        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            in.close();
            //String s=???; Complete this line below
            String s = String.valueOf(n);
            //Write your code here

            System.out.println((n == Integer.parseInt(s)) ? "Good job" : "Wrong answer.");

        } catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }

    //The following class will prevent you from terminating the code using exit(0)!
    class DoNotTerminate {

        public class ExitTrappedException extends SecurityException {
            private static final long serialVersionUID = 1;
        }

        public void forbidExit() {
            final SecurityManager securityManager = new SecurityManager() {
                @Override
                public void checkPermission(Permission permission) {
                    if (permission.getName().contains("exitVM")) {
                        throw new ExitTrappedException();
                    }
                }
            };
            System.setSecurityManager(securityManager);
        }
    }

    private void AreaParalelogramoExec() {
        Scanner in = new Scanner(System.in);
        int breadth = in.nextInt();
        int height = in.nextInt();

        try {
            AreaParalelogramo area = new AreaParalelogramo(breadth, height);
            System.out.println(area.Result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    class AreaParalelogramo {
        public int Result;

        public AreaParalelogramo(int breadth, int height) throws Exception {
            if (breadth <= 0 || height <= 0) {
                throw new Exception("Breadth and height must be positive");
            }
            this.Result = breadth * height;
        }

    }

    private static void EOF() {
        List<String> lista = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String s = in.nextLine();
            lista.add(s);
        }
        int cont = 1;
        for (String item : lista) {
            System.out.println(cont + " " + item);
            cont++;
        }
    }

    private static void PrimitiveDataTypes() {
        //Java has 8 primitive data types; char, boolean, byte, short, int, long, float, and double.
        // For this exercise, we'll work with the primitives used to hold integer values (byte, short, int, and long):
        //A byte is an 8-bit signed integer.
        //A short is a 16-bit signed integer.
        //An int is a 32-bit signed integer.
        //A long is a 64-bit signed integer.

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> valores = new ArrayList<>();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String valor = in.next();
            valores.add(valor);
        }

        String canBeFittedIn = " can be fitted in:\n";
        String sByte = "* byte\n";
        String sShort = "* short\n";
        String sInt = "* int\n";
        String sLong = "* long\n";


        for (String valor : valores) {

            try {
                long x = Long.parseLong(valor);

                if (x >= Byte.MIN_VALUE && x <= Byte.MAX_VALUE) {
                    String out = String.format(canBeFittedIn + sByte + sShort + sInt + sLong);
                    System.out.print(valor + out);
                } else if (x >= Short.MIN_VALUE && x <= Short.MAX_VALUE) {
                    String out = String.format(canBeFittedIn + sShort + sInt + sLong);
                    System.out.print(valor + out);
                } else if (x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE) {
                    String out = String.format(canBeFittedIn + sInt + sLong);
                    System.out.print(valor + out);
                } else if (x >= Long.MIN_VALUE && x <= Long.MAX_VALUE) {
                    String out = String.format(canBeFittedIn + sLong);
                    System.out.print(valor + out);
                }

            } catch (Exception exception) {
                System.out.print(valor + " can't be fitted anywhere.\n");
            }
        }
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