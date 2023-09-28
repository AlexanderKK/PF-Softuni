package _08ObjectsAndClasses_Exercise._07groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
	private int capacity;
	private List<Pet> data;

	public GroomingSalon(int capacity) {
		this.capacity = capacity;
		this.data = new ArrayList<>(this.capacity);
	}

	public void add(Pet pet) {
		boolean isPresent = false;

		for (Pet entity : data) {
			if(pet.getName().equals(entity.getName()) && pet.getOwner().equals(entity.getOwner())) {
				isPresent = true;
			}
		}

		if(!isPresent) {
			data.add(pet);
		}
	}

	public boolean remove(String name) {
		for (Pet pet : data) {
			if(pet.getName().equals(name)) {
				data.remove(pet);
				return true;
			}
		}
		return false;
	}

	public Pet getPet(String name, String owner) {
		for (Pet pet : data) {
			if(pet.getName().equals(name) && pet.getOwner().equals(owner)) {
				return pet;
			}
		}
		return null;
	}

	public int getCount() {
		return data.size();
	}

	public String getStatistics() {
		String result = "The grooming salon has the following clients:\n";
		for (Pet pet : data) {
			result += pet.getName() + " " + pet.getOwner() + "\n";
		}
		result = result.substring(0, result.length() - 1);

		return result;
	}
}
