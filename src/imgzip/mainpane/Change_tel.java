package imgzip.mainpane;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
/**
 @Author:  吴泳仪
 @Date: 2019.12.19
 */
public class Change_tel {
    /**
    加载更改电话号码的页面
     */
    public Change_tel(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Change_tel.fxml"));
            Stage primaryStage = new Stage();
            primaryStage.setTitle("修改电话号码");
            primaryStage.setScene(new Scene(root, 400, 300));
            primaryStage.getIcons().add(new Image("res/icon/logo.png"));
            primaryStage.show();
            primaryStage.getIcons().add(new Image("res/icon/logo.ico"));
            primaryStage.setOnCloseRequest(e->{
                new Personal();
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
