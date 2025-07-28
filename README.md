
# Manager-APP 🛒

Простое Spring Boot приложение для управления товарами

## 📌 О проекте

Manager-APP - это backend-приложение на Java с использованием Spring Boot, которое предоставляет REST API для управления товарами в магазине или на складе.

## 🚀 Возможности

- Создание, чтение, обновление и удаление товаров (CRUD операции)
- Поиск товаров по различным параметрам
- Пагинация и сортировка результатов
- Валидация входящих данных
- Обработка ошибок и стандартизированные ответы API

## 🛠 Технологии

- **Java** (версия 17+)
- **Spring Boot** (версия 3.x)
- **Spring Data JPA** - для работы с базой данных
- **Hibernate** - как JPA провайдер
- **H2 Database** / **PostgreSQL** - встроенная или внешняя БД
- **Lombok** - для сокращения boilerplate кода
- **Swagger** - документация API (опционально)

## 📚 API Документация

Приложение предоставляет следующие REST эндпоинты:

| Метод | Путь               | Описание                     |
|-------|--------------------|-----------------------------|
| GET   | /api/products      | Получить список всех товаров |
| GET   | /api/products/{id} | Получить товар по ID         |
| POST  | /api/products      | Создать новый товар          |
| PUT   | /api/products/{id} | Обновить существующий товар  |
| DELETE| /api/products/{id} | Удалить товар                |

### Пример запроса (JSON)
```json
{
  "name": "Ноутбук ASUS",
  "description": "Игровой ноутбук 16ГБ RAM",
  "price": 899.99,
  "quantity": 10,
  "category": "Электроника"
}
🚀 Запуск приложения
Клонируйте репозиторий:

bash
git clone https://github.com/Am1nch1k/Manager-APP.git
Запустите приложение:

bash
./mvnw spring-boot:run
Приложение будет доступно по адресу:

text
http://localhost:8080
🔧 Конфигурация
Настройки приложения можно изменить в файле:

text
src/main/resources/application.properties
Доступные параметры:

Порт сервера: server.port

Настройки БД: spring.datasource.*

Логирование: logging.level.*

🤝 Как внести вклад
Форкните репозиторий

Создайте ветку для вашей фичи (git checkout -b feature/amazing-feature)

Зафиксируйте изменения (git commit -m 'Add some amazing feature')

Запушьте в ветку (git push origin feature/amazing-feature)

Откройте Pull Request

📜 Лицензия
Этот проект распространяется под лицензией MIT. См. файл LICENSE для подробностей.

