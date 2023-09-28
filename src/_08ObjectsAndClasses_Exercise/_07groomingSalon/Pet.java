package _08ObjectsAndClasses_Exercise._07groomingSalon;

public class Pet {
	private String name;
	private int age;
	private String owner;

	public Pet(String name, int age, String owner) {
		this.name = name;
		if(age > 0) {
			this.age = age;
		} else {
			this.age = 1;
		}
		this.owner = owner;
	}

	@Override
	public String toString() {
		return this.name + " " + this.age + " - " + "(" + this.owner + ")";
	}

	public String getName() {
		return name;
	}

	public String getOwner() {
		return owner;
	}
}
