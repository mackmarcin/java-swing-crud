package Model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ClientTableModel extends AbstractTableModel {

	private String[] columnNames = { "id", "name", "phone", "address" };
	private List<Client> clients;

	public ClientTableModel(List<Client> clientList) {

		clients = clientList;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return clients.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Client client = clients.get(row);

        switch (col) {
            case 0:
                return client.getId();
            case 1:
                return client.getNome();
            case 2:
                return client.getPhone();
            case 3:
                return client.getAddress();
            default:
                return null;
        }
	}

	@Override
	public Class getColumnClass(int c) {

		return getValueAt(0, c).getClass();
	}

}
