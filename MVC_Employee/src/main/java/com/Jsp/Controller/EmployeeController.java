package com.Jsp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Jsp.Dao.EmployeeDao;
import com.Jsp.Dto.Employee;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeDao dao;
	@RequestMapping("/add")
	public  ModelAndView saveEmployee()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("employee",new Employee());
		mv.setViewName("AddEmployee.jsp");
		return mv;
		
	}
	@RequestMapping("/save")
	public ModelAndView createEmployee(@ModelAttribute Employee employee)
	{
		dao.saveEmployee(employee);
		ModelAndView view =new ModelAndView();
		view.setViewName("Index.jsp");
		return view;
	}
	@RequestMapping("/find")
	public ModelAndView searchEmployee() {
		ModelAndView view =new ModelAndView();
		view.addObject("employee",new Employee());
		view.setViewName("Search.jsp");
		return view;

	}
	
	@RequestMapping("/search")
	public ModelAndView findEmployee(@ModelAttribute Employee employee)
	{
		ModelAndView view =new ModelAndView();
		Employee emp =dao.getEmployeeById(employee.getId());
		view.addObject("employee",emp);
		view.setViewName("Display.jsp");
		return view;
	}
	
	@RequestMapping("/cut")
	public ModelAndView cutEmployee() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee", new Employee());
		mv.setViewName("Delete.jsp");
		return mv;
		
	}

	 @RequestMapping("/delete")
	    public ModelAndView removeEmployee(@ModelAttribute Employee employee) {
	        dao.removeEmployee(employee.getId()); // Passing only the ID to the DAO method
	        ModelAndView view = new ModelAndView();
	        view.setViewName("Index.jsp");
	        return view;
	    }
	 
	 @RequestMapping("/change")
	 public ModelAndView changeEmployee() {
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("employee", new Employee());
		 mv.setViewName("Update.jsp");
		 return mv;
	 }
	
	 @RequestMapping("/update")
	 public ModelAndView updateEmployee(@ModelAttribute Employee employee) {
		 dao.updateEmployee(employee);
		 ModelAndView view = new ModelAndView();
	        view.setViewName("Index.jsp");
	        return view;
	 }

	 @RequestMapping("/displayall")
	 public ModelAndView getAllDetailsEmployee() {
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("employeelist", dao.getAllEmployee());
		 mv.setViewName("DisplayAll.jsp");
		 return mv; 
	 }

}
