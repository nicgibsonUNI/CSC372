import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
    public static void writeToFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
