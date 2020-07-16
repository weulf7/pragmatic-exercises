package org.fasttrackit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ArrayValidator {

    public static String validateArray(int[] array) {
        for(int k=0;k<array.length;k++){
            for (int x=k+1;x<array.length;x++) {

                if (array[k] <array[x]){
                    for (int y=x+1;y<array.length;y++){
                        if (array[y]<array[k]){
                            return "INVALID";
                        }
                    }
                }
            }
        }
        return "VALID";
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(Paths.get("src\\main\\java\\org\\fasttrackit\\exercise 6 - input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("target/arrayValidatorOutput.txt"));

        //value of T
        int testCasesCount = scanner.nextInt();

        for(int i = 1; i <= testCasesCount; i++) {
            //value of N
            int arrayLength = scanner.nextInt();

            //array A
            int[] array = new int[arrayLength];

            for(int j = 0; j < arrayLength; j++) {
                array[j] = scanner.nextInt();
            }

            String result = validateArray(array);

            String outputLine = "CASE #" + i + ": " + result;

            bufferedWriter.write(outputLine);
            bufferedWriter.newLine();
        }

        scanner.close();
        bufferedWriter.close();

    }

}
