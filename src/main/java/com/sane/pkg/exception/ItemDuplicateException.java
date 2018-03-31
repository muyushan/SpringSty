package com.sane.pkg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CREATED ,reason = "item has bean created")
public class ItemDuplicateException extends  RuntimeException {
}
