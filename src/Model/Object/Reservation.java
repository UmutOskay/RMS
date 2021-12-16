package Model.Object;

public class Reservation {

    private String student_id;
    private int room_id;
    private String time_slot;

    public Reservation(){}

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getTime_slot() {
        return time_slot;
    }

    public void setTime_slot(String time_slot) {
        this.time_slot = time_slot;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "student_id='" + student_id + '\'' +
                ", room_id=" + room_id +
                ", time_slot='" + time_slot + '\'' +
                '}';
    }
}
