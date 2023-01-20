package lapireteam.quizzle.entity.validator;

import lapireteam.quizzle.entity.RegistrationForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatches, Object> {
   @Override
   public void initialize(PasswordMatches constraint) {
   }

   @Override
   public boolean isValid(Object obj, ConstraintValidatorContext context) {
      RegistrationForm registrationForm = (RegistrationForm) obj;
      if (registrationForm.getPassword() != null) {
         return registrationForm.getPassword().equals(registrationForm.getConfirmPassword());
      }
      return true;
   }
}
