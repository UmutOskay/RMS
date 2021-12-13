INSERT INTO user(faculty_id,user_fullname,user_mail,user_password,is_admin,is_banned,time_slots_left)VALUES
('S017812','Sefa Yapici','sefa.yapici@ozu.edu.tr','1234',0,0,3),
('S017813','Umut Oskay','umut.oskay@ozu.edu.tr','1234',0,0,3),
('S017815','Hasan Umut Suluhan','umut.suluhan@ozu.edu.tr','1234',0,0,3),
('S017819','Selami Karakaş','selami.karakas@ozu.edu.tr','1234',0,0,3),
('F000034','Mehmet Ali Alakurt','tefa.yapici@ozu.edu.tr','1234',1,0,3);

INSERT INTO room(room_id,room_location,is_available_at_08,is_available_at_09,is_available_at_10,is_available_at_11,is_available_at_12,is_available_at_13,is_available_at_14,is_available_at_15,is_available_at_16,is_available_at_17)VALUES
(241,"AB1",1,1,1,1,1,1,1,1,1,1),
(242,"AB1",1,1,1,1,1,1,1,1,1,1),
(103,"AB2",1,1,1,1,1,1,1,1,1,1),
(104,"AB2",1,1,1,1,1,1,1,1,1,1),
(351,"AB3",1,1,1,1,1,1,1,1,1,1);

#INSERT INTO reservations(student_id,room_id,time_slot)VALUES
