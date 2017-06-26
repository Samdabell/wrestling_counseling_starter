package example.codeclan.com.wrestling;

import java.util.Scanner;

/**
 * Created by Sam on 26/06/2017.
 */

public class Runner {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        Subject.getAllNameId();
        System.out.println("Select a subject number");
        Integer choice = Integer.valueOf(sc.nextLine());
        Subject.getSubjectInfo(choice);


    }

}
