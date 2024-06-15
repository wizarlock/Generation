import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

public class Generate {

    public InputStream generate(GenerationDTO generationDTO) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            DrawingDTO drawing = generationDTO.getDrawing();
            ProjectDTO project = generationDTO.getProjectById(drawing.getProjectId());

            if (project != null) {
                writeLine(outputStream, project.getName());
            }

            writeLine(outputStream, drawing.getName());

            writeAudios(outputStream, generationDTO, drawing);
            writeLabels(outputStream, generationDTO, drawing);
            writeDefects(outputStream, generationDTO, drawing);
            writeTexts(outputStream, generationDTO, drawing);

            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void writeLine(ByteArrayOutputStream outputStream, String line) throws IOException {
        outputStream.write((line + System.lineSeparator()).getBytes());
    }

    private void writeAudios(ByteArrayOutputStream outputStream, GenerationDTO generationDTO, DrawingDTO drawing) throws IOException {
        List<AudioDTO> audios = generationDTO.getAudios();
        for (AudioDTO audio : audios) {
            if (audio.getProjectId().equals(drawing.getProjectId())) {
                writeLine(outputStream, "Аудио: " + audio.getName() + ".mp3");
            }
        }
    }

    private void writeLabels(ByteArrayOutputStream outputStream, GenerationDTO generationDTO, DrawingDTO drawing) throws IOException {
        List<LabelDTO> labels = generationDTO.getLabels();
        for (LabelDTO label : labels) {
            if (label.getDrawingId().equals(drawing.getId())) {
                writeLine(outputStream, "Фото: (" + label.getXReal() + "/" + label.getYReal() + "), " + label.getName());
            }
        }
    }

    private void writeDefects(ByteArrayOutputStream outputStream, GenerationDTO generationDTO, DrawingDTO drawing) throws IOException {
        List<DefectDTO> defects = generationDTO.getDefects();
        for (DefectDTO defect : defects) {
            if (defect.getDrawingId().equals(drawing.getId())) {
                List<DefectPointDTO> defectPoints = generationDTO.getDefectPointsById(defect.getId());
                TypeOfDefectDTO typeOfDefect = generationDTO.getTypeOfDefectById(defect.getTypeOfDefectId());
                if (typeOfDefect != null) {
                    String nameTypeOfDefect = typeOfDefect.getName();
                    String colorTypeOfDefect = typeOfDefect.getHexCode();
                    DefectType defectType = DefectType.fromPointsAndClosure(defectPoints.size(), defect.getIsClosed(), defectPoints);
                    writeDefect(outputStream, defectType, defectPoints, nameTypeOfDefect, colorTypeOfDefect);
                }
            }
        }
    }

    private void writeDefect(ByteArrayOutputStream outputStream, DefectType defectType, List<DefectPointDTO> defectPoints, String nameTypeOfDefect, String colorTypeOfDefect) throws IOException {
        String defectDescription = defectType.getDescription(defectPoints);
        writeLine(outputStream, defectDescription + ", " + nameTypeOfDefect + "_" + colorTypeOfDefect);
    }

    private void writeTexts(ByteArrayOutputStream outputStream, GenerationDTO generationDTO, DrawingDTO drawing) throws IOException {
        List<TextDTO> texts = generationDTO.getTexts();
        for (TextDTO text : texts) {
            if (text.getDrawingId().equals(drawing.getId())) {
                writeLine(outputStream, "Текст: (" + text.getXReal() + "/" + text.getYReal() + "), \"" + text.getText() + "\"");
            }
        }
    }

    private enum DefectType {
        POINT {
            @Override
            public String getDescription(List<DefectPointDTO> points) {
                return "Точечный дефект: (" + points.get(0).getXReal() + "/" + points.get(0).getYReal() + ")";
            }
        },
        LINE {
            @Override
            public String getDescription(List<DefectPointDTO> points) {
                return "Линия: (" + points.get(0).getXReal() + "/" + points.get(0).getYReal() + "; " + points.get(1).getXReal() + "/" + points.get(1).getYReal() + ")";
            }
        },
        RECTANGLE {
            @Override
            public String getDescription(List<DefectPointDTO> points) {
                return "Прямоугольник: (" + points.get(0).getXReal() + "/" + points.get(0).getYReal() + "; " + points.get(1).getXReal() + "/" + points.get(1).getYReal() + "; " + points.get(2).getXReal() + "/" + points.get(2).getYReal() + "; " + points.get(3).getXReal() + "/" + points.get(3).getYReal() + ")";
            }
        },
        CLOSED_BROKEN_LINE {
            @Override
            public String getDescription(List<DefectPointDTO> points) {
                return "Замкнутая ломанная линия: " + getPointsDescription(points);
            }
        },
        BROKEN_LINE {
            @Override
            public String getDescription(List<DefectPointDTO> points) {
                return "Ломанная линия: " + getPointsDescription(points);
            }
        };

        public abstract String getDescription(List<DefectPointDTO> points);

        protected String getPointsDescription(List<DefectPointDTO> points) {
            StringBuilder description = new StringBuilder("(");
            for (int i = 0; i < points.size(); i++) {
                description.append(points.get(i).getXReal()).append("/").append(points.get(i).getYReal());
                if (i != points.size() - 1) {
                    description.append("; ");
                }
            }
            description.append(")");
            return description.toString();
        }

        public static DefectType fromPointsAndClosure(int pointsSize, int isClosed, List<DefectPointDTO> points) {
            if (pointsSize == 1) {
                return POINT;
            } else if (pointsSize == 2) {
                return LINE;
            } else if (pointsSize == 4 && isClosed == 1 &&
                    Objects.equals(points.get(1).getXReal(), points.get(0).getXReal()) &&
                    Objects.equals(points.get(1).getYReal(), points.get(2).getYReal()) &&
                    Objects.equals(points.get(3).getXReal(), points.get(2).getXReal()) &&
                    Objects.equals(points.get(3).getYReal(), points.get(0).getYReal())) {
                return RECTANGLE;
            } else if (isClosed == 1) {
                return CLOSED_BROKEN_LINE;
            } else {
                return BROKEN_LINE;
            }
        }
    }
}
