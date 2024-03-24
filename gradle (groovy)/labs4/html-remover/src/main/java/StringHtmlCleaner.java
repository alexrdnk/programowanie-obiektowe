import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class StringHtmlCleaner {
    public static String clean(String textToClean) {
        Document document = Jsoup.parse(textToClean);
        return document.text();
    }
}
