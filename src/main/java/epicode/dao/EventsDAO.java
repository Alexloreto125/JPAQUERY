package epicode.dao;

import epicode.entities.Concerto;
import epicode.entities.Event;
import epicode.entities.PartitaPallavolo;
import epicode.entities.TipoConcerto;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class EventsDAO {
    private EntityManager em;

    public EventsDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Event evento) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(evento);
            t.commit();
            System.out.println("Evento - " + evento.getTitolo() + " - creato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Event findById(long id) {
        return em.find(Event.class, id);
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Event found = em.find(Event.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Evento eliminato");
            } else System.out.println("Evento non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        Query query = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming");
        query.setParameter("inStreaming", inStreaming);
        return query.getResultList();
    }
    public List<Concerto> getConcertiPerGenere(TipoConcerto tipoConcerto) {
        Query query = em.createQuery("SELECT c FROM Concerto c WHERE c.tipoConcerto = :tipoConcerto");
        query.setParameter("tipoConcerto", tipoConcerto);
        return query.getResultList();
    }

    public List<PartitaPallavolo> getPartiteVinteInCasa(String squadraCasa) {
        TypedQuery<PartitaPallavolo> query = em.createNamedQuery("PartitaPallavolo.getPartiteVinteInCasa", PartitaPallavolo.class);
        query.setParameter("squadraCasa", squadraCasa);
        return query.getResultList();
    }

    public List<PartitaPallavolo> getPartiteVinteInTrasferta(String squadraCasa) {
        TypedQuery<PartitaPallavolo> query = em.createNamedQuery("PartitaPallavolo.getPartiteVinteInTrasferta", PartitaPallavolo.class);
        query.setParameter("squadraCasa", squadraCasa);
        return query.getResultList();
    }
}
