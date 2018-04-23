package testApp.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "details", catalog = "statistics")
public class Details {

    @GenericGenerator(name = "generator", strategy = "foreign",
                      parameters = @Parameter(name = "property", value = "content"))
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "line_id", unique = true, nullable = false)
    private Long lineId;

    @Column(name = "line_length", nullable = false)
    private Integer lineLength;

    @Column(name = "average_word_length", nullable = false)
    private BigDecimal averageWordLength;

    @Column(name = "longest_word", nullable = false)
    private String longestWord;

    @Column(name = "shortest_word", nullable = false)
    private String shortestWord;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Content lineContent;

    public Details(Long lineId, Integer lineLength, BigDecimal averageWordLength, String longestWord, String shortestWord, Content lineContent) {
        this.lineId = lineId;
        this.lineLength = lineLength;
        this.averageWordLength = averageWordLength;
        this.longestWord = longestWord;
        this.shortestWord = shortestWord;
        this.lineContent = lineContent;
    }

    public Details() {
    }

    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public Integer getLineLength() {
        return lineLength;
    }

    public void setLineLength(Integer lineLength) {
        this.lineLength = lineLength;
    }

    public BigDecimal getAverageWordLength() {
        return averageWordLength;
    }

    public void setAverageWordLength(BigDecimal averageWordLength) {
        this.averageWordLength = averageWordLength;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public void setLongestWord(String longestWord) {
        this.longestWord = longestWord;
    }

    public String getShortestWord() {
        return shortestWord;
    }

    public void setShortestWord(String shortestWord) {
        this.shortestWord = shortestWord;
    }

    public Content getLineContent() {
        return lineContent;
    }

    public void setLineContent(Content lineContent) {
        this.lineContent = lineContent;
    }


    @Override
    public String toString(){
        return "ID: "           + lineId +
                ", DETAILS: "   + lineLength +
                "/"             + averageWordLength +
                "/"             + shortestWord +
                "/"             + longestWord;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Details){
            Details other = (Details)obj;
            if(other.getLineId().equals(lineId))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + lineLength.hashCode();
        result = 31 * result + averageWordLength.hashCode();
        result = 31 * result + longestWord.hashCode();
        result = 31 * result + shortestWord.hashCode();
        result = 31 * result + lineContent.hashCode();
        return result;
    }
}
