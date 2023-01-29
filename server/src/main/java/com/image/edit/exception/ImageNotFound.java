package com.image.edit.exception;

public class ImageNotFound extends RuntimeException{

    private String message;
    public ImageNotFound(){}
    public ImageNotFound(String message)
    {
        super(message);
        this.message=message;
    }
}

