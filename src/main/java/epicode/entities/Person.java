package epicode.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "persone")
public class Person {
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String cognome;
	private String email;
	private LocalDate data_di_nascita;
	private char sesso;


	@OneToMany(mappedBy = "persona")
	private List<Attendance> listaPartecipazioni;

	public Person() {
	}

	public Person(String nome, String cognome, String email, LocalDate data_di_nascita, char sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.data_di_nascita = data_di_nascita;
		this.sesso = sesso;
	}

	public long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getData_di_nascita() {
		return data_di_nascita;
	}

	public void setData_di_nascita(LocalDate data_di_nascita) {
		this.data_di_nascita = data_di_nascita;
	}

	public char getSesso() {
		return sesso;
	}

	public void setSesso(char sesso) {
		this.sesso = sesso;
	}

	public List<Attendance> getListaPartecipazioni() {
		return listaPartecipazioni;
	}

	public void setListaPartecipazioni(List<Attendance> lista_partecipazioni) {
		this.listaPartecipazioni = lista_partecipazioni;

	}

	@Override
	public String toString() {
		return "Persona{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", cognome='" + cognome + '\'' +
				", email='" + email + '\'' +
				", data_di_nascita=" + data_di_nascita +
				", sesso=" + sesso +
				'}';
	}
}
