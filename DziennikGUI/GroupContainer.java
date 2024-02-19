import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class GroupContainer {
    private Map<String, Group> groupsMap = new HashMap<>();
    private List<String> groupIndex = new ArrayList<>();

    public boolean createGroup(String groupName, double maxCapacity) {
        if (groupsMap.containsKey(groupName)) {
            System.out.println("Grupa istnieje");
            return false;
        }
        try {
            Group newGroup = new Group(groupName, maxCapacity);
            groupsMap.put(groupName, newGroup);
            groupIndex.add(groupName);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Nie mozna stworzyc grupy: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteGroup(String groupName) {
        groupsMap.remove(groupName);
        groupIndex.remove(groupName);
        return true;
    }

    public List<Group> getEmptyGroups() {
        List<Group> emptyGroups = new ArrayList<>();
        for (Group group : groupsMap.values()) {
            if (group.getStudentCount() == 0) {
                emptyGroups.add(group);
            }
        }
        return emptyGroups;
    }

    public Group getGroup(String name) {
        return groupsMap.get(name);
    }

    public int getGroupsCount() {
        return groupsMap.size();
    }

    public Group getGroupById(int id) {
        return getGroup(groupIndex.get(id));
    }

    public void displaySummary() {
        System.out.println("-------------");
        System.out.println("Podsumowanie");
        if (groupsMap.isEmpty()) {
            System.out.println("Brak grup");
        } else {
            for (var entry : groupsMap.entrySet()) {
                System.out.println("Grupa: " + entry.getKey());
                System.out.printf("Pojemnosc: %.0f%%\n", entry.getValue().getCapacityRatio() * 100.0);
                System.out.printf("Rzeczywista pojemnosc: %.0f%%\n", entry.getValue().getCurrentRatio() * 100.0);
                entry.getValue().displaySummary();
                System.out.println("-------------");
            }
        }
    }
}
