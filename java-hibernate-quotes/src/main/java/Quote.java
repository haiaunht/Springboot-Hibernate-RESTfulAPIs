import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="quotes")
public class Quote {
  @Id
  @SequenceGenerator(name="quote_generator", sequenceName = "quotes_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quote_generator")
  @Column(name="id", nullable = false, unique = true)
  private Long id;

  @Column(name = "quote", nullable = false, length = 3000)
  private String quote;

  @Column(name = "author", nullable = false, length = 255)
  private String author;

  @Column(name = "subject", nullable = false, length = 255)
  private String subject;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getQuote() {
    return this.quote;
  }

  public void setQuote(String quote) {
    this.quote = quote;
  }

  public String getAuthor() {
    return this.author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getSubject() {
    return this.subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }
}
