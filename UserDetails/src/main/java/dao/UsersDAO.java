package dao;

import java.util.*;
import java.sql.*;

public class UsersDAO {

    //Creating Database Connection
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mariadb://localhost:3305/mydb?allowPublicKeyRetrieval=true&useSSL=false","root","password");
        } catch (ClassNotFoundException  | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    //Saving User Details
public static int save(Users users){
        Connection con=UsersDAO.getConnection();
        int status=0;
    try {
        PreparedStatement psSave=con.prepareStatement("insert into userdetail values (?,?,?,?,?)");
        psSave.setInt(1,users.getId());
        psSave.setString(2,users.getFirstName());
        psSave.setString(3,users.getLastName());
        psSave.setString(4,users.getCity());
        psSave.setInt(5,users.getAge());
        status=psSave.executeUpdate();
        con.close();
    } catch(Exception ex){ex.printStackTrace();}
    return status;
}
    //Updating User
    public static int update(Users users){
        int status=0;
        try{
            Connection con=UsersDAO.getConnection();
            PreparedStatement psUpdate=con.prepareStatement(
                    "update userdetail set firstName=?,lastName=?,city=?,age=? where id=?");
            psUpdate.setString(1,users.getFirstName());
            psUpdate.setString(2,users.getLastName());
            psUpdate.setString(3,users.getCity());
            psUpdate.setInt(4,users.getAge());
            psUpdate.setInt(5,users.getId());

            status=psUpdate.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }
    //Deleting User
    public static int delete(int userId){
        int status=0;
        try{
            Connection con=UsersDAO.getConnection();
            PreparedStatement psDelete=con.prepareStatement("delete from userdetail where id=?");
            psDelete.setInt(1,userId);
            status=psDelete.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    //Showing User Details Based on id
    public static Users getUserDetailsById(int userId){
        Users users=new Users();
        try{
            Connection con=UsersDAO.getConnection();
            PreparedStatement psGetDetails=con.prepareStatement("select * from userdetail where id=?");
            psGetDetails.setInt(1,userId);
            ResultSet resultSet=psGetDetails.executeQuery();

            if(resultSet.next()){
                users.setId(resultSet.getInt(1));
                users.setFirstName(resultSet.getString(2));
                users.setLastName(resultSet.getString(3));
                users.setCity(resultSet.getString(4));
                users.setAge(resultSet.getInt(5));
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    //Showing all users
    public static List<Users> getAllUsers(){
        List<Users> list=new ArrayList<>();
        try{
            Connection con=UsersDAO.getConnection();
            Statement allUser=con.createStatement();
            ResultSet resultSet=allUser.executeQuery("select * from userdetail");
            while(resultSet.next()){
                Users users=new Users();
                users.setId(resultSet.getInt(1));
                users.setFirstName(resultSet.getString(2));
                users.setLastName(resultSet.getString(3));
                users.setCity(resultSet.getString(4));
                users.setAge(resultSet.getInt(5));
                con.close();
                list.add(users);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
