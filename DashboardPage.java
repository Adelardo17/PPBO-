import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DashboardPage extends JFrame {
    private JTextField nameField, nimField, prodiField;
    private JButton addButton, deleteButton;
    private JTable table;
    private DefaultTableModel tableModel;

    public DashboardPage() {
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.add(new JLabel("Nama"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("NIM"));
        nimField = new JTextField();
        inputPanel.add(nimField);

        inputPanel.add(new JLabel("Prodi"));
        prodiField = new JTextField();
        inputPanel.add(prodiField);

        addButton = new JButton("Add Student");
        deleteButton = new JButton("Delete Student");

        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        add(inputPanel, BorderLayout.NORTH);

        String[] columns = {"Nama", "NIM", "Prodi"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        addButton.addActionListener(e -> {
            String nama = nameField.getText();
            String nim = nimField.getText();
            String prodi = prodiField.getText();

            if (nama.isEmpty() || nim.isEmpty() || prodi.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
                return;
            }

            tableModel.addRow(new Object[]{nama, nim, prodi});
            nameField.setText("");
            nimField.setText("");
            prodiField.setText("");
        });

        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                tableModel.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus!");
            }
        });
    }
}
