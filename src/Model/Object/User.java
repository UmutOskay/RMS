package Model.Object;

public class User {

    private String faculty_id;
    private String user_full_name;
    private String user_mail;
    private boolean is_admin;
    private boolean is_banned;
    private int left_slots;
    private String banned_until;



    public User(){}

    public String getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(String faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getUser_full_name() {
        return user_full_name;
    }

    public void setUser_full_name(String user_full_name) {
        this.user_full_name = user_full_name;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public boolean isIs_banned() {
        return is_banned;
    }

    public void setIs_banned(boolean is_banned) {
        this.is_banned = is_banned;
    }

    public int getLeft_slots() {
        return left_slots;
    }

    public void setLeft_slots(int left_slots) {
        this.left_slots = left_slots;
    }

    public String getBanned_until() {
        return banned_until;
    }

    public void setBanned_until(String banned_until) {
        this.banned_until = banned_until;
    }

    @Override
    public String toString() {
        return "User{" +
                "faculty_id='" + faculty_id + '\'' +
                ", user_full_name='" + user_full_name + '\'' +
                ", user_mail='" + user_mail + '\'' +
                ", is_admin=" + is_admin +
                ", is_banned=" + is_banned +
                ", left_slots=" + left_slots +
                ", banned_until='" + banned_until + '\'' +
                '}';
    }
}
