package Project;

import java.time.LocalDate;
import java.util.ArrayList;

public class Projet {
	private Client G_Client;
	private Employe Employe;
	private ArrayList<Tache> taches;

 
	
	public Projet(Client Client, Employe Employe) {
		//Initialization
		this.G_Client=Client;
		this.Employe = Employe;
		this.taches = new ArrayList<Tache>();
	}
	public Projet(Client Client, Employe Employe, ArrayList<Tache> taches) {
		//using the first constructor with two params
		this(Client, Employe);
		this.taches = taches;
	}

	public Client getG_Client() {
		return G_Client;
	}

	public void setG_Client(Client g_Client) {
		G_Client = g_Client;
	}

	public Employe getEmploye() {
		return Employe;
	}

	public void setEmploye(Employe employe) {
		Employe = employe;
	}

	public ArrayList<Tache> getTaches() {
		return taches;
	}

	public void setTaches(ArrayList<Tache> taches) {
		this.taches = taches;
	}
	
	//CRUD simple functions
	
		public void addTache(Tache tache) {
			this.taches.add(tache);
		}
		
		public void deleteTache(Tache tache) {
			int preRequisIndex = this.taches.indexOf(tache);
			this.taches.remove(preRequisIndex);
		}
		
		public void modifyTache(Tache tache) {
			int preRequisIndex = this.taches.indexOf(tache);
			this.taches.set(preRequisIndex, tache);
		}
		
		
		
		//getting all delayed tasks
		public ArrayList<Tache> tacheRetard() {
			LocalDate date = LocalDate.now();  
			ArrayList<Tache> taches_retard = new ArrayList<Tache>();
			
			for (Tache tache : taches) {
				//comparing between task date and current date 
				//greater that 0 proceed.
				//also checking if the task isn't finished yet
				if(tache.getDatefin().compareTo(date) < 0 && !tache.isFinished()) {
					taches_retard.add(tache);
				}
			}
			
			return taches_retard;
			
		}
		

		public void afficheTaches(ArrayList<Tache> tasks) {

			for (Tache tache : tasks) {
				System.out.println(tache);
			}
		}
		
		public void afficheTaches() {

			for (Tache tache : this.taches) {
				System.out.println(tache);
			}
		}

		
	

}