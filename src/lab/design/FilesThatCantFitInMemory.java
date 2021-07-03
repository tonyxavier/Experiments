package lab.design;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilesThatCantFitInMemory {

    public static void main(String[] args) {
        //generateAHugeFile(10);
        //List<File> files = createSortedSubFiles();

        String file1 = "numbers_1.txt";
        String file2 = "numbers_2.txt";

        FilesThatCantFitInMemory problem = new FilesThatCantFitInMemory();
        problem.mergeSortedSubFiles(file1,file2);


    }


    private static List<File> createSortedSubFiles() {

        ArrayList<Integer> nums = new ArrayList<>();
        List<File> sortedFiles = new ArrayList<>();

        try {
            FileReader fr = new FileReader("numbers.txt");
            BufferedReader bufferreader = new BufferedReader(fr);
            String line;

            int count = 0;
            int fileSeqNum = 1;
            while ((line = bufferreader.readLine()) != null) {
                System.out.println(count++);
                String numStr = line.substring(0, 9);
                nums.add(Integer.parseInt(numStr));

                if (count % 20 == 0) {
                    Collections.sort(nums);
                    sortedFiles.add(writeSortedListToFile(nums, fileSeqNum));
                    fileSeqNum++;
                    nums = new ArrayList<>();
                }
            }

            Collections.sort(nums);
            sortedFiles.add(writeSortedListToFile(nums, fileSeqNum));
            bufferreader.close();

            return sortedFiles;

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        return null;

    }

    private File mergeSortedSubFiles(String f1, String f2) {

        File file = new File("FinalSorted.txt");
        FileReaderFacade file1 = new FileReaderFacade(f1);
        FileReaderFacade file2 = new FileReaderFacade(f2);
        try {

            file.createNewFile();
            FileWriter writer = new FileWriter(file);

            int count=0;
            while (true) {

                while((file1.getNextNumber()<file2.getNextNumber() || file2.isEndOfFile()) && !file1.isEndOfFile()){
                    writer.write(file1.getNextNumber()+"\n");
                    file1.markAsUsed();
                    count++;
                }

                while((file2.getNextNumber()<=file1.getNextNumber() || file1.isEndOfFile()) && !file2.isEndOfFile()){
                    writer.write(file2.getNextNumber()+"\n");
                    file2.markAsUsed();
                    count++;
                }

                System.out.println(count);

                if(file1.isEndOfFile() && file2.isEndOfFile())
                    break;

            }

        writer.close();
        return file;


}
      catch (IOException ioe){
          ioe.printStackTrace();

      }

      return file;
  }



  private static File writeSortedListToFile(ArrayList<Integer> nums, int fileSeqNum){

      File file = new File("numbers_"+fileSeqNum+".txt");
      try {

          file.createNewFile();
          FileWriter writer = new FileWriter(file);

          for(Integer num:nums){

              writer.write(num.toString()+"\n");
          }

          writer.close();
          return file;

      }
      catch (IOException ioe){
          ioe.printStackTrace();

      }

      return null;

  }



    private static void generateAHugeFile(int sizeInGB){

        File file = new File("numbers.txt");
        try {


            file.createNewFile();
            FileWriter writer = new FileWriter(file);

            int count=0;
            while(count<99999999){
                double r =Math.random();
                int random = (int) (r*(999999999-100000000)) + 100000000;
                writer.write(random +" This is just the same boring line of text that comes with the random number just to fill in space blaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaah\n");

                System.out.println( count++);



            }

            writer.close();



        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }


    }


    private class FileReaderFacade {

        private String fileName;
        private FileReader fr = null;
        private BufferedReader br = null;
        private boolean isQueued = false;
        private int nextNum;
        private boolean isDone=false;

        public FileReaderFacade(String fileName) {

            this.fileName = fileName;
            try {
                fr = new FileReader(fileName);
                br = new BufferedReader(fr);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

        }


        public int getNextNumber() {

            if (isQueued)
                return nextNum;

            if(isDone)
                return -1;

            String line;
            try {
                if((line = br.readLine()) != null) {
                    isQueued = true;
                    nextNum = Integer.parseInt(line);
                    return nextNum;
                }

            } catch (IOException ioe) {
                ioe.printStackTrace();

            }

            isDone=true;
            return -1;

        }


        public void markAsUsed(){
            isQueued=false;

        }

        public boolean isEndOfFile(){
            return isDone;

        }


    };




}
