package complex_tasks_clean_code.task2;

public class Stream {
    private final Video video;

    public Stream(Video video) {
        this.video = video;
    }

    public void start() {
        System.out.println("Стриминг видео в формате MP4: " + video.getMp4Path());
    }
}
