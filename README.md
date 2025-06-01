# <div align="center">Веб-блог на Spring Boot</div> 

<div align="center">
     <img src="https://github.com/user-attachments/assets/0221c15a-0d8a-4bce-9113-5ffd7ddcce7f" alt="Главная страница">
</div>

Веб-приложение блога с использованием Spring Boot, Spring Data JPA и Thymeleaf. Позволяет создавать, редактировать и удалять статьи. Статьи хранятся в базе данных MySQL.

## 🌟 Особенности
- CRUD операции для статей (создание, чтение, обновление, удаление)
- Хранение данных в MySQL через Spring Data JPA
- Шаблонизация с использованием Thymeleaf
- Модульные компоненты (хедер/футер)
- Адаптивный дизайн на Bootstrap 5

## 📦 Технологический стек
| Компонент       | Технология                  |
|-----------------|-----------------------------|
| Бэкенд         | Spring Boot 3.5             |
| База данных    | MySQL                       |
| Шаблонизация   | Thymeleaf                   |
| Стилизация     | Bootstrap 5                 |
| Сборка         | Maven                       |

## 🛠️ Требования
- Java 24+
- MySQL Server 8.0+
- Maven 3.9+

## 🏗️ Структура проекта
```
├── pom.xml # Зависимости Maven
└── src/main/
    ├── java/com/omuny/web_Blog/
    │   ├── WebBlogApplication.java # Точка входа
    │   ├── controllers/
    │   │   ├── BlogController.java # Управление статьями
    │   │   └── MainController.java # Основные страницы
    │   ├── models/
    │   │   └── Post.java           # Модель статьи
    │   └── repo/
    │       └── PostRepository.java # Доступ к БД
    │ 
    └── resources/
        ├── application.properties # Настройки
        └── templates/
            ├── blocks/
            │   ├── footer.html    # Общий футер
            │   └── header.html    # Общий хедер
            ├── about.html         # Страница "О нас"
            ├── blog-add.html      # Добавление статьи
            ├── blog-details.html  # Детали статьи
            ├── blog-edit.html     # Редактирование
            ├── blog-main.html     # Список статей
            └── home.html          # Главная
```

## ⚙️ Конфигурация
### Настройка БД (application.properties)
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/spring_web_blog
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
```
### Модель данных (Post.java)
```java
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String anons;
    private String full_text;
    private int views;
}
```

## 🚀 Установка и запуск
1. Создайте БД MySQL:
```sql
CREATE DATABASE spring_web_blog;
```
2. Запустите сервер с БД
3. Клонируйте репозиторий:
```bash
git clone https://github.com/Omuny/chess_Engine.git
```
4. Скопилируйте программу:
5. Запустите приложение:
```bash
mvn spring-boot:run
```
6. Откройте в браузере ``http://localhost:8080``

## 🔧 Функционал
### 1. Управление статьями
- Добавление (/blog/add):
  ```java
  @PostMapping("/blog/add")
  public String blogPostAdd(@RequestParam String title, ...) {
      Post post = new Post(title, ...);
      postRepository.save(post);
  }
  ```

<div align="center">
    <img src="https://github.com/user-attachments/assets/d1beb199-7ee1-4856-a6c7-0905e3c6bc47" alt="Создание статьи" width="700">
</div>

- Редактирование (/blog/{id}/edit):
  ```java
  @PostMapping("/blog/{id}/edit")
  public String blogPostUpdate(...) {
    Post post = postRepository.findById(id).orElseThrow();
    post.setTitle(title);
    postRepository.save(post);
  }
  ```
- Удаление (/blog/{id}/remove):
  ```java
  @PostMapping("/blog/{id}/remove")
  public String blogPostDelete(...) {
    postRepository.delete(post);
  }
  ```
### 2. Шаблоны
- Компонентный подход:
  ```html
  <header th:insert="blocks/header :: header"></header>
  <div th:insert="blocks/footer :: footer"></div>
  ```
- Динамические данные:
  ```html
  <h3 th:text="${el.title}"/>
  <a th:href="'/blog/' + ${el.id}">Детальнее</a>
  ```

<div align="center"> 
     <img src="https://github.com/user-attachments/assets/22d68649-2b99-4c83-8cfd-9d7c46d44e8f" alt="Страница блога" width="700">
     <img src="https://github.com/user-attachments/assets/1d00edb0-fd5c-4db7-a727-efe2657b9892" alt="Детали статьи" width="700">
</div>
