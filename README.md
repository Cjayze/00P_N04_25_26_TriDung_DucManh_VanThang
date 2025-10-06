# OOP_N04_25_26_TriDung_DucManh_VanThang

Demo Spring Boot project (ArrayList storage) for Product, Customer, Order, User.
Includes REST API and Thymeleaf UI.

## Run
- Open in IDE and run `DemoApplication.java` or: `mvn spring-boot:run`
- Web UI: http://localhost:8080/
- APIs: /api/products, /api/customers, /api/orders, /api/users

## Class Diagram (Mermaid)
```mermaid
classDiagram
    class Product {
      +int id
      +String name
      +double price
    }
    class Customer {
      +int id
      +String name
      +String email
    }
    class Order {
      +int id
      +int customerId
      +int productId
      +int quantity
    }
    class User {
      +String name
      +String email
    }
    Customer "1" --> "*" Order
    Product "1" --> "*" Order
```
## Activity diagrams (Mermaid)

### Create
```mermaid
flowchart TD
 A[Start] --> B[Input data]
 B --> C[Validate]
 C -->|Valid| D[Add to ArrayList]
 C -->|Invalid| E[Show error]
 D --> F[End]
 E --> B
```

### Read
```mermaid
flowchart TD
 A[Start] --> B[Request list or item]
 B --> C[Return data from ArrayList]
 C --> D[End]
```

### Update
```mermaid
flowchart TD
 A[Start] --> B[Select ID]
 B --> C[Input new data]
 C --> D[Validate]
 D -->|Valid| E[Replace item in ArrayList]
 D -->|Invalid| F[Show error]
 E --> G[End]
 F --> B
```

### Delete
```mermaid
flowchart TD
 A[Start] --> B[Select ID]
 B --> C[Confirm]
 C -->|Yes| D[Remove from ArrayList]
 C -->|No| E[Abort]
 D --> F[End]
 E --> F
```

## Notes
- Data is stored in-memory. Restarting the app resets data.
- You can extend DAOs to use JPA/H2 or MySQL later.