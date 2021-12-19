DROP TABLE IF EXISTS reservations;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS room;



CREATE TABLE IF NOT EXISTS user(
	#user_index int auto_increment not null,
    faculty_id VARCHAR(10) unique not null,
    user_fullname MEDIUMTEXT not null,
    user_mail VARCHAR(30)  unique not null,
    user_password LONGTEXT not null,
    is_admin BOOLEAN not null,
    is_banned BOOLEAN not null,
    time_slots_left int not null,
    banned_at date, 
    PRIMARY KEY (faculty_id)
    );
CREATE TABLE IF NOT EXISTS room(
	room_id int not null,
    room_location MEDIUMTEXT not null,
    is_available_at_08 BOOLEAN not null,
    is_available_at_09 BOOLEAN not null,
    is_available_at_10 BOOLEAN not null,
    is_available_at_11 BOOLEAN not null,
    is_available_at_12 BOOLEAN not null,
    is_available_at_13 BOOLEAN not null,
    is_available_at_14 BOOLEAN not null,
    is_available_at_15 BOOLEAN not null,
    is_available_at_16 BOOLEAN not null,
    is_available_at_17 BOOLEAN not null,
	PRIMARY KEY (room_id)
);    
CREATE TABLE IF NOT EXISTS reservations(
	faculty_id VARCHAR(10) not null,
    room_id int not null,
    time_slot MEDIUMTEXT not null,
    time_of_reservation TIMESTAMP not null, 
    reservation_timeslot TIMESTAMP not null,
    FOREIGN KEY (faculty_id) REFERENCES user(faculty_id),
    FOREIGN KEY (room_id) REFERENCES room(room_id)
	
);

