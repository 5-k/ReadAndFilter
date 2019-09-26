
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by prateekm on 9/26/19.
 */
public class ReadAndFilter {


    public static void main(String[] args) throws IOException {

        File inputFile = getFile(args[0]);//"/Users/prateekm/Desktop/testFile");
        File inputArrayFile = getFile(args[1]);//"/Users/prateekm/Desktop/input_file");
       

        String seperator = "@";

        String inputData = getInputArrayFileData(inputArrayFile);
        String[] inputArray = inputData.split("[,]");
        List<String> inputList = new ArrayList();
        for (String input : inputArray) {
            inputList.add(input.trim());
        }

        System.out.println("\n\nBefore Filtering: " + inputList.toString());


        //Reading the file
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            while (null != (line = bufferedReader.readLine())) {
                //Line Example : -cm_tgl mda @ -cpp, -debug_access
                String keyVal[] = line.split(seperator); //Split by seperator
                String key = keyVal[0].trim();   //ex: -cm_tgl mda
                String value = keyVal[1].trim();  //ex:  -cpp, -debug_access

                if (inputList.contains(key)) {
                    //Split the value by comma for multiple values
                    List<String> valueListForKey = Arrays.asList(value.split("[,]"));
                    for (String val : valueListForKey) {
                        inputList.remove(val.trim());
                    }
                    //Check if any of this is present in input string
                }
            }

        } finally {
        }

        System.out.println("After Filtering: " + inputList.toString());
    }


    private static File getFile(String path) {
        File inputFile = new File(path);
        if (!inputFile.exists()) {
            throw new RuntimeException("File " + path + " does not exists");
        }
        return inputFile;
    }

    private static String getInputArrayFileData(File file) throws IOException {
        StringBuilder inputArray = new StringBuilder();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (null != (line = bufferedReader.readLine())) {
                inputArray.append(line);
            }
        } finally {

        }

        return inputArray.toString();
    }

    private static void printFile(File file) throws IOException {
        String line;
        System.out.println("\nReading file: " + file.getAbsolutePath() + "\n");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (null != (line = bufferedReader.readLine())) {
                System.out.println(line);
            }
        } finally {

        }
        System.out.println("****************************************************************");
    }

}
