package validacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="validarCorreo")
public class validarCorreo implements Validator {
	private Pattern pattern=Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		
		Matcher matcher = pattern.matcher(value.toString());
		
		if(!matcher.matches()){
			
			 throw new ValidatorException(new FacesMessage("El componente " + component.getId() + " no contiene un NIF valido")); 
		}
		
		
		
		
			
	}

}
