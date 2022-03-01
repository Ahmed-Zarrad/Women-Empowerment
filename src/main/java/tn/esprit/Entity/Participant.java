package tn.esprit.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Participant {
	
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int Id;
		
		@Column(name="FirstName")
		private String FirstName;
		
		@Column(name="Email")
		private String Email;

		
		@Column(name="LastName")
		private String LastName;
		
	
		@ManyToMany(mappedBy="participant", cascade = CascadeType.ALL )
		private Set<CharityEvent> charityEvent;

		@OneToOne
		private Userx userx;

		public int getId() {
			return Id;
		}

		public void setId(int id) {
			Id = id;
		}

		public String getFirstName() {
			return FirstName;
		}

		public void setFirstName(String firstName) {
			FirstName = firstName;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}

		public String getLastName() {
			return LastName;
		}

		public void setLastName(String lastName) {
			LastName = lastName;
		}

		public Set<CharityEvent> getCharityEvent() {
			return charityEvent;
		}

		public void setCharityEvent(Set<CharityEvent> charityEvent) {
			this.charityEvent = charityEvent;
		}

		public Userx getUserx() {
			return userx;
		}

		public void setUserx(Userx userx) {
			this.userx = userx;
		}

		public Participant(int id, String firstName, String email, String lastName, Set<CharityEvent> charityEvent,
				Userx userx) {
			super();
			Id = id;
			FirstName = firstName;
			Email = email;
			LastName = lastName;
			this.charityEvent = charityEvent;
			this.userx = userx;
		}

		public Participant() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}
