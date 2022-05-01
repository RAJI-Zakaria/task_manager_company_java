package Project;

import java.time.LocalDate; 

import java.util.ArrayList;

public class main {
	
	 
	public static void main(String[] args) {
		//creating new employees
		Employe emp1 = new Employe("zak", "raj", LocalDate.of(1998, 06, 13));
		Employe emp2 = new Employe("well", "karl", LocalDate.of(1996, 01, 9));
		Employe emp3 = new Employe("jake", "sparrow", LocalDate.of(1990, 06, 8));
		

		
		//creating new client
		Client cli1 = new Client("Jean", "Smith", LocalDate.of(1970, 12, 13));
		//creating new project
		Projet projet1 = new Projet( cli1,  emp1);
		//creating new tache  
		Tache Tache1 = new Tache("Tache 1 ",  "no description",   LocalDate.of(2022, 04, 13),  LocalDate.of(2022, 04, 20),  1, emp1);
		//adding task 1 to the project 1
		projet1.addTache(Tache1);
		
		//more tasks
		Tache Tache2 = new Tache("Tache 2 ",  "no description",   LocalDate.of(2022, 03, 2),  LocalDate.of(2022, 03, 6),  21, emp2);
		Tache Tache3 = new Tache("Tache 3 ",  "no description",   LocalDate.of(2022, 04, 3),  LocalDate.of(2022, 04, 5),  33, emp1);
		Tache Tache4 = new Tache("Tache 4 ",  "no description",   LocalDate.of(2022, 12, 18),  LocalDate.of(2022, 12, 20),  6, emp3);
		Tache Tache5 = new Tache("Tache 5 ",  "no description",   LocalDate.of(2022, 6, 14),  LocalDate.of(2022, 11, 12),  7, emp1);
		Tache Tache6 = new Tache("Tache 6 ",  "no description",   LocalDate.of(2022, 3, 21),  LocalDate.of(2022, 04, 11),  8, emp2);
		Tache Tache7 = new Tache("Tache 7 ",  "no description",   LocalDate.of(2022, 2, 22),  LocalDate.of(2022, 9, 7),  2, emp3);
		Tache Tache8 = new Tache("Tache 8 ",  "no description",    LocalDate.of(2022, 03, 2),  LocalDate.of(2022, 03, 6),  2, emp3);
		Tache Tache9 = new Tache("Tache 9 ",  "no description",    LocalDate.of(2022, 01, 23),  LocalDate.of(2022, 06, 16),  2, emp2);

		projet1.addTache(Tache8);
		projet1.addTache(Tache9);

		//adding required tasks to the project 1
		Tache1.addPreRequis(Tache2);
		Tache1.addPreRequis(Tache3);
		Tache1.addPreRequis(Tache4);
		Tache1.addPreRequis(Tache5);
		Tache1.addPreRequis(Tache6);
		Tache1.addSousTaches(Tache7);
		
//		System.out.println("=============");
//		Tache1.displayPreRequis();
//		
//		System.out.println("=============");
		//executing the task number one which is stored inside the project number one && which also contains other required/sub tasks 

		
		System.out.println("======= Executing Tache1.execute(); ======");
		Tache1.execute();
		
//		System.out.println("=============");
//		
//		Tache8.execute();
//
//		System.out.println("=======================================");
//		System.out.println(Tache1);
		
		//getting the delayed tasks
		projet1.tacheRetard();

		//getting the finished tasks
		projet1.tachesTerminees();

		//getting tasks in progress
		projet1.tachesEnCours(emp2);
			
		
		
		System.out.println("=============");
		System.out.println("=============");
		MyObjectFileStore mof = new MyObjectFileStore(); 
		//saving the project to a file :
		mof.storeObject(projet1);
		

		//reading stored project from a file :
		Projet stored_projet = mof.readProjet();
		
		//showing delayed tasks from the stored project
		stored_projet.tacheRetard();
	
	}

}
