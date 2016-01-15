package View;

import Model.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

class OrderTableModel extends AbstractTableModel {

	private String[] columnNames = { "id", "client", "amount", "date" };
	private List<Order> orders;

	public OrderTableModel(List<Order> orderList) {

		orders = orderList;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return orders.size();
	}

    public Order getRowEntity(int row)
    {
        return orders.get(row);
    }

    public void removeRow(int row) {
        orders.remove(row);
    }

    @Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Order order = orders.get(row);

        switch (col) {
            case 0:
                return order.getId();
            case 1:
                return order.getClient();
            case 2:
                return order.getAmount();
            case 3:
                return order.getDate();
            default:
                return null;
        }
	}

	@Override
	public Class getColumnClass(int c) {

		return getValueAt(0, c).getClass();
	}

	public void addRow(Order rowData) {
		int row = orders.size();
		orders.add(rowData);
		fireTableRowsInserted(row, row);
	}

	public void updateRow() {
		int row = orders.size();
		fireTableRowsUpdated(0,row);
	}

}
