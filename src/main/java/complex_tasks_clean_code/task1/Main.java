package complex_tasks_clean_code.task1;

public class Main {
    public static void main(String[] args) {
        // Конфигурация библиотеки с выбранной стратегией сокращения
        UrlShortenerService shortenerService =
                new UrlShortenerService(new ShortenerFactory(new Base62Strategy()));

        // Сокращение URL
        String shortUrl = shortenerService.shortenUrl("https://example.com/very/long/url");
        System.out.println("Short URL: " + shortUrl);

        // Восстановление URL
        String longUrl = shortenerService.expandUrl(shortUrl);
        System.out.println("Original URL: " + longUrl);

        // Переключение стратегии
        shortenerService.setFactory(new ShortenerFactory(new UuidStrategy()));
        String uuidUrl = shortenerService.shortenUrl("https://example.com/another/long/url");
        System.out.println("Short URL (UUID): " + uuidUrl);
        System.out.println("Original URL: " + shortenerService.expandUrl(uuidUrl));
    }
}
