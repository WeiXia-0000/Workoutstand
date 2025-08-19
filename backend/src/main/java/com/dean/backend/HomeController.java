package com.dean.backend;

import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.aspectj.util.LangUtil.ProcessController.Thrown;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@CrossOrigin
public class HomeController {
    // for sql:
    public static final String URL = "jdbc:mysql://35.223.44.116:3306/WorkOutStand";
    public static final String USER = "root";
    public static final String PASSWORD = "11111111";

    // for login:
    // * 0:no account; 1:login successful
    public static int login_status = 0;
    public static int user_id = 0;
    public static int demand_id = 0;
    public static int get_demand_time = 1;

    @PostMapping("/login_post")
    public String login(@RequestBody String file11) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(file11);
        String username_received = json.get("username").toString();
        String password_received = json.get("password").toString();
        System.out.println("Username: " + username_received + "\nPassword: " + password_received);
        String toReturn = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet sql_result = statement.executeQuery("SELECT userName, userPassword, User_id FROM User "
                    + "WHERE User.userName = " + "\"" + username_received + "\"");
            // Example name: Atwell White, Dusty Martin
            while (sql_result.next()) {
                String userName = sql_result.getString("userName");
                String userPassword = sql_result.getString("userPassword");
                if (password_received.equals(userPassword)) {
                    user_id = sql_result.getInt("User_id");
                    toReturn = "{\"userName\":" + "\"" + userName + "\", " + "\"password\":" + "\"" + userPassword
                            + "\"" + "," + "\"User_id\":" + "\"" + user_id + "\"}";
                    login_status = 1;
                    System.out.println(toReturn);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("111111: " + toReturn);
        return toReturn;

    }

    @PostMapping("/sign_up_post")
    public String sign_up(@RequestBody String file11) throws ParseException, SQLException {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(file11);
        String username_received = json.get("username").toString();
        String password_received = json.get("password").toString();
        String email_received = json.get("email").toString();
        String gender_received = json.get("gender").toString();
        String goal_received_first = json.get("goal_first").toString();
        String goal_received_second = json.get("goal_second").toString();
        String fitnessLevel_received = json.get("fitnessLevel").toString();
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = conn.createStatement();
        ResultSet sql_result = statement.executeQuery("SELECT max(User_id) AS max FROM WorkOutStand.User;");
        sql_result.next();
        user_id = sql_result.getInt("max") + 1;
        ResultSet sql_result_2 = statement.executeQuery("SELECT max(demandId) FROM WorkOutStand.Demands;");
        sql_result_2.next();
        demand_id = sql_result_2.getInt("max(demandId)") + 1;
        String toReturn = "";
        try {
            int age_received = Integer.parseInt(json.get("age").toString());
            int weight_received = Integer.parseInt(json.get("weight").toString());
            int height_received = Integer.parseInt(json.get("height").toString());
            int gymAccess_received = Integer.parseInt(json.get("gymAccess").toString());
            double timeAvailable_received = Double.parseDouble(json.get("timeAvailable").toString());
            System.out.println("Username: " + username_received + "\nPassword: " + password_received + "\nEmail: "
                    + email_received);
            System.out.println("Age: " + String.valueOf(age_received) + "\nGender: " + gender_received + "\nweight: "
                    + String.valueOf(weight_received) + "\nheight: " + String.valueOf(height_received));
            System.out.println("goal: " + goal_received_first + " " + goal_received_second + "\nfitnessLevel: "
                    + fitnessLevel_received + "\ngymAccess: " + String.valueOf(gymAccess_received) + "\ntimeAvailable: "
                    + String.valueOf(timeAvailable_received));
            // Class.forName("com.mysql.cj.jdbc.Driver");
            // insert to user table
            statement.executeUpdate(
                    "INSERT INTO User " + "VALUES(" + String.valueOf(user_id) + "," + "\"" + username_received + "\""
                            + "," + "\"" + email_received + "\"" + "," + "\"" + password_received + "\"" + ")");
            // insert to demands table
            statement.executeUpdate("INSERT INTO Demands " + "VALUES(" + String.valueOf(demand_id) + ","
                    + String.valueOf(user_id) + "," + String.valueOf(age_received) + "," + "\"" + gender_received + "\""
                    + "," + String.valueOf(weight_received) + "," + String.valueOf(height_received) + "," + "\""
                    + goal_received_first + ": " + goal_received_second + "\"" + "," + "\"" + fitnessLevel_received
                    + "\"" + "," + String.valueOf(gymAccess_received) + "," + String.valueOf(timeAvailable_received)
                    + ")");
            // Example name: Atwell White, Dusty Martin
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("222222: " + toReturn);
        return toReturn;
    }

    @PostMapping("/change_password_post")
    public String change_password(@RequestBody String file11) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(file11);
        String new_password_received = json.get("new_password").toString();
        String toReturn = "";
        try {
            int User_Id_received = Integer.parseInt(json.get("User_id").toString());
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            // update demands table
            statement.executeUpdate("UPDATE User" + " SET User.userPassword = " + "\"" + new_password_received + "\""
                    + "WHERE User.User_id = " + String.valueOf(User_Id_received));
            toReturn = "{\"User_id\":" + "\"" + User_Id_received + "\"}";
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("444444: " + toReturn);
        return toReturn;
    }

    @PostMapping("/delete_account_post")
    public String delete_account(@RequestBody String file11) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(file11);
        String toReturn = "";
        try {
            int User_Id_received = Integer.parseInt(json.get("User_id").toString());
            System.out.println("User_id: " + String.valueOf(User_Id_received));
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            // update demands table
            statement.executeUpdate(
                    "DELETE FROM Demands " + "WHERE Demands.User_id = " + String.valueOf(User_Id_received));
            statement.executeUpdate("DELETE FROM User " + "WHERE User.User_id = " + String.valueOf(User_Id_received));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("555555: " + toReturn);
        return toReturn;
    }

    @PostMapping("/sign_out_post")
    public void sign_out() {
        System.out.println("Successfully signed out!");
        login_status = 0;
    }

    @PostMapping("/search_post")
    public String search(@RequestBody String file11) throws SQLException {
        String toReturn = "";
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = conn.createStatement();
        ResultSet sql_result = statement
                .executeQuery("SELECT DISTINCT name FROM WorkOutStand.exercise WHERE name LIKE \"%" + file11 + "%\";");
        while (sql_result.next()) {
            String move = sql_result.getString("name") + "; ";
            toReturn += move;
        }
        return toReturn;
    }

    @PostMapping("/max_age_post")
    public String search() throws SQLException {
        String toReturn = "";
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = conn.createStatement();
        ResultSet sql_result = statement.executeQuery(
                "SELECT userName, age, goal FROM User NATURAL JOIN Demands WHERE age = (SELECT max(age) FROM Demands) LIMIT 1;");
        sql_result.next();
        String move = sql_result.getString("userName") + " is " + sql_result.getString("age")
                + " years old and still wants to do " + sql_result.getString("goal");
        toReturn += move;
        return toReturn;
    }

    @PostMapping("/ge_plan_post")
    public String ge_plan_post(@RequestBody String file11) throws SQLException {
        System.out.println("get_demand_time " + get_demand_time);
        get_demand_time = Integer.parseInt(file11);
        System.out.println("get_demand_time " + get_demand_time);
        String toReturn = "";
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = conn.createStatement();
        ResultSet sql_result = statement.executeQuery(
                "SELECT exercise_plan.exercise_plan_id FROM Demands JOIN exercise_plan ON (Demands.goal = exercise_plan.goal AND Demands.gymAccess = exercise_plan.gymAccess)"
                        + "WHERE Demands.User_id = " + user_id);
        int times = get_demand_time;
        System.out.println("times " + times);
        for (int i = 0; i < times; i += 1) {
            sql_result.next();
        }
        get_demand_time += 1;
        String exercise_plan_id = sql_result.getString("exercise_plan_id");
        ResultSet sql_result2 = statement.executeQuery(
                "SELECT name FROM exercise " + "WHERE exercise_plan_id = " + exercise_plan_id);
        String plan = "";
        while (sql_result2.next()) {
            plan += sql_result2.getString("name") + "; ";
        }
        toReturn = "{\"plan\":" + "\"" + plan + "\", " + "\"get_demand_time\":" + String.valueOf(get_demand_time) + "}";

        return toReturn;
    }

    @PostMapping("/magic_post")
    public String magic() throws SQLException {
        String toReturn = "";
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = conn.createStatement();
        ResultSet sql_result = statement.executeQuery(
                "SELECT exercise_plan.exercise_plan_id, COUNT(exercise_id), exercise_plan.estTime, exercise_plan.goal FROM WorkOutStand.exercise_plan CROSS JOIN WorkOutStand.exercise WHERE exercise_plan.exercise_plan_id = exercise.exercise_plan_id AND exercise_plan.goal = \"Muscle Build: 20kg\" AND exercise_plan.estTime = 3 GROUP BY exercise_plan_id ORDER BY COUNT(exercise_id), exercise_plan.estTime LIMIT 1;");
        sql_result.next();
        String move = "exercise_plan_id is " + sql_result.getString("exercise_plan_id") + " estTime is "
                + sql_result.getString("estTime") + " goal is " + sql_result.getString("goal");
        toReturn += move;
        return toReturn;
    }

    @PostMapping("/new_weight_post")
    public String new_weight_post(@RequestBody String file11) throws SQLException {
        int new_weight = Integer.parseInt(file11);
        String toReturn = "";
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = conn.createStatement();
        statement.executeUpdate("UPDATE Demands" + " SET weight = " + "\"" + new_weight + "\""
                + "WHERE User_id = " + String.valueOf(user_id));
        ResultSet sql_result = statement.executeQuery("SELECT print FROM PrintCongret "
                + "WHERE id = 1 ");
        sql_result.next();
        int print = sql_result.getInt("print");
        if (print == 1) {
            toReturn = "1";
            statement.executeUpdate("UPDATE PrintCongret" + " SET print = 0 "
                    + "WHERE id = 1");
        } else {
            toReturn = "0";
        }
        return toReturn;
    }
}