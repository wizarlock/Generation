import java.util.UUID;

public class LabelDTO {
    private String id;
    private String name;
    private String labelFilePath;
    private String drawingId;
    private Double xReal;
    private Double yReal;

    public LabelDTO() {
        this.id = UUID.randomUUID().toString();
        this.name = "";
        this.labelFilePath = "";
        this.drawingId = "";
        this.xReal = 0.0;
        this.yReal = 0.0;
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

    public String getLabelFilePath() {
        return labelFilePath;
    }

    public void setLabelFilePath(String labelFilePath) {
        this.labelFilePath = labelFilePath;
    }

    public String getDrawingId() {
        return drawingId;
    }

    public void setDrawingId(String drawingId) {
        this.drawingId = drawingId;
    }

    public Double getXReal() {
        return xReal;
    }

    public void setXReal(Double xReal) {
        this.xReal = xReal;
    }

    public Double getYReal() {
        return yReal;
    }

    public void setYReal(Double yReal) {
        this.yReal = yReal;
    }
}
