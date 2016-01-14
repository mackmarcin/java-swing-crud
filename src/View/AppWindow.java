package View;

import Model.*;
import Core.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AppWindow extends JFrame {

//	private JPanel contentPane;
//	private JTextField lastNameTextField;
//	private JScrollPane scrollOrderPane;
//	private JScrollPane scrollClientPane;
//	private JTable orderTable;
//	private JTable clientTable;
//	private JTable table;
//	private JButton getBtn;

    private Dao dao;

    private OrderTableModel orderModel;
    private ClientTableModel clientModel;

	public static void main(String[] args) {

		try {
			AppWindow frame = new AppWindow();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AppWindow() {

		try {
			dao = new Dao();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		setTitle("Company order App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 800, 600);
        JTable orderTable = new JTable();
        JTable clientTable = new JTable();
        clientTable.setRowSelectionAllowed(false);
        clientTable.setCellSelectionEnabled(false);
        clientTable.setColumnSelectionAllowed(false);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

        JScrollPane orderTabPane = new JScrollPane();
        orderTabPane.setPreferredSize(new Dimension(190,400));
        orderTabPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        orderTabPane.setBackground(Color.BLUE);
        contentPane.add(orderTabPane, BorderLayout.WEST);

        JScrollPane clientTabPane = new JScrollPane();
        clientTabPane.setPreferredSize(new Dimension(190,400));
        orderTabPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        clientTabPane.setBackground(Color.RED);
        contentPane.add(clientTabPane, BorderLayout.CENTER);

        JButton add = new JButton();
        add.setText("Dodaj");
        JButton edit = new JButton();
        edit.setText("Edytuj");
        JButton remove = new JButton();
        remove.setText("Usuń");
        JPanel buttonPane = new JPanel();
        buttonPane.setPreferredSize(new Dimension(790,90));
        orderTabPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        buttonPane.setBackground(Color.GREEN);
        contentPane.add(buttonPane, BorderLayout.SOUTH);
        buttonPane.add(add, BorderLayout.CENTER);
        buttonPane.add(edit, BorderLayout.CENTER);
        buttonPane.add(remove, BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(10,2));
        formPanel.setPreferredSize(new Dimension(400,500));
        formPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        clientTabPane.setBackground(Color.YELLOW);
        contentPane.add(formPanel, BorderLayout.EAST);

        JTextField amountField = new JTextField();
//        amountField.setColumns(10);
        JLabel amountLabel = new JLabel("Wartość");
        amountLabel.setLabelFor(amountField);

        DateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        DateFormatter df = new DateFormatter(format);
        JFormattedTextField dateField = new JFormattedTextField(df);

        dateField.setValue(new Date());
        JLabel dateLabel = new JLabel("Data");
        dateLabel.setLabelFor(dateField);

        formPanel.add(amountLabel);
        formPanel.add(amountField);
        formPanel.add(dateLabel);
        formPanel.add(dateField);

        try {
            List<Order> orders = dao.getAllOrder();
            List<Client> clients = dao.getAllClient();
            orderModel = new OrderTableModel(orders);
            orderTable.setModel(orderModel);
            clientModel = new ClientTableModel(clients);
            clientTable.setModel(clientModel);

        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "DAO Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();

		}

        orderTabPane.setViewportView(orderTable);
        clientTabPane.setViewportView(clientTable);

        remove.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {
                    Integer rowId = orderTable.getSelectedRow();
                    Integer value = (Integer) orderModel.getValueAt(rowId, 0);

                    JOptionPane.showMessageDialog(null, "thank you for using java " + value);

                    ///tutaj dodamy akcje
                    ///trzeba zrefaktorowac ten kod bo jest bajzel


                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
	}
}
