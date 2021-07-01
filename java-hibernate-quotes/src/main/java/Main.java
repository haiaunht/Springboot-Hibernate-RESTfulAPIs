import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("com.launchacademy.quotes");
    EntityManager em = emf.createEntityManager();

    try {
      Quote quote = new Quote();
      quote.setQuote("This is my quote");
      quote.setAuthor("Hai-Au Bui");
      quote.setSubject("Hibernate");

      Author haiau = new Author();
      haiau.setFirstName("Hai-Au");
      haiau.setLastName("Bui");

      em.getTransaction().begin();
      //em.persist(quote);
      //em.persist(haiau);
      em.getTransaction().commit();
    }
    finally {
      em.close();
      emf.close();
    }
  }
}
