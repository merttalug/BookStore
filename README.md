

# Bookstore Application

A web-based Bookstore application built using **Spring Boot**, **H2 Database**, and **Thymeleaf**. The application allows users to register, log in, and perform CRUD operations on books. It features role-based authentication and a secure login system.

## Features

- User registration and login
- Role-based access control
- CRUD operations on books
- Dynamic pages using Thymeleaf
- H2 Database integration
- Session tracking for authenticated users

---

## Technologies Used

- **Backend:** Spring Boot, Spring Security, H2 Database
- **Frontend:** Thymeleaf, Bootstrap, HTML, CSS
- **Build Tool:** Maven
- **API Testing:** Postman

---

## Getting Started

### Prerequisites

- Java 17 or later
- Maven 3.8+
- A web browser (to access the application)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/bookstore.git
   cd bookstore
   ```

2. Build the project:

```
mvn clean install
```

3. Run the application:

```
mvn spring-boot:run
```

4. Access the application in your browser at:

```
http://localhost:8080
```

------

## Application Structure

### Endpoints

#### Public Endpoints

| Endpoint              | Method | Description         |
| --------------------- | ------ | ------------------- |
| `/register`           | GET    | Registration page   |
| `/login`              | GET    | Login page          |
| `/api/users/register` | POST   | Register a new user |
| `/api/users/login`    | POST   | Authenticate a user |

#### Protected Endpoints

| Endpoint     | Method | Description          |
| ------------ | ------ | -------------------- |
| `/addBook`   | GET    | Add book page        |
| `/books`     | GET    | List all books       |
| `/api/books` | GET    | Get all books (JSON) |
| `/api/books` | POST   | Add a new book       |

------

## Configuration

### H2 Database

The application uses an in-memory H2 database for development. You can access the H2 console at:

```
http://localhost:8080/h2-console
```

#### H2 Database Credentials

- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Username:** `sa`
- **Password:** `password`

To enable the H2 console, ensure the following properties are set in `application.properties`:

```
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

------

## Usage

1. **Register a User:**
   - Navigate to `/register` and create a new account.
2. **Login:**
   - Navigate to `/login` and log in using your credentials.
3. **Add a Book:**
   - After logging in, go to `/addBook` and fill out the form to add a new book.
4. **View Books:**
   - Navigate to `/books` to see the list of all added books.

------

## Security

- **Authentication:** Spring Security is used to secure endpoints.
- **Authorization:** Users must be logged in to access `/addBook` and `/books`.
- **Session Management:** Sessions are tracked to ensure secure access for authenticated users.

------

## Development

### Running Tests

Run tests using:

```
mvn test
```

### API Testing with Postman

Sample requests:

- **Register a User:**

  - URL: `POST /api/users/register`

  - Body:

    ```
    json{
      "username": "testuser",
      "password": "testpass",
      "email": "testuser@example.com"
    }
    ```

- **Login:**

  - URL: `POST /api/users/login`

  - Body:

    ```
    json{
      "username": "testuser",
      "password": "testpass"
    }
    ```

- **Add a Book:**

  - URL: `POST /api/books`

  - Body:

    ```
    json{
      "title": "Book Title",
      "author": "Author Name",
      "price": 19.99
    }
    ```

------

## Known Issues

- H2 Console may not be accessible in production mode.
- Customize error messages for a better user experience.

------

## License

This project is licensed under the MIT License.

------

## Contributors

- **Mert Taluğ**
