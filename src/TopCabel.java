/**
 * Created by admin on 26.11.2015.
 */
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class TopCabel {
        public static void main(String[] args) throws Exception {
        String url = "http://topkabel.ru/";
        Connection connection = Jsoup.connect(url);
        Document document = connection.get();
        //System.out.println(document);

        Elements elements = document.select(".cat-list");
        for (Element element : elements) {
            Elements links = element.select("a");
            for (Element link : links) {
                String linkHref = link.attr("href");
                String linkText = link.text();

                if (linkHref.startsWith("https")) {
                    // System.out.println(linkHref);
                    connection = Jsoup.connect(linkHref);
                    document = connection.get();
                    readGoods(document, linkText);
                }
            }

        }
    }

    public static void readGoods(Document document, String category) {
        Elements elements = document.select(".cart-table");
        for (Element element : elements) {
            int index = 0;
            Elements table = element.select("td");
            for (Element row : table) {
                if  (row.childNodeSize() == 3)
                    parseLink(row, index, category);
                else if (row.childNodeSize() > 0)
                    parseLink(row, index, category);
                index = (++index) % 7;
            }
        }
    }

    public static void parseLink(Element link, int index, String cat) {
        if (index == 0) {
            System.out.println(cat);
            readLink(link); }
        else if (index == 1) {
            readArt(link);
        }
        else if (index == 2)
            return;
        else if (index == 3)
            return;
        else if (index == 4)
            return;
        else if (index == 5)
            readDeskription(link);
        else if (index == 6)
            return;
        else
            System.out.println(index + ":" + " " + link);
    }

    public static void readLink(Element link) {
        String txt = link.text();
        String href = link.select("a").get(0).attr("href");
        readFullDeskription(href);

        System.out.println(txt + ": " + href);
    }

    public static void readArt(Element link) {
        String art = link.text();
        System.out.println("art: " + art);
    }

    public static void readDeskription(Element link) {
        String deskription = link.text();
        System.out.println("desk:" + deskription);
    }

    public static void readFullDeskription(String link) {
        Connection connection = Jsoup.connect(link);
        try {
            Document document = connection.get();
            Elements desk = document.select(".product-tabs-container");
            String fullDesk = desk.select("p").get(0).text();
            System.out.println(fullDesk);
        }
        catch (IOException e) {}
    }
}
