INSERT INTO user(faculty_id,user_fullname,user_mail,user_password,is_admin,is_banned,banned_until,time_slots_left)VALUES
('S017812','Sefa Yapici','sefa.yapici@ozu.edu.tr','dNKiZG8N3skhsdHA4SHynQ==',1,0,null,3), 		  	 /* password is admin1234  */
('S017813','Umut Oskay','umut.oskay@ozu.edu.tr','BliIxTqWFO7ku5ZfxEFroA==',0,0,null,3),                       /* password is user1234  */
('S017815','Hasan Umut Suluhan','umut.suluhan@ozu.edu.tr','PfkVfvlBzhcBOOJiJvNvcg==',0,0,null,3),             /* password is user2234  */
('S017819','Selami Karakaş','selami.karakas@ozu.edu.tr','wr1lUl2VuSqy537aLNc2hQ==',0,0,null,3);		 /* password is user3234  */

INSERT INTO room(room_id,room_location,is_available_at_08,is_available_at_09,is_available_at_10,is_available_at_11,is_available_at_12,is_available_at_13,is_available_at_14,is_available_at_15,is_available_at_16,is_available_at_17)VALUES
(241,"AB1",0,0,0,0,0,0,0,0,0,0),
(242,"AB1",0,0,0,0,0,0,0,0,0,0),
(243,"AB1",0,0,0,0,0,0,0,0,0,0),
(103,"AB2",0,0,0,0,0,0,0,0,0,0),
(104,"AB2",0,0,0,0,0,0,0,0,0,0),
(105,"AB2",0,0,0,0,0,0,0,0,0,0),
(351,"AB3",0,0,0,0,0,0,0,0,0,0),
(352,"AB3",0,0,0,0,0,0,0,0,0,0),
(353,"AB3",0,0,0,0,0,0,0,0,0,0);

#INSERT INTO reservations(student_id,room_id,time_slot,time_of_reservation)VALUES
	
