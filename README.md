## [REST API](http://localhost:8080/doc)

## Концепция:
- Spring Modulith
  - [Spring Modulith: достигли ли мы зрелости модульности](https://habr.com/ru/post/701984/)
  - [Introducing Spring Modulith](https://spring.io/blog/2022/10/21/introducing-spring-modulith)
  - [Spring Modulith - Reference documentation](https://docs.spring.io/spring-modulith/docs/current-SNAPSHOT/reference/html/)

```
  url: jdbc:postgresql://localhost:5432/jira
  username: jira
  password: JiraRush
```
- Есть 2 общие таблицы, на которых не fk
  - _Reference_ - справочник. Связь делаем по _code_ (по id нельзя, тк id привязано к окружению-конкретной базе)
  - _UserBelong_ - привязка юзеров с типом (owner, lead, ...) к объекту (таска, проект, спринт, ...). FK вручную будем проверять

## Аналоги
- https://java-source.net/open-source/issue-trackers

## Тестирование
- https://habr.com/ru/articles/259055/

Список выполненных задач:
1.✔ Understand the project structure (onboarding).
2.✔ Delete social networks: vk, yandex.
3.✔ Transfer sensitive information (login, database password, identifiers for OAuth registration/authorization, mail settings) to a separate property file. The values of these properties must be read at server startup from the environment variables of the machine.
4.✔ Redo the tests so that during the tests the in memory database (H2) is used, and not PostgreSQL. To do this, you need to define 2 beans, and the selection of which one to use should be determined by the active Spring profile.
5.✔ Write tests for all public methods of ProfileRestController.
6.✔ Add new functionality: adding tags to the task. The front is optional.
7.✔ Add the ability to subscribe to tasks that are not assigned to the current user. (There is no need to send notifications/letters about the task status change). The front is optional.
8. Add automatic calculation of the time how long the task was in work and testing. Write 2 methods for service levels that take a task as a parameter and return the elapsed time
9.✔ Write a Dockerfile for the main server
10. Write a docker-compose file to run the server container along with the database and nginx. For nginx, use the config/nginx.conf config file. If necessary, the config file can be edited
11.✔ Add localization in at least two languages for letter templates (mails) and index.html start page.
12. Implement a backlog - a complete list of tasks (with paging) that must be completed and do not yet belong to any sprint. (back + front).
13. Change the "friend or foe" recognition mechanism between front and back from JSESSIONID to JWT. Of the difficulties - you will have to redo the form submission from the front in order to add the authentication header.
