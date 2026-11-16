package complex_tasks_clean_code.task1;

import java.util.HashMap;
import java.util.Map;

// Singleton: единственное хранилище всех URL
public class InMemoryUrlStorage implements UrlStorage {
    private static final InMemoryUrlStorage INSTANCE = new InMemoryUrlStorage();

    private final Map<String, String> longToShort = new HashMap<>();
    private final Map<String, String> shortToLong = new HashMap<>();

    private InMemoryUrlStorage() {
    }

    public static InMemoryUrlStorage getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(String longUrl, String shortUrl) {
        longToShort.put(longUrl, shortUrl);
        shortToLong.put(shortUrl, longUrl);
    }

    @Override
    public String getShortUrl(String longUrl) {
        return longToShort.get(longUrl);
    }

    @Override
    public String getLongUrl(String shortUrl) {
        return shortToLong.get(shortUrl);
    }
}
