import java.util.List;

public class GenerationDTO {
    private List<AudioDTO> audios;
    private List<DefectDTO> defects;
    private List<DefectPointDTO> defectPoints;
    private DrawingDTO drawing;
    private List<LabelDTO> labels;
    private List<ProjectDTO> projects;
    private List<TextDTO> texts;
    private List<TypeOfDefectDTO> typesOfDefect;

    public GenerationDTO(List<AudioDTO> audios, List<DefectDTO> defects, List<DefectPointDTO> defectPoints,
                         DrawingDTO drawing, List<LabelDTO> labels, List<ProjectDTO> projects,
                         List<TextDTO> texts, List<TypeOfDefectDTO> typesOfDefect) {
        this.audios = audios;
        this.defects = defects;
        this.defectPoints = defectPoints;
        this.drawing = drawing;
        this.labels = labels;
        this.projects = projects;
        this.texts = texts;
        this.typesOfDefect = typesOfDefect;
    }
    public List<AudioDTO> getAudios() {
        return audios;
    }

    public void setAudios(List<AudioDTO> audios) {
        this.audios = audios;
    }

    public List<DefectDTO> getDefects() {
        return defects;
    }

    public void setDefects(List<DefectDTO> defects) {
        this.defects = defects;
    }

    public List<DefectPointDTO> getDefectPoints() {
        return defectPoints;
    }

    public void setDefectPoints(List<DefectPointDTO> defectPoints) {
        this.defectPoints = defectPoints;
    }

    public DrawingDTO getDrawing() {
        return drawing;
    }

    public void setDrawing(DrawingDTO drawing) {
        this.drawing = drawing;
    }

    public List<LabelDTO> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelDTO> labels) {
        this.labels = labels;
    }

    public List<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }

    public List<TextDTO> getTexts() {
        return texts;
    }

    public void setTexts(List<TextDTO> texts) {
        this.texts = texts;
    }

    public List<TypeOfDefectDTO> getTypesOfDefect() {
        return typesOfDefect;
    }

    public void setTypesOfDefect(List<TypeOfDefectDTO> typesOfDefect) {
        this.typesOfDefect = typesOfDefect;
    }

    public ProjectDTO getProjectById(String id) {
        return projects.stream().filter(project -> project.getId().equals(id)).findFirst().orElse(null);
    }

    public List<DefectPointDTO> getDefectPointsById(String id) {
        return defectPoints.stream().filter(defectPoint -> defectPoint.getDefectId().equals(id)).toList();
    }

    public TypeOfDefectDTO getTypeOfDefectById(String id) {
        return typesOfDefect.stream().filter(typeOfDefect -> typeOfDefect.getId().equals(id)).findFirst().orElse(null);
    }
}
