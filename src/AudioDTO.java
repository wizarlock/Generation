import java.util.UUID;

public class AudioDTO {
    private String id;
    private String name;
    private String audioFilePath;
    private String projectId;
    private String drawingId;

    public AudioDTO() {
        this.id = UUID.randomUUID().toString();
        this.name = "";
        this.audioFilePath = "";
        this.projectId = "";
        this.drawingId = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAudioFilePath() {
        return audioFilePath;
    }

    public void setAudioFilePath(String audioFilePath) {
        this.audioFilePath = audioFilePath;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getDrawingId() {
        return drawingId;
    }

    public void setDrawingId(String drawingId) {
        this.drawingId = drawingId;
    }
}
