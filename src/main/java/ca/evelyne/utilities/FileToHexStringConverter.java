package ca.evelyne.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileToHexStringConverter {
    public static void main(String[] args) throws IOException {
        // TODO: seems to have a bug, byte string gets corrupted somewhere.
        try(FileInputStream stream = new FileInputStream(new File("./images/david-tennant.jpg"))) {
            System.out.print("0x");
            int b = stream.read();
            while(b != -1) {
                System.out.printf("%2h ",b);
                b = stream.read();
            }
        }
    }
}
