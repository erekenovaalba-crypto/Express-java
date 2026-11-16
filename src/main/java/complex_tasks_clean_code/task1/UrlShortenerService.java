package complex_tasks_clean_code.task1;

public class UrlShortenerService {
    private static final String DOMAIN = "http://short.ly/";

    private final UrlStorage storage;
    private ShorteningStrategy strategy;

    // Хранилище по умолчанию — Singleton
    public UrlShortenerService(ShortenerFactory factory) {
        this(factory, InMemoryUrlStorage.getInstance());
    }

    public UrlShortenerService(ShortenerFactory factory, UrlStorage storage) {
        this.storage = storage;
        this.strategy = factory.createStrategy();
    }

    // Переключение способа сокращения
    public void setFactory(ShortenerFactory factory) {
        this.strategy = factory.createStrategy();
    }

    public String shortenUrl(String longUrl) {
        String existing = storage.getShortUrl(longUrl);
        if (existing != null) {
            return existing;
        }
        String shortUrl = DOMAIN + strategy.shorten(longUrl);
        storage.save(longUrl, shortUrl);
        return shortUrl;
    }

    public String expandUrl(String shortUrl) {
        String longUrl = storage.getLongUrl(shortUrl);
        if (longUrl == null) {
            throw new IllegalArgumentException("Короткий URL не найден: " + shortUrl);
        }
        return longUrl;
    }
}
