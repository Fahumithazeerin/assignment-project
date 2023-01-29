package com.image.edit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.image.edit.entity.ImageData;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageData,Long> {

    @Query(value = "SELECT * FROM Image_Data im WHERE im.edit= true",nativeQuery = true)
    public List<ImageData> findEditedImages();
}
