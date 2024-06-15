import java.util.UUID;

public class TypeOfDefectDTO {
    private String id;
    private String name;
    private String hexCode;
    private String projectId;

    public TypeOfDefectDTO() {
        this.id = UUID.randomUUID().toString();
        this.name = "";
        this.hexCode = "";
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

    public String getHexCode() {
        return hexCode;
    }

    public void setHexCode(String hexCode) {
        this.hexCode = hexCode;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
