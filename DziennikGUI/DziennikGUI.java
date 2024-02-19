import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;

public class DziennikGUI extends JFrame {
    JPanel container;
    JPanel tables;
    JPanel buttons;
    JTable studentTable;
    JTable classTable;
    StudentTable selectedClass;
    private JFormattedTextField searcher;

    public void run() throws Exception {
        GroupContainer groupContainer = new GroupContainer();

        // dodaj klasy
        groupContainer.createGroup("Informatyka", 0.75);
        groupContainer.createGroup("Matematyka", 0.5);
        groupContainer.createGroup("Fizyka", 0.25);

        // dodaj studentow predefiniowanych
        groupContainer.getGroup("Informatyka")
                .enrollStudent(new Student("Adam", "Nowak", StudentCondition.Refurb, 2001, 18.5, 409217));
        groupContainer.getGroup("Informatyka")
                .enrollStudent(new Student("Alicja", "Kowalska", StudentCondition.Sick, 2002, 19.2, 407555));
        groupContainer.getGroup("Matematyka")
                .enrollStudent(new Student("Bartek", "Wisniewski", StudentCondition.Absent, 2001, 17.8, 408752));
        groupContainer.getGroup("Informatyka")
                .enrollStudent(new Student("Jan", "Kowalski", StudentCondition.Refurb, 2000, 20.1, 410124));
        groupContainer.getGroup("Informatyka")
                .enrollStudent(new Student("Anna", "Nowakowska", StudentCondition.Sick, 2001, 19.5, 409810));
        groupContainer.getGroup("Matematyka")
                .enrollStudent(new Student("Michal", "Wojcik", StudentCondition.Absent, 2002, 18.2, 410309));
        groupContainer.getGroup("Informatyka")
                .enrollStudent(new Student("Piotr", "Kowalczyk", StudentCondition.Refurb, 2001, 19.8, 409512));
        groupContainer.getGroup("Informatyka")
                .enrollStudent(new Student("Karolina", "Lewandowska", StudentCondition.Sick, 2000, 19.9, 409102));
        groupContainer.getGroup("Matematyka")
                .enrollStudent(new Student("Weronika", "Kaminska", StudentCondition.Absent, 2001, 18.7, 409702));
        groupContainer.getGroup("Informatyka")
                .enrollStudent(new Student("Kamil", "Szymanski", StudentCondition.Refurb, 2002, 18.3, 410501));
        groupContainer.getGroup("Informatyka")
                .enrollStudent(new Student("Marta", "Jankowska", StudentCondition.Sick, 2000, 19.1, 410312));
        groupContainer.getGroup("Matematyka")
                .enrollStudent(new Student("Tomasz", "Kowalewski", StudentCondition.Absent, 2001, 17.5, 410203));
        groupContainer.getGroup("Informatyka")
                .enrollStudent(new Student("Magdalena", "Kaczmarek", StudentCondition.Refurb, 2002, 19.7, 410422));
        groupContainer.getGroup("Informatyka")
                .enrollStudent(new Student("Krzysztof", "Pawlak", StudentCondition.Sick, 2001, 18.9, 410216));
        groupContainer.getGroup("Matematyka")
                .enrollStudent(new Student("Agnieszka", "Michalska", StudentCondition.Absent, 2000, 18.4, 410723));
        groupContainer.getGroup("Informatyka")
                .enrollStudent(new Student("Dominik", "Czarnecki", StudentCondition.Refurb, 2001, 19.2, 410627));
        groupContainer.getGroup("Informatyka")
                .enrollStudent(new Student("Patrycja", "Piotrowska", StudentCondition.Sick, 2002, 18.7, 410915));
        groupContainer.getGroup("Matematyka")
                .enrollStudent(new Student("Sebastian", "Nowicki", StudentCondition.Absent, 2001, 17.9, 410804));
        groupContainer.getGroup("Informatyka")
                .enrollStudent(new Student("Mateusz", "Grabowski", StudentCondition.Refurb, 2000, 19.6, 410329));
        groupContainer.getGroup("Informatyka")
                .enrollStudent(new Student("Kinga", "Adamczyk", StudentCondition.Sick, 2001, 19.3, 410519));
        groupContainer.getGroup("Matematyka")
                .enrollStudent(new Student("Damian", "Jablonski", StudentCondition.Absent, 2002, 18.1, 410634));
        groupContainer.getGroup("Fizyka")
                .enrollStudent(new Student("Janusz", "Kowalczyk", StudentCondition.Refurb, 2001, 19.8, 411001));
        groupContainer.getGroup("Fizyka")
                .enrollStudent(new Student("Ewa", "Nowakowska", StudentCondition.Sick, 2000, 19.5, 411002));
        groupContainer.getGroup("Fizyka")
                .enrollStudent(new Student("Michal", "Wojcik", StudentCondition.Absent, 2002, 18.2, 411003));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Dziennik");
        this.setSize(640, 640);
        this.setBounds(0, 0, 640, 640);

        container = new JPanel();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        classTable = new JTable(new ClassTable(groupContainer));
        classTable.setLayout(new GridBagLayout());
        classTable.setBounds(0, 0, 640, 640);
        classTable.setSize(640, 640);

        selectedClass = new StudentTable(null);
        studentTable = new JTable(selectedClass);
        studentTable.setLayout(new GridLayout(0, 1));
        studentTable.setBounds(640, 0, 640, 640);
        studentTable.setSize(640, 640);

        JScrollPane studentListSP = new JScrollPane(studentTable);
        JScrollPane classListSP = new JScrollPane(classTable);

        constraints.gridx = 0;
        container.add(studentListSP, constraints);
        constraints.gridx = 1;
        container.add(classListSP, constraints);

        classTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                var id = classTable.getSelectedRow();
                var group = groupContainer.getGroupById(id);
                studentTable.setModel(new StudentTable(group.findStudents("")));

                var column = studentTable.getColumnModel().getColumn(2);
                var combo = new JComboBox<StudentCondition>();
                for (var i = 0; i < StudentCondition.values().length; i++) {
                    combo.addItem(StudentCondition.values()[i]);
                }
                column.setCellEditor(new DefaultCellEditor(combo));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        buttons = new JPanel();
        constraints.fill = GridBagConstraints.BASELINE;
        constraints.gridx = 0;
        constraints.gridy = 1;
        container.add(buttons, constraints);

        var buttonAdd = new JButton("Dodaj");
        buttonAdd.setSize(80, 30);
        buttonAdd.addActionListener(e -> {
            var classId = classTable.getSelectedRow();
            var group = groupContainer.getGroupById(classId);
            if (group == null) {
                return;
            }

            // Tworzenie okna dialogowego do wprowadzania danych studenta
            JTextField nameField = new JTextField();
            JTextField surnameField = new JTextField();
            JComboBox<StudentCondition> conditionField = new JComboBox<>(StudentCondition.values());
            JTextField birthDateField = new JTextField();
            JTextField pointsField = new JTextField();
            JTextField indeksField = new JTextField();

            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Imie:"));
            panel.add(nameField);
            panel.add(new JLabel("Nazwisko:"));
            panel.add(surnameField);
            panel.add(new JLabel("Stan:"));
            panel.add(conditionField);
            panel.add(new JLabel("Rok Urodzenia:"));
            panel.add(birthDateField);
            panel.add(new JLabel("Punkty:"));
            panel.add(pointsField);
            panel.add(new JLabel("Numer Indeksu:"));
            panel.add(indeksField);

            int result = JOptionPane.showConfirmDialog(null, panel, "Dodaj Nowego Studenta",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String name = nameField.getText();
                String surname = surnameField.getText();
                StudentCondition condition = (StudentCondition) conditionField.getSelectedItem();

                try {
                    int birthDate = Integer.parseInt(birthDateField.getText());
                    double points = Double.parseDouble(pointsField.getText());
                    int indeks = Integer.parseInt(indeksField.getText());

                    Student newStudent = new Student(name, surname, condition, birthDate, points, indeks);

                    // Sprawdzanie, czy grupa jest pełna po próbie dodania nowego studenta
                    if (!group.enrollStudent(newStudent)) {
                        JOptionPane.showMessageDialog(null, "Grupa jest pelna lub student juz istnieje.", "Blad",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Aktualizowanie modelu tabeli
                    studentTable.setModel(new StudentTable(group.findStudents(searcher.getText())));
                    studentTable.updateUI();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Nieprawidlowy format danych. Prosze sprawdzic pola Rok Urodzenia, Punkty i Numer Indeksu.",
                            "Blad", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttons.add(buttonAdd);

        var buttonRemove = new JButton("Usun");
        buttonRemove.setSize(80, 30);
        buttonRemove.addActionListener(e -> {
            var classId = classTable.getSelectedRow();
            var group = groupContainer.getGroupById(classId);
            if (group == null) {
                return;
            }
            var studentId = studentTable.getSelectedRow();
            System.out.println("ID " + studentId);
            group.removeStudentById(studentId);

            // Aktualizowanie modelu tabeli
            studentTable.setModel(new StudentTable(group.findStudents(searcher.getText())));
            studentTable.updateUI();
        });
        buttons.add(buttonRemove);

        var buttonSortByName = new JButton("Posortuj");
        buttonSortByName.setSize(80, 30);
        buttonSortByName.addActionListener(e -> {
            var classId = classTable.getSelectedRow();
            var group = groupContainer.getGroupById(classId);
            group.sortStudentsBySurname();

            // Aktualizowanie modelu tabeli
            studentTable.setModel(new StudentTable(group.findStudents(searcher.getText())));
            studentTable.updateUI();
        });
        buttons.add(buttonSortByName);

        var buttonSortByIndexNumber = new JButton("Posortuj po numerze indeksu");
        buttonSortByIndexNumber.setSize(150, 30);
        buttonSortByIndexNumber.addActionListener(e -> {
            var classId = classTable.getSelectedRow();
            var group = groupContainer.getGroupById(classId);
            group.sortStudentsByIndexNumber();

            // Aktualizowanie modelu tabeli
            studentTable.setModel(new StudentTable(group.findStudents(searcher.getText())));
            studentTable.updateUI();
        });
        buttons.add(buttonSortByIndexNumber);

        var buttonSortByPoints = new JButton("Posortuj po punktach");
        buttonSortByPoints.setSize(130, 30);
        buttonSortByPoints.addActionListener(e -> {
            var classId = classTable.getSelectedRow();
            var group = groupContainer.getGroupById(classId);
            group.sortStudentsByPoints();

            // Aktualizowanie modelu tabeli
            studentTable.setModel(new StudentTable(group.findStudents(searcher.getText())));
            studentTable.updateUI();
        });
        buttons.add(buttonSortByPoints);

        searcher = new JFormattedTextField();
        searcher.setColumns(16);
        buttons.add(new JLabel("Wyszukaj studenta: "));
        buttons.add(searcher);
        searcher.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                changed();
            }

            private void changed() {
                var id = classTable.getSelectedRow();
                var group = groupContainer.getGroupById(id);
                if (group == null) {
                    return;
                }
                studentTable.setModel(new StudentTable(group.findStudents(searcher.getText())));
                studentTable.updateUI();
            }
        });

        this.add(container);
        this.pack();
        this.setVisible(true);
    }
}

class StudentTable extends AbstractTableModel {
    private static final String[] COLUMN_NAMES = { "Imie", "Nazwisko", "Stan", "Rok urodzenia", "Punkty",
            "Numer Indeksu" };

    ArrayList<Student> students;

    public StudentTable(ArrayList<Student> students) {
        this.students = students;
    }

    public void setStudentClass(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public String getColumnName(int col) {
        return COLUMN_NAMES[col];
    }

    @Override
    public int getRowCount() {
        if (students == null)
            return 1;
        return students.size() + 1;
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public boolean isCellEditable(int rows, int cols) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (students == null)
            return null;
        if (rowIndex == students.size()) {
            if (columnIndex == 0) {
                return "";
            } else {
            }
            return "";
        }
        Student student = students.get(rowIndex);
        if (student == null) {
            return null;
        }
        switch (columnIndex) {
            case 0:
                return student.getName();
            case 1:
                return student.getSurname();
            case 2:
                return student.getCondition();
            case 3:
                return student.getBirthDate();
            case 4:
                return student.getPoints();
            case 5:
                return student.getIndeks();
        }
        return null;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        var student = students.get(rowIndex);
        if (student == null) {
            return;
        }
        switch (columnIndex) {
            case 0:
                student.setName(aValue.toString());
                break;
            case 1:
                student.setSurname(aValue.toString());
                break;
            case 2:
                var condition = StudentCondition.fromString(aValue.toString());
                student.setCondition(condition);
                break;
            case 3:
                student.setBirthDate(Integer.parseInt(aValue.toString()));
                break;
            case 4:
                student.setPoints(Double.parseDouble(aValue.toString()));
                break;
            case 5:
                student.setIndeks(Integer.parseInt(aValue.toString()));
                break;
        }
        fireTableDataChanged();
        fireTableRowsUpdated(rowIndex, columnIndex);
    }

}

class ClassTable extends AbstractTableModel {
    private static final String[] COLUMN_NAMES = { "Klasa", "Zapelnienie", "Zapelnienie rzeczywiste" };

    public ClassTable(GroupContainer groups) {
        this.groupContainer = groups;
    }

    public void setClassContainer(GroupContainer classContainer) {
        this.groupContainer = classContainer;
    }

    GroupContainer groupContainer;

    @Override
    public String getColumnName(int col) {
        return COLUMN_NAMES[col];
    }

    @Override
    public int getRowCount() {
        return groupContainer.getGroupsCount();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (groupContainer == null) {
            return null;
        }
        var group = groupContainer.getGroupById(rowIndex);
        if (group == null) {
            return null;
        }
        switch (columnIndex) {
            case 0:
                return group.getCourseName();
            case 1:
                return group.getCapacityRatio();
            case 2:
                return group.getCurrentRatio();
        }
        return null;
    }

    private String[] getColumnNames() {
        return COLUMN_NAMES;
    }
}
