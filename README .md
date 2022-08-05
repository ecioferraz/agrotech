
# Agrotech measure shelter

API developed with Java + Quarkus. Testing with JUnit + QuarkusTest. Database hosted in Atlas mongo with connection through Panache.

The goal of this app is to create a central interface for maintaining and monitoring measure shelters. The documents contain information about the shelters, the measurements and satellite pictures taken every 20 days.

## API Reference

#### Measurements

```http
  GET /measurement
```

| Return | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Measurement` | `[json]` | all measurements |

Measurement: {
    idIsle,
    temperature,
    soilHumidity,
    airHumidity,
    measuredAt
}

```http
  POST /measurement
```

| Body | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Measurement` | `json` | **Required** measurement by an isle (NO DATE)|

Measurement: {
    idIsle,
    temperature,
    soilHumidity,
    airHumidity,
}

#### Isle

```http
  GET /isle
```

| Return | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Isle` | `[json]` | measurement isles |

Isle: {
    id,
    name,
    status
}

```http
  POST /isle
```

| Body | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Isle` | `json` | measurement isle (NO ID) |

Isle: {
    name,
    status
}

```http
  GET /isle/{id}
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `String` | isle id |

| Return | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Isle` | `json` | measurement isle |

Isle: {
    id,
    name,
    status
}

```http
  PUT /isle/{id}
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `String` | isle id |

| Body | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Isle` | `json` | measurement isle |

| Return | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Isle` | `json` | measurement isle |

Isle: {
    id,
    name,
    status
}

```http
  DELETE /isle/{id}
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `String` | isle id |

```http
  GET /isle/search/{name}
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `name` | `String` | isle name |

| Return | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Isle` | `json` | measurement isle |

Isle: {
    id,
    name,
    status
}

```http
  GET /isle/count
```
| Return | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Count` | `long` | isle count |

Isle: {
    id,
    name,
    status
}

#### Image

```http
  GET /image
```

| Return | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Image` | `[json]` | reference to satellite images |

Image: {
    createdAt,
    path
}

```http
  POST /image
```

| Body | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `File` | `Multipart FormData` | **Required** image file |

```http
  GET /image/{createdAt}
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `createdAt` | `String` | date and time of insertion |

| Return | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Download Link` | `.png` | download link |

Image: {
    createdAt,
    path
}




## Run Locally

Clone the project

```bash
  git clone https://link-to-project
```

Go to the project directory

```bash
  cd my-project
```

Create package

```bash
  ./mvnw clean package
```

Build the docker image

```bash
  docker build -f src/main/docker/Dockerfile.jvm -t quarkus/agrotech-measure-shelter-jvm .
```

Deploy the containers on your local network

```bash
  cd src/main/docker && docker-compose up
```


## Running Tests

To run tests, run the following command

```bash
  mvn test
```

To check test coverage, go to

```bash
  target/site/jacoco
```

and open the `index.html` on a browser.

## Authors

- [@EcioFerraz](https://www.github.com/ecioferraz)
- [@LucasAccurcio](https://www.github.com/lucasaccurcio)
- [@GustavoDias](https://www.github.com/unamednada)


