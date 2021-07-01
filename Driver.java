import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Driver {

	// Monkey and Dog Array Lists holds information on service animals that have been added system 
	private static ArrayList<Dog> dogList = new ArrayList<Dog>();
	private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
	
	// List of accepted monkey species
	static List<String> speciesList = Arrays.asList("CAPUCHIN", "GUENON", "MACAQUE", "MARMOSET", "SQUIRREL MONKEY", "TAMARIN");

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		// Variable declared and initialized for user input
		String userInput = "";
		initializeDogList();
		initializeMonkeyList();

		// Do-while loop displays menu and prompts user for input
		// Loop exits when user inputs "q"
		do {
			displayMenu();
			userInput = scanner.nextLine();

			// Switch statement allows application to take appropriate 
			// action based on user input
			switch (userInput) {
			
			// If user enters "1", intake new dog method called
			case "1": 
				intakeNewDog(scanner);
				break;
			
			// If user enters "2", intake new monkey method called
			case "2": 
				intakeNewMonkey(scanner);
				break;

			// If user enters "3", reserve animal method called
			case "3": 
				reserveAnimal(scanner);
				break;
				
			// If user enters "4", print animal method called, only dogs
			case "4": 
				printAnimals("dog");
				break;
				
			// If user enters "5", print animal method called, only monkeys
			case "5": 
				printAnimals("monkey");
				break;

			// If user enters "6", print animal method called, only unreserved animals
			case "6": 
				printAnimals("available");
				break;

			// If user enters "q", loop ends, application quits
			case "q": 
				System.out.println("Quit application");
				System.out.println("Goodbye");
				break;
				
			// Default case ensures user enters valid menu option
			default: 
				System.out.println("\nInvalid menu option");
				break;
			} 
		} while (!userInput.equals("q"));
	}

	// This method prints the menu options
	public static void displayMenu() {
		System.out.println("\n\n");
		underlineTabString("Rescue Animal System Menu");
		System.out.println("[1] Intake a new dog");
		System.out.println("[2] Intake a new monkey");
		System.out.println("[3] Reserve an animal");
		System.out.println("[4] Print a list of all dogs");
		System.out.println("[5] Print a list of all monkeys");
		System.out.println("[6] Print a list of all animals that are not reserved");
		System.out.println("[q] Quit application");
		System.out.println();
		System.out.println("Enter a menu selection");
	}

	// Adds dogs to a list for testing
	public static void initializeDogList() {
		Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake",
				false, "United States");
		Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "in-service", false,
				"United States");
		Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in-service", false,
				"Canada");

		dogList.add(dog1);
		dogList.add(dog2);
		dogList.add(dog3);
	}

	// Adds monkeys to a list for testing
	public static void initializeMonkeyList() {
		Monkey monkey1 = new Monkey("Michelle", "Capuchin", "female", "1", "30.5", "3.4", "45.5", "24.2", "02-21-2020",
				"United States", "Phase IV", false, "United States");
		Monkey monkey2 = new Monkey("Phillip", "Guenon", "male", "4", "25.2", "4.8", "34.0", "16.0", "08-03-2020",
				"Spain", "Phase II", false, "Canada");
		Monkey monkey3 = new Monkey("Trevor", "Marmoset", "male", "2", "31.4", "19.6", "26.0", "22.8", "07-06-2020",
				"Africa", "in-service", false, "China");

		monkeyList.add(monkey1);
		monkeyList.add(monkey2);
		monkeyList.add(monkey3);
	}

	// intakeNewDog method prompts user for input to add new dog to list
	// Validates name and outputs error message if dog name is dogList already
	// using exception handling construct.
	public static void intakeNewDog(Scanner scanner) throws Exception {
		try {
			
			System.out.println("What is the dog's name?");
			String name = scanner.nextLine();
			
			// Validate name
			for (Dog dog : dogList) {
				if (dog.getName().equalsIgnoreCase(name)) {
					throw new Exception (name + " is already in our system\n\n");
				}
			}
			
			System.out.println("What is the dog's breed?");
			String breed = scanner.nextLine();

			System.out.println("What is the dog's gender?");
			String gender = scanner.nextLine();

			System.out.println("What is the dog's age?");
			String age = scanner.nextLine();

			System.out.println("What is the dog's weight?");
			String weight = scanner.nextLine();

			System.out.println("What is the dog's acquisition date?");
			String acquisitionDate = scanner.nextLine();
	
			System.out.println("What is the dog's acquisition country?");
			String acquisitionCountry = scanner.nextLine();

			System.out.println("What is the dog's training status?");
			String trainingStatus = scanner.nextLine();
	
			System.out.println("Is the dog reserved? True or False");
			boolean reserved = scanner.nextBoolean();
			scanner.nextLine();
	
			System.out.println("What country is the dog in service?");
			String inServiceCountry = scanner.nextLine();
			System.out.println("");
	
			// Set attributes for new dog based on user input
			Dog dog = new Dog(name, breed, gender, age, weight, acquisitionDate,
					acquisitionCountry, trainingStatus, reserved, inServiceCountry);
	
			// Add new dog to list of dogs
			dogList.add(dog);
	
			// Output confirmation to user that new dog has been added
			System.out.println(name + "'s information has been added!");
		}  catch (Exception excpt) {
			System.out.println(excpt.getMessage());
		}
	} // End intakeNewDog


	// intakeNewMonkey method prompts user for input to add new monkey to list
	// Validates name to make sure monkey is not in the system already
	// and validates that the species is accepted in speciesList
	// Outputs error message if invalid species or monkey name in system already
	// using exception handling construct
	public static void intakeNewMonkey(Scanner scanner) throws Exception {
		try {
			
			System.out.println("What is the monkey's name?");
			String name = scanner.nextLine();
			
			// Validate name
			for (Monkey monkey : monkeyList) {
				
				if (monkey.getName().equalsIgnoreCase(name)) {
					throw new Exception (name + " is already in our system.\n\n"); 
				}
			}
			
			
			System.out.println("What is the monkey's species?");
			System.out.println("[Capuchin, Guenon, Macaque, Marmoset, Squirrel Monkey, or Tamarin]");
			String species = scanner.nextLine().toUpperCase();
			
			// Validate species
			if (!speciesList.contains(species)){
				throw new Exception ("\nInvalid species.");
			}
			
			System.out.println("What is the monkey's gender?");
			String gender = scanner.nextLine();

			System.out.println("What is the monkey's age?");
			String age = scanner.nextLine();

			System.out.println("What is the monkey's weight?");
			String weight = scanner.nextLine();

			System.out.println("What is the monkey's tail length?");
			String tailLength = scanner.nextLine();

			System.out.println("What is the monkey's height?");
			String height = scanner.nextLine();

			System.out.println("What is the monkey's body length?");
			String bodyLength = scanner.nextLine();

			System.out.println("What is the monkey's acquisition date?");
			String acquisitionDate = scanner.nextLine();
	
			System.out.println("What is the monkey's acquisition country?");
			String acquisitionCountry = scanner.nextLine();

			System.out.println("What is the monkey's training status?");
			String trainingStatus = scanner.nextLine();
	
			System.out.println("Is the monkey reserved? True or False");
			boolean reserved = scanner.nextBoolean();
			scanner.nextLine();
	
			System.out.println("What country is the monkey in service?");
			String inServiceCountry = scanner.nextLine();
			System.out.println("");
	
			// Set attributes for new monkey based on user input
			Monkey monkey = new Monkey(name, species, gender, age, weight, tailLength, height, bodyLength, acquisitionDate,
					acquisitionCountry, trainingStatus, reserved, inServiceCountry);
	
			// Add new monkey to list of monkeys
			monkeyList.add(monkey);
	
			// Output confirmation to user that new monkey has been added
			System.out.println(name + "'s information has been added!");
			
		} catch (Exception excpt) {
			System.out.println(excpt.getMessage());
		}
	} // End intakeNewMonkey
	
	// reserveAnimal method prompts user for animal type and in service country 
	// If in array list animal matches in service country and is not reserved(false), 
	// first occurrence modified to reserved(true).
	// User informed if invalid animal type or if no animals matches criteria 
	public static void reserveAnimal(Scanner scanner) throws Exception {
		try {
			
			// Prompt user for animal type
			System.out.println("What type of animal? Dog or Monkey");
			String animalType = scanner.nextLine();
			
			// If animal type = "dog" then check dogList for dog with matching in-service country and 
			// that is not reserved. Change only first occurrence if match found. Output error if no match 
			// found.
			if (animalType.equalsIgnoreCase("Dog")) {
				System.out.println("What is the in-service country?");
				String serviceCountry = scanner.nextLine();
				for (Dog dog : dogList) {
					for (int i = 0; i < dogList.size(); i++) {
						dog = dogList.get(i);
			            if (dog.getInServiceLocation().equalsIgnoreCase(serviceCountry) && !dog.getReserved()){
			            	dog.setReserved(true);
			            	System.out.println("");
			            	// Print name of dog reserved
			                System.out.println(dog.getName() + " has been reserved.");
			                return;
			            }   
					}
				}
				
				for (Dog dog : dogList) {
					for (int i = 0; i < dogList.size(); i++) {
						dog = dogList.get(i);
			            if ((dog.getInServiceLocation().equalsIgnoreCase(serviceCountry) && dog.getReserved())  || (!dog.getInServiceLocation().equalsIgnoreCase(serviceCountry))){
			                // Print no available dog
			            	System.out.println("\nSorry, no rescue dog available in " + serviceCountry);
			                return;
			            }
					}
				}
			}		
			// If animal type = "monkey" then check monkeyList for dog with matching in-service country and 
			// that is not reserved. Change only first occurrence if match found. Output error if no match 
			// found.		
			if (animalType.equalsIgnoreCase("Monkey")) {
				System.out.println("What is the in-service country?");
				String serviceCountry = scanner.nextLine();
				for (Monkey monkey : monkeyList) {
					for (int i = 0; i < monkeyList.size(); i++) {
						monkey = monkeyList.get(i);
			            if (monkey.getInServiceLocation().equalsIgnoreCase(serviceCountry) && !monkey.getReserved()){
			            	monkey.setReserved(true);
			            	System.out.println("");
			            	// Print name of monkey reserved
			                System.out.println(monkey.getName() + " has been reserved.");
			                return;
			            } 
					}
				}
				
				for (Monkey monkey : monkeyList) {
					for (int i = 0; i < monkeyList.size(); i++) {
						monkey = monkeyList.get(i);
			            if ((monkey.getInServiceLocation().equalsIgnoreCase(serviceCountry) && monkey.getReserved()) || (!monkey.getInServiceLocation().equalsIgnoreCase(serviceCountry))) {
			            	// Print no available dog
			            	System.out.println("\nSorry, no rescue monkey available in " + serviceCountry);
			                return;
			            }
					}
				}
			}
			
			// Output error if user input != "dog" or "monkey"
			else {
				throw new Exception ("Invalid animal type.\n\n");
			}
	
		}catch (Exception excpt) {
			System.out.println(excpt.getMessage());
		} 
	} // End reserveAnimal
	
	
	// Print method uses string parameter to print desired list of animals
	// based on menu selection. Method prints animal name, status, acquisition  
	// country and if the animal is reserved while using toString method in 
	// RescueAnimal class.
	public static void printAnimals(String x) {
		
		// Prints list of all dogs 
		if (x == "dog") {
		underlineTabString("List of Dogs");
			for(Dog dog: dogList) {
				System.out.println(dog);
			}
		}
		
		// Prints list of all monkeys
		else if (x == "monkey") {
			underlineTabString("List of Monkeys");

			for (Monkey monkey : monkeyList) {
				System.out.println(monkey);
			}		
		}
		
		// Print list of all unreserved and in-service animals 
		if (x == "available") {
			underlineTabString("List of Available & In-Service Animals");
			System.out.println("Dogs");
			System.out.println("----");
			for(Dog dog: dogList) {
				if (dog.getTrainingStatus().equalsIgnoreCase("in-service") && !dog.getReserved())
					System.out.println(dog);
			}
			System.out.println("Monkeys");
			System.out.println("-------");
			for (Monkey monkey : monkeyList) {
				if (monkey.getTrainingStatus().equalsIgnoreCase("in-service") && !monkey.getReserved()) {
					System.out.println(monkey); 	
				}
			}
		}	
	} // End printAnimals
	
	// Method used to tab and underline string with asterisks
	public static void underlineTabString(String str) {
		System.out.print("\n\t\t\t" + str + "\n\t\t\t");
		for (int i = 0; i < str.length(); ++i) {
			System.out.print("*");
		}
		System.out.println("");
	} // End underlineTabString

}
