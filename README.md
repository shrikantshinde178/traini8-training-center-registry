# traini8-training-center-registry
Traini8 Training Center Registry is a Spring Boot project for managing government-funded training centers. It includes APIs for creating and fetching center details. 

## Traini8 Center Registry - Setup Instructions

Welcome to Traini8 Center Registry! This guide will help you set up the project environment and run the application smoothly.

### Prerequisites
- JDK 17 or higher installed on your system.
- MySQL database server installed and running.
- Maven installed to build and manage dependencies.

### Installation Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/shrikantshinde178/training-center-registry.git
   cd training-center-registry
   ```

2. **Database Configuration**
   - Open `src/main/resources/application.properties`.
   - Configure your MySQL database connection settings:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/traini_8_registry
     spring.datasource.username=root
     spring.datasource.password=YourMySQLPassword
     ```

3. **Database Setup**
   - Create a new MySQL database named `traini_8_registry`.
   - The tables will be created automatically when you run the application.

4. **Build and Run**
   - Build the project using Maven:
     ```bash
     mvn clean install
     ```
   - Run the application:
     ```bash
     java -jar target/training-center-registry-0.0.1-SNAPSHOT.jar
     ```

5. **Access the Application**
   - Once the application is running, you can access the APIs using the following base URL:
     ```
     http://localhost:8080/api/
     ```

### API Endpoints

#### Create a Training Center
- **Endpoint:** `POST /createCenter`
- **Description:** Create and save a new training center with the provided details.
- **Request Body:** JSON object containing the training center details.
- **Example Request:**
  ```json
  {
    "centerName": "Example Training Center",
    "centerCode": "ABCDE1234567",
    "address": {
      "detailedAddress": "123 Example Street",
      "city": "Example City",
      "state": "Example State",
      "pincode": "123456"
    },
    "studentCapacity": 100,
    "coursesOffered": ["Course1", "Course2"],
    "contactEmail": "example@example.com",
    "contactPhone": "1234567890"
  }
  ```
- **Response:** JSON object containing the newly saved training center details with auto-incremented id.

#### Get All Training Centers
- **Endpoint:** `GET /fetchCenters`
- **Description:** Retrieve a list of all stored training center information.
- **Response:** JSON array containing the details of all training centers.

### Conclusion
You have successfully set up Traini8 Center Registry on your local machine. Feel free to explore the provided APIs and integrate them into your applications. If you encounter any issues during setup or usage, please don't hesitate to reach out for assistance.
