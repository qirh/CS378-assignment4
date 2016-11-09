create cs378_almto3;
use cs378_almto3;

create table Projects(name varchar(255) NOT NULL, descrption varchar(255) NOT NULL, project_id int NOT NULL AUTO_INCREMENT, PRIMARY KEY(project_id));

insert into Projects(name, description) values("Data Management", "Data Managment course");
insert into Projects(name, description) values("Modern Web Apps", "Dr. dev's class");

select * from Projects;