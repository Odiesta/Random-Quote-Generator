package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class ReadTextFile {

    public static void main(String[] args) {
        Path paths = FileSystems.getDefault().getPath("resources/quote.txt");
        try {
            File file = new File(paths.toAbsolutePath().toUri());
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                System.out.println(Arrays.toString(data));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

}
