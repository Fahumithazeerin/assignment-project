package com.image.edit.service;

import com.image.edit.entity.ImageStyle;
import com.image.edit.exception.ImageNotFound;
import com.image.edit.exception.NoEditedImageException;
import com.image.edit.repository.ImageRepository;
import com.image.edit.entity.ImageData;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;


    public ImageData downloadImage() throws IOException {

        String seedName = RandomStringGenerator();

        RestTemplate restTemplate = new RestTemplate();
        byte[] imageBytes = restTemplate.getForObject("https://api.dicebear.com/5.x/adventurer/svg?seed={seedName}", byte[].class,seedName);

        ImageData imageData = new ImageData();
        imageData.setImagedata(imageBytes);


        return imageRepository.save(imageData);
    }

    public ImageData getImage(Long id)
    {
        return imageRepository.findById(id).
                orElseThrow(()->new ImageNotFound("Image with id["+id+"] not found"));


    }

    public  ImageData setImageDataStyle(Long id , ImageStyle imageStyle)
    {
        ImageData imageData = imageRepository.findById(id).get();

        imageData.setBlur(imageStyle.getBlur());
        imageData.setContrast(imageStyle.getContrast());
        imageData.setRotate(imageStyle.getRotate());
        imageData.setHeight(imageStyle.getHeight());
        imageData.setWidth(imageStyle.getWidth());
        imageData.setEdit(imageStyle.getEdit());

        return imageRepository.save(imageData);

    }

    public List<ImageData> getAllImages()
    {
        List<ImageData> allImages = imageRepository.findEditedImages();
        if(allImages.isEmpty())
        {
            throw new NoEditedImageException("No Images has been edited yet");
        }
        else {
            return allImages;
        }
    }


    public String RandomStringGenerator()
    {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int len=3;
        for(int i=0;i<len;i++)
        {
            int index =random.nextInt(alphabets.length());
            char randomChar = alphabets.charAt(index);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }


}
