package complex_tasks_clean_code.task2;

import java.util.HashMap;
import java.util.Map;

public class VideoService {
    private final Map<String, VideoAdapter> adapters = new HashMap<>();
    private final Map<String, Video> videos = new HashMap<>();
    private int nextId = 1;

    public VideoService(VideoAdapter... adapters) {
        for (VideoAdapter adapter : adapters) {
            this.adapters.put(adapter.getFormat(), adapter);
        }
    }

    public Video uploadVideo(String path) {
        String format = getExtension(path);
        String mp4Path;

        if (format.equals("mp4")) {
            mp4Path = path;
        } else {
            VideoAdapter adapter = adapters.get(format);
            if (adapter == null) {
                throw new IllegalArgumentException("Формат не поддерживается: " + format);
            }
            mp4Path = adapter.convertToMp4(path);
        }

        Video video = new Video("video-" + nextId++, path, mp4Path);
        videos.put(video.getId(), video);
        System.out.println("Видео загружено, ID: " + video.getId());
        return video;
    }

    public Stream streamVideo(String id) {
        Video video = videos.get(id);
        if (video == null) {
            throw new IllegalArgumentException("Видео не найдено: " + id);
        }
        return new Stream(video);
    }

    private String getExtension(String path) {
        int dot = path.lastIndexOf('.');
        if (dot < 0) {
            throw new IllegalArgumentException("У файла нет расширения: " + path);
        }
        return path.substring(dot + 1).toLowerCase();
    }
}
