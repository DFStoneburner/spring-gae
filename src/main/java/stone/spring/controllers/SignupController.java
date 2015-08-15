package stone.spring.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import stone.spring.models.Signup;
import stone.spring.services.SignupService;
import stone.spring.utils.RandomDate;
import stone.spring.validators.SignupValidator;

@Controller
public class SignupController {

	@Autowired
	SignupService signupService;
	
	@Autowired
	SignupValidator signupValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@ModelAttribute("allSignups")
	public List<Signup> listSignups() {
		return this.signupService.findAll();
	}

	@RequestMapping({ "signup", "signup/list" })
	public String showSignups() {

		return "signups/show";
	}

	@RequestMapping({ "signup/add" })
	public String showSignup(final Signup signup) {
		signup.setSignUpDate(Calendar.getInstance().getTime());

		return "signups/add";
	}

	@RequestMapping(value="signup/add", params={"save"})
	public String saveSignup(
			final Signup signup, final BindingResult bindingResult, final ModelMap model) {
		signupValidator.validate(signup, bindingResult);
		
		if(bindingResult.hasErrors()) {
			return "signups/add";
		}
		
		this.signupService.add(signup);
		model.clear();

		return "redirect:list";
	}

	@RequestMapping({ "signup/init" })
	public String initData() {
		signupService.deleteAll();

		signupService.add(new Signup("Debora", "Bell",
				"DeboraLBell@dayrep.com", RandomDate.next()));
		signupService.add(new Signup("Lisa", "Dupre", "LisaDMurrah@dayrep.com",
				RandomDate.next()));
		signupService.add(new Signup("Thomas", "Alverson",
				"ThomasCAlverson@dayrep.com", RandomDate.next()));
		signupService.add(new Signup("Dion", "Dion",
				"DionAJohnson@armyspy.com", RandomDate.next()));
		signupService.add(new Signup("Arthur", "Alexander",
				"ArthurAAlexander@rhyta.com", RandomDate.next()));

		return "redirect:list";
	}
}
