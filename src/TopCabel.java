/**
 * Created by admin on 26.11.2015.
 */
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
            Elements table = element.select("td");
            for (Element row : table) {
                if  (row.childNodeSize() == 3)
                    //System.out.println(row.childNode(1));
                else if (row.childNodeSize() > 0)
                    //System.out.println(row.childNode(0));
            }
        }
    }
    
    public static void parseLink(String link) {
        System.out.println(link);        
    }
}
