
import com.launchacademy.teamrosterwithspring.models.Team;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "leagues")
public class League {
  @Id
  @SequenceGenerator(name = "team_generator",sequenceName = "teams_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @Column(name = "league_name")
  private String leagueName;

  @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
  private List<Team> players = new ArrayList<Team>();

  public void setPlayers(List<Team> players) {
    this.players = players;
  }

  public List<Team> getPlayers() {
    return this.players;
  }
}