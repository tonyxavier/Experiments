package lab.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

/*Find the number of distinct directory structures from an incoming stream of
 * Directory names and subdirectory names
 *
 * For example
 * A,A1 (A is the parent directory of A1)
 * A,A2
 * B,B1
 * A1,C
 *
 * The above stream has 2 distinct directory structures
 */
public class DistinctDirectoryStructure {


    public DistinctDirectoryStructure() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String args[]) {


        List<List<String>> input = new ArrayList<List<String>>();

        List<String> temp;


        temp = new ArrayList<String>();
        temp.add(0, "A");
        temp.add(1, "A1");
        input.add(temp);

        temp = new ArrayList<String>();
        temp.add(0, "A");
        temp.add(1, "A2");
        input.add(temp);

        temp = new ArrayList<String>();
        temp.add(0, "B");
        temp.add(1, "B1");
        input.add(temp);


        temp = new ArrayList<String>();
        temp.add(0, "A1");
        temp.add(1, "C");
        input.add(temp);
		
		/*
		temp=new ArrayList<String>();		
		temp.add(0, "A2");
		temp.add(1, "B");		
		input.add(temp);
		
	*/


        int count = DistinctDirectoryStructure.disctinctDirStructureCount(input);
        System.out.println("Count:" + count);


    }

    public static int disctinctDirStructureCount(List<List<String>> input) {


        HashMap<String, String> h1 = new HashMap<String, String>();

        HashMap<String, String> h2 = new HashMap<String, String>();


        for (List<String> array : input) {
            String parent = array.get(0);
            h1.put(parent, "");

            String child = array.get(1);
            h2.put(child, "");


        }


        Set<String> parents = h1.keySet();

        Set<String> children = h2.keySet();


        System.out.println(children);

        System.out.println("-----");

        int count = 0;
        for (String str : parents) {

            System.out.println(str);

            if (h2.get(str) == null) {

                count++;
                System.out.println(str + " is parent of a distinct dir structure ");
            }


        }


        return count;
    }

}
