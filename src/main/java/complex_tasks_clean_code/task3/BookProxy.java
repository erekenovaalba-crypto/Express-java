package practice_pattern_programming.task15;

// Proxy: загружает содержимое книги только при первом обращении
public class BookProxy implements BookContent {
    private final Book book;
    private String content;

    public BookProxy(Book book) {
        this.book = book;
    }

    @Override
    public String getTitle() {
        return book.getTitle();
    }

    @Override
    public String getContent() {
        if (content == null) {
            content = book.getContent();
        } else {
            System.out.println("Содержимое взято из кэша: " + book.getTitle());
        }
        return content;
    }

    public boolean isLoaded() {
        return content != null;
    }
}
