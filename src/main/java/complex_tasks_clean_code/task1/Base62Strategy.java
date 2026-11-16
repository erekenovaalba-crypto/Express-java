package complex_tasks_clean_code.task1;

public class Base62Strategy implements ShorteningStrategy {
    private static final String ALPHABET =
            "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private long counter = 1000;

    @Override
    public String shorten(String longUrl) {
        long number = counter++;
        StringBuilder code = new StringBuilder();
        while (number > 0) {
            code.append(ALPHABET.charAt((int) (number % 62)));
            number /= 62;
        }
        return code.reverse().toString();
    }
}
