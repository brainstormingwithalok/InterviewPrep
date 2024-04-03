package main.java.algos.string;

import java.io.*;

/*

We specify the filename of the large file we want to read (replace "largefile.txt" with the actual file path).
We define a buffer size (bufferSize) to determine the size of each chunk of data to read from the file.
Adjust this value based on your system's memory and the size of the file being read.
We open a FileInputStream to read bytes from the file, and then wrap it in a BufferedInputStream for efficient reading.
We wrap the BufferedInputStream in an InputStreamReader and then in a BufferedReader to read characters from the file.
Inside the while loop, we repeatedly read chunks of data from the file into the buffer until the end of the file is reached.
We process each chunk of data by calling the processChunk method, where you can implement custom logic to handle the data.
We catch any IOException that may occur during file reading and print the stack trace for debugging purposes.
 */
public class ReadLargeFileInJava {

    public static void main(String[] args) {
        String fileName = "/Users/alokmishra/Documents/learning/code/InterviewPrep/src/main/java/algos/slidingwindow/description.txt";
        readFile(fileName);
    }


    public static void readFile(String fileName) {
        try (
                FileInputStream iS = new FileInputStream(fileName);
                BufferedInputStream bIS = new BufferedInputStream(iS);
                InputStreamReader ir = new InputStreamReader(bIS);
                BufferedReader br = new BufferedReader(ir)) {
            int maxBuffer = 4096;
            char[] buffer = new char[maxBuffer];
            int read;
            while ((read = br.read(buffer, 0, maxBuffer)) != -1) {
                processChunk(buffer, read);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void processChunk(char[] buffer, int length) {
        // Process the chunk of data (buffer) here
        // You can convert the char[] buffer to a String if needed
        String chunk = new String(buffer, 0, length);
        System.out.print(chunk);
    }
}
