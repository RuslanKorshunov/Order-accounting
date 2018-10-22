package Controller;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation;

import java.util.ArrayList;

public class Controller
{
    private JDBC jdbc;

    public Controller()
    {
        jdbc=new JDBC();
    }

    public boolean addNewCorrespondent(String fio, String division_name, String position)
    {
        ArrayList<String> list=jdbc.select("SELECT FIO FROM workers WHERE FIO=\""+fio+"\"", JDBC.WORKERS);
        if(list.isEmpty())
        {
            String query="INSERT INTO workers VALUES (\""+fio+"\", \""+division_name+"\", \""+position+"\")";
            return jdbc.insert(query);
        }
        if(list.get(0).equals(fio))
            return true;
        return false;
    }

    public boolean addNewReport(String number,
                                String date,
                                String content,
                                String head,
                                String event,
                                String responsibleMan,
                                String dateEvent,
                                String mark)
    {
        boolean answer=addNewCorrespondent(head.split("\n")[0], head.split("\n")[1], head.split("\n")[2]);
        if(answer==false)
            return answer;
        ArrayList<String> list=jdbc.select("SELECT ID FROM orders WHERE ID=\""+number+"\"", JDBC.ORDERS);
        if(list.isEmpty())
        {
            String query="INSERT INTO orders VALUES ("+number+", \""+date+"\", \""+content+"\", \""+head.split("\n")[0]+"\")";
            answer=jdbc.insert(query);
            if(answer==false)
                return answer;
        }
        list.clear();
        list=jdbc.select("SELECT ORDEREVENT, ID_OF_ORDER FROM orderevents WHERE ORDEREVENT=\""+event+"\" AND ID_OF_ORDER=\""+number+"\"", JDBC.ORDEREVENTS);
        if(list.isEmpty())
        {
            String query="INSERT INTO orderevents VALUES (\""+event+"\", "+number+", \""+dateEvent+"\", \""+mark+"\", \""+responsibleMan+"\")";
            return jdbc.insert(query);
        }
        if(list.get(0).equals(event))
            return true;
        return false;
    }
}