package testApp.model;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "files", catalog = "statistics")
public class File implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "file_id", unique = true, nullable = false)
    private Long fileId;

    @Column(name = "file_name", nullable = false, length = 10)
    private String fileName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "file",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Content> contentSet = new HashSet<>();

    public File(Long fileId, String fileName, Set<Content> contentSet) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.contentSet = contentSet;
    }

    public File() {
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Set<Content> getContentSet() {
        return contentSet;
    }

    public void setContentSet(Set<Content> contentSet) {
        this.contentSet = contentSet;
    }

    @Override
    public String toString(){
        return "ID: "       + fileId +
               ", NAME: "  + fileName;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof File){
            File other = (File)obj;
            if(other.getFileId().equals(fileId))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + fileId.hashCode();
        result = 31 * result + fileName.hashCode();

        return result;
    }
}



