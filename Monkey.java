// Monkey class  inherits from RescueAnimal class
public class Monkey extends RescueAnimal {

	// Instance variables to meet specifications
	private String species;
	private String tailLength;
	private String height;
	private String bodyLength;

	// Constructor takes values for attributes and sets them
	public Monkey(String name, String species, String gender, String age, String weight, String tailLength,
			String height, String bodyLength, String acquisitionDate, String acquisitionCountry, String trainingStatus,
			boolean reserved, String inServiceCountry) {
		setName(name);
		setSpecies(species);
		setGender(gender);
		setAge(age);
		setWeight(weight);
		setTailLength(tailLength);
		setHeight(height);
		setBodyLength(bodyLength);
		setAcquisitionDate(acquisitionDate);
		setAcquisitionLocation(acquisitionCountry);
		setTrainingStatus(trainingStatus);
		setReserved(reserved);
		setInServiceCountry(inServiceCountry);

	}

	// Accessor Method returns species
	public String getSpecies() {
		return species;
	}

	// Mutator Method sets species
	public void setSpecies(String monkeySpecies) {
		species = monkeySpecies;
	}

	// Accessor Method returns tail length
	public String getTailLength() {
		return tailLength;
	}

	// Mutator Method sets tail length
	public void setTailLength(String monkeyTailLength) {
		tailLength = monkeyTailLength;
	}

	// Accessor Method returns monkey height
	public String getHeight() {
		return height;
	}

	// Mutator Method sets monkey height
	public void setHeight(String monkeyHeight) {
		height = monkeyHeight;
	}

	// Accessor Method returns body length
	public String getBodyLength() {
		return bodyLength;
	}

	// Mutator Method sets body length
	public void setBodyLength(String monkeyBodyLength) {
		bodyLength = monkeyBodyLength;
	}

}
