package _08ObjectsAndClasses_Bonus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class _01CompanyRoster {
	public static class Department {
		private List<Employee> department;

		public Department() {
			this.department = new ArrayList<>();
		}

		public void add(Employee employee) {
			department.add(employee);
		}

		public void getEmployees() {
			for (Employee employee : department) {
				System.out.printf("%s %.2f %s %s %s %d%n", employee.getName(), employee.getSalary(), employee.getPosition(), employee.getDepartment(), employee.getEmail(), employee.getAge());
			}
		}

		public String getBestPaidEmployees(String bestDepartment) {
			List<Employee> bestEmployees = new ArrayList<>();
			for (Employee employee : department) {
				if(employee.getDepartment().equals(bestDepartment)) {
					bestEmployees.add(employee);
				}
			}

			bestEmployees.sort(Comparator.comparing(Employee::getSalary).reversed());
			String result = "";
			for (Employee bestEmployee : bestEmployees) {
				result += String.format("%s %.2f %s %d%n", bestEmployee.getName(), bestEmployee.getSalary(), bestEmployee.getEmail(), bestEmployee.getAge());
			}
			return result;
		}

		public String highestAvgSalary() {
			double maxAvgSalary = 0;
			String vipDepartment = "";

			for (int i = 0; i < department.size(); i++) {
				double sumSalary = 0;
				int countEmployees = 1;

				String currentDepartment = department.get(i).getDepartment();
				sumSalary += department.get(i).getSalary();

				for (int j = i + 1; j < department.size(); j++) {
					String nextDepartment = department.get(j).getDepartment();
					if (currentDepartment.equals(nextDepartment)) {
						sumSalary += department.get(j).getSalary();
						countEmployees++;
					}
				}

				double avgSalary = sumSalary / countEmployees;
				if(sumSalary > maxAvgSalary) {
					maxAvgSalary = sumSalary;
					vipDepartment = currentDepartment;
				}
			}
			return vipDepartment;
		}
	}

	public static class Employee {
		private String name;
		private double salary;
		private String position;
		private String department;
		private String email;
		private int age;

		public Employee(String name, double salary, String position, String department) {
			this.name = name;
			this.salary = salary;
			this.position = position;
			this.department = department;
			this.email = "n/a";
			this.age = -1;
		}

		public Employee(String name, double salary, String position, String department, String email) {
			this.name = name;
			this.salary = salary;
			this.position = position;
			this.department = department;
			this.email = email;
			this.age = -1;
		}

		public Employee(String name, double salary, String position, String department, int age) {
			this.name = name;
			this.salary = salary;
			this.position = position;
			this.department = department;
			this.email = "n/a";
			this.age = age;
		}

		public Employee(String name, double salary, String position, String department, String email, int age) {
			this.name = name;
			this.salary = salary;
			this.position = position;
			this.department = department;
			this.email = email;
			this.age = age;
		}

		public String getName() {
			return this.name;
		}

		public double getSalary() {
			return this.salary;
		}

		public String getPosition() {
			return this.position;
		}

		public String getDepartment() {
			return this.department;
		}

		public String getEmail() {
			return this.email;
		}

		public int getAge() {
			return this.age;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int employeesCount = Integer.parseInt(scanner.nextLine());

		Department listEmployees = new Department();
		for (int i = 1; i <= employeesCount; i++) {
			String[] input = scanner.nextLine().split(" ");
			String name = input[0];
			double salary = Double.parseDouble(input[1]);
			String position = input[2];
			String department = input[3];

			Employee employee;
			if(input.length == 4) {
				employee = new Employee(name, salary, position, department);
			} else if(input.length == 5) {
				try {
					int age = Integer.parseInt(input[4]);
					employee = new Employee(name, salary, position, department, age);
				} catch(Exception e) {
					String email = input[4];
					employee = new Employee(name, salary, position, department, email);
				}
			} else {
				String email = input[4];
				int age = Integer.parseInt(input[5]);
				employee = new Employee(name, salary, position, department, email, age);
			}

			listEmployees.add(employee);
		}

//		listEmployees.getEmployees();

		String bestDepartment = listEmployees.highestAvgSalary();
		System.out.printf("Highest Average Salary: %s%n", bestDepartment);
		System.out.println(listEmployees.getBestPaidEmployees(bestDepartment));
	}
}
