package RegionalniCentar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Database {
    private static Database instance = null;
    
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("RegionalniCentarPU");
    private EntityManager em = entityManagerFactory.createEntityManager();
    
    private Database() {}
    
    public static Database getInstance() {
        if (instance == null) 
            instance = new Database();
        
        return instance;
    }
    
    public EntityManager getEntityManager() {
        return em;
    }
}
