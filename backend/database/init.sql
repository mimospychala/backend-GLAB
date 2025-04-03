CREATE DATABASE db_todo_list;
DROP USER IF EXISTS db_todo_list;
CREATE USER 'db_todo_list' IDENTIFIED BY 'Pass4CRUD2020';
GRANT ALL PRIVILEGES ON TABLE `db_todo_list`.* TO 'db_todo_list';
