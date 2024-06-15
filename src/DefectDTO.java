import java.util.UUID;

public class DefectDTO {
    private String id;
    private String drawingId;
    private String typeOfDefectId;
    private int isClosed;

    public DefectDTO() {
        this.id = UUID.randomUUID().toString();
        this.drawingId = "";
        this.typeOfDefectId = "";
        this.isClosed = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDrawingId() {
        return drawingId;
    }

    public void setDrawingId(String drawingId) {
        this.drawingId = drawingId;
    }

    public String getTypeOfDefectId() {
        return typeOfDefectId;
    }

    public void setTypeOfDefectId(String typeOfDefectId) {
        this.typeOfDefectId = typeOfDefectId;
    }

    public int getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(int isClosed) {
        this.isClosed = isClosed;
    }
}
