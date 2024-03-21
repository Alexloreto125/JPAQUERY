package epicode.dao;

import epicode.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PeopleDAO {
	private EntityManager em;

	public PeopleDAO(EntityManager em) {
		this.em = em;
	}


	public void save(Person p) {
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.persist(p);
			t.commit();
			System.out.println(p.getNome() + " " + p.getCognome() + " creato!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Person findById(long id) {
		return em.find(Person.class, id);
	}

	public void findByIdAndDelete(long id) {
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();
			Person found = em.find(Person.class, id);
			if (found != null) {
				em.remove(found);
				t.commit();
				System.out.println("Persona eliminata");
			} else System.out.println("Persona non trovata");


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
