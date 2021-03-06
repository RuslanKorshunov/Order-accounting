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
    public static final int ORDER_EVENTS =3;
    public static final int WORKERS_SELECTED_ALL =4;
    public static final int ORDERS_SELECTED_ALL =5;
    public static final int ORDER_EVENT_SELECTED_ALL =6;

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public ArrayList<String> select(String query, int code)
    {
        ArrayList<String> list=new ArrayList<>();
        try
        {
            connection= DriverManager.getConnection(url, userName, password);
            statement=connection.createStatement();
            resultSet=statement.executeQuery(query);
            if(code==WORKERS || code== WORKERS_SELECTED_ALL)
                while (resultSet.next())
                {
                    list.add(resultSet.getString("FIO"));
                    if(code== WORKERS_SELECTED_ALL)
                    {
                        list.add(resultSet.getString("POSITION"));
                        list.add(resultSet.getString("DIVISION_NAME"));
                    }
                }
            if(code==ORDERS || code== ORDERS_SELECTED_ALL)
                while (resultSet.next())
                {
                    list.add(Integer.toString(resultSet.getInt("ID")));
                    if(code== ORDERS_SELECTED_ALL)
                    {
                        list.add(resultSet.getString("DATE_OF_ADOPTION"));
                        list.add(resultSet.getString("CONTENT"));
                        list.add(resultSet.getString("FIO"));
                    }
                }
            if(code== ORDER_EVENTS || code== ORDER_EVENT_SELECTED_ALL)
                while (resultSet.next())
                {
                    list.add(resultSet.getString("ORDEREVENT"));
                    if(code== ORDER_EVENT_SELECTED_ALL)
                    {
                        list.add(resultSet.getString("DATE_OF_ADOPTION"));
                        list.add(resultSet.getString("MARK"));
                        list.add(resultSet.getString("FIO"));
                    }
                }
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

    public boolean update(String query)
    {
        return insert(query);
    }

    public boolean delete(String query)
    {
        return insert(query);
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