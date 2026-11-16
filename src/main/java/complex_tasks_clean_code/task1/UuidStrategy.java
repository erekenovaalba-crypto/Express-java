package complex_tasks_clean_code.task1;

import java.util.UUID;

public class UuidStrategy implements ShorteningStrategy {
    @Override
    public String shorten(String longUrl) {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
