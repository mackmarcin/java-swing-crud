package Core;

import Model.*;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dao {

	private final static String INSERT_ORDER = "INSERT INTO demand (amount,date) VALUES (?,?)";
	private final static String UPDATE_ORDER = "UPDATE demand SET amount = ?, date = ?, WHERE id = ?";
	private final static String DELETE_ORDER = "DELETE FROM demand WHERE id = ?";
	private final static String GET_ALL_ORDER = "select * from demand";
	private final static String GET_ORDER_BY_ID = "SELECT * FROM demand WHERE id = ?";

	public void saveOrder(Order order) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ConnectionManager.getConnection();
			if (order.getId() == null) {
				stmt = getStatementInsert(conn, order);
			} else {
				stmt = getStatementUpdate(conn, order);
			}
			stmt.executeUpdate();
			conn.commit();

		} catch (SQLException e) {
            e.printStackTrace();
		} finally {
            ConnectionManager.close(conn, stmt);
		}
	}
	
	private PreparedStatement getStatementInsert(Connection conn, Order order) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(INSERT_ORDER);
		stmt.setDate(1, new java.sql.Date(order.getDate().getTime()));
		stmt.setFloat(2, order.getAmount());
		return stmt;
	}
	
	private PreparedStatement getStatementUpdate(Connection conn, Order order) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(UPDATE_ORDER);
        stmt.setFloat(1, order.getAmount());
        stmt.setDate(2, new java.sql.Date(order.getDate().getTime()));
		stmt.setInt(3, order.getId());
		return stmt;
	}

	public void remove(Order order) {
		if (order.getId() == null) {
			return;
		}
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(DELETE_ORDER);
			stmt.setInt(1, order.getId());
			stmt.executeUpdate();

		} catch (SQLException e) {
            e.printStackTrace();
		}finally{
			ConnectionManager.close(conn, stmt);
		}
	}
	
	public Order findOrderById(Integer id) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
        Order order = null;
		
		try {
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(GET_ORDER_BY_ID);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
                order = new Order();
                order.setId(rs.getInt("id"));
                order.setClient(rs.getInt("client_id"));
                order.setDate(rs.getDate("date"));
                order.setAmount(rs.getFloat("amount"));
			}

			return order;

		} catch (SQLException e) {
            e.printStackTrace();
		} finally {
            ConnectionManager.close(conn, stmt);
		}

        return order;
    }
	
	public List<Order> getAllOrder() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
        List<Order> list = new ArrayList<Order>();

        try {
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(GET_ALL_ORDER);
			rs = stmt.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setClient(rs.getInt("client_id"));
                order.setDate(rs.getDate("date"));
                order.setAmount(rs.getFloat("amount"));

                list.add(order);
            }

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
		} finally {
			ConnectionManager.close(conn, stmt);
		}

        return list;
    }
}