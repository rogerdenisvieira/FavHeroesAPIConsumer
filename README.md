# FavHeroesAPIConsumer
A application designed to consume Marver's Superheroes API.

## Maven Installed

These commands just works if you're running a installed version of Maven. To use its standalone version, jump to next section.

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

## Using Maven Wrapper

These instructions are designeted to machines that doesn't have Apache Maven installed. To run Maven command, navigate to application's folder,  so you're supposed to find two files called **mvnw** and **mvnw.cmd**. The first one is a Linux's standalone version of Maven, to use as following:

```
> ./mvnw <your_command_here>
```

The second one is a version of Maven Wrapper to use in Windows operation system. Similary to first one, just run following commands:

```
> cmd mvnw.cmd <your_command_here>
```