import java.util.UUID;

public class DrawingDTO {
    private String id;
    private String name;
    private String drawingFilePath;
    private String projectId;

    public DrawingDTO() {
        this.id = UUID.randomUUID().toString();
        this.name = "";
        this.drawingFilePath = "";
        this.projectId = "";
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

    public String getDrawingFilePath() {
        return drawingFilePath;
    }

    public void setDrawingFilePath(String drawingFilePath) {
        this.drawingFilePath = drawingFilePath;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}

