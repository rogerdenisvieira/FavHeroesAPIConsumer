# FavHeroesAPIConsumer
An application designed to consume Marvel's Superheroes API.

## Maven Installed

These commands just work if you're running an installed version of Maven. To use its standalone version, jump to next section.

### Solving Dependencies
In both operation systems, Windows and Linux, navigate until application's folder and run the following commands:

```
> mvn clean 
> mvn install
```
### Running the Application 
As in previously command, navigate to application's folder, so type the command:

```
> mvn spring-boot:run
```

### Accessing Application

To access the application's home, open a regular web browser and put the address as follows:

http://localhost:8080/

Comics's page is available by an hyperlink below character's description, however you can access it directly by typing the following URL in your browser:

http://localhost:8080/characters/1009368/comics

**Note:** in this case, ID 1009368 refers to Iron Man comics page.

## Using Maven Wrapper

These instructions are designated to machines that don't have Apache Maven installed. In this case, to run Maven commands, navigate to application's folder, so you're supposed to find two files called **mvnw** and **mvnw.cmd**. The first one is a Linux's standalone version of Maven, to use as following:

```
> ./mvnw <your_command_here>
```

The second one is a version of Maven Wrapper to use in Windows operation system. Similary to first one, just run following commands:

```
> cmd mvnw.cmd <your_command_here>
```