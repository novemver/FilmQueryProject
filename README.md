# Film Query Application

## Description
The Film Query Application displays a three option menu when started. The User is prompted to select from three options. 
<ol>
<li>The first option will prompt the User for a film ID to be entered which will then be displayed.
</li>
<li>
The second option will prompt the User to enter a keyword, which will then display all films containing User enters keyword for each film title or description said keyword is found. 
</li>
<li>
The third option will Exit the application.
</li>
</ol>
After each User query, the menu continues to display until the User selects option 3 to quit.
Each time a film is displayed for either selection 1 or 2, the film information displayed will include:<ul> <li>The Film ID</li> <li>Film Title</li><li>Year of Film Release</li><li>Film Rating</li><li>A Description of the Film</li> <li>The Language the Film is in</li> <li>Cast members of selected FIlm</li></ul>
Invalid User entries will be reported back to User to try again.


## Technologies Used
<ul>
<li>Java</li><li>SQL</li><li>Maven</li>
</ul>


## Lesson Learned 
In this application, I am practicing Object-Relational Mapping (ORM) and understanding the processes involved.
ORM is how information from a database is translated and used in an Object Oriented programming language application. 
In my Film Query Application, I am selecting information from an SQL database of Film tables and data. I implement a "Driver Manager" method which will accept my Query in string form. My query is a SQL statement to find, join, and select the data needed. I plug this SQL query statement into into my Java file: "Database Accessor Object". 
With my returned query, I can then create objects to interact with the data pulled from the SQL database.

I am learning how to search and retrieve desired data from a SQL Database with query statements to select information from one or multiple tables, how to JOIN tables and find corresponding data with Primary Keys and Foreign Keys. I can narrow down query criteria further with clauses to select data based pattern matching or User input.