package testApp.model;


import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "content", catalog = "statistics")
public class Content implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "line_id", nullable = false, unique = true)
    private Long lineId;

    @Column(name = "line_content", nullable = false)
    private String lineContent;

    @Column(name = "file_id", nullable = false, insertable = false, updatable = false)
    private Long fileId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id",
                nullable = false,
                foreignKey = @ForeignKey(name = "file_id_fk"))
    private File file;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "lineContent", cascade = CascadeType.ALL)
    private Details details;


    public Content(Long lineId, String lineContent, Long fileId, File file, Details details) {
        this.lineId = lineId;
        this.lineContent = lineContent;
        this.fileId = fileId;
        this.file = file;
        this.details = details;
    }

    public Content() {

    }

    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public String getLineContent() {
        return lineContent;
    }

    public void setLineContent(String lineContent) {
        this.lineContent = lineContent;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    @Override
    public String toString(){

        String contentToDisplay = (lineContent.length() > 30) ? lineContent.substring(0, 29) : lineContent;
        return "ID: "           + lineId +
               ", CONTENT: "    + contentToDisplay.concat("...");
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Content){
            Content other = (Content)obj;
            if(other.getLineId().equals(lineId))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + lineId.hashCode();
        result = 31 * result + lineContent.hashCode();

        return result;
    }
}

