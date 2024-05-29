Weather API Documentation
Overview
The Weather API provides detailed weather data collected from various sensors. This API is designed for developers needing real-time weather metrics like temperature, humidity, and wind speed. The data can be queried for specific sensors and time ranges, making it versatile for applications in weather forecasting, research, and climate analysis.
Features
    • Fetch weather metrics from one or multiple sensors.
    • Calculate statistical data (minimum, maximum, sum, average) for a chosen metric.
    • Query data over a specific period (from one day up to a month).
API Endpoints
Get Weather Stats
URL : /api/metrics/stats
Method : GET
Auth required : NO
Permissions required : None
Query Parameters:
    • sensorId: long (required) - The ID of the sensor.
    • metric: string (required) - The type of metric (e.g., 'temperature', 'humidity').
    • stat: string (required) - The statistical calculation to perform ('min', 'max', 'sum', 'average').
    • start: datetime (optional) - The start of the date range.
    • end: datetime (optional) - The end of the date range.
Success Response
Code : 200 OK
Content example
json
Copy code
{
  "value": 23.5
}
Error Responses
Condition : If any required query parameters are missing.
Code : 400 BAD REQUEST
Content :
json
Copy code
{
  "error": "Missing required parameter(s)"
}
Development
Prerequisites
    • Java 11+
    • Maven 3.6+
    • Spring Boot 2.5+
Running Locally
Clone the repository and navigate to the project directory:

git clone https://github.com/diegocardosodemelo/weatherapi.git
cd weatherapi
To run the application, execute:
./mvn spring-boot:run
Tests
Run tests using:
./mvn test
Deployment
Describe how to deploy the application to a live system, mentioning any prerequisites or environment specifics.




This README provides a good foundation, detailing essential information users need to effectively utilize the API. You can add more sections as necessary, such as 'Configuration', 'Advanced Usage', or 'Contributing'.

