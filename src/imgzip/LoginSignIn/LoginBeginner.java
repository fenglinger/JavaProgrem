
package imgzip.LoginSignIn;

import imgzip.mainpane.Course;
import imgzip.mainpane.Pane_sceenbeginner;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/**
 @Author:   肖尧
 @Date: 2019.12.12

 登录页面的启动类，写成构造方法形式被调用，方便其他文件夹中其他页面调用。
 */

public class LoginBeginner {
    public LoginBeginner(){
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));


            /**
             * 将组件载入到start/main方法中，使得可以调用。以便于执行一些需要在页面生成就可以自动执行生成的效果
             */

            TextField account = (TextField)root.lookup("#Account");
            PasswordField password = (PasswordField)root.lookup("#password");
            CheckBox remember = (CheckBox)root.lookup("#remember");
            Button logIn = (Button)root.lookup("#Login");
            Label passwordWrong = (Label)root.lookup("#passwordWrong");
            passwordWrong.setVisible(false);

            /**
             在页面开启之前检查上一次登录时是否记住了密码，
             如果上一次登录点击了记住密码，则在本次打开时会将账号和密码写入
             */
            try {

                /**
                 * 读取记录账号密码的文本文件，如果不存在则会创造文件夹和文件，保持一致性。
                 */
                File fi = new File("txtFile");
                File file = new File("txtFile/RememberAccount&Password.txt");
                if(!fi.exists()){
                    fi.mkdir();
                }
                if(!file.exists()){
                    file.createNewFile();
                }
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                String line = "";
                line = br.readLine();

                /**
                 * 读取账号和密码。
                 */

                if(file.length() != 0){

                    String[] judge = line.split("\\|");
                    String truejudge = "true";
                    int accountIndex = 0;
                    int passwordIndex = 1;
                    int judgeIndex = 2;

                    if(judge[judgeIndex].equals(truejudge) ){
                        account.setText(judge[accountIndex]);
                        password.appendText(judge[passwordIndex]);

                        remember.setSelected(true);
                        logIn.setDisable(false);
                    }

                    br.close();
                    fr.close();
                }


            }catch (Exception e){
                e.printStackTrace();
            }

            primaryStage.setTitle("Imgzip login");
            primaryStage.setScene(new Scene(root, 638, 400));
            primaryStage.getIcons().add(new Image("res/icon/logo.png"));
            primaryStage.show();
            primaryStage.getIcons().add(new Image("res/icon/logo.ico"));

            primaryStage.setOnCloseRequest(e->{
                new Pane_sceenbeginner();
            });
        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
