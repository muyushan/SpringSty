package com.sane.pkg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "item not found")
public class ItemNotFoundException extends RuntimeException {
}
