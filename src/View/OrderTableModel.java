package View;

import Model.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

class OrderTableModel extends AbstractTableModel {

	private String[] columnNames = { "id", "client", "amount", "date" };
	private List<Order> orders;

	public OrderTableModel(List<Order> orders) {

		orders = orders;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return orders.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Order order = orders.get(row);

		return order.getId();
	}

	@Override
	public Class getColumnClass(int c) {

		return getValueAt(0, c).getClass();
	}
}
