package facades;

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

    //TODO: Delete this comment, just used for actions
    public List<Conference> getAllConf(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Conference> query = em.createQuery("SELECT r FROM Conference r", Conference.class);
        List<Conference> confs = query.getResultList();
        return confs;
    }
}
