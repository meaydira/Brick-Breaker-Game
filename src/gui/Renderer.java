package gui;

public class Renderer {
    private MainMenuPanel mainMenu;
    private ErrorPanel errorPanel;
    private LoginPanel loginPanel;
    private RegisterPanel registerPanel;
    private static Renderer renderer_instance = null;

    public static Renderer getInstance(){
        if(renderer_instance == null){
            renderer_instance = new Renderer();
            return renderer_instance;
        }else{
            return renderer_instance;
        }

    }
    public MainMenuPanel getMainMenu() {
        this.mainMenu = MainMenuPanel.getInstance();
        return mainMenu;
    }

    public ErrorPanel getErrorPanel() {
        this.errorPanel = ErrorPanel.getInstance();
        return errorPanel;
    }

    public LoginPanel getLoginPanel() {
        this.loginPanel= LoginPanel.getInstance();
        return loginPanel;
    }

    public RegisterPanel getRegisterPanel() {
        this.registerPanel = RegisterPanel.getInstance();
        return registerPanel;
    }
}
