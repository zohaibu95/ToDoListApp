# ToDoListApp
It is a Java EE application developed By me for an evaluation task which basically create/delete/update/view the to do list task. You can manage your to-do list task via this app. 

Salient features of this app (for evaluation) are as under:
 - Followed MVC architecture
 - Has DAO pattern
 - Using Oracle 11g DBMS
 - Ui is quite simple just for evaluation. 
 - Used JSP/Servlets/JSTL tags
 
 I have used parametrized queries to avoid SQL injection. Queries which i have used for create/delete/update/view/delete all are as under
 
 1. INSERT INTO \"DEMO\".\"TODO_LIST\" (NOTE_SUBJECT, NOTE_DESCRIPTION) VALUES (?, ?)
 2. DELETE FROM \"DEMO\".\"TODO_LIST\" WHERE ID=?
 3. UPDATE \"DEMO\".\"TODO_LIST\" SET NOTE_SUBJECT=?, NOTE_DESCRIPTION=? WHERE ID=?
 4. SELECT * FROM \"DEMO\".\"TODO_LIST\"
 5. SELECT * FROM \"DEMO\".\"TODO_LIST\" WHERE ID=?
 6. DELETE FROM \"DEMO\".\"TODO_LIST\"

Proper naming convention is used.
If you have any question do contact me on zohaib.ahmed.khan@outlook.com
