package example.codeclan.com.wrestling;

import java.sql.ResultSet;

import db.SqlRunner;

/**
 * Created by Sam on 26/06/2017.
 */

public class Subject {



    public Subject(){

    }

    public static void getAllNameId(){
        String sql = ("SELECT id, name FROM subjects;");
        ResultSet rs = SqlRunner.executeQuery(sql);
        try{
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("Subject num: " + id);
                System.out.println("Subject name: " + name);
                System.out.println();
            }
        } catch (Exception ex){
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }

    public static void getSubjectInfo(int num){
        String sql = String.format("SELECT subjects.description, counselors.first_name, counselors.nick_name, counselors.last_name, counselors.member_since, counselors.email, counselors.telephone FROM counselors JOIN subjects ON counselors.id = subjects.counselor_id WHERE subjects.id = '%d';", num);
        ResultSet rs = SqlRunner.executeQuery(sql);
        try{
            while(rs.next()){
                String description = rs.getString("description");
                String first_name = rs.getString("first_name");
                String nick_name = rs.getString("nick_name");
                String last_name = rs.getString("last_name");
                String member_since = rs.getString("member_since");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");
                System.out.println("Subject description: " + description);
                System.out.println(String.format("Counselor name: %s %s %s", first_name, nick_name, last_name));
                System.out.println("Member since: " + member_since);
                System.out.println("Email: " + email);
                System.out.println("Telephone: " + telephone);
            }
        } catch (Exception ex){
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }
}
