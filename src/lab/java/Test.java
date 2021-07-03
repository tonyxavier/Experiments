package lab.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Test {


    private interface Testing {

        public void show();

    }

    public interface AutoTest {

        public void showing();
    }

    class Tester implements Testing {


        public void show() {


        }

    }

    public static void main(String args[]) throws Exception {

        String ip = "2.4.abc.6";

        String[] nets = ip.split(".");

        int net1 = Integer.parseInt(nets[0]);


        int net2 = Integer.parseInt(nets[1]);


    }
}