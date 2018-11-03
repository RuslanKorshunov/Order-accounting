package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWindow extends JFrame
{
    private final int WIDTH=800;
    private final int HEIGHT=600;
    private Container mainContainer;
    private SpringLayout layout;
    private Controller controller;

    public MainWindow(Controller controller)
    {
        this.controller=controller;

        setTitle("Учёт приказов и распоряжений");
        setSize(new Dimension(WIDTH, HEIGHT));
        setLocation(new Point(300,100));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        mainContainer =this.getContentPane();
        layout=new SpringLayout();

        JMenuBar menuBar=new JMenuBar();
        JMenu menu=new JMenu("Меню");
        JMenuItem add=new JMenuItem("Добавить");
        JMenuItem edit=new JMenuItem("Редактировать");
        JMenuItem delete=new JMenuItem("Удалить");
        JMenuItem search=new JMenuItem("Поиск");
        JMenuItem exit=new JMenuItem("Выход");
        menu.add(add);
        menu.add(edit);
        menu.add(delete);
        menu.add(search);
        menu.addSeparator();
        menu.add(exit);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        deleteDate();

        add.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mainContainer.removeAll();
                addNewData();
            }
        });
        edit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mainContainer.removeAll();
                editData();
            }
        });
        delete.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mainContainer.removeAll();
                deleteDate();
            }
        });
        exit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    private void addNewData()
    {
        JTabbedPane tabbedPane=new JTabbedPane();

        Container container1=new Container();
        Container container2=new Container();

        container1.setLayout(layout);
        container2.setLayout(layout);

        JLabel numberLabel=new JLabel("Номер:");
        JLabel dateLabel=new JLabel("Дата:");
        JLabel contentLabel=new JLabel("Содержание:");
        JLabel headLabel=new JLabel("Руководитель:");
        JLabel eventLabel=new JLabel("Мероприятие:");
        JLabel responsibleManLabel=new JLabel("Ответсвенный:");
        JLabel dateEventLabel=new JLabel("Дата:");
        JLabel markLabel=new JLabel("Выполнено:");
        JLabel fioLabel=new JLabel("ФИО:");
        JLabel positionLabel=new JLabel("Должность:");
        JLabel divisionLabel=new JLabel("Подразделение:");

        JTextField numberTextField=new JTextField(20);
        JTextField dateTextField=new JTextField(20);
        JTextField dateEventTextField=new JTextField(20);
        JComboBox markComboBox=new JComboBox(new String[]{"Да", "Нет"});
        JTextField fioTextField=new JTextField(20);
        JTextField positionTextField=new JTextField(20);
        JTextField divisionTextField=new JTextField(20);

        JTextArea headTextArea=new JTextArea("ФИО\nподразделение\nдолжность",3, 20);
        headTextArea.setLineWrap(true);
        headTextArea.setWrapStyleWord(true);
        JScrollPane headScrollPane=new JScrollPane(headTextArea);
        JTextArea contentTextArea=new JTextArea(10, 20);
        contentTextArea.setLineWrap(true);
        contentTextArea.setWrapStyleWord(true);
        JScrollPane contentScrollPane=new JScrollPane(contentTextArea);
        JTextArea eventTextArea=new JTextArea(5,20);
        eventTextArea.setLineWrap(true);
        eventTextArea.setWrapStyleWord(true);
        JScrollPane eventScrollPane=new JScrollPane(eventTextArea);
        JTextArea responsibleManTextArea=new JTextArea(3, 20);
        responsibleManTextArea.setLineWrap(true);
        responsibleManTextArea.setWrapStyleWord(true);
        JScrollPane responsibleManScrollPane=new JScrollPane(responsibleManTextArea);

        JButton add1Button=new JButton("Добавить");
        JButton add2Button=new JButton("Добавить");

        container1.add(numberLabel);
        container1.add(numberTextField);
        container1.add(dateLabel);
        container1.add(dateTextField);
        container1.add(contentLabel);
        container1.add(contentScrollPane);
        container1.add(headLabel);
        container1.add(headScrollPane);
        container1.add(eventLabel);
        container1.add(eventScrollPane);
        container1.add(responsibleManLabel);
        container1.add(responsibleManScrollPane);
        container1.add(dateEventLabel);
        container1.add(dateEventTextField);
        container1.add(markLabel);
        container1.add(markComboBox);
        container1.add(add1Button);

        container2.add(fioLabel);
        container2.add(fioTextField);
        container2.add(positionLabel);
        container2.add(positionTextField);
        container2.add(divisionLabel);
        container2.add(divisionTextField);
        container2.add(add2Button);

        final int width1=300;
        final int width2=190;

        layout.putConstraint(SpringLayout.NORTH, numberLabel, 5, SpringLayout.NORTH, container1);
        layout.putConstraint(SpringLayout.WEST, numberLabel, width2, SpringLayout.WEST, container1);
        layout.putConstraint(SpringLayout.NORTH, numberTextField, 5, SpringLayout.NORTH, container1);
        layout.putConstraint(SpringLayout.WEST, numberTextField, width1, SpringLayout.WEST, container1);
        layout.putConstraint(SpringLayout.NORTH, dateLabel, 5, SpringLayout.SOUTH, numberTextField);
        layout.putConstraint(SpringLayout.WEST, dateLabel, width2, SpringLayout.WEST, container1);
        layout.putConstraint(SpringLayout.NORTH, dateTextField, 5, SpringLayout.SOUTH, numberTextField);
        layout.putConstraint(SpringLayout.WEST, dateTextField, 0, SpringLayout.WEST, numberTextField);
        layout.putConstraint(SpringLayout.NORTH, contentLabel, 5, SpringLayout.SOUTH, dateTextField);
        layout.putConstraint(SpringLayout.WEST, contentLabel, width2, SpringLayout.WEST, container1);
        layout.putConstraint(SpringLayout.NORTH, contentScrollPane, 5, SpringLayout.SOUTH, dateTextField);
        layout.putConstraint(SpringLayout.WEST, contentScrollPane, 0, SpringLayout.WEST, dateTextField);
        layout.putConstraint(SpringLayout.NORTH, headLabel, 5, SpringLayout.SOUTH, contentScrollPane);
        layout.putConstraint(SpringLayout.WEST, headLabel, width2, SpringLayout.WEST, container1);
        layout.putConstraint(SpringLayout.NORTH, headScrollPane, 5, SpringLayout.SOUTH, contentScrollPane);
        layout.putConstraint(SpringLayout.WEST, headScrollPane, 0, SpringLayout.WEST, contentScrollPane);
        layout.putConstraint(SpringLayout.NORTH, eventLabel, 20, SpringLayout.SOUTH, headScrollPane);
        layout.putConstraint(SpringLayout.WEST, eventLabel, width2, SpringLayout.WEST, container1);
        layout.putConstraint(SpringLayout.NORTH, eventScrollPane, 20, SpringLayout.SOUTH, headScrollPane);
        layout.putConstraint(SpringLayout.WEST, eventScrollPane, 0, SpringLayout.WEST,headScrollPane);
        layout.putConstraint(SpringLayout.NORTH, responsibleManLabel, 5, SpringLayout.SOUTH, eventScrollPane);
        layout.putConstraint(SpringLayout.WEST, responsibleManLabel, width2, SpringLayout.WEST, container2);
        layout.putConstraint(SpringLayout.NORTH, responsibleManScrollPane, 5, SpringLayout.SOUTH, eventScrollPane);
        layout.putConstraint(SpringLayout.WEST, responsibleManScrollPane, 0, SpringLayout.WEST, eventScrollPane);
        layout.putConstraint(SpringLayout.NORTH, dateEventLabel, 5, SpringLayout.SOUTH, responsibleManScrollPane);
        layout.putConstraint(SpringLayout.WEST, dateEventLabel, width2, SpringLayout.WEST, container1);
        layout.putConstraint(SpringLayout.NORTH, dateEventTextField, 5, SpringLayout.SOUTH, responsibleManScrollPane);
        layout.putConstraint(SpringLayout.WEST, dateEventTextField, 0, SpringLayout.WEST, responsibleManScrollPane);
        layout.putConstraint(SpringLayout.NORTH, markLabel, 5, SpringLayout.SOUTH, dateEventTextField);
        layout.putConstraint(SpringLayout.WEST, markLabel, width2, SpringLayout.WEST, container2);
        layout.putConstraint(SpringLayout.NORTH, markComboBox, 5, SpringLayout.SOUTH, dateEventTextField);
        layout.putConstraint(SpringLayout.WEST, markComboBox, 0, SpringLayout.WEST, dateEventTextField);
        layout.putConstraint(SpringLayout.NORTH, add1Button, 5, SpringLayout.SOUTH, markComboBox);
        layout.putConstraint(SpringLayout.WEST, add1Button, width1+50, SpringLayout.WEST, container1);

        layout.putConstraint(SpringLayout.NORTH, fioLabel, 200, SpringLayout.NORTH, container2);
        layout.putConstraint(SpringLayout.WEST, fioLabel, width2-18, SpringLayout.WEST, container2);
        layout.putConstraint(SpringLayout.NORTH, fioTextField,200, SpringLayout.NORTH, container2);
        layout.putConstraint(SpringLayout.WEST, fioTextField, width1, SpringLayout.WEST, container2);
        layout.putConstraint(SpringLayout.NORTH, positionLabel, 5, SpringLayout.SOUTH, fioTextField);
        layout.putConstraint(SpringLayout.WEST, positionLabel, 0, SpringLayout.WEST, fioLabel);
        layout.putConstraint(SpringLayout.NORTH, positionTextField, 5, SpringLayout.SOUTH, fioTextField);
        layout.putConstraint(SpringLayout.WEST, positionTextField, 0, SpringLayout.WEST, fioTextField);
        layout.putConstraint(SpringLayout.NORTH, divisionLabel, 5, SpringLayout.SOUTH, positionTextField);
        layout.putConstraint(SpringLayout.WEST, divisionLabel, 0, SpringLayout.WEST, positionLabel);
        layout.putConstraint(SpringLayout.NORTH, divisionTextField, 5, SpringLayout.SOUTH, positionTextField);
        layout.putConstraint(SpringLayout.WEST, divisionTextField, 0, SpringLayout.WEST, positionTextField);
        layout.putConstraint(SpringLayout.NORTH, add2Button, 10, SpringLayout.SOUTH, divisionTextField);
        layout.putConstraint(SpringLayout.WEST, add2Button, 50, SpringLayout.WEST, divisionTextField);

        tabbedPane.addTab("Приказ", null, container1, "Форма для добавления приказа");
        tabbedPane.addTab("Корреспондент", null, container2, "Форма для добавления корреспондента");

        add1Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean answer=true;
                String number=numberTextField.getText();
                String date=dateTextField.getText();
                String content=contentTextArea.getText();
                String head=headTextArea.getText();
                String event=eventTextArea.getText();
                String responsibleMan=responsibleManTextArea.getText();
                String dateEvent=dateEventTextField.getText();
                String mark=(String) markComboBox.getSelectedItem();
                if(number.equals(""))
                {
                    numberTextField.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(date.equals(""))
                {
                    dateTextField.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(head.equals("ФИО\nподразделение\nдолжность"))
                {
                    headTextArea.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(event.equals(""))
                {
                    eventTextArea.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(responsibleMan.equals(""))
                {
                    responsibleManTextArea.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(dateEvent.equals(""))
                {
                    dateEventTextField.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(mark.equals(""))
                {
                    markComboBox.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(answer!=false)
                {
                    answer=controller.addNewOrder(number, date, content, head, event, responsibleMan, dateEvent, mark);
                    if(answer==false)
                        showErrorMessage();
                    numberTextField.setText("");
                    numberTextField.setBackground(Color.WHITE);
                    dateTextField.setText("");
                    dateTextField.setBackground(Color.WHITE);
                    contentTextArea.setText("");
                    headTextArea.setText("ФИО\nподразделение\nдолжность");
                    headTextArea.setBackground(Color.WHITE);
                    eventTextArea.setText("");
                    eventTextArea.setBackground(Color.WHITE);
                    responsibleManTextArea.setText("");
                    responsibleManTextArea.setBackground(Color.WHITE);
                    dateEventTextField.setText("");
                    dateEventTextField.setBackground(Color.WHITE);
                    markComboBox.setBackground(Color.WHITE);
                }
            }
        });
        add2Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean answer=true;
                String fio=fioTextField.getText();
                String position=positionTextField.getText();
                String division_name=divisionTextField.getText();
                if(fio.equals(""))
                {
                    fioTextField.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(position.equals(""))
                {
                    positionTextField.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(division_name.equals(""))
                {
                    divisionTextField.setBackground(Color.YELLOW);
                    answer=false;
                }
                if(answer!=false)
                {
                    answer = controller.addNewCorrespondent(fio, division_name, position);
                    if(answer==false)
                        showErrorMessage();
                    fioTextField.setText("");
                    fioTextField.setBackground(Color.WHITE);
                    positionTextField.setText("");
                    positionTextField.setBackground(Color.WHITE);
                    divisionTextField.setText("");
                    divisionTextField.setBackground(Color.WHITE);
                }
            }
        });

        mainContainer.add(tabbedPane);

        revalidate();
        repaint();
    }

    private void editData()
    {
        JTabbedPane tabbedPane=new JTabbedPane();

        Container container1=new Container();
        Container container2=new Container();

        container1.setLayout(layout);
        container2.setLayout(layout);

        JLabel numberLabel=new JLabel("Номер:");
        numberLabel.setForeground(Color.GRAY);
        JLabel dateLabel=new JLabel("Дата:");
        dateLabel.setForeground(Color.GRAY);
        JLabel contentLabel=new JLabel("Содержание:");
        contentLabel.setForeground(Color.GRAY);
        JLabel headLabel=new JLabel("Руководитель:");
        headLabel.setForeground(Color.GRAY);
        JLabel eventLabel=new JLabel("Мероприятие:");
        eventLabel.setForeground(Color.GRAY);
        JLabel responsibleManLabel=new JLabel("Ответсвенный:");
        responsibleManLabel.setForeground(Color.GRAY);
        JLabel dateEventLabel=new JLabel("Дата:");
        dateEventLabel.setForeground(Color.GRAY);
        JLabel markLabel=new JLabel("Выполнено:");
        markLabel.setForeground(Color.GRAY);
        JLabel fioLabel=new JLabel("ФИО:");
        fioLabel.setForeground(Color.GRAY);
        JLabel positionLabel=new JLabel("Должность:");
        positionLabel.setForeground(Color.GRAY);
        JLabel divisionLabel=new JLabel("Подразделение:");
        divisionLabel.setForeground(Color.GRAY);

        JTextField numberTextField=new JTextField(20);
        numberTextField.setEnabled(false);
        JTextField dateTextField=new JTextField(20);
        dateTextField.setEnabled(false);
        JTextField dateEventTextField=new JTextField(20);
        dateEventTextField.setEnabled(false);
        JTextField fioTextField=new JTextField(20);
        fioTextField.setEnabled(false);
        JTextField positionTextField=new JTextField(20);
        positionTextField.setEnabled(false);
        JTextField divisionTextField=new JTextField(20);
        divisionTextField.setEnabled(false);

        JTextArea headTextArea=new JTextArea("ФИО\nподразделение\nдолжность",3, 20);
        headTextArea.setEnabled(false);
        headTextArea.setLineWrap(true);
        headTextArea.setWrapStyleWord(true);
        JScrollPane headScrollPane=new JScrollPane(headTextArea);
        JTextArea contentTextArea=new JTextArea(10, 20);
        contentTextArea.setEnabled(false);
        contentTextArea.setLineWrap(true);
        contentTextArea.setWrapStyleWord(true);
        JScrollPane contentScrollPane=new JScrollPane(contentTextArea);
        JTextArea eventTextArea=new JTextArea(5,20);
        eventTextArea.setEnabled(false);
        eventTextArea.setLineWrap(true);
        eventTextArea.setWrapStyleWord(true);
        JScrollPane eventScrollPane=new JScrollPane(eventTextArea);
        JTextArea responsibleManTextArea=new JTextArea(3, 20);
        responsibleManTextArea.setEnabled(false);
        responsibleManTextArea.setLineWrap(true);
        responsibleManTextArea.setWrapStyleWord(true);
        JScrollPane responsibleManScrollPane=new JScrollPane(responsibleManTextArea);

        DefaultComboBoxModel correspondentComboBoxModel=new DefaultComboBoxModel(controller.getListCorrespondents());
        JComboBox correspondentComboBox=new JComboBox(correspondentComboBoxModel);
        JComboBox markComboBox=new JComboBox(new String[]{"Да", "Нет"});
        markComboBox.setEnabled(false);
        JComboBox orderComboBox=new JComboBox(controller.getListOrders());
        //DefaultComboBoxModel eventComboBoxModel=new DefaultComboBoxModel();
        JComboBox eventComboBox=new JComboBox(/*eventComboBoxModel*/);
        eventComboBox.setEnabled(false);

        JButton change1Button=new JButton("Изменить");
        change1Button.setEnabled(false);
        JButton change2Button=new JButton("Изменить");
        change2Button.setEnabled(false);

        container1.add(orderComboBox);
        container1.add(numberLabel);
        container1.add(numberTextField);
        container1.add(dateLabel);
        container1.add(dateTextField);
        container1.add(contentLabel);
        container1.add(contentScrollPane);
        container1.add(headLabel);
        container1.add(headScrollPane);
        container1.add(eventComboBox);
        container1.add(eventLabel);
        container1.add(eventScrollPane);
        container1.add(responsibleManLabel);
        container1.add(responsibleManScrollPane);
        container1.add(dateEventLabel);
        container1.add(dateEventTextField);
        container1.add(markLabel);
        container1.add(markComboBox);
        container1.add(change1Button);

        container2.add(correspondentComboBox);
        container2.add(fioLabel);
        container2.add(fioTextField);
        container2.add(positionLabel);
        container2.add(positionTextField);
        container2.add(divisionLabel);
        container2.add(divisionTextField);
        container2.add(change2Button);

        final int width1=300;
        final int width2=190;

        layout.putConstraint(SpringLayout.NORTH, orderComboBox, 5, SpringLayout.NORTH, container1);
        layout.putConstraint(SpringLayout.WEST, orderComboBox, 5, SpringLayout.WEST, container1);
        layout.putConstraint(SpringLayout.SOUTH, orderComboBox, 0, SpringLayout.SOUTH, numberTextField);
        layout.putConstraint(SpringLayout.EAST, orderComboBox, -15, SpringLayout.WEST, numberLabel);
        layout.putConstraint(SpringLayout.NORTH, numberLabel, 5, SpringLayout.NORTH, container1);
        layout.putConstraint(SpringLayout.WEST, numberLabel, width2, SpringLayout.WEST, container1);
        layout.putConstraint(SpringLayout.NORTH, numberTextField, 5, SpringLayout.NORTH, container1);
        layout.putConstraint(SpringLayout.WEST, numberTextField, width1, SpringLayout.WEST, container1);
        layout.putConstraint(SpringLayout.NORTH, dateLabel, 5, SpringLayout.SOUTH, numberTextField);
        layout.putConstraint(SpringLayout.WEST, dateLabel, width2, SpringLayout.WEST, container1);
        layout.putConstraint(SpringLayout.NORTH, dateTextField, 5, SpringLayout.SOUTH, numberTextField);
        layout.putConstraint(SpringLayout.WEST, dateTextField, 0, SpringLayout.WEST, numberTextField);
        layout.putConstraint(SpringLayout.NORTH, contentLabel, 5, SpringLayout.SOUTH, dateTextField);
        layout.putConstraint(SpringLayout.WEST, contentLabel, width2, SpringLayout.WEST, container1);
        layout.putConstraint(SpringLayout.NORTH, contentScrollPane, 5, SpringLayout.SOUTH, dateTextField);
        layout.putConstraint(SpringLayout.WEST, contentScrollPane, 0, SpringLayout.WEST, dateTextField);
        layout.putConstraint(SpringLayout.NORTH, headLabel, 5, SpringLayout.SOUTH, contentScrollPane);
        layout.putConstraint(SpringLayout.WEST, headLabel, width2, SpringLayout.WEST, container1);
        layout.putConstraint(SpringLayout.NORTH, headScrollPane, 5, SpringLayout.SOUTH, contentScrollPane);
        layout.putConstraint(SpringLayout.WEST, headScrollPane, 0, SpringLayout.WEST, contentScrollPane);
        layout.putConstraint(SpringLayout.NORTH, eventComboBox, 0, SpringLayout.NORTH, eventScrollPane);
        layout.putConstraint(SpringLayout.WEST, eventComboBox, 5, SpringLayout.WEST, container1);
        layout.putConstraint(SpringLayout.SOUTH, eventComboBox, 20, SpringLayout.NORTH, eventComboBox);
        layout.putConstraint(SpringLayout.EAST, eventComboBox, -20, SpringLayout.WEST, eventLabel);
        layout.putConstraint(SpringLayout.NORTH, eventLabel, 20, SpringLayout.SOUTH, headScrollPane);
        layout.putConstraint(SpringLayout.WEST, eventLabel, width2, SpringLayout.WEST, container1);
        layout.putConstraint(SpringLayout.NORTH, eventScrollPane, 20, SpringLayout.SOUTH, headScrollPane);
        layout.putConstraint(SpringLayout.WEST, eventScrollPane, 0, SpringLayout.WEST,headScrollPane);
        layout.putConstraint(SpringLayout.NORTH, responsibleManLabel, 5, SpringLayout.SOUTH, eventScrollPane);
        layout.putConstraint(SpringLayout.WEST, responsibleManLabel, width2, SpringLayout.WEST, container2);
        layout.putConstraint(SpringLayout.NORTH, responsibleManScrollPane, 5, SpringLayout.SOUTH, eventScrollPane);
        layout.putConstraint(SpringLayout.WEST, responsibleManScrollPane, 0, SpringLayout.WEST, eventScrollPane);
        layout.putConstraint(SpringLayout.NORTH, dateEventLabel, 5, SpringLayout.SOUTH, responsibleManScrollPane);
        layout.putConstraint(SpringLayout.WEST, dateEventLabel, width2, SpringLayout.WEST, container1);
        layout.putConstraint(SpringLayout.NORTH, dateEventTextField, 5, SpringLayout.SOUTH, responsibleManScrollPane);
        layout.putConstraint(SpringLayout.WEST, dateEventTextField, 0, SpringLayout.WEST, responsibleManScrollPane);
        layout.putConstraint(SpringLayout.NORTH, markLabel, 5, SpringLayout.SOUTH, dateEventTextField);
        layout.putConstraint(SpringLayout.WEST, markLabel, width2, SpringLayout.WEST, container2);
        layout.putConstraint(SpringLayout.NORTH, markComboBox, 5, SpringLayout.SOUTH, dateEventTextField);
        layout.putConstraint(SpringLayout.WEST, markComboBox, 0, SpringLayout.WEST, dateEventTextField);
        layout.putConstraint(SpringLayout.NORTH, change1Button, 5, SpringLayout.SOUTH, markComboBox);
        layout.putConstraint(SpringLayout.WEST, change1Button, width1+50, SpringLayout.WEST, container1);

        layout.putConstraint(SpringLayout.WEST, correspondentComboBox, 0, SpringLayout.WEST, fioTextField);
        layout.putConstraint(SpringLayout.EAST, correspondentComboBox, 0, SpringLayout.EAST, fioTextField);
        layout.putConstraint(SpringLayout.NORTH, correspondentComboBox, 160, SpringLayout.NORTH, container2);
        layout.putConstraint(SpringLayout.NORTH, fioLabel, 200, SpringLayout.NORTH, container2);
        layout.putConstraint(SpringLayout.WEST, fioLabel, width2, SpringLayout.WEST, container2);
        layout.putConstraint(SpringLayout.NORTH, fioTextField,200, SpringLayout.NORTH, container2);
        layout.putConstraint(SpringLayout.WEST, fioTextField, width1, SpringLayout.WEST, container2);
        layout.putConstraint(SpringLayout.NORTH, positionLabel, 5, SpringLayout.SOUTH, fioTextField);
        layout.putConstraint(SpringLayout.WEST, positionLabel, 0, SpringLayout.WEST, fioLabel);
        layout.putConstraint(SpringLayout.NORTH, positionTextField, 5, SpringLayout.SOUTH, fioTextField);
        layout.putConstraint(SpringLayout.WEST, positionTextField, 0, SpringLayout.WEST, fioTextField);
        layout.putConstraint(SpringLayout.NORTH, divisionLabel, 5, SpringLayout.SOUTH, positionTextField);
        layout.putConstraint(SpringLayout.WEST, divisionLabel, 0, SpringLayout.WEST, positionLabel);
        layout.putConstraint(SpringLayout.NORTH, divisionTextField, 5, SpringLayout.SOUTH, positionTextField);
        layout.putConstraint(SpringLayout.WEST, divisionTextField, 0, SpringLayout.WEST, positionTextField);
        layout.putConstraint(SpringLayout.NORTH, change2Button, 10, SpringLayout.SOUTH, divisionTextField);
        layout.putConstraint(SpringLayout.WEST, change2Button, 50, SpringLayout.WEST, divisionTextField);

        tabbedPane.addTab("Приказ", container1);
        tabbedPane.addTab("Корреспондент", container2);

        orderComboBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                numberLabel.setForeground(Color.BLACK);
                dateLabel.setForeground(Color.BLACK);
                dateTextField.setEnabled(true);
                contentLabel.setForeground(Color.BLACK);
                contentTextArea.setEnabled(true);
                headLabel.setForeground(Color.BLACK);
                headTextArea.setEnabled(true);
                eventComboBox.setEnabled(true);
                ArrayList<String> information=controller.getInformationAboutOrder((String) orderComboBox.getSelectedItem());
                numberTextField.setText(information.get(0));
                dateTextField.setText(information.get(1));
                contentTextArea.setText(information.get(2));
                headTextArea.setText(information.get(3));
                String[] listEvents=controller.getListEvents(numberTextField.getText());
                eventComboBox.setModel(new DefaultComboBoxModel(listEvents));
            }
        });
        eventComboBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                eventLabel.setForeground(Color.BLACK);
                eventTextArea.setEnabled(true);
                responsibleManLabel.setForeground(Color.BLACK);
                responsibleManTextArea.setEnabled(true);
                dateEventLabel.setForeground(Color.BLACK);
                dateEventTextField.setEnabled(true);
                markLabel.setForeground(Color.BLACK);
                markComboBox.setEnabled(true);
                ArrayList<String> information=controller.getInformationAboutEvent((String)eventComboBox.getSelectedItem());
                eventTextArea.setText(information.get(0));
                responsibleManTextArea.setText(information.get(3));
                dateEventTextField.setText(information.get(1));
                if(information.get(2).equals("Y"))
                    markComboBox.setSelectedIndex(0);
                else
                    markComboBox.setSelectedIndex(1);
                change1Button.setEnabled(true);
            }
        });
        correspondentComboBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                fioLabel.setForeground(Color.BLACK);
                positionLabel.setForeground(Color.BLACK);
                divisionLabel.setForeground(Color.BLACK);
                fioTextField.setEnabled(true);
                positionTextField.setEnabled(true);
                divisionTextField.setEnabled(true);
                change2Button.setEnabled(true);
                ArrayList<String> information=controller.getInformationAboutCorr((String) correspondentComboBox.getSelectedItem());
                fioTextField.setText(information.get(0));
                positionTextField.setText(information.get(1));
                divisionTextField.setText(information.get(2));
            }
        });
        change1Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean answer=true;
                String number=numberTextField.getText();
                String date=dateTextField.getText();
                String content=contentTextArea.getText();
                String head=headTextArea.getText().split("\n")[0];
                String event=eventTextArea.getText();
                String responsibleMan=responsibleManTextArea.getText();
                String dateEvent=dateEventTextField.getText();
                String mark=markComboBox.getSelectedItem()=="Да"? "Y":"N";
                answer=controller.changeOrder(number, date, content, head, event, responsibleMan, dateEvent, mark);
                if(answer=false)
                    showErrorMessage();
                else
                {
                    numberLabel.setForeground(Color.GRAY);
                    numberTextField.setText("");
                    dateLabel.setForeground(Color.GRAY);
                    dateTextField.setEnabled(false);
                    dateTextField.setText("");
                    contentLabel.setForeground(Color.GRAY);
                    contentTextArea.setEnabled(false);
                    contentTextArea.setText("");
                    headLabel.setForeground(Color.GRAY);
                    headTextArea.setEnabled(false);
                    headTextArea.setText("ФИО\nподразделение\nдолжность");
                    eventComboBox.setEnabled(false);
                    eventComboBox.setModel(new DefaultComboBoxModel());
                    eventLabel.setForeground(Color.GRAY);
                    eventTextArea.setEnabled(false);
                    eventTextArea.setText("");
                    responsibleManLabel.setForeground(Color.GRAY);
                    responsibleManTextArea.setEnabled(false);
                    responsibleManTextArea.setText("");
                    dateEventLabel.setForeground(Color.GRAY);
                    dateEventTextField.setEnabled(false);
                    dateEventTextField.setText("");
                    markLabel.setForeground(Color.GRAY);
                    markComboBox.setSelectedIndex(0);
                    markComboBox.setEnabled(false);
                    change2Button.setEnabled(false);
                }
            }
        });
        change2Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String oldfio=(String)correspondentComboBox.getSelectedItem();
                String fio=fioTextField.getText();
                String position=positionTextField.getText();
                String division=divisionTextField.getText();
                boolean answer=controller.changeCorrespondent(oldfio, fio, division, position);
                if(answer==false)
                    showErrorMessage();
                else
                {
                    if(!fio.equals(oldfio))
                    {
                        int index=correspondentComboBoxModel.getIndexOf(correspondentComboBoxModel.getSelectedItem());
                        correspondentComboBoxModel.removeElementAt(index);
                        correspondentComboBoxModel.insertElementAt(fio, index);
                        correspondentComboBoxModel.setSelectedItem(fio);
                    }
                    fioLabel.setForeground(Color.GRAY);
                    positionLabel.setForeground(Color.GRAY);
                    divisionLabel.setForeground(Color.GRAY);
                    fioTextField.setText("");
                    positionTextField.setText("");
                    divisionTextField.setText("");
                    fioTextField.setEnabled(false);
                    positionTextField.setEnabled(false);
                    divisionTextField.setEnabled(false);
                    change2Button.setEnabled(false);
                }
            }
        });

        mainContainer.add(tabbedPane);

        revalidate();
        repaint();
    }

    private void deleteDate()
    {
        JTabbedPane tabbedPane=new JTabbedPane();

        Container container1=new Container();
        Container container2=new Container();

        container1.setLayout(layout);
        container2.setLayout(layout);

        JLabel numberLabel=new JLabel("Номер приказа:");
        numberLabel.setForeground(Color.BLACK);

        JButton delete1Button=new JButton("Удалить");
        delete1Button.setEnabled(false);
        JButton delete2Button=new JButton("Удалить");
        delete2Button.setEnabled(false);

        JComboBox orderComboBox=new JComboBox(controller.getListOrders());
        JComboBox correspondentComboBox=new JComboBox(controller.getListCorrespondents());
        JComboBox eventComboBox=new JComboBox();
        eventComboBox.setEnabled(false);
        eventComboBox.setPreferredSize(new Dimension(0, 20));

        container1.add(numberLabel);
        container1.add(orderComboBox);
        container1.add(delete1Button);
        container1.add(eventComboBox);
        container2.add(correspondentComboBox);
        container2.add(delete2Button);

        layout.putConstraint(SpringLayout.NORTH, numberLabel, 150, SpringLayout.NORTH, container1);
        layout.putConstraint(SpringLayout.WEST, numberLabel, 300, SpringLayout.WEST, container1);
        layout.putConstraint(SpringLayout.NORTH, orderComboBox, 0, SpringLayout.NORTH, numberLabel);
        layout.putConstraint(SpringLayout.WEST, orderComboBox, 5, SpringLayout.EAST, numberLabel);
        layout.putConstraint(SpringLayout.SOUTH, orderComboBox, 0, SpringLayout.SOUTH, numberLabel);
        layout.putConstraint(SpringLayout.NORTH, eventComboBox, 10, SpringLayout.SOUTH, numberLabel);
        layout.putConstraint(SpringLayout.WEST, eventComboBox, 0, SpringLayout.WEST, numberLabel);
        layout.putConstraint(SpringLayout.EAST, eventComboBox, 0, SpringLayout.EAST, orderComboBox);
        layout.putConstraint(SpringLayout.NORTH, delete1Button, 10, SpringLayout.SOUTH, eventComboBox);
        layout.putConstraint(SpringLayout.WEST, delete1Button, 25, SpringLayout.WEST, eventComboBox);

        layout.putConstraint(SpringLayout.NORTH, correspondentComboBox, 180, SpringLayout.NORTH, container2);
        layout.putConstraint(SpringLayout.WEST, correspondentComboBox, 280, SpringLayout.WEST, container2);
        layout.putConstraint(SpringLayout.NORTH, delete2Button, 10, SpringLayout.SOUTH, correspondentComboBox);
        layout.putConstraint(SpringLayout.WEST, delete2Button, 60, SpringLayout.WEST, correspondentComboBox);

        orderComboBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String[] events=controller.getListEvents((String) orderComboBox.getSelectedItem());
                String[] optionsToChoose=new String[events.length+2];
                optionsToChoose[0]="Удалить приказ";
                optionsToChoose[1]="Удалить мероприятия";
                if(events.length!=0)
                    for(int i=2; i<optionsToChoose.length; i++)
                        optionsToChoose[i]=events[i-2];
                eventComboBox.setModel(new DefaultComboBoxModel(optionsToChoose));
                eventComboBox.setEnabled(true);
            }
        });
        eventComboBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                delete1Button.setEnabled(true);
            }
        });
        delete1Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean answer=false;
                String choice=(String)eventComboBox.getSelectedItem();
                if(choice.equals("Удалить приказ"))
                    answer=controller.deleteOrder((String) orderComboBox.getSelectedItem());
                else
                if(choice.equals("Удалить мероприятия"))
                    answer=controller.deleteAllEvents((String) orderComboBox.getSelectedItem());
                else
                    answer=controller.deleteEvent((String) eventComboBox.getSelectedItem());
                if(answer==false)
                    showErrorMessage();
                else
                {
                    orderComboBox.setModel(new DefaultComboBoxModel(controller.getListOrders()));
                    eventComboBox.setModel(new DefaultComboBoxModel());
                    eventComboBox.setEnabled(false);
                    delete1Button.setEnabled(false);
                }
            }
        });
        correspondentComboBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                delete2Button.setEnabled(true);
            }
        });
        delete2Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                boolean answer=controller.deleteCorrespondent((String)correspondentComboBox.getSelectedItem());
                if(answer==false)
                    showErrorMessage();
                else
                {
                    correspondentComboBox.setModel(new DefaultComboBoxModel(controller.getListCorrespondents()));
                    delete2Button.setEnabled(false);
                }
            }
        });

        tabbedPane.addTab("Приказ", container1);
        tabbedPane.addTab("Корреспондент", container2);

        mainContainer.add(tabbedPane);

        revalidate();
        repaint();
    }

    private void showErrorMessage()
    {
        JOptionPane.showMessageDialog(this,"Возникли проблемы соединения с базой данных","Ошибка", JOptionPane.ERROR_MESSAGE);
    }
}