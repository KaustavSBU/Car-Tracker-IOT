# Car-Tracker-IOT
Summary: Fleet Management System, involving development of RESTful APIs to track real-time car readings.
Technologies: Spring MVC, SpringBoot, MySQL, AWS SES, Docker, Jenkins.
Data Source: http://mocker.egen.academy/

Functionalities:
1. Developed following REST endpoints for ingestion from: http://mocker.egen.academy/
- Load vehicle details in bulk via a PUT /vehicles endpoint.
- If the vehicle with same VIN is already present, update the regard in db.
- Ingest readings from these vehicles via POST readings .
2. Create alerts with given priority when following rules are triggered:
- Rule: engineRpm > readlineRpm , Priority: HIGH
- Rule: fuelVoLume < 10% of maxFuelVolume , Priority: MEDIUM
- Rule: tire pressure of any tire < 32psi | > 36psi , Priority: LOW
- Rule: engineCoolantLow = true || checkEngineLightOn = true , Priority: LOW
3. Develop ability to send an email and SMS to the user when HIGH alerts are triggered for a vehicle (AWS SES).
4. Develop REST end points for:
- Fetch details of all the vehicles like VIN, make, model, year etc.
- Fetch HIGH alerts within last 2 hours for all the vehicles and ability to sort list of vehicles based on it.
- Ability to list vehicle's geolocation within last 30minutes on a map.
- Ability to list a vehicle's all historical alerts.
5. Dockerfile and Jenkinsfile support.
6. SwaggerUI support.
