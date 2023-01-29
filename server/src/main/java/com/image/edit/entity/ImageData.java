package com.image.edit.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ImageData")
public class ImageData {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "image",columnDefinition = "MEDIUMBLOB")
     private byte[] imageData;

    @Column(name = "blur")
    private Integer blur = 0;
    @Column(name = "contrast")
    private Integer contrast = 100;

    @Column(name = "rotate")
    private Integer rotate =10;

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    @Column(name = "edit")
    private boolean edit = false;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Column(name = "height")
    private Integer height = 300;

    @Column(name = "width")
    private Integer width = 200;

    public Integer getBlur() {
        return blur;
    }

    public void setBlur(Integer blur) {
        this.blur = blur;
    }

    public Integer getContrast() {
        return contrast;
    }

    public void setContrast(Integer contrast) {
        this.contrast = contrast;
    }

    public Integer getRotate() {
        return rotate;
    }

    public void setRotate(Integer rotate) {
        this.rotate = rotate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImagedata() {
        return imageData;
    }

    public void setImagedata(byte[] imageData) {
        this.imageData = imageData;
    }


}
