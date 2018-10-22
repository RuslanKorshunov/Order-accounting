package View;

import Controller.Controller;
import Controller.JDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame
{
    private final int WIDTH=800;
    private final int HEIGHT=600;
    private Container container;
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

        container=this.getContentPane();
        layout=new SpringLayout();

        JMenuBar jMenuBar=new JMenuBar();
        JMenu add=new JMenu("Добавить");
        add.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                addNewData();
            }
        });
        JMenu edit=new JMenu("Редактировать");
        JMenu delete=new JMenu("Удалить");
        JMenu search=new JMenu("Поиск");
        jMenuBar.add(add);
        jMenuBar.add(edit);
        jMenuBar.add(delete);
        jMenuBar.add(search);
        setJMenuBar(jMenuBar);
        addNewData();

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
        container1.add(add1Button);

        container2.add(fioLabel);
        container2.add(fioTextField);
        container2.add(positionLabel);
        container2.add(positionTextField);
        container2.add(divisionLabel);
        container2.add(divisionTextField);
        container2.add(add2Button);

        final int width1=this.getWidth()/3;
        final int width2=170;

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

        layout.putConstraint(SpringLayout.NORTH, eventLabel, 15, SpringLayout.SOUTH, headScrollPane);
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
                String mark=markComboBox.getSelectedIndex()==0?"Y":"N";
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
                    answer=controller.addNewReport(number, date, content, head, event, responsibleMan, dateEvent, mark);
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

        container.add(tabbedPane);

        revalidate();
        repaint();
    }

    private void showErrorMessage()
    {
        JOptionPane.showMessageDialog(this,"Возникли проблемы соединения с базой данных","Ошибка", JOptionPane.ERROR_MESSAGE);
    }
}