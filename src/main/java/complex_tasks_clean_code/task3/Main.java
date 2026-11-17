package complex_tasks_clean_code.task3;

public class Main {
    public static void main(String[] args) {
        // Инициализация BookBuilder для создания книги
        BookBuilder builder = new BookBuilder();
        Book book = builder.setTitle("War and Peace")
                .setAuthor("Leo Tolstoy")
                .setDescription("A historical novel about the Napoleonic Wars.")
                .build();

        // Инициализация Proxy для ленивой загрузки
        BookProxy proxy = new BookProxy(book);
        System.out.println("Книга: " + proxy.getTitle() + ", загружена: " + proxy.isLoaded());

        // Доступ к содержимому книги через Proxy, загрузка происходит только при первом обращении
        String content = proxy.getContent();
        System.out.println("Content of the book: " + content);

        // Повторное обращение не загружает книгу заново
        proxy.getContent();
        System.out.println("Загружена: " + proxy.isLoaded());
    }
}
