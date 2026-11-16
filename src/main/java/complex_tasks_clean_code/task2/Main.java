package complex_tasks_clean_code.task2;

public class Main {
    public static void main(String[] args) {
        // Инициализация сервиса с адаптерами для поддерживаемых форматов
        VideoService videoService = new VideoService(
                new AviVideoAdapter(), new MovVideoAdapter(), new WmvVideoAdapter());

        // Загрузка видео файла в формате AVI
        String videoPath = "path/to/example.avi";
        Video video = videoService.uploadVideo(videoPath);

        // Стриминг видео в формате MP4
        Stream stream = videoService.streamVideo(video.getId());
        stream.start();

        // Вывод информации о стриме
        System.out.println("Streaming video in MP4 format, Video ID: " + video.getId());
    }
}
