public class Application {
    public static void main(String[] args) {

        if (args.length > 0 && !args[0].isEmpty()) {
            String html = PageDownloadingUtility.download(args[0]);
            String cleanedText = StringHtmlCleaner.clean(html);
            System.out.println(cleanedText);

        }
        else {
            System.err.println("Podaj adres strony jako argument!");
            System.exit(1);
        }
    }
}
