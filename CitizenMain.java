package ComplaintRegistration;

import java.util.Scanner;


public class CitizenMain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		CitizenDA citida = new CitizenDA();
		
		int choice;
		
		do {
			System.out.println("\n------------Citizen Register-----------");
			System.out.println("1. Add Citizen");
			System.out.println("2. Update Citizen");
			System.out.println("3. View Citizen");
			System.out.println("4. Delete Citizen");
			System.out.println("5. Exit");
			
			System.out.print("Enter your choice : ");
			
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			
			case 1:
				Citizen citi = new Citizen();
				
				System.out.print("Enter Citizen Name : ");
				citi.setCitizenName(sc.nextLine());
				
				System.out.print("Enter PhoneNumber : ");
				citi.setPhoneNumber(sc.nextLine());
				
				System.out.print("Enter Address : ");
				citi.setAddress(sc.nextLine());
				
				citida.addCitizen(citi);
				break;
				
			case 2:
				Citizen updateCit = new Citizen();
				
				System.out.print("Enter Citizen ID : ");
				updateCit.setCitizenId(sc.nextInt());
				sc.nextLine();
				
				System.out.print("Enter Citizen Name : ");
				updateCit.setCitizenName(sc.nextLine());
								
				System.out.print("Enter Phonenumber : ");
				updateCit.setPhoneNumber(sc.nextLine());
				
				System.out.print("Enter Address : ");
				updateCit.setAddress(sc.nextLine());
				
				citida.updateCitizen(updateCit);
				
				break;
				
			case 3:
				citida.viewCitizen();
				
				break;
				
			case 4:
				
				System.out.print("Enter Citizen ID : ");
				int id = sc.nextInt();
				
				citida.deleteCitizen(id);
				
				break;
				
			case 5: 
				
				System.out.println("Thanking you....(: ");
				break;
				
				default:
					
					System.out.println("Invaild choice...");
			}
		}while(choice != 5);
		
		sc.close();

	}
}
