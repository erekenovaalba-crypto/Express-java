package complex_tasks_clean_code.task2;

public class Video {
    private final String id;
    private final String originalPath;
    private final String mp4Path;

    public Video(String id, String originalPath, String mp4Path) {
        this.id = id;
        this.originalPath = originalPath;
        this.mp4Path = mp4Path;
    }

    public String getId() {
        return id;
    }

    public String getOriginalPath() {
        return originalPath;
    }

    public String getMp4Path() {
        return mp4Path;
    }
}
