**Help Desk — Система управления заявками.**
Учебный проект на Java 17 + Spring Boot 3.5.x, созданный в рамках практических работ

**О проекте:**
Help Desk — это веб-приложение для регистрации и сопровождения обращений пользователей. Проект демонстрирует поэтапное развитие от простого Spring Boot приложения до полноценной системы с базой данных, валидацией форм и разграничением доступа.
Основные возможности:
1) Создание заявок через публичную форму
2) Администраторская зона с защитой через Spring Security
3) Хранение данных в H2 Database
4) Валидация форм на стороне сервера
5) Адаптивный интерфейс на Bootstrap 5
   
## Пользовательские роли

В приложении реализованы две системы доступа:

| Роль | Логин | Пароль | Доступ |
|------|-------|--------|--------|
|  **Администратор** | `admin` | `admin` | Полный доступ к админ-панели `/admin/tickets` |
|  **Обычный пользователь** | `user` | `user` | Доступ к админ-панели **запрещён** (403) |

---

## Маршруты приложения

| URL | Описание | Доступ |
|-----|----------|--------|
| `/` | Главная страница |  Публично |
| `/about` | О нас | Публично |
| `/contacts` | Контакты | Публично |
| `/tickets/new` | Форма создания заявки | Публично |
| `/tickets/{id}/success` | Страница благодарности | Публично |
| `/login` | Страница входа | Публично |
| `/h2-console` | Консоль базы данных | Публично |
| `/admin/tickets` | Админ-панель | Только ADMIN |
| `/logout` | Выход из системы | Только ADMIN |

---

## Технологический стек

| Категория | Технология |
|-----------|------------|
| **Язык** | Java 17 |
| **Фреймворк** | Spring Boot 3.5.x |
| **База данных** | H2 Database (in-memory) |
| **ORM** | Spring Data JPA + Hibernate |
| **Шаблоны** | Thymeleaf |
| **Стили** | Bootstrap 5.3.3 + Custom CSS |
| **Безопасность** | Spring Security |
| **Валидация** | Jakarta Validation |
| **Сборка** | Maven |
| **IDE** | IntelliJ IDEA |

---

##  Предварительные требования

-  **Java 17** или выше
-  **Maven 3.8+**
-  **IntelliJ IDEA** (рекомендуется)


Как установить и запустить этот проект:
1. Клонируйте репозиторий
2. Откройте проект и загрузите зависимости Maven
3. Для запускка приложения найдите файл LatartsevaSpring1Application.java и запустите его
4. В браузере перейти по ссылке http://localhost:8080

Дерево проекта:
```
latartsevaSpring1/
├── src/main/java/com/example/latartsevaSpring1/
│   ├── config/
│   │   └── SecurityConfig.java          # Настройки безопасности
│   ├── controller/
│   │   ├── PageController.java          # Публичные страницы
│   │   ├── TicketController.java        # Форма создания заявки
│   │   ├── LoginController.java         # Страница входа
│   │   └── AdminTicketController.java   # Админ-панель
│   ├── dto/
│   │   └── TicketCreateDto.java         # DTO для формы
│   ├── model/
│   │   ├── Ticket.java                  # Сущность заявки
│   │   └── TicketStatus.java            # Enum статусов
│   ├── repository/
│   │   ── TicketRepository.java        # Репозиторий JPA
│   └── service/
│       ├── TicketService.java           # Интерфейс сервиса
│       └── TicketServiceImpl.java       # Реализация сервиса
├── src/main/resources/
│   ├── static/css/
│   │   └── style.css                    # Стили
│   ├── templates/
│   │   ├── index.html                   # Главная страница
│   │   ├── about.html                   # О нас
│   │   ├── contacts.html                # Контакты
│   │   ├── tickets.html                 # Список заявок
│   │   ├── ticket-form.html             # Форма создания
│   │   ├── ticket-success.html          # Страница благодарности
│   │   ├── login.html                   # Страница входа
│   │   ├── access-denied.html           # Страница 403
│   │   └── admin/
│   │       └── tickets.html             # Админ-панель
│   ├── application.properties           # Конфигурация
│   ── data.sql                         # Тестовые данные
└── pom.xml                              # Зависимости Maven
```
Используемые зависимости:
<dependencies>
    <!-- Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- Thymeleaf -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    
    <!-- JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    <!-- H2 Database -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    
    <!-- Validation -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    
    <!-- Security -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
</dependencies>
