package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primary.fxml"));
        Parent parent = fxmlLoader.load();
        scene = new Scene(parent, 600, 600);
        stage.setScene(scene);
        stage.show();
        PrimaryController primaryController = fxmlLoader.getController();
        File file = new File(App.class.getResource("pics").getPath());
        List<String> strList = new ArrayList<>();
        for(File tmpFile : file.listFiles())
            strList.add(tmpFile.getName());
        System.out.println(strList);
        primaryController.setListOfImages(strList);
    }


    public static void main(String[] args) {
        launch();
    }

}