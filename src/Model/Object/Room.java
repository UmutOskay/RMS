package Model.Object;

public class Room {

    private int room_id;
    private String room_location;
    private boolean is_available_at_08;
    private boolean is_available_at_09;
    private boolean is_available_at_10;
    private boolean is_available_at_11;
    private boolean is_available_at_12;
    private boolean is_available_at_13;
    private boolean is_available_at_14;
    private boolean is_available_at_15;
    private boolean is_available_at_16;
    private boolean is_available_at_17;

    public Room(){}

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getRoom_location() {
        return room_location;
    }

    public void setRoom_location(String room_location) {
        this.room_location = room_location;
    }

    public boolean isIs_available_at_08() {
        return is_available_at_08;
    }

    public void setIs_available_at_08(boolean is_available_at_08) {
        this.is_available_at_08 = is_available_at_08;
    }

    public boolean isIs_available_at_09() {
        return is_available_at_09;
    }

    public void setIs_available_at_09(boolean is_available_at_09) {
        this.is_available_at_09 = is_available_at_09;
    }

    public boolean isIs_available_at_10() {
        return is_available_at_10;
    }

    public void setIs_available_at_10(boolean is_available_at_10) {
        this.is_available_at_10 = is_available_at_10;
    }

    public boolean isIs_available_at_11() {
        return is_available_at_11;
    }

    public void setIs_available_at_11(boolean is_available_at_11) {
        this.is_available_at_11 = is_available_at_11;
    }

    public boolean isIs_available_at_12() {
        return is_available_at_12;
    }

    public void setIs_available_at_12(boolean is_available_at_12) {
        this.is_available_at_12 = is_available_at_12;
    }

    public boolean isIs_available_at_13() {
        return is_available_at_13;
    }

    public void setIs_available_at_13(boolean is_available_at_13) {
        this.is_available_at_13 = is_available_at_13;
    }

    public boolean isIs_available_at_14() {
        return is_available_at_14;
    }

    public void setIs_available_at_14(boolean is_available_at_14) {
        this.is_available_at_14 = is_available_at_14;
    }

    public boolean isIs_available_at_15() {
        return is_available_at_15;
    }

    public void setIs_available_at_15(boolean is_available_at_15) {
        this.is_available_at_15 = is_available_at_15;
    }

    public boolean isIs_available_at_16() {
        return is_available_at_16;
    }

    public void setIs_available_at_16(boolean is_available_at_16) {
        this.is_available_at_16 = is_available_at_16;
    }

    public boolean isIs_available_at_17() {
        return is_available_at_17;
    }

    public void setIs_available_at_17(boolean is_available_at_17) {
        this.is_available_at_17 = is_available_at_17;
    }

    // Remove afterwards, most probably not needed
    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", room_location='" + room_location + '\'' +
                ", is_available_at_08=" + is_available_at_08 +
                ", is_available_at_09=" + is_available_at_09 +
                ", is_available_at_10=" + is_available_at_10 +
                ", is_available_at_11=" + is_available_at_11 +
                ", is_available_at_12=" + is_available_at_12 +
                ", is_available_at_13=" + is_available_at_13 +
                ", is_available_at_14=" + is_available_at_14 +
                ", is_available_at_15=" + is_available_at_15 +
                ", is_available_at_16=" + is_available_at_16 +
                ", is_available_at_17=" + is_available_at_17 +
                '}';
    }

    public int getSize(){
        return 12;
    }
}
