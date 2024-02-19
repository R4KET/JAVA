public class Main {
    public static void main(String[] args) {
        DziennikGUI dziennikGUI = new DziennikGUI();
        try {
            dziennikGUI.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
//PAOiM_as - haslo do lab6