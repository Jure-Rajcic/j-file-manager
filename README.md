
# JFileApp

A simple file management web application that allows users to upload and download multiple files as a zip file, built with React, Spring and PostgreSQL.

## Features

- Upload multiple files
- Download all uploaded files in a single .zip file

## Requirements

- Node.js
- npm
- Java
- Maven
- PostgreSQL


## Getting Started

1. Clone the repository
git clone https://github.com/jurerajcic/JFileApp.git

2. Install the dependencies
npm install

3. Start the development server
npm start

4. Clone the backend repository
git clone https://github.com/jurerajcic/JFileAppBackend.git

5. Install the dependencies for the backend
mvn install

6. Start the backend server
mvn spring-boot:run


## File Structure
```
FRONTEND
├── package-lock.json
├── package.json
├── public
│   ├── favicon.ico
│   └── index.html
└── src
    ├── App.css
    ├── App.js
    ├── components
    │   ├── DownloadComponent.jsx
    │   ├── FooterComponent.jsx
    │   ├── HeaderComponent.js
    │   ├── UploadComponent.jsx
    │   └── resources
    │       ├── download.png
    │       └── upload.png
    ├── index.css
    ├── index.js
    ├── logo.svg
    ├── serviceWorker.js
    └── services
        └── JFileService.js
```

```
BACKEND
├── docker
│   └── maven
│       └── Dockerfile
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src
    └── main
        ├── java
        │   └── hr
        │       └── app
        │           └── v1
        │               ├── Main.java
        │               ├── additions
        │               │   ├── LocalDateTimeAttributeConverter.java
        │               │   └── RequestDeniedException.java
        │               ├── controller
        │               │   └── JFileController.java
        │               ├── model
        │               │   └── JFileEntity.java
        │               ├── repository
        │               │   └── JFileRepository.java
        │               └── services
        │                   ├── classes
        │                   │   └── JFileServiceImpl.java
        │                   └── interfaces
        │                       └── JFileService.java
        └── resources
            └── application.properties
```


## Technology Stack

- React.js
- axios
- file-saver
- Spring Boot
- PostgreSQL

## Contributing

If you have any suggestions or improvements, feel free to create a pull request.

## Author

Jure Rajcic