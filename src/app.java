import Controller.Controller;
import Core.Dao;
import View.AppWindow;

public class app {

    public static void main(String[] args) {



        try {
            Controller controller = new Controller();
            AppWindow view = new AppWindow(controller);
//            view.setController(controller);

            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
