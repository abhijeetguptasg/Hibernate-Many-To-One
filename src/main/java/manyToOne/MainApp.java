package manyToOne;

import jakarta.persistence.*;

public class MainApp {

    public static void main(String[] args) {
        
        // Create EntityManagerFactory and EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryBook");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        
        try {
            // Begin transaction
            transaction.begin();
            
            // Create Library and Books
            Library library = new Library("City Library", "Downtown");

            Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", library);
            Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", library);

            // Persist the library and books
            em.persist(library);
            em.persist(book1);
            em.persist(book2);

            // Commit the transaction
            transaction.commit();

            System.out.println("Library and Books saved successfully!");
        }
        catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
    }
}
