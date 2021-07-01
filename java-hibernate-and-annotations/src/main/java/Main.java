import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("com.launchacademy.books");
    EntityManager em = emf.createEntityManager();

    try {
      Author author = new Author();
      author.setFirstName("James");
      author.setLastName("SA Corey");
      em.getTransaction().begin();
      em.persist(author);
      em.getTransaction().commit();
    }
    finally {
      em.close();
      emf.close();
    }
  }
}
