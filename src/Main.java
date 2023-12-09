import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main (String[] args) throws ScannerException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Input:");
        String expression = sc.nextLine();
        String result = calc(expression);
        System.out.println("Output:");
        System.out.println(result);
}
    public static String calc(String s) throws ScannerException {
        int res = 0;

        String c = s.replaceAll(" ","");

        String[] signs = {"+","-","/","*"};
        String sign = "";
        int signCount = 0;

        for(int i=0; i<signs.length; i++){
            if(c.contains(signs[i])){
                sign=signs[i];
                signCount++;
            }
        }

        if(sign == "") {
            throw new ScannerException("throws Exception //т.к. строка не является математической операцией");
        }
        if(signCount > 1){
            throw new ScannerException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }


        Pattern pattern = Pattern.compile("^([1][0]|[1-9])([+,-]|[/,*])([1][0]|[1-9])$");
        Matcher matcher = pattern.matcher(c);

        if(!matcher.matches()) {
            throw new ScannerException("throws Exception");
        }

        /*if(!matcher.matches()) {
            try {
                throw new ScannerException("des-error");
            } catch (ScannerException e) {
                System.err.println("throws Exception");
            }
        }*/

        StringTokenizer st = new StringTokenizer(c, "*/+-");

        String aStr = st.nextToken();
        int a = Integer.parseInt(aStr);
        String bStr = st.nextToken();
        int b = Integer.parseInt(bStr);

        res = calculate(a,sign,b);

       /* String[] signs = {"+","-","/","*"};
        for(int i=0; i<signs.length; i++){
            if(c.contains(signs[i])){
                String sign=signs[i];
                res = calculate(a,sign,b);
            }
        }*/

       /* if(a==10){
            res = calculate(a,""+c.charAt(2),b);
        }else {
            res =calculate(a,""+c.charAt(1),b);
        }*/


      /*  if(c.contains("+")){
                System.out.println("+");
                res =calc(a,"+",b);
        } else if(c.contains("-")){
            System.out.println("-");
            res =calc(a,"-/",b);
        }
        if(c.contains("*")){
            System.out.println("*");
            res =calc(a,"*",b);
        }
        if(c.contains("/")){
            System.out.println("/");
            res =calc(a,"/",b);
        }
*/

        return ""+res;

    }

        private static int calculate (int a, String c, int b) {
            int result;
        switch (c) {
            case "+": result=a+b; break;
            case "-": result=a-b; break;
            case "*": result=a*b; break;
            case "/": result=a/b; break;
            default: result=a;
        }
        return result;
    }

}



