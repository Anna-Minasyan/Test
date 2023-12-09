import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Input:");
        String expression = sc.nextLine();
        String result = calc(expression);
        System.out.println("Output:");
        System.out.println(result);
}
    public static String calc(String s) {
        int res = 0;

        String c = s.replaceAll(" ","");

       /* try{

        }catch (Exception ex){
            System.out.println("throws Exception");
        };*/

        Pattern pattern = Pattern.compile("^([1][0]|\\d)([+,-]|[/,*])([1][0]|\\d)$");
        Matcher matcher = pattern.matcher(c);

        if(!matcher.matches()) {
            return "throws Exception";
        }

        StringTokenizer st = new StringTokenizer(c, "*/+-");

        String aStr = st.nextToken();
        int a = Integer.parseInt(aStr);
        String bStr = st.nextToken();
        int b = Integer.parseInt(bStr);

        if(a==10){
            res = calculate(a,""+c.charAt(2),b);
        }else {
            res =calculate(a,""+c.charAt(1),b);
        }


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



