# WeatherAPI

Requirements:
Spring boot application with h2 database and java1.8

API
1. Endpoint to post weather data
POST /weather
Example of body
{
    "id": 1,
    "date": "1985-01-01",
    "location": {
      "lat": 36.1189,
      "lon": -86.6892,
      "city": "Palo Alto",
      "state": "California"
    },
    "temparature": [
      37.3,
      36.8,
      36.4,
      36,
      35.6,
      35.3,
      35,
      34.9,
      35.8,
      38,
      40.2,
      42.3,
      43.8,
      44.9,
      45.5,
      45.7,
      44.9,
      43,
      41.7,
      40.8,
      39.9,
      39.2,
      38.6,
      38.1
    ]
  }

2. Endpoint to get weather data
GET /weather
Lists all weather data in ascending order of id

3. Endpoint to get weather data filtered by date
GET /weather?date={date}
http://localhost:8080/weather?date=1985-01-01
NOTE: Date should be given in yyyy-MM-dd
The weather data for that particular date is shown

4. Endpoint to delete weather data 
DELETE /erase
Deletes all weather data and sends Httpstatus code 200 

