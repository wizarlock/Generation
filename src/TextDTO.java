import java.util.UUID;

public class TextDTO {
    private String id;
    private String text;
    private String drawingId;
    private Double xReal;
    private Double yReal;

    public TextDTO() {
        this.id = UUID.randomUUID().toString();
        this.text = "";
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
