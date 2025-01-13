package in.ap.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ap.main.entity.User;
import in.ap.main.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	
	@Autowired
	private UserService service;

	@GetMapping("/regPage")
	public String openRegPage(Model model) {
		model.addAttribute("user",new User());
		return "register";
	}
	
	@PostMapping("/regForm")
	public String submitRegPage(@ModelAttribute User user, Model model)
	{
		boolean status = service.registerUser(user);
		if(status)
		{
			model.addAttribute("successMsg","User Registered Successfully !");
		}
		else
		{
			model.addAttribute("errorMsg","User not Registered !");
		}
		return "register";
	}
	
	@GetMapping("/loginPage")
	public String openLoginPage(Model model)
	{
		model.addAttribute("user",new User());
		return "login";
	}
	
	@PostMapping("/loginForm")
	public String submitLoginForm(@ModelAttribute User user, Model model)
	{
		User validUser = service.loginUser(user.getEmail(), user.getPassword());
		if(validUser != null)
		{
			model.addAttribute("modelName",validUser.getName());
			return "profile";
		}
		else
		{
			model.addAttribute("errorMsg", "Email id and password didn't matched");
		}
		return "login";
	}
	
	@GetMapping("/logout")
	public String Logout(HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		if(session != null)
		{
			session.invalidate();
		}
		return "redirect:/loginPage";
	}
	
}
