package com.javaweb.controlleradvice;


import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.spi.http.HttpHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.model.ErrorResponseDTO;

import customexception.FieldRequiedException;
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{
	// xu ly loi java customs san
		@ExceptionHandler(ArithmeticException.class)
		public ResponseEntity<Object> handleArithmeticException(
				// nhan vao 4 tham so
				
					//xu ly ve toan hoc
					ArithmeticException ex,
					WebRequest request
				
				){
			ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
			errorResponseDTO.setError(ex.getMessage());
			List<String> details = new ArrayList<>();
			details.add("So nguyen sao chi cho 0 duoc cha @@@");
			errorResponseDTO.setDetail(details);
			
			// tra ve doi tuong error va http status
			return new ResponseEntity<Object>(errorResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		// xu ly loi tu custom
			
		@ExceptionHandler(FieldRequiedException.class)
		public ResponseEntity<Object> handleFieldRequiredexception(
	
				
					//xu ly date trong bean toan hoc
					FieldRequiedException ex,
					WebRequest request
				
				){
			ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
			errorResponseDTO.setError(ex.getMessage());
			List<String> details = new ArrayList<>();
			details.add("Check lai coi chung null nhe");
			errorResponseDTO.setDetail(details);
			
			// tra ve doi tuong error va http status
			return new ResponseEntity<Object>(errorResponseDTO,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

}
