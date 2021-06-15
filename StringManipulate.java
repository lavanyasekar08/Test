import java.util.Scanner;

public class StringManipulate {
    enum Digits
    {
        ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9);

        private int digit;

        public int getDigit()
        {
            return this.digit;
        }
        private Digits(int digit)
        {
            this.digit = digit;
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter Input String:");
        Scanner sc=new Scanner(System.in);
        String strInput=sc.nextLine();
        String strOutput=null;
        if(strInput!=null) {
            strOutput=methodCall(strInput);
        }
        System.out.println(strOutput);
    }
    public static String methodCall(String str) {
        String[] splitStr=str.split("-");
        StringBuffer sb=new StringBuffer();
        int sum=0;
        try {
            if(splitStr!=null)
                for(String s:splitStr) {
                    int temp=0;
                    if(sb.length()>0)
                        sb.append("+");
                    if(s!=null && !s.trim().equals("")) {
                        try {
                            if(s.matches("\\d{1}")) {
                                temp=Integer.valueOf(s.trim());
                            }
                            else
                            {
                                Digits d= Digits.valueOf(s.trim().toUpperCase());
                                temp=d.getDigit();
                            }
                        }catch(IllegalArgumentException iaexp) {
                            throw iaexp;
                        }
                    }
                    else {
                        return "Invalid String...";
                    }
                    sum=sum+temp;
                    sb.append(temp);
                }
        }
        catch(Exception ex) {
            return "Invalid String...";
        }
        System.out.println("sum:"+sum);
        return sb+"="+sum;
    }
}