package epicode.dao;

import epicode.entities.Attendance;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AttendancesDAO {
	private EntityManager em;

	public AttendancesDAO(EntityManager em) {
		this.em = em;
	}
	public void save(Attendance attendance) {
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.persist(attendance);
			t.commit();
			System.out.println("Partecipazione all'evento " + attendance.getEvento() + " per la persona " + attendance.getPersona().getCognome() + ", creata");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Attendance findById(long id) {
		return em.find(Attendance.class, id);
	}

	public void findByIdAndDelete(long id) {
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();
			Attendance found = em.find(Attendance.class, id);
			if (found != null) {
				em.remove(found);
				t.commit();
				System.out.println("Partecipazione cancellata");
			} else System.out.println("Partecipazione non trovata");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
