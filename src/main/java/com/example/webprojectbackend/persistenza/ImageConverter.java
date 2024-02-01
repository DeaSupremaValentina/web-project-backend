package com.example.webprojectbackend.persistenza;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import javax.imageio.ImageIO;

public class ImageConverter {
    private static ImageConverter instance = null;
    private ImageConverter() {}
    public static ImageConverter getInstance() {
        if (instance == null) {
            instance = new ImageConverter();
        }
        return instance;
    }

    public String convertToData(String imagePath) {
        try {
            byte[] imgBytes = Files.readAllBytes(Paths.get(imagePath));
            String base64Image = Base64.getEncoder().encodeToString(imgBytes);
            return base64Image;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public BufferedImage convertToImage(String base64Image) {
        try {
            byte[] decodedImgBytes = Base64.getDecoder().decode(base64Image);
            ByteArrayInputStream bis = new ByteArrayInputStream(decodedImgBytes);
            BufferedImage image = ImageIO.read(bis);
            return image;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
