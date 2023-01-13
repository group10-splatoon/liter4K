import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MapGameClear{

    public static void GameClear(){
        int toggle = 0;
        System.out.println("MapGameClear:GameClear()");
        Label l = new Label("GAME CLEAR!!!!!");
        BorderPane bp = new BorderPane();
        Scene s = new Scene(bp, 320, 240);
        Stage st = new Stage();
        bp.setCenter(l);
        st.setScene(s);
        st.show();
    }
}
