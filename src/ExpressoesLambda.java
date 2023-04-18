import java.util.StringTokenizer;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
    PerformOperation isOdd(){
        return (v) -> v % 2 != 0;
    }
    PerformOperation isPrime() {
        return (v) -> {
            for (int i = 2; i <= v / 2; i++) {
                if(v % i == 0)  return false;
            }
            return true;
        };
    }

    PerformOperation isPalindrome() {
        return (v) -> {
            String strNum = Integer.toString(v);
            int l = 0;
            int r = strNum.length() - 1;
            while(l < r)
                if(strNum.charAt(l++) != strNum.charAt(r--))
                    return false;
            return true;
        };
    }
}

public class ExpressoesLambda {
    public static void main(String[] args) {
        int i = 6;

        String[] s = {"2 12", "1 3", "3 898", "2 5", "1 4", "3 898"};

        MyMath ob = new MyMath();
        PerformOperation op;
        boolean ret = false;
        String ans = null;

        while (i-- > 0) {
            String temp = s[i].trim();
            StringTokenizer st = new StringTokenizer(temp);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
            }
            System.out.println(ans);
        }
    }
}