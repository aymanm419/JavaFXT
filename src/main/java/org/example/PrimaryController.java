package org.example;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrimaryController {
    private List<String> images;
    @FXML
    private Button firstButton, secondButton;
    @FXML
    private ImageView firstImage, secondImage;

    private String firstOption, secondOption;
    private List<String> alternativeList = new ArrayList<>();
    @FXML
    public void initialize() {

    }

    @FXML
    public void voteOne(){
        alternativeList.add(firstOption);
        setImagesForFight();
    }
    @FXML
    public void voteTwo() {
        alternativeList.add(secondOption);
        setImagesForFight();
    }
    private void setImagesForFight()
    {
        if(images.size() <= 1)
        {
            if(alternativeList.size() == 0)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Champion!");
                alert.setHeaderText("WE HAVE A WINNER");
                alert.showAndWait();
                return;
            }
            if(images.size() > 0)
            alternativeList.add(images.get(0));
            images.clear();
            images.addAll(alternativeList);
            alternativeList.clear();
            setImagesForFight();
            return;
        } else {
            firstImage.setImage(readImage(images.get(0)));
            secondImage.setImage(readImage(images.get(1)));
            firstOption = images.get(0);
            secondOption = images.get(1);
            images.remove(0);
            images.remove(0);
        }
    }
    public void setListOfImages(List<String> imagesPath) {
        Collections.shuffle(imagesPath);
        images = imagesPath;
        setImagesForFight();
    }

    private Image readImage(String imageName) {
        return new Image(getClass().getResourceAsStream("pics/" + imageName));
    }
}
