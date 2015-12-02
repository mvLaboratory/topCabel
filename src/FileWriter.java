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

    public static void writeCategory(String cat) {
        file.println("<div class=\"tovar\">");
        file.println("<div class=\"cat\">" + cat + "</div> ");
    }

    public static void writeName(String name) {
        file.println("<div class=\"name\">" + name + "</div> ");
    }

    public static void writeArt(String art) {
        file.println("<div class=\"articul\">" + art + "</div> ");
    }
}
