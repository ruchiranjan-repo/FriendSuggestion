package com.friendsuggestiondemo.friendsuggestion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.friendsuggestiondemo.friendsuggestion.dto.ExceptionMessageDTO;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ExceptionMessageDTO> memberNotFoundExceptionHandler(MemberNotFoundException memberNotFoundException)
	{
		ExceptionMessageDTO exceptionMessageDTO= new ExceptionMessageDTO(memberNotFoundException.getMessage(),memberNotFoundException.getErrorCode());
		return new ResponseEntity<>(exceptionMessageDTO,HttpStatus.NOT_FOUND);
	}

}
