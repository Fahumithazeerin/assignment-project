package com.image.edit.contoller;

import com.image.edit.entity.Image;
import com.image.edit.entity.ImageData;
import com.image.edit.entity.ImageStyle;
import com.image.edit.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController()
@CrossOrigin(origins = "http://localhost:3000")
public class ImageController {

    @Autowired
    private ImageService imageService;


    @PostMapping("/images")
    public Image downloadImage() throws IOException {

        ImageData imageData = imageService.downloadImage();
        Image image = new Image();
        image.setId(imageData.getId());
        image.setImage(imageData.getImagedata());
        return image;
    }

    @GetMapping("/images/{id}")
    public ImageData getImage(@PathVariable Long id) throws IOException
    {
        return imageService.getImage(id);
    }
    @PutMapping(value ="/images/{id}/styles", consumes ={"application/json"})
    public ImageStyle setImageStyle(@PathVariable Long id, @RequestBody ImageStyle imageStyle)
    {
        ImageData imageData = imageService.setImageDataStyle(id,imageStyle);


        ImageStyle imageStyleReceived = new ImageStyle();
        imageStyleReceived.setBlur(imageData.getBlur());
        imageStyleReceived.setContrast(imageData.getContrast());
        imageStyleReceived.setRotate(imageData.getRotate());
        imageStyleReceived.setHeight(imageData.getHeight());
        imageStyleReceived.setWidth(imageData.getWidth());

        return imageStyleReceived;
    }

    @GetMapping("/allimages")
     public List<ImageData> getAllImages()
    {
        return imageService.getAllImages();
    }


}
