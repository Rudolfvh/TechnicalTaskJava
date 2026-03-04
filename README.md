# Property View API

Тестовое задание.

## Стек технологий

- Java 17 / 21
- Spring Boot 3.2.5
- Spring Data JPA
- H2 (in-memory)
- Liquibase
- Springdoc OpenAPI (Swagger)

---

## Запуск приложения

Склонировать репозиторий:

git clone <repo-url>

Перейти в директорию проекта:

cd property-view

Собрать и запустить:

mvn clean install  
mvn spring-boot:run

---

## Приложение будет доступно:

API:  
http://localhost:8092

Swagger UI:  
http://localhost:8092/swagger-ui/index.html

H2 Console:  
http://localhost:8092/h2-console

JDBC URL:  
jdbc:h2:mem:propertydb

User: sa  
Password: (пусто)

---

## Особенности

- Миграции базы данных выполняются через Liquibase
- Реализована фильтрация и histogram согласно ТЗ
- Используется конфигурация через application.properties
- Реализован global exception handler