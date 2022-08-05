
# Agrotech measure shelter

API desenvolvida em Java com Quarkus. Testes em JUnit e Quarkus Test. Banco de dados hospedado no Atlas e conexão feita através do Panache.

O objetivo dessa API é criar uma central de buscas e monitoramento de ilhas de uma plantação. Através dos documentos contendo informação sobre as ilhas, as medidas feitas pelas ilhas e referências à imagens de satélite, a API disponibiliza os dados de forma organizada e seguindo os padrões REST.

## API Reference

#### Measurements

```http
  GET /measurement
```

| Return | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Measurement` | `[json]` | Medidas feitas pelas ilhas |

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
| `Measurement` | `json` | **Required** Medida feita pela ilha (SEM DATA)|

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
| `Isle` | `[json]` | Ilhas de monitoramento |

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
| `Isle` | `json` | Ilha de monitoramento (SEM ID) |

Isle: {
    name,
    status
}

```http
  GET /isle/{id}
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `String` | Id da ilha |

| Return | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Isle` | `json` | Ilha de monitoramento |

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
| `id` | `String` | Id da ilha |

| Body | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Isle` | `json` | Ilha de monitoramento |

| Return | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Isle` | `json` | Ilha de monitoramento |

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
| `id` | `String` | Id da ilha |

```http
  GET /isle/search/{name}
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `name` | `String` | Nome da ilha |

| Return | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Isle` | `json` | Ilha de monitoramento |

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
| `Count` | `long` | Contagem de Ilhas |

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
| `Image` | `[json]` | Referências às imagens de satélite |

Image: {
    createdAt,
    path
}

```http
  POST /image
```

| Body | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `File` | `Multipart FormData` | **Required** Arquivo de imagem |

```http
  GET /image/{createdAt}
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `createdAt` | `String` | Data e hora da inserção da imagem |

| Return | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Download Link` | `.png` | Link para download da imagem |

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


