package complex_tasks_clean_code.task1;

// Factory Method: создаёт объект стратегии сокращения
public class ShortenerFactory {
    private final ShorteningStrategy strategy;

    public ShortenerFactory(ShorteningStrategy strategy) {
        this.strategy = strategy;
    }

    public ShorteningStrategy createStrategy() {
        return strategy;
    }
}
