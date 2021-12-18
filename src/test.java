import Model.Object.Reservation;
import Model.Object.Room;
import Model.Object.User;
import Model.Services.DisplayService;
import Model.Services.LoginService;
import Model.Services.UpdateService;

import java.sql.SQLException;
import java.util.ArrayList;

public class test {

    public static void main(String[] args) throws SQLException {
        LoginService ls = new LoginService();
        DisplayService ds = new DisplayService();
        UpdateService us = new UpdateService();

        System.out.println(ls.validate_user("t000034", "admin1234"));
        System.out.println(ls.validate_user("f000034", "admin1234"));
        System.out.println(ls.validate_user("s017812", "user4234"));

        ArrayList<User> users = ds.displayUser();
        for(User item: users){
            System.out.println(item);
        }

        ArrayList<Room> rooms = ds.displayRoom();
        for(Room item: rooms){
            System.out.println(item);
        }

        ArrayList<Reservation> reservations = ds.displayReservations();
        for(Reservation item: reservations){
            System.out.println(item);
        }

        us.reservation("F000034", 241, "8-9");
        us.reservation("F000034", 242, "8-9");
        us.reservation("F000034", 244, "9-10");
        us.reservation("S017812", 242, "9-10");
        us.reservation("S017812", 103, "10-11");
        us.reservation("S017812", 151, "11-12");
        us.reservation("S017812", 104, "12-13");
    }

}
