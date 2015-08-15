package stone.spring.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import stone.spring.models.Signup;

@Component
public class SignupValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Signup.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstName", "First name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastName", "Last name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email", "Email is required.");
		
	}

}
