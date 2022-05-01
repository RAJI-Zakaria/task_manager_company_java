package Project;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Tache  implements Serializable{
	private String titre;
	private String description;
	private LocalDate dateDeb;
	private LocalDate datefin;
	//Ex : task with priority = 5 is going to be executed before other tasks with less priority level.
	private int niveauPriorite;
	

	private boolean finished;
	
	private Employe employe;


	private ArrayList<Tache> preRequis;
	private ArrayList<Tache> sousTaches;

	
	public Tache(String titre, String description, LocalDate dateDeb, LocalDate datefin, int niveauPriorite, Employe employe) {
		//setting the properties
		this.titre = titre;
		this.description = description;
		this.dateDeb = dateDeb;
		this.datefin = datefin;
		this.niveauPriorite = niveauPriorite;
		//initializing the lists ==> empty list
		this.preRequis = new ArrayList<Tache>();
		this.sousTaches = new ArrayList<Tache>();
		this.employe=employe;
		
		this.finished=false;
	}
	//overloading the constructor
	public Tache(String titre, String description, LocalDate dateDeb, LocalDate datefin, int niveauPriorite, Employe employe, ArrayList<Tache> preRequis, ArrayList<Tache> sousTaches) {
		//calling the other construction to set the other elements
		this(titre, description, dateDeb, datefin, niveauPriorite, employe);
		//setting up the lists 
		this.preRequis = preRequis;
		this.sousTaches = sousTaches;
	}
 
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
	
	public LocalDate getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(LocalDate dateDeb) {
		this.dateDeb = dateDeb;
	}

	public LocalDate getDatefin() {
		return datefin;
	}

	public void setDatefin(LocalDate datefin) {
		this.datefin = datefin;
	}

	public int getNiveauPriorite() {
		return niveauPriorite;
	}

	public void setNiveauPriorite(int niveauPriorite) {
		this.niveauPriorite = niveauPriorite;
	}

	public ArrayList<Tache> getPreRequis() {
		return preRequis;
	}

//	public void setPreRequis(ArrayList<Tache> preRequis) {
//		this.preRequis = preRequis;
//	}

	public ArrayList<Tache> getSousTaches() {
		return sousTaches;
	}

	public void displayPreRequis() {
		for (Tache tache : this.preRequis) {
			 System.out.println(tache);
			 System.out.println("--------------------------");
		} 
	}

//	public void setSousTaches(ArrayList<Tache> sousTaches) {
//		this.sousTaches = sousTaches;
//	}

	public Employe getEmploye() {
		return employe;
	}
	public void setClient(Employe employe) {
		this.employe = employe;
	}
	
	public boolean isFinished() {
		return finished;
	}
	public void finished() {
		this.finished = true;
	}
	
//	public void setFinished(boolean finished) {
//		this.finished = finished;
//	}
	
	//CRUD simple functions 

	public void addPreRequis(Tache P_Task) {

		 this.preRequis = addItemSortInsert(P_Task, this.preRequis);
		
	}

	public void addSousTaches(Tache P_Task) {

		 this.sousTaches.add(P_Task);
		
	}
	
	
	 
	//adding new task with sorted insertion based on their priority level
	//so that we can execute all required tasks without checking the level of each one of them.
	public ArrayList<Tache> addItemSortInsert(Tache P_Task, ArrayList<Tache> tasks) {

		int lgt = tasks.size();
		if(lgt==0) { 
			tasks.add(P_Task);   
		}
		else {
			for (int index=0; index< lgt; index++) {
				 if(isGT(P_Task, tasks.get(index))) {
					 //.add(index, task) is going to add the task at the specified index 
					 //but at the same time is going to shift the rest of task 
					 //isn't that so c00.00l!!!
					 tasks.add(index, P_Task); 
					 break;
					 
				 }else if(index==lgt-1){//add to the end
 					 tasks.add(P_Task); 
					 break;
				 }
 
			}
		}
		
		
		return tasks;
		
	}
	
	public void deletePreRequis(Tache preRequis) {
		int preRequisIndex = this.preRequis.indexOf(preRequis);
		this.preRequis.remove(preRequisIndex);
	}
	
	public void modifyPreRequis(Tache preRequis) {
		int preRequisIndex = this.preRequis.indexOf(preRequis);
		this.preRequis.set(preRequisIndex, preRequis);
	}
	
	//a task can have other task as required or sub,
	//and required/sub tasks also can have other sub/req tasks
	//which means that we are dealing with a tree of element
	//With being said, to execute a task we must check the required tasks first --> requires tasks of the selected required task.....

	public void executePreRequisTache() {
		for (Tache tache : this.preRequis) { 
			//before executing the next task we must execute the required current task
			//here we are going to use a recursive function call
			//which will check every sub of sub of... sub requiredTask
			//-task1 --> require(task2)  EXECUTE TASK 3 BEFORE TASK 2
			//					-task2 --> require(task3)  EXECUTE TASK 3 THEN 2 
			//										-task3 --> require(task4)  EXECUTE TASK 4 THEN 1 
			
			//tache.executePreRequisTache()
			tache.execute();
			//THIS is going to set the finished property of each nested required task to true
			tache.finished();
			System.out.println("Executing requirements : "+tache);
		}
		
		
	}
	
	public void executeSousTache() {
		for (Tache tache : this.sousTaches) { 
			  
			tache.finished();
			System.out.println("Executing sub-task : "+tache);
		} 
	}
	

	
	public void execute() { 
		
		 //first execute the required tasks ()sorted based on priority attribute
		executePreRequisTache();
		//second execute the sub tasks (the order doesn't matter)
		executeSousTache();
		//now task is finished 100% ==> set finished of the this task to true
		this.finished=true;
 
		
	}
	
	//index of high priority not executed task
	public Tache indexOfHighPriorityNXTache(ArrayList<Tache> taches) {
		//first object.
		Tache task = taches.get(0);
		//comparing the priority of the first object with rest of the tasks tab while changing task with an other task with high priority.
		for (Tache tache : this.preRequis) {
			if(tache.getNiveauPriorite() > task.getNiveauPriorite() && !tache.isFinished()) {
				task = tache;
			}
		}
		
		return task;
	}
	
	
	
	
	//— donner la liste des tâches en cours pour un employé
//	public Tache TacheCoursEmploye(Employe emp) {
//		return preRequis.get;
//	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " titre : "+this.titre+"\n description : "+ this.description+"\n Deb : "+  this.dateDeb+"\n Fin : "+  this.datefin+"\n Prio : "+  this.niveauPriorite+"\n finished : "+  this.isFinished();
	}

	//checking the priority of the current object/instance and the other one passed through the param
	//isGT ===> task1.isGreaterThan(task2)
	public boolean isGT(Tache P_Task, Tache P_Task2) {
		return P_Task.niveauPriorite > P_Task2.niveauPriorite;
}
	public boolean isLT(Tache P_Task, Tache P_Task2) {
		return P_Task.niveauPriorite < P_Task2.niveauPriorite;
}
	
	

}
