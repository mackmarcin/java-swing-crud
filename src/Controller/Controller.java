package Controller;

import Core.Dao;
import Model.Client;
import Model.ClientTableModel;
import Model.Order;
import Model.OrderTableModel;
import View.AppWindow;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private AppWindow view;
    private Dao dao;

    public Controller() {
        dao = new Dao();
    }

    public OrderTableModel setOrderData(JTable table) {

        OrderTableModel orderModel = null;

        try {
            List<Order> orders = dao.getAllOrder();
            orderModel = new OrderTableModel(orders);
            table.setModel(orderModel);
            table.setShowVerticalLines(true);
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "DAO Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        return orderModel;
    }

    public ClientTableModel setClientData(JTable table) {

        ClientTableModel clientModel = null;

        try {
            List<Client> clients = dao.getAllClient();
            clientModel = new ClientTableModel(clients);
            table.setModel(clientModel);
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "DAO Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        return clientModel;
    }

    public void setClientList(JComboBox<Client> clientList) {

        List<Client> clients = dao.getAllClient();

        for (Client client : clients) {
            clientList.addItem(client);
        }
    }

    public void setView(AppWindow appWindow) {
        this.view = appWindow;
    }
}
