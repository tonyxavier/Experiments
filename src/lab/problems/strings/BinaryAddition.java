package lab.problems.strings;

public class BinaryAddition {


    public static void main(String[] args) {

        BinaryAddition binarymath = new BinaryAddition();

        String s1="11111";
        String s2="111";

        System.out.println(binarymath.add(s1,s2));


    }


    public String add(String num1,String num2){


        if(num1.length()>num2.length()){
            num2=padWithZeros(num2,num1.length()-num2.length());
        }
        else if(num2.length()>num1.length())
            num1=padWithZeros(num1,num2.length()-num1.length());



       String result="";
       Character reminder = '0';

        for(int i=num1.length()-1;i>=0;i--){
            DigitSum digitSum = digitSum(num1.charAt(i),num2.charAt(i),reminder);
            result=digitSum.sum+result;
            reminder=digitSum.reminder;
        }

        if(reminder=='1')
            return "1"+result;
        else
            return result;




    }


    private String padWithZeros(String str,int n){

        String prefix="";
        for(int i=0;i<n;i++)
            prefix=prefix+'0';

        return prefix+str;
    }


    public DigitSum digitSum(Character num1,Character num2, Character reminder){



        if (num1=='1' && num2=='1' && reminder=='1')
            return new DigitSum('1','1');
        else if(num1=='1' && num2=='1' && reminder=='0')
            return new DigitSum('0','1');
        else if(num1=='1' && num2=='0' && reminder=='1')
            return new DigitSum('0','1');
        else if(num1=='1' && num2=='0' && reminder=='0')
            return new DigitSum('1','0');
        else if(num1=='0' && num2=='1' && reminder=='1')
            return new DigitSum('0','1');
        else if(num1=='0' && num2=='1' && reminder=='0')
            return new DigitSum('1','0');
        else if(num1=='0' && num2=='0' && reminder=='1')
            return new DigitSum('1','0');
        else //if(num1=='0' && num2=='0' && reminder=='0')
            return new DigitSum('0','0');





    }



    private class DigitSum{

        Character sum,reminder;

        public DigitSum(Character sum, Character reminder){
            this.sum=sum;
            this.reminder=reminder;
        }

    }

}
