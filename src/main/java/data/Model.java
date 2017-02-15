/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.RewriteException;
import objects.CoffeeShop;
import objects.Review;

/**
 *
 * @author ubuntu
 */
public class Model {

    static final Logger logger = Logger.getLogger(Model.class.getName());
    private static Model instance;
    private Connection conn;
    List<Review> reviewList;
      List<CoffeeShop> coffeeShopList;

    public static Model singleton() throws Exception {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    Model() throws Exception {
        Class.forName("org.postgresql.Driver");
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        if ((dbUrl == null) || (dbUrl.length() < 1)) {
            dbUrl = System.getProperties().getProperty("DBCONN");
        }
        logger.log(Level.INFO, "dbUrl=" + dbUrl);
        logger.log(Level.INFO, "attempting db connection");
        conn = DriverManager.getConnection(dbUrl);
        logger.log(Level.INFO, "db connection ok.");
        reviewList = new ArrayList<>();
    }

    private Connection getConnection() {
        return conn;
    }

    private Statement createStatement() throws SQLException {
        Connection conn = getConnection();
        if ((conn != null) && (!conn.isClosed())) {
            logger.log(Level.INFO, "attempting statement create");
            Statement st = conn.createStatement();
            logger.log(Level.INFO, "statement created");
            return st;
        } else {
            // Handle connection failure
        }
        return null;
    }

    private PreparedStatement createPreparedStatement(String sql) throws SQLException {
        Connection conn = getConnection();
        if ((conn != null) && (!conn.isClosed())) {
            logger.log(Level.INFO, "attempting statement create");
            PreparedStatement pst = conn.prepareStatement(sql);
            logger.log(Level.INFO, "prepared statement created");
            return pst;
        } else {
            // Handle connection failure
        }
        return null;
    }

    public void createReview(Review review) {
        reviewList.add(review);
    }

    public List<Review> getReviews() throws SQLException {
        return reviewList;
    }

    public void deleteReview(String name) {
        //To change body of generated methods, choose Tools | Templates.
        
        System.out.println("deleted");

        // pst.setInt(1, name);
        // pst.execute();
    }

    public void updateReview(Review jobj) {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("update review ");
        sqlQuery.append("set name='" + jobj.getName() + "', ");
        sqlQuery.append("rating=" + jobj.getRating() + " ");
        sqlQuery.append("where description=" + jobj.getDescription() + ";");
        System.out.println("updated");
    }

    public void deleteCoffeeShop(String jobj) {

        //To change body of generated methods, choose Tools | Templates.
        System.out.println("deleted");
    }

    public List<CoffeeShop> getCoffeeShop() {
        //To change body of generated methods, choose Tools | Templates.
        return coffeeShopList;
    }

   public boolean updateCoffeeShop(CoffeeShop shop) throws SQLException
    {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append("update coffee shop ");
        sqlQuery.append("set name='" + shop.getName() + "', ");
        sqlQuery.append("address=" + shop.getAddress() + " ");
        sqlQuery.append("user rating=" + shop.getRating() + ";");
        Statement st = createStatement();
        logger.log(Level.INFO, "UPDATE SQL=" + sqlQuery.toString());
        return st.execute(sqlQuery.toString());
    }



}
