import com.sun.media.jfxmediaimpl.MediaDisposer;

import java.io.*;
import java.nio.charset.StandardCharsets;

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
            //file = new PrintWriter(new FileOutputStream("D:/MV-lab/topKabel.html"));
            //file = new OutputStreamWriter(new FileOutputStream ("D:/MV-lab/topKabel.html"));
            file = new PrintWriter(new OutputStreamWriter(new FileOutputStream ("D:/MV-lab/topKabel.html"), StandardCharsets.UTF_16));
        }
        catch (FileNotFoundException e) {
            System.out.println("file not find");
        }
    }

    public static void dispose() {
        file.close();
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

    public static void writeDeskr(String Deskr) {
        file.println("<div class=\"minidesc\">" + Deskr + "</div> ");
    }

    public static void writeFullDeskr(String Deskr) {
        file.println("<div class=\"minidesc\">" + Deskr + "</div> ");
    }

    public static void writeEnd() {
        file.println("</div> ");
    }
}
