import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClassContainer {
    private Map<String, Class> container;

    public ClassContainer() {
        this.container = new HashMap<>();
    }

    public void addClass(Class c) {
        container.put(c.getClassName(), c);
    }

    public void removeClass(String name) {
        container.remove(name);
    }

    public ArrayList<String> findEmpty() {
        ArrayList<String> empty = new ArrayList<>();

        for (String key : container.keySet()) {
            if (container.get(key).countStudents() == 0) {
                empty.add(container.get(key).getClassName());
            }
        }
        return empty;
    }

    public void summary() {
        for (String key : container.keySet()) {
            System.out.println("Nazwa grupy: " + key + "\nProcentowe zapelnienie: "
                    + (container.get(key).getStudentList().size() / container.get(key).getMaxCount()) * 100 + "%");
        }
    }
}
