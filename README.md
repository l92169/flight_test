# Flight Statistics Application

## Overview
This Java application processes data from a `tickets.json` file to calculate specific flight statistics between Vladivostok (VVO) and Tel Aviv (TLV). It offers a REST API to upload the tickets file, calculate minimum flight time for each carrier, and determine the difference between the average price and the median price for flights between these two cities.

## Features
- **File Upload**: Upload a `tickets.json` file to be processed.
- **Minimum Flight Time Calculation**: Calculate the minimum flight time between Vladivostok and Tel Aviv for each carrier in minutes.
- **Difference Between Average and Median Price Calculation**: Compute the difference between the average and median price of flights between Vladivostok and Tel Aviv.
- **Data Deletion**: Allows deletion of all ticket data from the system.

## Running with Docker
To run the application using Docker, follow these steps:

1. **Prerequisites**:
   - Ensure Docker and Docker Compose are installed on your system.

2. **Starting the Application**:
   - Navigate to the root directory of the application where the `docker-compose.yml` file is located.
   - Run the following command to start the application:
     ```
     docker-compose up
     ```
   - The application will start and be accessible on the port 8080.

3. **Interacting with the API**:
    - **Uploading File**:
        - Endpoint: `POST localhost:8080/file/upload`
        - Form-data: `file` (Select the `tickets.json` file)
    - **Calculating Minimum Flight Time**:
        - Endpoint: `GET localhost:8080/statistics/min-time`
        - This returns the minimum flight time between VVO and TLV for each carrier.
    - **Calculating Difference Between Average and Median Price**:
        - Endpoint: `GET localhost:8080/statistics/diff-avg-medium`
        - This returns the difference between the average and median prices of flights.
    - **Deleting Data**:
        - Endpoint: `DELETE localhost:8080/statistics`
        - This deletes all ticket data from the system.

## Using Swagger UI
After starting the application, you can explore and test the API endpoints using Swagger UI:

1. Open a web browser and navigate to [http://localhost:8080/swagger-ui/index.html#](http://localhost:8080/swagger-ui/index.html#).
2. You will see a list of all available REST endpoints.
3. Click on any endpoint to expand it, view the documentation, and try out the API calls.


### Uploading File
```shell
curl -X POST -F "file=@path_to_tickets.json" http://localhost:8080/file/upload
```
### Getting Minimum Flight Time
```shell
curl http://localhost:8080/statistics/min-time
```
### Getting Difference Between Average and Median Price
```shell
curl http://localhost:8080/statistics/diff-avg-medium
```
### Deleting Data
```shell
curl -X DELETE http://localhost:8080/statistics
```