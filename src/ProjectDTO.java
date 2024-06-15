import java.util.UUID;

public class ProjectDTO {
    private String id;
    private String name;
    private String projectFilePath;
    private int photoNum;
    private int audioNum;

    public ProjectDTO() {
        this.id = UUID.randomUUID().toString();
        this.name = "";
        this.projectFilePath = "";
        this.photoNum = 0;
        this.audioNum = 0;
    }

    // Getters and Setters
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

    public String getProjectFilePath() {
        return projectFilePath;
    }

    public void setProjectFilePath(String projectFilePath) {
        this.projectFilePath = projectFilePath;
    }

    public int getPhotoNum() {
        return photoNum;
    }

    public void setPhotoNum(int photoNum) {
        this.photoNum = photoNum;
    }

    public int getAudioNum() {
        return audioNum;
    }

    public void setAudioNum(int audioNum) {
        this.audioNum = audioNum;
    }
}
