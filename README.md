### Hexlet tests and linter status:
[![Actions Status](https://github.com/bf-6/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/bf-6/java-project-78/actions)
[![Java CI](https://github.com/bf-6/java-project-78/workflows/Java%20CI/badge.svg)](https://github.com/bf-6/java-project-78/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/1ac520f43170cc054759/maintainability)](https://codeclimate.com/github/bf-6/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/1ac520f43170cc054759/test_coverage)](https://codeclimate.com/github/bf-6/java-project-78/test_coverage)
## About:
A data validator is a library with which you can check the correctness of any data. There are many similar libraries in every language, since almost all programs work with external data that needs to be checked for correctness. First of all, we are talking about the data of the forms filled in by users. The yup library is used as the basis for the project.


## Usage example:
```sh
Validator v = new Validator();

// string
StringSchema schema = v.string().required();

schema.isValid("what does the fox say"); // true
schema.isValid(""); // false

// number
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// map
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "nikita");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "");
human2.put("age", null);
schema.isValid(human1); // false
```
## Start:
```sh
make
```
## Setup:
```sh
make build
```

## Run tests:
``` sh
make test
```

## Run checkstyle:
``` sh
make lint
```

## Run jacoco report:
``` sh
make report
