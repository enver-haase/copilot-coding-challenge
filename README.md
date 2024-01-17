# Github Copilot Coding Challenge
This is a playground project for testing out Github Copilot with Vaadin Flow.

Clone this repo. Create

For more information you can refer to this Google Docs document: https://docs.google.com/document/d/1fgkVuvlDYJ6lN3bvQHjuhZK0hBu5rJHGao_bXMc5ISU/edit

## Challenges

- Algorithms
  - Solve FizzBuzz 30
    - Write a program that prints the numbers from 1 to 30. But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. For numbers which are multiples of both three and five print “FizzBuzz”.
  - Solve Bubble sort
  - Solve Fibonacci average
  - Sort text in a code file
    - You can use e.g. sort-me.txt file under resources.sort-this for this
- Data manipulation / code conversion
  - Generate enums from a text file
    - You can use this as the input: resources.challenge-data.categories.categories.txt
    - Do the same with the categories-with-ids.txt file. This time you need to generate IDs as well as integers for the enum.
    - Do the same with categories-with-ids-and-countries.txt. Now you need to add a country field as well.
    - Generate unit test that checks that all the enums are correct and correspond to the original text files.
  - Generate translations for a new language
    - resources.challenge-data.translation.translate.properties
  - Migrate a class from Java to another language
    - This can be any class of your choice. You can do this as many times as you like and from as many languages to another as you wish.
  - Generate 100 person’s names in a file called test-data.json.
    - See resources.challenge-data.generate-json-example.test.json for an example
- Testing
  - Write unit test cases for a previous algorithm
  - Write TestBench tests
  - Write TestBench unit tests
- Refactoring
  - Refactor selection into a new method
  - Modernize Java code (e.g. StringBuffer/Builder -> String block)
- Optimization
  - Optimize BogoSort into something better
    - org.vaadin.challenges.sort.BogoSort
  - Optimize an algorithm (e.g. bubble sort of Fibonacci average)
- Explanation
  - Ask Copilot to explain you a piece of code
    - Evaluate whether it was correct
    - If not ask again until you receive a satisfactory answer
    - Repeat this until you can get an idea if you would like to use this method in the future or not.
- Documentation
  - Add JavaDocs to your previously generated methods and classes
- Bug hunt / linting
  - The code in the org.vaadin.challenges.bugs package has some simple bugs. Try to find out the bugs and fix them using Copilot.
- Security Challenge
  - Evaluate the org.vaadin.challenges.security.InsecureCodeExample for potential security issues 🙃
- Game development
  - Implement Game of Life
  - Implement Tetris

## Scoring (optional)

In case you are up for it you can fill in the scorecard in the next section. This is purely for fun and to enhance the sense of accomplishment as part of the coding challenge. The main point of the challenge is to learn something new. If you accomplish this you are a winner 🙂

For solving a single challenge you get 1 point. You can also increase the points you get from a single solution using the following difficulty modifiers


| Modifier                                                   | Points |
|:-----------------------------------------------------------|:-------|
| Use an IDE that you usually don’t normally use             | x 1.5  |
| Write the solution in a language you are not familiar with | x 2    |
| Do the challenge another time in a different way           | x 2    |
| < Add your own modifiers here >                            |        |

## Scorecard (optional)

| Challenge                                                  | Points |
|:-----------------------------------------------------------|:-------|
| Solve FizzBuzz 30                                          |        |
| Solve Bubble sort                                          |        |
| Solve Fibonacci average                                    |        |
| Generate enums from a text file                            |        |
| Generate translations for a new language                   |        |
| Migrate a class from Java to another language              |        |
| Generate 100 person’s names                                |        |
| Write unit test cases for a previous algorithm             |        |
| Write TestBench tests                                      |        |
| Write TestBench unit tests                                 |        |
| Refactor selection into a new method                       |        |
| Modernize Java code                                        |        |
| Optimize BogoSort into something better                    |        |
| Optimize an algorithm                                      |        |
| Ask Copilot to explain you a piece of code                 |        |
| Add JavaDocs                                               |        |
| Find bugs in org.vaadin.challenges.bugs                    |        |
| Evaluate InsecureCodeExample for potential security issues |        |
| Implement Game of Life                                     |        |
| Implement Tetris                                           |        |
| < Add your own challenges here to keep going >             |        |
| Total                                                      |        |



# Project Base for Vaadin and Spring Boot

This project can be used as a starting point to create your own Vaadin application with Spring Boot.
It contains all the necessary configuration and some placeholder files to get you started.

