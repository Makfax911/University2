package com.example.University2.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Query {
    Scanner scanner=new Scanner(System.in);
    Statement statement=DatabaseHandler.getDbConnection().createStatement();

    public Query() throws SQLException, ClassNotFoundException {
    }

    public void getDepartmentName() throws SQLException, ClassNotFoundException {

        System.out.println("Enter department: ");
        String department=scanner.nextLine();
        String queryHeaderDep = "SELECT head_departments FROM departments WHERE department_name='"+department+"'";


        ResultSet resultSet=statement.executeQuery(queryHeaderDep);

        while (resultSet.next()){
                String head_departments=resultSet.getString("head_departments");
               System.out.println("Head of "+department+" department is "+head_departments+"");
            }
        statement.close();
    }
    public void getStatistic() throws SQLException, ClassNotFoundException {
        String statisticAssistant="SELECT COUNT(*) FROM lectors WHERE degree = 'assistant'";
        String statisticAssociateProfessors="SELECT COUNT(*) FROM lectors WHERE degree = 'associate professors'";
        String statisticProfessors="SELECT COUNT(*) FROM lectors WHERE degree = 'professor'";


        ResultSet resultSetAssistant=statement.executeQuery(statisticAssistant);
        while (resultSetAssistant.next()){
            int assistant=resultSetAssistant.getInt(1);
            System.out.println( "Answer:\nassistans - "+assistant);
        }

        ResultSet resultSetAssistantProf=statement.executeQuery(statisticAssociateProfessors);
        while (resultSetAssistantProf.next()){
            int assistantProf=resultSetAssistantProf.getInt(1);
            System.out.println( "associate professors - "+assistantProf);
        }

        ResultSet resultSetProf=statement.executeQuery(statisticProfessors);
        while (resultSetProf.next()){
            int professors=resultSetProf.getInt(1);
            System.out.println( "professors -"+professors);
        }
        statement.close();
    }
    public void averageSalary() throws SQLException {
        System.out.println("Enter department: ");
        String department=scanner.nextLine();
        String salaryDep="SELECT AVG(salary) FROM departments WHERE department_name='"+department+"'" ;

        ResultSet resultSetProf=statement.executeQuery(salaryDep);
        while (resultSetProf.next()){
            int avgSalary=resultSetProf.getInt(1);
            System.out.println("The average salary of "+department+" is "+avgSalary+"");
        }
        statement.close();
    }
    public void countEmployee () throws SQLException {
        String countEmp="SELECT COUNT(lectors_name) FROM lectors";

        ResultSet resultSetProf=statement.executeQuery(countEmp);
        while (resultSetProf.next()){
            int allEmp=resultSetProf.getInt(1);
            System.out.println(allEmp);
        }
        statement.close();
    }
    public void globalSearch() throws SQLException {
        System.out.println("Enter the word you want to search for");
        String searchWord=scanner.nextLine();
        String search="SELECT * FROM lectors WHERE lectors_name LIKE '%"+searchWord+"%' ;";

        ResultSet resultSetProf=statement.executeQuery(search);
        while (resultSetProf.next()){
            String findWord=resultSetProf.getString("lectors_name");
            System.out.println(findWord);
        }
        statement.close();
    }
}
