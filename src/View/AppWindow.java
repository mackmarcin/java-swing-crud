package View;

import Model.*;
import Core.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.List;

public class AppWindow extends JFrame {

	private JPanel contentPane;
//	private JTextField lastNameTextField;
	private JScrollPane scrollPane;
	private JTable table;
//	private JButton getBtn;
	private Dao dao;

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
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		setTitle("Company order App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
//		JLabel lblEnterLastName = new JLabel("Enter last name");
//		panel.add(lblEnterLastName);
		
//		lastNameTextField = new JTextField();
//		panel.add(lastNameTextField);
//		lastNameTextField.setColumns(10);
//
//		getBtn = new JButton("Get");
//		getBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//
//				try {
//					String lastName = lastNameTextField.getText();
//
//					List<Order> order = null;
//
//					if (lastName != null && lastName.trim().length() > 0) {
//						employees = employeeDAO.searchEmployees(lastName);
//					} else {
//						employees = employeeDAO.getAllEmployees();
//					}
//
//					// create the model and update the "table"
//					EmployeeTableModel model = new EmployeeTableModel(employees);
//
//					table.setModel(model);
//
//					/*
//					for (Employee temp : employees) {
//						System.out.println(temp);
//					}
//					*/
//				} catch (Exception exc) {
//					JOptionPane.showMessageDialog(EmployeeSearchApp.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
//				}
//
//			}
//		});
//		panel.add(btnSearch);


        try {
            List<Order> orders = null;
            orders = dao.getAllOrder();
            table.setModel(new OrderTableModel(orders));

            orders.add(new Order());
//            Order o = new Order();
//
//                        o = dao.findOrderById(1);

        } catch (Exception exc) {
            JOptionPane.showMessageDialog(this, "DAO Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
