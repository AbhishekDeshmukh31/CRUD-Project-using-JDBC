package com.tka.eci.client;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.tka.eci.controller.CandidateController;
import com.tka.eci.entity.Candidate;

public class CandidateClient {

	public static void main(String[] args) {

		CandidateController controller = new CandidateController();
		Scanner scanner = new Scanner(System.in);
		int choice = 0;

		do {

			System.out.println();
			System.out.println("** Maharashtra Assembly Election 2024 Information Portal **");
			System.out.println();
			System.out.println();
			System.out.println("Enter 1: To check All Candidates contesting in Satara District");
			System.out.println("Enter 2: To check All Candidates contesting in Satara District by PartyName");
			System.out.println("Enter 3: To insert Candidates into DataBase ");
			System.out.println("Enter 4: To update Candidate's Data ");
			System.out.println("Enter 5: To update Candidate's PartyName ");
			System.out.println("Enter 6: To update Candidate's Assembly");
			System.out.println("Enter 7: To update Candidate's Gender ");
			System.out.println("Enter 8: To update Candidate's Age ");
			System.out.println("Enter 9: To update Candidate's Name ");
			System.out.println("Enter 10: To delete Candidate's Data from DataBase ");
			System.out.println("Enter 11: To Exit ");
			System.out.println();
			System.out.println();

			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Total Candidates Contesting in Satara District are: ");
				System.out.println();
				List<Candidate> list = controller.getallCandidatesController();
				for (Candidate candidate : list) {
					System.out.println(candidate);
				}
				System.out.println("-----------------------------------------------------------------------");
				break;

			case 2:
				System.out.println();
				try {
					System.out.println("Enter PartyName of Candidate: ");
					String pn = scanner.next();
					System.out.println("Candidates contesting in Satara District by PartyName are: ");
					List<Candidate> plist = controller.getcandidatesbypnameController(pn);
					for (Candidate candidate : plist) {
						System.out.println(candidate);
					}
				} catch (InputMismatchException e) {
					e.printStackTrace();
				}
				System.out.println("-----------------------------------------------------------------------");
				break;

			case 3:
				try {
					System.out.println("Enter name of Candidate: ");
					String name = scanner.nextLine();
					System.out.println("Enter PartyName of Candidate: ");
					String partyname = scanner.nextLine();
					System.out.println("Enter Name of Candidate's Assembly: ");
					String assembly = scanner.nextLine();
					System.out.println("Enter Gender of Candidate: ");
					String gender = scanner.nextLine();
					System.out.println("Enter Age of Candidate: ");
					int age = scanner.nextInt();
					System.out.println();
					String result = controller.addcandidatesController(name, partyname, assembly, gender, age);
					System.out.println(result);
				} catch (InputMismatchException e) {
					e.printStackTrace();
				}
				break;

			case 4:
				try {
					System.out.println("To Update Candidate's Data fill required fields");
					System.out.println();
					System.out.println("Enter Candidate's new PartyName: ");
					String partyname = scanner.nextLine();
					System.out.println("Enter Candidate's new Assembly: ");
					String assembly = scanner.nextLine();
					System.out.println("Enter Candidate's new Age: ");
					int age = scanner.nextInt();
					System.out.println("Enter Candidate's Name of whose data is being updated: ");
					String name = scanner.nextLine();
					String res = controller.updatecandidateDataController(name, partyname, assembly, age, name);
					System.out.println(res);
					System.out.println();
				} catch (InputMismatchException e) {
					e.printStackTrace();
				}
				break;

			case 5:
				try {
					System.out.println("Enter PartyName of Candidate: ");
					String partyname = scanner.nextLine();
					System.out.println("Enter Candidate name: ");
					String name = scanner.nextLine();
					System.out.println();
					String result = controller.updatecandidatePartyController(partyname, name);
					System.out.println(result);
				} catch (InputMismatchException e) {
					e.printStackTrace();
				}
				break;

			case 6:
				try {
					System.out.println("Enter Name of Assembly: ");
					String p = scanner.nextLine();
					System.out.println("Enter Candidate's Name: ");
					String n = scanner.nextLine();
					System.out.println();
					String result = controller.updatecandidateAssemblyController(p, n);
					System.out.println(result);
				} catch (InputMismatchException e) {
					e.printStackTrace();
				}
				break;

			case 7:
				try {
					System.out.println("Enter Gender of Candidate: ");
					String g = scanner.nextLine();
					System.out.println("Enter Candidate's Name: ");
					String n = scanner.nextLine();
					System.out.println();
					String result = controller.updatecandidateGenderController(g, n);
					System.out.println(result);
				} catch (InputMismatchException e) {
					e.printStackTrace();
				}
				break;

			case 8:
				try {
					System.out.println("Enter Age of Candidate: ");
					int ag = scanner.nextInt();
					System.out.println("Enter Candidate's Name: ");
					String n = scanner.nextLine();
					System.out.println();
					String result = controller.updatecandidateAgeController(ag, n);
					System.out.println(result);
				} catch (InputMismatchException e) {
					e.printStackTrace();
				}
				break;

			case 9:
				try {
					System.out.println("Enter Name of Candidate: ");
					String n = scanner.nextLine();
					System.out.println("Enter Candidate's PartyName: ");
					String pn = scanner.nextLine();
					System.out.println("Enter Candidate's Assembly: ");
					String a = scanner.nextLine();
					System.out.println();
					String result = controller.updatecandidateNameController(n, pn, a);
					System.out.println(result);
				} catch (InputMismatchException e) {
					e.printStackTrace();
				}
				break;

			case 10:
				try {
					System.out.println("Enter Name of Candidate: ");
					String n = scanner.nextLine();
					System.out.println();
					String result = controller.deletecandidatesController(n);
					System.out.println(result);
				} catch (InputMismatchException e) {
					e.printStackTrace();
				}
				break;

			case 11:
				System.out.println("Thankyou for using our Portal");
				break;
			default:
				System.out.println("Invalid Choice ! Please enter again.");
				System.out.println();
				break;

			}

		} while (choice != 11);
		scanner.close();
	}
}
