package Controller;

import java.sql.*;
import java.util.ArrayList;

public class JDBC
{
    private static final String url="jdbc:mysql://localhost:3306/PBZ2";
    private static final String userName="root";
    private static final String password="12345";
    public static final int WORKERS=1;
    public static final int ORDERS=2;
    public static final int ORDEREVENTS=3;

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public ArrayList<String> select(String query, int code)
    {
        ArrayList<String> list=new ArrayList<>();
        //String query="SELECT * FROM workers";
        try
        {
            connection= DriverManager.getConnection(url, userName, password);
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            if(code==WORKERS)
                while (resultSet.next())
                    list.add(resultSet.getString("FIO"));
            if(code==ORDERS)
                while (resultSet.next())
                    list.add(Integer.toString(resultSet.getInt("ID")));
            if(code==ORDEREVENTS)
                while (resultSet.next())
                    list.add(resultSet.getString("ORDEREVENT"));
            /*while(resultSet.next())
                System.out.println(resultSet.getString("FIO")+
                        resultSet.getString("DIVISION_NAME")+
                        resultSet.getString("POSITION"));*/
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
            list.add("error");
        }
        finally
        {
            close();
        }
        return list;
    }

    public boolean insert(String query)
    {
        try
        {
            connection=DriverManager.getConnection(url, userName, password);
            statement=connection.createStatement();
            statement.executeUpdate(query);
        }
        catch(SQLException sqle)
        {
            return false;
        }
        finally
        {
            close();
        }
        return true;
    }

    private void close()
    {
        try
        {
            connection.close();
            statement.close();
            resultSet.close();
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }
    }
}