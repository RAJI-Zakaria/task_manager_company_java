package Project;

import java.time.LocalDate;

import java.util.ArrayList;

public class main {
	
	

	public static void main(String[] args) { 
		//creating new employee
		Employe emp1 = new Employe("zak", "raj", LocalDate.of(1998, 06, 13));
		Employe emp2 = new Employe("well", "karl", LocalDate.of(1996, 01, 9));
		Employe emp3 = new Employe("jake", "sparrow", LocalDate.of(1990, 06, 8));
		
		
		
		//creating new employe
		Client cli1 = new Client("Jean", "Smith", LocalDate.of(1970, 12, 13));
		//creating new project
		Projet projet1 = new Projet( cli1,  emp1);
		//creating new tache 

		Tache Tache1 = new Tache("Tache 1 ",  "no description",   LocalDate.of(2022, 04, 13),  LocalDate.of(2022, 04, 20),  1, emp1);
		
		projet1.addTache(Tache1);
		
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
		Tache1.execute();
		
//		System.out.println("=============");
//		
//		Tache8.execute();
//
//		System.out.println("=======================================");
//		System.out.println(Tache1);
		
projet1.tacheRetard();

projet1.tachesTerminees();

projet1.tachesEnCours(emp2);
		
		//creating new employe
	}

}
