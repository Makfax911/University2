package com.example.University2.db;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    Scanner scanner=new Scanner(System.in);
    Query query=new Query();

    public Menu() throws SQLException, ClassNotFoundException {
    }

    public void menuItem() throws SQLException, ClassNotFoundException {

        System.out.println("1. Head of department name\n" +
                           "2. Show department name statistics\n" +
                           "3. Show the average salary for the department\n" +
                           "4. Show count of employee\n" +
                           "5. Global search");

            int menu=scanner.nextInt();
            switch (menu){

                case 1:
                    query.getDepartmentName();
                    break;
                case 2:
                    query.getStatistic();
                    break;
                case 3:
                    query.averageSalary();
                    break;
                case 4:
                    query.countEmployee();;
                    break;
                case 5:
                    query.globalSearch();
                    break;
                default:
                    System.exit(0);
        }
    }
}
