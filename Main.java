package ComplaintRegistration;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CitizenDA citiDA = new CitizenDA();
        OfficerDA offDA = new OfficerDA();
        ComplaintDA compDA = new ComplaintDA();

        int choice;

        do {

            System.out.println("\n==============================================");

            System.out.println("  Municipal Complaint Registration  ");

            System.out.println("\n==============================================");
            
            System.out.println("1. Register Citizen");
            System.out.println("2. View Citizens");
            System.out.println("3. Update Citizen");
            System.out.println("4. Delete Citizen");

            System.out.println("5. Register Officer");
            System.out.println("6. View Officers");

            System.out.println("7. Register Complaint");
            System.out.println("8. Assign Officer");
            System.out.println("9. Update Complaint Status");
            System.out.println("10. View Resolution");
            System.out.println("11. View All Complaints");

            System.out.println("12. Exit");

            System.out.println("==============================================");

            System.out.print("Enter Choice : ");

            while (!sc.hasNextInt()) {

                System.out.println("Invalid input! Please enter a number." );

                sc.next();

                System.out.print("Enter Choice : ");
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

               

                case 1:

                    Citizen citi = new Citizen();
    				
    				System.out.print("Enter Citizen Name : ");
    				citi.setCitizenName(sc.nextLine());
    				
    				System.out.print("Enter PhoneNumber : ");
    				citi.setPhoneNumber(sc.nextLine());
    				
    				System.out.print("Enter Address : ");
    				citi.setAddress(sc.nextLine());
    				
    				citiDA.addCitizen(citi);
    				
    				break;

                
                case 2:

                    citiDA.viewCitizen();

                    break;

              
                case 3:

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
    				
    				citiDA.updateCitizen(updateCit);

                    break;

               
                case 4:

                	System.out.print("Enter Citizen ID : ");
    				int id = sc.nextInt();
    				
    				citiDA.deleteCitizen(id);

                    break;

                
                case 5:

                	System.out.print("Enter Officer Name : ");
                	String officerName = sc.nextLine();

                	System.out.print("Enter Department : ");
                	String department = sc.nextLine();

                	System.out.print("Enter Phone : ");
                	String phone = sc.nextLine();

                	Officer officer = new Officer(
                	        officerName,
                	        department,
                	        phone
                	);

                	offDA.registerOfficer(officer);
                    break;

               
                case 6:

                    offDA.viewOfficers();

                    break;

                
                case 7:
                    System.out.print("Enter Citizen ID : " );

                    int citizenId = sc.nextInt();

                    sc.nextLine();

                    System.out.println("\nComplaint Types:" );

                    System.out.println("1. Road Damage");

                    System.out.println("2. Water Supply");

                    System.out.println("3. Street Light");

                    System.out.println("4. Garbage Collection");

                    System.out.println("5. Drainage");

                    System.out.println("6. Other");

                    System.out.print("Enter Complaint Type : ");

                    String complaintType = sc.nextLine();

                    System.out.print("Enter Description : " );

                    String description = sc.nextLine();

                    Date complaintDate = Date.valueOf(LocalDate.now() );

                    
                    Complaint complaint = new Complaint(
                            citizenId,
                            complaintType,
                            description,
                            complaintDate
                    );
                    compDA.registerComplaint(complaint);

                    break;

                
                case 8:
                    System.out.print("Enter Complaint ID : ");

                    int complaintId = sc.nextInt();

                    System.out.print("Enter Officer ID : ");

                    int officerId = sc.nextInt();

                    sc.nextLine();

                    compDA.assignOfficer(
                            complaintId,
                            officerId
                    );

                    break;

                
                case 9:
                    System.out.print("Enter Complaint ID : ");

                    int statusComplaintId = sc.nextInt();

                    sc.nextLine();

                    System.out.println("\n1. Pending");

                    System.out.println("2. In Progress");

                    System.out.println("3. Resolved");

                    System.out.println("4. Rejected");

                    System.out.print("Enter Status Choice : ");

                    int statusChoice =
                            sc.nextInt();

                    sc.nextLine();

                    String status;

                    switch (statusChoice) {

                        case 1:
                            status = "Pending";
                            break;

                        case 2:
                            status = "In Progress";
                            break;

                        case 3:
                            status = "Resolved";
                            break;

                        case 4:
                            status = "Rejected";
                            break;

                        default:
                            System.out.println(
                                    "Invalid Status!"
                            );
                            continue;
                    }

                    System.out.print(
                            "Enter Resolution : "
                    );

                    String resolution =
                            sc.nextLine();

                    compDA.updateStatus(
                            statusComplaintId,
                            status,
                            resolution
                    );

                    break;

               
                case 10:                   
                    System.out.print("Enter Complaint ID : ");

                    int resolutionId = sc.nextInt();

                    sc.nextLine();

                    compDA.viewResolution(resolutionId);

                    break;

               
                case 11:

                    compDA.viewAllComplaints();

                    break;

                
                case 12:

                    System.out.println(
                            "\nThank you for using "
                            + "Municipal Complaint Management System!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid Choice!"
                    );
            }

        } while (choice != 12);

        sc.close();
    }
}
