package _09AssociativeArrays_Exercise;

import java.util.*;

public class _09ForceBook {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String command;

		LinkedHashMap<String, List<String>> forceBookMap = new LinkedHashMap<>();
		while(!(command = scanner.nextLine()).equals("Lumpawaroo")) {
			if(command.contains("|")) {
				String side = command.split(" \\| ")[0];
				String user = command.split(" \\| ")[1];

				forceBookMap.putIfAbsent(side, new ArrayList<>());

				boolean isExistingUser = false;
				for (List<String> listUsers : forceBookMap.values()) {
					if(listUsers.contains(user)) {
						isExistingUser = true;
						break;
					}
				}
				if(!isExistingUser) {
					forceBookMap.get(side).add(user);
				}

			} else if(command.contains(" -> ")) {
				String user = command.split(" -> ")[0];
				String side = command.split(" -> ")[1];

				//if user exist in side -> remove user
				forceBookMap.entrySet().forEach(entry -> entry.getValue().remove(user));

				//if side does not exist create one
				forceBookMap.putIfAbsent(side, new ArrayList<>());

				//add user to side
				forceBookMap.get(side).add(user);

				System.out.printf("%s joins the %s side!%n", user, side);
			}
		}

		//filter map (users > 0)
		forceBookMap.entrySet().stream().filter(entry -> entry.getValue().size() > 0)   //leave data that corresponds to the condition
				.forEach(entry -> {
					System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());

					entry.getValue().forEach(user -> System.out.printf("! %s%n", user));
				});

//		for (Map.Entry<String, List<String>> entry : forceBookMap.entrySet()) {
//			if(entry.getValue().size() > 0) {
//				System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
//
//				for (String user : entry.getValue()) {
//					System.out.printf("! %s%n", user);
//				}
//			}
//		}
	}
}
