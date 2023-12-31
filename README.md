# Credit Card Transactions Management API

This is a Spring Boot application that provides a RESTful API for managing credit card transactions. The API allows you to list transactions with filtering, sorting, and pagination features.

## Features

- List Transactions: Retrieve a list of credit card transactions with filtering, sorting, and pagination options.

## Prerequisites

- Java 8 or higher
- Maven

## Getting Started

1. Clone the repository:
    ```bash
   git clone https://github.com/MehdiChargui/Credit-Card-Transactions.git

2. Navigate to the project directory:
    ```bash
    cd credit-card-transactions-api

3. Build the project:
    ```bash
    mvn clean install

4. Run the application:
    ```bash
    mvn spring-boot run

5. Access the API at http://localhost:8080/api/transactions.

## Endpoints
List Transactions
Get a paginated list of credit card transactions.

URL: /api/transactions

Method: GET

Query Parameters:

    - page: Page number (default: 0)
    - size: Number of items per page (default: 10)
    - amount: transaction amount
    - merchant: Merchant name
    - status: Transaction status (APPROVED, REFUSED, PENDING)
    - sort: Sorting criteria in the format field,direction (default: amount,desc)

Example Request:
    ``` http
    GET /api/transactions?page=0&size=10&sort=amount,desc
    ```

Example Response:
    
    
    {
        "content": [
        {
        "id": 1,
        "amount": 100.0,
        "date": "2023-08-15T10:30:00Z",
        "merchant": "Example Merchant",
        "status": "APPROVED"
        },
        // ... more transactions ...
        ],
        "totalElements": 25,
        "totalPages": 3,
        "number": 0,
        "size": 10
    }
    


## Contributing
Contributions are welcome! If you find any issues or want to enhance the application, feel free to open a pull request.



