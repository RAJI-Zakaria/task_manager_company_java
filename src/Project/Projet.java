package Project;

import java.time.LocalDate;
import java.util.ArrayList;

public class Projet {
	//client
	private Client G_Client;
	//referent
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
		//donner la liste des tâches en retard (tous projets confondus)
		public void tacheRetard() {
			
			
			System.out.println("\n========= Delayed Tasks =========");

			LocalDate date = LocalDate.now();   
			
			for (Tache tache : taches) {
				//comparing between task date and current date 
				//greater that 0 proceed.
				//also checking if the task isn't finished yet
				/*
				 * compareTo(LocalDate otherDate)
				 * It returns 0 if both the dates are equal.
				 * It returns positive value if “this date” is greater than the otherDate.
				 * It returns negative value if “this date” is less than the otherDate. 
				 */
				if(tache.getDatefin().compareTo(date) < 0 && !tache.isFinished()) {
					System.out.println(tache);
				}
			} 
			
		}
		//donner la liste des tâches terminées par projet
		//get all finished tasks
		public void tachesTerminees() {
			
			
			System.out.println("\n========= Finished Tasks ========="); 
			
			for (Tache tache : taches) { 
				if(tache.isFinished()) {
					System.out.println(tache);
				}
			} 
			
		}
		
		//donner la liste des tâches en cours pour un employé
		//to get a progressing task we are going to check if the current date is between start date and end date of the current task 
		//as well as checking if the first required task has already been executed (at least)
		public void tachesEnCours(Employe emp) { 
			
			System.out.println("\n========= Progressing Tasks =========");

			LocalDate date = LocalDate.now();   
			
			for (Tache tache : taches) {
				if(tache.getEmploye().equals(emp))
				{
					boolean dateBetweenDebAndEndOfTask = tache.getDatefin().compareTo(date) >= 0 && tache.getDateDeb().compareTo(date) <= 0 ;
					 
					boolean oneRequiredTaskFinished = true  ;
					//task contains at least one required task which has to be executed  
					 if(!tache.getPreRequis().isEmpty()) {
						 oneRequiredTaskFinished = tache.getPreRequis().get(0).isFinished();
					 }
							
					if( dateBetweenDebAndEndOfTask && !tache.isFinished() && oneRequiredTaskFinished) {
						System.out.println(tache);
					}
				}
			} 
			
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