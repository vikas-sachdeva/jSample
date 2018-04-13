package jsample.service;

import java.util.ArrayList;
import java.util.List;

import jsample.model.Employee;

public class EmployeeService {

	private static final EmployeeService instance = new EmployeeService();

	private List<Employee> employeeList = new ArrayList<Employee>() {
		private static final long serialVersionUID = 1L;
		{
			add(new Employee(101, "Bob"));
			add(new Employee(102, "Alice"));
		}
	};

	private EmployeeService() {

	}

	public static EmployeeService getInstance() {
		return instance;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}
}