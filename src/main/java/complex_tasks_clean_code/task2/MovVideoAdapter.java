package complex_tasks_clean_code.task2;

public class MovVideoAdapter implements VideoAdapter {
    @Override
    public String getFormat() {
        return "mov";
    }

    @Override
    public String convertToMp4(String path) {
        System.out.println("Конвертация MOV в MP4: " + path);
        return path.substring(0, path.lastIndexOf('.')) + ".mp4";
    }
}
