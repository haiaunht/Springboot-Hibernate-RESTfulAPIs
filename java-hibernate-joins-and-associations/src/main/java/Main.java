import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.launchacademy.blog");
    EntityManager em = emf.createEntityManager();

    try {
      Article article = em.createQuery("SELECT a FROM Article a WHERE subject = 'Testing Hibernate'", Article.class).getSingleResult();

      //the new way
      Comment firstComment = article.getComments().get(0);
      System.out.println(firstComment.getBody());
    }
    finally {
      em.close();
      emf.close();
    }
  }
}