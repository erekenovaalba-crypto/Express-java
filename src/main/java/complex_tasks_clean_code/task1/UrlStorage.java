package complex_tasks_clean_code.task1;

public interface UrlStorage {
    void save(String longUrl, String shortUrl);
    String getShortUrl(String longUrl);
    String getLongUrl(String shortUrl);
}
