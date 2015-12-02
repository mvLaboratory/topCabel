import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileWriter {
    private static FileWriter instance;
    public static PrintWriter file;

    static {
        createFile();
    }

    public static FileWriter getInstance() {
        if (instance == null) instance = new FileWriter();
        return instance;
    }

    private FileWriter() {
    }

    public static void createFile() {
        try {
            file = new PrintWriter(new FileOutputStream("D:/MV_lab/topKabel.html"));
            file.println("<div class=\"tovar\">");
            file.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("file not find");
        }
    }

    public static void writeCategory() {

    }
}