The best way to create your own project based on this starter is [start.vaadin.com](https://start.vaadin.com/) - you can get only the necessary parts and choose the package naming you want to use.

## Running the Application
There are two ways to run the application :  using `mvn spring-boot:run` or by running the `Application` class directly from your IDE.

You can use any IDE of your preference,but we suggest Eclipse or Intellij IDEA.
Below are the configuration details to start the project using a `spring-boot:run` command. Both Eclipse and Intellij IDEA are covered.

#### Eclipse
- Right click on a project folder and select `Run As` --> `Maven build..` . After that a configuration window is opened.
- In the window set the value of the **Goals** field to `spring-boot:run` 
- You can optionally select `Skip tests` checkbox
- All the other settings can be left to default

Once configurations are set clicking `Run` will start the application

#### Intellij IDEA
- On the right side of the window, select Maven --> Plugins--> `spring-boot` --> `spring-boot:run` goal
- Optionally, you can disable tests by clicking on a `Skip Tests mode` blue button.

Clicking on the green run button will start the application.

After the application has started, you can view your it at http://localhost:8080/ in your browser.


If you want to run the application locally in the production mode, use `spring-boot:run -Pproduction` command instead.
### Running Integration Tests

Integration tests are implemented using [Vaadin TestBench](https://vaadin.com/testbench). The tests take a few minutes to run and are therefore included in a separate Maven profile. We recommend running tests with a production build to minimize the chance of development time toolchains affecting test stability. To run the tests using Google Chrome, execute

`mvn verify -Pit,production`

and make sure you have a valid TestBench license installed.

Profile `it` adds the following parameters to run integration tests:
```sh
-Dwebdriver.chrome.driver=path_to_driver
-Dcom.vaadin.testbench.Parameters.runLocally=chrome
```

If you would like to run a separate test make sure you have added these parameters to VM Options of JUnit run configuration

### Live Reload (optional)

With live reload, you can see the results of your code changes immediately. 
When you edit your Java code and recompile it, the application changes will be automatically reloaded and the browser is refreshed.
This is done by leveraging [Spring Boot Developer Tools](https://docs.spring.io/spring-boot/docs/2.1.5.RELEASE/reference/html/using-boot-devtools.html). 
To be able to see the changes in the browser tab, the page still needs to be reloaded. 
That can also  be automated via a LiveReload browser extension. 
One such extension for Google Chrome is [LiveReload](https://chrome.google.com/webstore/detail/livereload/jnihajbhpnppcggbcgedagnkighmdlei). 
In Firefox, [LiveReload - Web extension](https://addons.mozilla.org/en-US/firefox/addon/livereload-web-extension/) can be used.
You can find such similar extensions for other major browsers too.
These extensions add an icon to your browser next to the address bar.
To enable the extension, you should click that icon after you opened your application. 

You can find more information at [Live Reload in Spring Boot Applications](https://vaadin.com/docs/flow/workflow/tutorial-spring-boot-live-reload.html) document.

## Structure

Vaadin web applications are full-stack and include both client-side and server-side code in the same project.

| Directory | Description |
| :--- | :--- |
| `frontend/` | Client-side source directory |
| &nbsp;&nbsp;&nbsp;&nbsp;`index.html` | HTML template |
| &nbsp;&nbsp;&nbsp;&nbsp;`index.ts` | Frontend entrypoint |
| &nbsp;&nbsp;&nbsp;&nbsp;`main-layout.ts` | Main layout Web Component (optional) |
| &nbsp;&nbsp;&nbsp;&nbsp;`views/` | UI views Web Components (TypeScript / HTML) |
| &nbsp;&nbsp;&nbsp;&nbsp;`styles/` | Styles directory (CSS) |
| `src/main/java/<groupId>/` | Server-side source directory |
| &nbsp;&nbsp;&nbsp;&nbsp;`Application.java` | Server entrypoint |
| &nbsp;&nbsp;&nbsp;&nbsp;`AppShell.java` | application-shell configuration |

## Useful links

- Read the documentation at [vaadin.com/docs](https://vaadin.com/docs).
- Follow the tutorials at [vaadin.com/tutorials](https://vaadin.com/tutorials).
- Watch training videos and get certified at [vaadin.com/learn/training](https://vaadin.com/learn/training).
- Create new projects at [start.vaadin.com](https://start.vaadin.com/).
- Search UI components and their usage examples at [vaadin.com/components](https://vaadin.com/components).
- View use case applications that demonstrate Vaadin capabilities at [vaadin.com/examples-and-demos](https://vaadin.com/examples-and-demos).
- Discover Vaadin's set of CSS utility classes that enable building any UI without custom CSS in the [docs](https://vaadin.com/docs/latest/ds/foundation/utility-classes). 
- Find a collection of solutions to common use cases in [Vaadin Cookbook](https://cookbook.vaadin.com/).
- Find Add-ons at [vaadin.com/directory](https://vaadin.com/directory).
- Ask questions on [Stack Overflow](https://stackoverflow.com/questions/tagged/vaadin) or join our [Discord channel](https://discord.gg/MYFq5RTbBn).
- Report issues, create pull requests in [GitHub](https://github.com/vaadin/platform).
