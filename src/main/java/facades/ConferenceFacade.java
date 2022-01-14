package facades;

import dtos.ConferenceDTO;
import dtos.RenameMeDTO;
import entities.Conference;
import entities.RenameMe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ConferenceFacade {
    private static EntityManagerFactory emf;
    private static ConferenceFacade instance;

    public ConferenceFacade() {
    }

    public static ConferenceFacade getConferenceFacade(EntityManagerFactory _emf) {
        if(instance == null){
            emf = _emf;
            instance = new ConferenceFacade();
        }
        return instance;
    }

    public ConferenceDTO addConference(ConferenceDTO cDTO){
        EntityManager em = emf.createEntityManager();
        Conference c = new Conference(cDTO);
        try{
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cDTO;
    }

    public List<Conference> getAllConf(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Conference> query = em.createQuery("SELECT r FROM Conference r", Conference.class);
        List<Conference> confs = query.getResultList();
        return confs;
    }
}
