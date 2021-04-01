package br.com.zupacademy.mateus.casadocodigo.config.validation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Handler que captura exceptions lançadas durante a execução dos end-points e modifica a resposta.
 * 
 * @author Mateus Soares
 */
@RestControllerAdvice
public class ValidationErrorHandler {

	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({MethodArgumentNotValidException.class, javax.validation.ValidationException.class})
	public Map<String, String> handle(BindingResult br) {
		Map<String, String> validationErrorsList = new HashMap<String, String>();
		List<FieldError> bindingResultFieldErrors = br.getFieldErrors();
		bindingResultFieldErrors.forEach(error -> {
			String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			validationErrorsList.put(error.getField(), message);
		});
		return validationErrorsList;
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public Map<String, String> handle(Exception exception) {
		Map<String, String> validationErrorsList = new HashMap<String, String>();
		String error = messageSource.getMessage("InternalServerError", null, "500", null);
		validationErrorsList.put("error", error);
		return validationErrorsList;
	}
}
