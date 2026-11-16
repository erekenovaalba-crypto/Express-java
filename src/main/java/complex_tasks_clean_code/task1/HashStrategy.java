package complex_tasks_clean_code.task1;

public class HashStrategy implements ShorteningStrategy {
    @Override
    public String shorten(String longUrl) {
        return Integer.toHexString(longUrl.hashCode());
    }
}
