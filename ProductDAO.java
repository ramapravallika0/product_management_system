package pjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	Connection conn = DBUtil.getDBConnection();

	public int addProd(Product prod) {

		String insertQuery = "insert into prod values(?,?,?)";

		int count = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);

			pstmt.setInt(1, prod.getPid());
			pstmt.setString(2, prod.getPname());
			pstmt.setDouble(3, prod.getPrice());

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	public int updateProd(Product prod) {

		String updateQuery = "update prod set pname =? , price =? where pid = ?";

		int count = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);

			pstmt.setString(1, prod.getPname());
			pstmt.setDouble(2, prod.getPrice());
			pstmt.setInt(3, prod.getPid());

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;

	}

	public Product getProdById(int pid) {

		String selectQuery = "select * from prod where pid = ?";

		Product dept = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectQuery);

			pstmt.setInt(1, pid);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				double price = rs.getDouble("price");

				dept = new Product();
				dept.setPid(pid);
				dept.setPname(pname);
				dept.setPrice(price);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dept;
	}

	public int deleteProdById(int deptNo) {

		// delete from dept where dno = ?;

		String deleteQuery = "delete from prod where pid = ?";

		int count = 0;

		try {
			PreparedStatement pstmt = conn.prepareStatement(deleteQuery);

			pstmt.setInt(1, deptNo);

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;

	}

	public List<Product> getAll() {

		String selectAllQuery = "select * from prod";

		List<Product> list = new ArrayList<Product>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(selectAllQuery);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				double price = rs.getDouble("price");

				Product prod = new Product();
				list.add(prod);

				prod.setPid(pid);
				prod.setPname(pname);
				prod.setPrice(price);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
