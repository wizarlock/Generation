import java.util.UUID;
public class DefectPointDTO {
    private String id;
    private String defectId;
    private int position;
    private Double xReal;
    private Double yReal;

    public DefectPointDTO() {
        this.id = UUID.randomUUID().toString();
        this.defectId = "";
        this.position = 0;
        this.xReal = 0.0;
        this.yReal = 0.0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDefectId() {
        return defectId;
    }

    public void setDefectId(String defectId) {
        this.defectId = defectId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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