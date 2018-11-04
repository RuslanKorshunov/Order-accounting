package Controller;

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

    public boolean addNewOrder(String number,
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
        list=jdbc.select("SELECT ORDEREVENT, ID_OF_ORDER FROM orderevents WHERE ORDEREVENT=\""+event+"\" AND ID_OF_ORDER=\""+number+"\"", JDBC.ORDER_EVENTS);
        if(list.isEmpty())
        {
            String query="INSERT INTO orderevents VALUES (\""+event+"\", "+number+", \""+dateEvent+"\", \""+mark+"\", \""+responsibleMan+"\")";
            return jdbc.insert(query);
        }
        if(list.get(0).equals(event))
            return true;
        return false;
    }

    public String[] getListCorrespondents()
    {
        ArrayList<String> arrayList=jdbc.select("SELECT FIO FROM workers", JDBC.WORKERS);
        String[] list=new String[arrayList.size()];
        for(int i=0; i<list.length; i++)
            list[i]=arrayList.get(i);
        return list;
    }

    public ArrayList<String> getInformationAboutCorr(String fio)
    {
        ArrayList<String> list=jdbc.select("SELECT * FROM workers WHERE FIO=\""+fio+"\"", JDBC.WORKERS_SELECTED_ALL);;
        return list;
    }

    public ArrayList<String> getInformationAboutOrder(String ID)
    {
        ArrayList<String> list=jdbc.select("SELECT * FROM orders WHERE ID=\""+ID+"\"", JDBC.ORDERS_SELECTED_ALL);
        System.out.println(list);
        ArrayList<String> correspondent=getInformationAboutCorr(list.get(3));
        if(correspondent.isEmpty())
            return new ArrayList<String>();//временно.
        System.out.println(correspondent);
        list.add(3, correspondent.get(0)+"\n"+correspondent.get(2)+"\n"+correspondent.get(1));
        return list;
    }

    public ArrayList<String> getInformationAboutEvent(String ORDEREVENT)
    {
        ArrayList<String> list=jdbc.select("SELECT ORDEREVENT, DATE_OF_ADOPTION, MARK, FIO FROM orderevents WHERE ORDEREVENT=\""+ORDEREVENT+"\"", +JDBC.ORDER_EVENT_SELECTED_ALL);
        System.out.println(list);
        return list;
    }

    public boolean changeCorrespondent(String oldfio, String fio, String division_name, String position)
    {
        boolean answer=jdbc.update("UPDATE workers SET FIO=\""+fio+"\", DIVISION_NAME=\""+
                                    division_name+"\", POSITION=\""+position+"\" WHERE FIO=\""+oldfio+"\"");
        return answer;
    }

    public boolean changeOrder(String number,
                               String date,
                               String content,
                               String head,
                               String event,
                               String responsibleMan,
                               String dateEvent,
                               String mark)
    {
        if(getInformationAboutCorr(head).isEmpty())
            return false;
        boolean answer=jdbc.update("UPDATE orders SET DATE_OF_ADOPTION=\""+
                                    date+"\", CONTENT=\""+
                                    content+"\", FIO=\""+
                                    head+"\" WHERE ID="+
                                    number);
        if(answer==false)
            return answer;
        System.out.println("UPDATE orderevents SET ORDEREVENT=\"" +
                event + "\", DATE_OF_ADOPTION=\"" +
                dateEvent + "\", MARK=\"" +
                mark + "\", FIO=\"" +
                responsibleMan + "\" WHERE ID_OF_ORDER="+number);
        if(!event.equals(""))
            answer = jdbc.update("UPDATE orderevents SET ORDEREVENT=\"" +
                    event + "\", DATE_OF_ADOPTION=\"" +
                    dateEvent + "\", MARK=\"" +
                    mark + "\", FIO=\"" +
                    responsibleMan + "\" WHERE ID_OF_ORDER="+number);
        return answer;
    }

    public boolean deleteOrder(String ID)
    {
        boolean answer=deleteAllEvents(ID);
        if(answer==false)
            return answer;
        answer=jdbc.delete("DELETE FROM orders WHERE ID=\""+ID+"\"");
        return answer;
    }

    public boolean deleteEvent(String event)
    {
        boolean answer=jdbc.delete("DELETE FROM orderevents WHERE ORDEREVENT=\""+event+"\"");
        return answer;
    }

    public boolean deleteAllEvents(String ID)
    {
        boolean answer=jdbc.delete("DELETE FROM orderevents WHERE ID_OF_ORDER=\""+ID+"\"");
        return answer;
    }

    public boolean deleteCorrespondent(String fio)
    {
        boolean answer=jdbc.delete("DELETE FROM workers WHERE FIO=\""+fio+"\"");
        return answer;
    }

    public String[] getListOrders()
    {
        ArrayList<String> arrayList=jdbc.select("SELECT ID FROM orders", JDBC.ORDERS);
        String[] list=new String[arrayList.size()];
        for(int i=0; i<list.length; i++)
            list[i]=arrayList.get(i);
        return list;
    }

    public String[] getListOrders(String date)
    {
        ArrayList<String> arrayList=jdbc.select("SELECT * FROM orders WHERE DATE_OF_ADOPTION<=\""+date+"\" ORDER BY DATE_OF_ADOPTION", JDBC.ORDERS_SELECTED_ALL);
        String[] list=new String[arrayList.size()];
        for(int i=0; i<list.length; i++)
        {
            list[i] = arrayList.get(i);
            System.out.println(list[i]);
        }
        return list;
    }

    public String[] getListEvents(String ID)
    {
        ArrayList<String> arrayList=jdbc.select("SELECT ORDEREVENT FROM orderevents WHERE ID_OF_ORDER=\""+ID+"\"", JDBC.ORDER_EVENTS);
        String[] list=new String[arrayList.size()];
        for(int i=0; i<list.length; i++)
            list[i]=arrayList.get(i);
        return list;
    }

    public String[] getListEvents(String beginDate, String endDate)
    {
        ArrayList<String> arrayList=jdbc.select("SELECT * FROM orderevents WHERE DATE_OF_ADOPTION BETWEEN \""+beginDate+"\" AND \""+endDate+"\"", JDBC.ORDER_EVENT_SELECTED_ALL);
        String[] list=new String[arrayList.size()];
        for(int i=0; i<list.length; i++)
            list[i] = arrayList.get(i);
        return list;
    }

    public String[] getListEvents(String date, int n)
    {
        ArrayList<String> arrayList=jdbc.select("SELECT * FROM orderevents WHERE DATE_OF_ADOPTION<=\""+date+"\" ORDER BY DATE_OF_ADOPTION", JDBC.ORDER_EVENT_SELECTED_ALL);
        String[] list=new String[arrayList.size()];
        for(int i=0; i<list.length; i++)
            list[i] = arrayList.get(i);
        return list;
    }
}