package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Week07_p527_ExceptionHandling1 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("a.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        System.out.println("여기서도 수행.");
    }
}
