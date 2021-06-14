package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Book_product;

public class BookRepository {
	private ArrayList<Book_product> listOfProducts = new ArrayList<>();
	
	private static BookRepository instance = new BookRepository();
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private static String url = "jdbc:mysql://localhost:3306/bookstore?serverTimesone=UTC";
	private static String user = "root";
	private static String password = "$^!423*^&";
	
	public static BookRepository getInstance() {
		return instance;
	}
	
	public BookRepository() {	}
	
	public ArrayList<Book_product> getAllProducts() {
		String sql = "select * from book";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Book_product product = new Book_product();
				product.setIsbn(rs.getString("p_isbn"));
				product.setCatagory(rs.getString("p_catagory"));
				product.setName(rs.getString("p_name"));
				product.setAuthor(rs.getString("p_author"));
				product.setUnitPrice(rs.getInt("p_unitPrice"));
				product.setDescription(rs.getString("p_description"));
				product.setUnitsInStrock(rs.getLong("p_unitsInStrock"));
				product.setState(rs.getString("p_state"));
				product.setFileName(rs.getString("p_fileName"));
				
				listOfProducts.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( pstmt != null) pstmt.close();
				if( conn != null) conn.close();
				System.out.println("DB 연동 해제");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return listOfProducts;
	}
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연동");
		} catch (Exception e) {
			System.out.println("DB 연동 실패");
			e.printStackTrace();
		}
		return conn;
	}
	
	public Book_product getProductById(String isbn) {
		Book_product productById = new Book_product();
		String sql = "select * from book where p_isbn = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			
			rs = pstmt.executeQuery();
			
			if ( !rs.next() ) {
				return null;
			}
			
			if (rs.next() ) {
				productById.setIsbn(rs.getString("p_isbn"));
				productById.setCatagory(rs.getString("p_catagory"));
				productById.setName(rs.getString("p_name"));
				productById.setAuthor(rs.getString("p_author"));
				productById.setUnitPrice(rs.getInt("p_unitPrice"));
				productById.setDescription(rs.getString("p_description"));
				productById.setUnitsInStrock(rs.getLong("p_unitsInStrock"));
				productById.setState(rs.getString("p_state"));
				productById.setFileName(rs.getString("p_fileName"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) rs.close();
				if( pstmt != null ) pstmt.close();
				if( conn != null) conn.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return productById;
	}
}
