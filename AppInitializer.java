import java.util.Scanner; 

public class AppInitializer {
	static Scanner scanner = new Scanner(System.in);
    static int MAX_STUDENTS = 100; // Maximum number of students to be stored
    static String[] studentIds = new String[MAX_STUDENTS];
    static String[] studentNames = new String[MAX_STUDENTS];
    static double[] studentPFMarks = new double[MAX_STUDENTS];
    static double[] studentDBMarks = new double[MAX_STUDENTS];
    static int numStudents = 0; // Number of students currently stored
    
    public static void main(String[] args) {
		loadHomePage(scanner);
    }
    
    public final static void clearConsole() { 
		try {
			final String os = System.getProperty("os.name"); 
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J"); 
				System.out.flush();
			}
		} catch (final Exception e) {
			e.printStackTrace();
			// Handle any exceptions.
		}
	}
    
     public static void loadHomePage(Scanner scanner) {
		String text = "WELCOME TO GDSE MARKS MANAGEMENT SYSTEM";
		int width = 100; 
		int spaces = (width - text.length()) / 2;
		String centeredText = String.format("%" + spaces + "s%s%" + spaces + "s", "", text, "");
		String border = String.format("%" + width + "s", "").replaceAll(" ", "=");
		System.out.println(border);
		System.out.println(centeredText);
		System.out.println(border);
		System.out.println();
		
		System.out.printf("%-50s %-50s\n", "[1]  Add New Student", "[2]  Add New Student With Marks");
		System.out.printf("%-50s %-50s\n", "[3]  Add Marks", "[4]  Update Student Details");
		System.out.printf("%-50s %-50s\n", "[5]  Update Marks", "[6]  Delete Student");
		System.out.printf("%-50s %-50s\n", "[7]  Print Student Details", "[8]  Print Student Rank");
		System.out.printf("%-50s %-50s\n", "[9]  Best in Programming Fundamentals", "[10] Best in Database Management System");
		System.out.println();
		System.out.println();
		
		System.out.print("Enter an option to continue > ");
		String option = scanner.next();
		clearConsole();

		switch (option) {
			case "1":
				addNewStudent(scanner);
				break;
			case "2":
				addNewStudentWithMarks(scanner);
				break;
			case "3":
				if(numStudents != 0){
					addMarks(scanner);
				}else{
					System.out.println("No Students are Available in the System. Please and a Student before Add Marks");
					try {
						Thread.sleep(3000); // wait for 3 seconds
					} catch (InterruptedException e) {
			   
					}
					clearConsole();
					loadHomePage(scanner);
				}
				break;	
		}
	}
	
	
	 public static void addMarksCheck(Scanner scanner) {
		 if(numStudents != 0){
				addMarks(scanner);
		}else{
		System.out.println("No Students are Available in the System. Please and a Student before Add Marks");
		System.out.println();
        
		try {
            Thread.sleep(3000); // wait for 3 seconds
        } catch (InterruptedException e) {
           
        }
			// redirect the user to the home page
			clearConsole();
			loadHomePage(scanner);
		}
	 }
    
     public static void addNewStudent(Scanner scanner) {
		String text = "ADD NEW STUDENT";
		int width = 100; 
		int spaces = (width - text.length()) / 2;
		String centeredText = String.format("%" + spaces + "s%s%" + spaces + "s", "", text, "");
		String border = String.format("%" + width + "s", "").replaceAll(" ", "=");
		System.out.println(border);
		System.out.println(centeredText);
		System.out.println(border);
		System.out.println();
		

       char response = 'Y';
        do {
            // Prompt the user to input a new student ID
            System.out.print("Enter Student ID : ");
            String studentId = scanner.next();

            // Check if the student ID already exists in the array
            boolean exists = false;
            for (int i = 0; i < numStudents; i++) {
                if (studentIds[i].equals(studentId)) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                // If the student ID already exists, prompt the user to enter a new ID
                System.out.println("Student ID already exists. Please enter a new ID.");
                continue;
            }

            // Prompt the user to input a new student name
            System.out.print("Enter Student Name : ");
            String studentName = scanner.next();

            // Add the new student ID and name to the arrays
            studentIds[numStudents] = studentId;
            studentNames[numStudents] = studentName;
            numStudents++;
            
             System.out.println();
            System.out.println("Student has been added successfully.");

             // Prompt the user if they want to add a new student
            do {
                System.out.print("Do you want to add a new student (Y/N): ");
                response = scanner.next().charAt(0);
                switch (response) {
                    case 'Y':
                    case 'y':
                        clearConsole();
						addNewStudent(scanner);
						break;
                    case 'N':
                    case 'n':
                        clearConsole();
						loadHomePage(scanner);
						break;
                    default:
                        System.out.println("Invalid input. Please enter Y or N.");
                }
            } while (response != 'Y' && response != 'y' && response != 'N' && response != 'n');
        }while (response == 'Y' || response == 'y');
	}
	
	
	 public static void addNewStudentWithMarks(Scanner scanner) {
		String text = "ADD NEW STUDENT WITH MARKS";
		int width = 100; 
		int spaces = (width - text.length()) / 2;
		String centeredText = String.format("%" + spaces + "s%s%" + spaces + "s", "", text, "");
		String border = String.format("%" + width + "s", "").replaceAll(" ", "=");
		System.out.println(border);
		System.out.println(centeredText);
		System.out.println(border);
		System.out.println();
		
		char response = 'Y';
        do {
            // Prompt the user to input a new student ID
            System.out.print("Enter Student ID : ");
            String studentId = scanner.next();

            // Check if the student ID already exists in the array
            boolean exists = false;
            for (int i = 0; i < numStudents; i++) {
                if (studentIds[i].equals(studentId)) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                // If the student ID already exists, prompt the user to enter a new ID
                System.out.println("Student ID already exists. Please enter a new ID.");
                continue;
            }

            // Prompt the user to input a new student name
            System.out.print("Enter Student Name : ");
            String studentName = scanner.next();
             System.out.println();
            
			// Prompt the user to input programming fundamentals marks
            System.out.print("Programming Fundamentals Marks : ");
            double studentPFMark = scanner.nextDouble();
            while (studentPFMark < 0 || studentPFMark > 100) {
                System.out.println("Invalid marks! Please enter a mark between 0 and 100.");
                studentPFMark = scanner.nextDouble();
            }
            
            // Prompt the user to input database management system marks
            System.out.print("Database Management System Marks : ");
            double studentDBMark = scanner.nextDouble();
            while (studentDBMark < 0 || studentDBMark > 100) {
                System.out.println("Invalid marks! Please enter a mark between 0 and 100.");
                studentDBMark = scanner.nextDouble();
            }
    

            // Add the new student ID and name to the arrays
            studentIds[numStudents] = studentId;
            studentNames[numStudents] = studentName;
            studentPFMarks[numStudents] = studentPFMark;
            studentDBMarks[numStudents] = studentDBMark;
            numStudents++;
            
             System.out.println();
            System.out.println("Student has been added successfully.");

             // Prompt the user if they want to add a new student
            do {
                System.out.print("Do you want to add a new student (Y/N): ");
                response = scanner.next().charAt(0);
                switch (response) {
                    case 'Y':
                    case 'y':
                        clearConsole();
						addNewStudentWithMarks(scanner);
						break;
                    case 'N':
                    case 'n':
                        clearConsole();
						loadHomePage(scanner);
						break;
                    default:
                        System.out.println("Invalid input. Please enter Y or N.");
                }
            } while (response != 'Y' && response != 'y' && response != 'N' && response != 'n');
        }while (response == 'Y' || response == 'y');
	}
		
	
	 public static void addMarks(Scanner scanner) {
        String text = "ADD MARKS";
        int width = 100; 
        int spaces = (width - text.length()) / 2;
        String centeredText = String.format("%" + spaces + "s%s%" + spaces + "s", "", text, "");
        String border = String.format("%" + width + "s", "").replaceAll(" ", "=");
        System.out.println(border);
        System.out.println(centeredText);
        System.out.println(border);
        System.out.println();
        
        
            char response = 'Y';
        do {
            System.out.print("Enter Student ID:");
        String studentId = scanner.next();
        
       int studentIndex = -1;
        for (int i = 0; i < studentIds.length; i++) {
            if (studentIds[i] != null && studentIds[i].equals(studentId)) {
                studentIndex = i;
                break;
            }
        }

            if (studentIndex == -1) {
                // If the student ID not exists, prompt the user to serch again
                do {
                System.out.print("Invalid Student ID. Do you want to serch again? (Y/N): ");
                response = scanner.next().charAt(0);
                switch (response) {
                    case 'Y':
                    case 'y':
                        break;
                    case 'N':
                    case 'n':
                        clearConsole();
                        loadHomePage(scanner);
                        break;
                    default:
                        System.out.println("Invalid input. Please enter Y or N.");
                }
            } while (response != 'Y' && response != 'y' && response != 'N' && response != 'n');
                
            }else {
            if (studentPFMarks[studentIndex] == 0) {
                String studentName = studentNames[studentIndex];
				System.out.println("Student name: " + studentName);
				System.out.println();

				
			// Prompt the user to input programming fundamentals marks
            System.out.print("Programming Fundamentals Marks : ");
            double studentPFMark = scanner.nextDouble();
            while (studentPFMark < 0 || studentPFMark > 100) {
                System.out.println("Invalid marks! Please enter a mark between 0 and 100.");
                studentPFMark = scanner.nextDouble();
            }
            
            // Prompt the user to input database management system marks
            System.out.print("Database Management System Marks : ");
            double studentDBMark = scanner.nextDouble();
            while (studentDBMark < 0 || studentDBMark > 100) {
                System.out.println("Invalid marks! Please enter a mark between 0 and 100.");
                studentDBMark = scanner.nextDouble();
            }
    

            // Add the new student ID and name to the arrays
            studentIds[numStudents] = studentId;
            studentNames[numStudents] = studentName;
            studentPFMarks[numStudents] = studentPFMark;
            studentDBMarks[numStudents] = studentDBMark;
            numStudents++;
            
             System.out.println();
            System.out.println("Marks have been added.");
            do {
                System.out.print("Do you want to add marks for another student? (Y/N): ");
                response = scanner.next().charAt(0);
                switch (response) {
                    case 'Y':
                    case 'y':
                        clearConsole();
						addMarks(scanner);
						break;
                    case 'N':
                    case 'n':
                        clearConsole();
						loadHomePage(scanner);
						break;
                    default:
                        System.out.println("Invalid input. Please enter Y or N.");
                }
            } while (response != 'Y' && response != 'y' && response != 'N' && response != 'n');
            } else {
                System.out.println("This student's marks have been already added");
                System.out.println("If you want to update the marks, please use [4] Update Marks option.");
                System.out.println();
                
                do {
                System.out.print("Do you want to add marks for another student? (Y/N): ");
                response = scanner.next().charAt(0);
                switch (response) {
                    case 'Y':
                    case 'y':
                        clearConsole();
						addMarks(scanner);
						break;
                    case 'N':
                    case 'n':
                        clearConsole();
						loadHomePage(scanner);
						break;
                    default:
                        System.out.println("Invalid input. Please enter Y or N.");
                }
            } while (response != 'Y' && response != 'y' && response != 'N' && response != 'n');
            }
        }
            
        }while (response == 'Y' || response == 'y');
        
        
        
    }
    
    
    
}
