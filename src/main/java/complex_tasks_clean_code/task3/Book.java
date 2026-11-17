package practice_pattern_programming.task15;

public class Book implements BookContent {
    private final String title;
    private final String author;
    private final String description;
    private final String cover;
    private final String content;

    Book(String title, String author, String description, String cover, String content) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.cover = cover;
        this.content = content;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getCover() {
        return cover;
    }

    // Тяжёлая операция: имитация чтения текста книги из хранилища
    @Override
    public String getContent() {
        System.out.println("Загрузка содержимого книги: " + title);
        if (content != null) {
            return content;
        }
        return "Full text of \"" + title + "\" by " + author;
    }
}
