package jsample.spark;

import com.fasterxml.jackson.databind.ObjectMapper;

import jsample.constants.HttpStatusCodes;
import jsample.model.Employee;
import jsample.service.EmployeeService;
import spark.Spark;

public class AppRoutes {

	private ObjectMapper objectMapper = new ObjectMapper();

	public void registerRoutes() {

		Spark.path("/employee", () -> {
			
			// curl -s http://localhost:4567/employee/101
			Spark.get("/:id", (req, res) -> {
				int id = Integer.parseInt(req.params("id"));
				for (int i = 0; i < EmployeeService.getInstance().getEmployeeList().size(); i++) {
					if (EmployeeService.getInstance().getEmployeeList().get(i).getId().equals(id)) {
						Employee emp = EmployeeService.getInstance().getEmployeeList().get(i);
						res.status(HttpStatusCodes.ACCEPTED);
						return objectMapper.writeValueAsString(emp);
					}
				}
				res.status(HttpStatusCodes.NOT_FOUND);
				return "Employee with id " + id + " is not found";
			});

			
			// curl -s -X DELETE http://localhost:4567/employee/101
			Spark.delete("/:id", (req, res) -> {
				int id = Integer.parseInt(req.params("id"));
				for (int i = 0; i < EmployeeService.getInstance().getEmployeeList().size(); i++) {
					if (EmployeeService.getInstance().getEmployeeList().get(i).getId().equals(id)) {
						EmployeeService.getInstance().getEmployeeList().remove(i);
						res.status(HttpStatusCodes.ACCEPTED);
						return "Employee with id " + id + " is deleted.";
					}
				}
				res.status(HttpStatusCodes.NOT_FOUND);
				return "Employee with id " + id + " is not found";
			});

			
			// curl -s -X POST http://localhost:4567/employee -d '{"id":102,"name":"Robert"}'
			Spark.post("", (req, res) -> {

				Employee emp = objectMapper.readValue(req.body(), Employee.class);

				if (emp.getId() == null) {
					res.status(HttpStatusCodes.NOT_FOUND);
					return "Employee id is not found";
				}
				EmployeeService.getInstance().getEmployeeList().add(emp);
				res.status(HttpStatusCodes.ACCEPTED);
				return objectMapper.writeValueAsString(emp);
			});
			
			
			// curl -s -X PUT http://localhost:4567/employee/102 -d '{"id":102,"name":"Wan"}'
			Spark.put("/:id", (req, res) -> {
				int id = Integer.parseInt(req.params("id"));
				Employee emp = objectMapper.readValue(req.body(), Employee.class);

				if (emp.getId() == null) {
					res.status(HttpStatusCodes.NOT_FOUND);
					return "Employee id is not found";
				}

				for (int i = 0; i < EmployeeService.getInstance().getEmployeeList().size(); i++) {
					if (EmployeeService.getInstance().getEmployeeList().get(i).getId().equals(id)) {
						EmployeeService.getInstance().getEmployeeList().remove(i);
					}
				}
				EmployeeService.getInstance().getEmployeeList().add(emp);
				res.status(HttpStatusCodes.ACCEPTED);
				return objectMapper.writeValueAsString(emp);
			});
		});
	}
}