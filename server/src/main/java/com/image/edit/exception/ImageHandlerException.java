package com.image.edit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ImageHandlerException {

    @ExceptionHandler(value = {ImageNotFound.class})
    public ResponseEntity<Object> handleImageNotFound
            (ImageNotFound imageNotFound)
    {
          ImageException imageException =
                  new ImageException(imageNotFound.getMessage(),
                          HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(imageException,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {NoEditedImageException.class})
    public ResponseEntity<Object> handleNoImageEditedException
            (NoEditedImageException noEditedImageException)
    {
        ImageException imageException =
                new ImageException(noEditedImageException.getMessage(),
                        HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(imageException,HttpStatus.NOT_FOUND);
    }




}
