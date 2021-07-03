package lab;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test implements  Cloneable{

     int i=10;
     int[] arr={1,2,3,4,5};

    public static void main(String args[]) throws CloneNotSupportedException{


   Test test =new Test();
    Test t1 =(Test) test.clone();
     test.i=20;
     test.arr[3]=100;
        System.out.println(test.arr[3]);
        System.out.println(t1.arr[3]);

    }


    @Override
    public Object clone(){

        try{

            Test copy = (Test) super.clone();
            copy.arr= copy.arr.clone();

       /*
       int[] temp =new int[copy.arr.length];
            for(int i=0;i<copy.arr.length;i++){
                temp[i]=copy.arr[i];
            }
            copy.arr=temp;
*/
            return copy;
        }
        catch (CloneNotSupportedException ce)
        {
            ce.printStackTrace();
        }
        return null;

    }

    public String toString(){

        return Integer.toString(i);
    }



}
