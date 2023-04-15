import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Permission;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

        //PatternRegex();

        //PatternIP();

        //RepeatWords();

        //PatternUsername();

        //MenorDiferenca();

        //ConversorBinToDec();

        //EsmagarTijolos();

        //ConversorDecToBinDevolveQuartoBit();

        //ParesBalanceados();

        //CutTheSticks();

        //TwoStrings();

        //Substring();

        //Tags();

        BigDecimal();

    }

    private static void BigDecimal() {
//        List<BigDecimal> list = List.of(
//                BigDecimal.valueOf(-100),
//                BigDecimal.valueOf(50),
//                BigDecimal.valueOf(0),
//                BigDecimal.valueOf(56.6),
//                BigDecimal.valueOf(90),
//                BigDecimal.valueOf(0.12),
//                BigDecimal.valueOf(.12),
//                BigDecimal.valueOf(02.34),
//                BigDecimal.valueOf(000.000));

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String[] s = new String[n+2]; // É do desafio do HackerHank
//        for (int i = 0; i < n; i++) {
//            s[i] = sc.next();
//        }
//        sc.close();

        String[] s = {"-100", "50", "0", "56.6", "90", "0.12", ".12", "02.34", "000.000"};

        List<String> temp = new ArrayList<>();

        for(int y = 0; y<s.length; y++){
            temp.add(s[y]);
        }

        temp.sort(Comparator.comparingDouble(Double::valueOf));

        Collections.reverse(temp);

        for(int z=0; z<temp.size()-1; z++){
            BigDecimal atual = new BigDecimal(temp.get(z));
            BigDecimal proximo = new BigDecimal(temp.get(z+1));

            if(atual.compareTo(proximo) == 0){
                String sAtual = temp.get(z);
                String sProximo = temp.get(z+1);

                if(!sAtual.contains("0.") || sAtual.contains("000")){
                    String aux = sAtual;
                    temp.set(z, sProximo);
                    temp.set(z+1, aux);
                }
            }
        }

        for(int x= 0; x < temp.size(); x++){
            Arrays.asList(s).set(x, temp.get(x));
        }

        Arrays.stream(s).forEach(System.out::println);
    }

    private static void Tags() {
        List<String> list = List.of(
                "<h1>had<h1>public</h1></h1>",
                "<>hello</><h>dim</h>",
                "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>",
                "<h1>Nayeem loves counseling</h1>",
                "<Amee>safat codes like a ninja</amee>",
                "<SA premium>Imtiaz has a secret crush</SA premium>",
                " ",
                "<h1>");

        List<String> out = new ArrayList<>();

        list.forEach(s -> {

            final String regex = "<(\\S[^<>]*)>(\\S[^<>]*)</(\\1)>";
            final Pattern pattern = Pattern.compile(regex);
            final Matcher matcher = pattern.matcher(s);
            boolean encontrado = false;

            while (matcher.find()) {
                out.add(matcher.group(2));
                encontrado = true;
            }
            if (!encontrado) out.add("None");

        });
        out.forEach(System.out::println);
    }

    private static void Substring() {
        String s = "welcometojava";
        int k = 3;

        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);

        for (int i = k; i <= s.length() - k; i++) {
            if (s.substring(i, i + k).compareTo(smallest) < 0) {
                smallest = s.substring(i, i + k);
            }
            if (s.substring(i, i + k).compareTo(largest) > 0) {
                largest = s.substring(i, i + k);
            }
        }

        System.out.println(smallest + "\n" + largest);
    }

    private static void TwoStrings() {
        String A = "hello";
        String B = "java";
        List<String> result = new ArrayList<>();

        result.add(String.valueOf(A.length() + B.length()));

        if (A.toLowerCase().compareTo(B.toLowerCase()) <= 0) { // A antes de B == negativo
            result.add("No");
        } else result.add("Yes");

        String A1 = A.substring(0, 1).toUpperCase() + A.substring(1).toLowerCase();
        String B1 = B.substring(0, 1).toUpperCase() + B.substring(1).toLowerCase();
        String out = A1 + " " + B1;

        result.add(out);
        result.forEach(System.out::println);
    }

    private static void CutTheSticks() {
        List<Integer> list = List.of(6, 5, 4, 4, 2, 2, 8);
        List<List<String>> result = new ArrayList<>();
        List<Integer> aux = new ArrayList<>();

        list.forEach(aux::add);
        aux.remove(aux.get(0));

        while (!verificaTermino(aux)) {
            List<String> aux2 = new ArrayList<>();

            aux.forEach(v -> aux2.add(v.toString()));

            Integer min = getMin(aux);

            aux2.add(min.toString());

            Long count = getCount(aux);
            aux2.add(count.toString());

            result.add(aux2);

            List<Integer> temp = new ArrayList<>();

            aux.forEach(i -> {
                if (i - min < 0) temp.add(0);
                else temp.add(i - min);
            });

            aux = List.copyOf(temp);
        }

        List<String> aux2 = new ArrayList<>();
        aux.forEach(v -> aux2.add(v.toString()));
        aux2.add("PRONTO");
        aux2.add("PRONTO");
        result.add(aux2);

        System.out.println(result);
    }

    private static boolean verificaTermino(List<Integer> aux) {
        return aux.stream().allMatch(i -> i.equals(0));
    }

    private static Long getCount(List<Integer> aux2) {
        return aux2.stream()
                .filter(n -> n.intValue() > 0)
                .count();
    }

    private static Integer getMin(List<Integer> aux) {
        return aux.stream()
                .filter(n -> n.intValue() > 0)
                .min(Integer::compareTo)
                .orElse(null);
    }

    private static void ParesBalanceados() {
        List<String> list = List.of("{[(])}", "{}[]()", "{[}]}", "[{}]", "[{]}");
        List<String> result = new ArrayList<>();
        Map<Character, Character> map = new HashMap<>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};

        list.forEach(s -> {
            if (s.length() % 2 != 0) {
                result.add("NÃO");
            } else {
                LinkedList<Character> linkedList = new LinkedList<>();
                char[] chars = s.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    if (map.containsKey(chars[i])) {
                        linkedList.add(chars[i]);
                    } else {
                        if (map.containsValue(chars[i]) && linkedList.getLast().equals(findKey(chars[i], map))) {
                            linkedList.removeLast();
                            if (i == chars.length - 1 && linkedList.isEmpty()) result.add("SIM");
                        } else {
                            result.add("NÃO");
                            i = chars.length;
                        }
                    }
                }
            }
        });
        result.forEach(System.out::println);
    }

    private static Character findKey(Character value, Map map) {
        for (Object key : map.keySet()) {
            if (Objects.equals(map.get(key), value)) {
                return key.toString().charAt(0); //return the first found
            }
        }
        return null;
    }

    private static void ConversorDecToBinDevolveQuartoBit() {
        List<Integer> list = List.of(0, 1, 0, 0, 1, 1);

        StringBuilder s = new StringBuilder();
        list.forEach(s::append);

        String substring = s.substring(4, 5);
    }

    private static void EsmagarTijolos() {
        System.out.println(smashTheBricks(4, List.of(3, 2, 5, 4, 6, 7, 9)));
        System.out.println(smashTheBricks(0, List.of(2)));
    }

    private static List<List<Long>> smashTheBricks(int bigHits, List<Integer> newtons) {
        Long totalHits = 0l;
        List<Long> idxGolpesGrande = new ArrayList<>();
        List<Long> idxGolpesPequeno = new ArrayList<>();

        List<Long> aux = newtons.stream().map(Integer::longValue).collect(Collectors.toList());
        List<Long> maiores = new ArrayList<>();

        if (bigHits > 0) {
            Collections.sort(aux);
            Collections.reverse(aux);
            for (int i = 0; i < bigHits; i++) {
                maiores.add(aux.get(i));
            }

            for (int y = 0; y < newtons.size(); y++) {
                if (maiores.contains(Long.valueOf(newtons.get(y)))) {
                    idxGolpesGrande.add(Long.valueOf(y) + 1);
                    totalHits++;
                } else {
                    idxGolpesPequeno.add(Long.valueOf(y) + 1);
                    totalHits += Long.valueOf(newtons.get(y));
                }
            }
            if (idxGolpesPequeno.isEmpty()) idxGolpesPequeno.add(-1L);

        } else {
            idxGolpesGrande.add(-1L);
            for (int y = 0; y < newtons.size(); y++) {
                idxGolpesPequeno.add(Long.valueOf(y) + 1);
                totalHits += Long.valueOf(newtons.get(y));
            }
        }
        return List.of(List.of(totalHits), idxGolpesGrande, idxGolpesPequeno);
    }

    private static void ConversorBinToDec() {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(0, 1, 0, 0, 1, 1));
        Collections.reverse(list);
        int soma = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            soma += pow(2, i) * list.get(i);
        }
    }

    private static void MenorDiferenca() {

        List<Integer> arr = Arrays.asList(-9, 5, -5, 12, 10, 9);
        Collections.sort(arr);
        List<Integer> arr1 = arr.stream().distinct().collect(Collectors.toList());

        int menor = arr1.get(1) - arr1.get(0);

        for (int i = 0; i < arr1.size() - 1; i++) {
            if (arr1.get(i + 1) - arr1.get(i) < menor) {
                menor = arr1.get(i + 1) - arr1.get(i);
            }
        }

        for (int i = 0; i < arr1.size() - 1; i++) {
            if (arr1.get(i + 1) - arr1.get(i) == menor) {
                System.out.println(arr1.get(i) + " " + arr1.get(i + 1));
            }
        }
    }

    private static void PatternUsername() {
        String[] strings = {"Julia", "Samantha", "Samantha_21", "1Samantha", "Samantha?10_2A", "JuliaZ007", "Julia@007", "_Julia007"};
        String regex = "^([a-zA-Z]{1})([a-zA-Z_0-9]{7,29})$";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        List<String> collect = Arrays.stream(strings)
                .peek(s -> System.out.println((s.matches(p.pattern()) ? "Valid" : "Invalid")))
                .filter(s -> s.matches(p.pattern()))
                .collect(Collectors.toList());
    }

    private static void RepeatWords() {
        String[] strings = {"Goodbye bYE bye WORLD world world",
                "Sam went went to TO to his business",
                "Reya IS is the the best player in eye eye game",
                "in inthe",
                "Hello hello Ab aB"};

        String regex = "\\b(\\w+)(\\s+\\1\\b)+"; // + = um ou mais | \1 = backreference ao grupo #1
        // \w = word | \d = digit | \s = whitespace | \b = word
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        for (String s : strings) {
            Matcher m = p.matcher(s);

            while (m.find()) {
                s = s.replaceAll(m.group(0), m.group(1));
            }
            System.out.println(s);
        }
    }

    private static void PatternIP() {
        List<String> list = new ArrayList<>();
        list.addAll(List.of("000.12.12.034", "121.234.12.12", "23.45.12.56", //validos
                "000.12.234.23.23", "666.666.23.23", ".213.123.23.32", "23.45.22.32.", "I.Am.not.an.ip")); // invalidos
        Pattern p = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

        for (String s : list) {
            System.out.println(s.matches(p.pattern()));
        }
    }

    class MyRegex {
        private final String pattern;

        public MyRegex() {
            this.pattern =
                    Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$")
                            .pattern();
        }
    }

    private static void PatternRegex() {
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int testCases = Integer.parseInt(in.nextLine());

        while (testCases-- > 0) {
            String pattern = in.nextLine();
            list.add(pattern);
        }
        for (String s : list) {

            try {
                Pattern.compile(s);
                System.out.println("Valid");
            } catch (Exception e) {
                System.out.println("Invalid");
            }
        }
    }

    private static void Split() {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
        String[] split = s.trim().split("[,.!?'@_] *| +");

        List<String> arr = new ArrayList<>();
        for (String s1 : split) {
            if (!s1.isEmpty()) {
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