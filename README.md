
# JFileApp

A simple file management web application that allows users to upload and download multiple files as a zip file, built with React, Spring and PostgreSQL.

## Features

- Upload multiple files
- Download all uploaded files in a single .zip file

## Requirements

- Node.js
- npm

## Getting Started

1. Clone the repository
git clone https://github.com/jurerajcic/JFileApp.git


2. Install the dependencies
npm install



3. Start the development server
npm start



4. Open the app in your browser at `http://localhost:3000`

## File Structure
JFileApp/
├── public/
│ ├── index.html
│ └── resources/
│ ├── download.png
│ └── upload.png
├── src/
│ ├── App.js
│ ├── components/
│ │ ├── DownloadComponent.js
│ │ ├── FooterComponent.js
│ │ └── UploadComponent.js
│ └── services/
│ └── JFileService.js
└── package.json


## Technology Stack

- React.js
- axios
- file-saver

## Contributing

If you have any suggestions or improvements, feel free to create a pull request.

## Author

Jure Rajcic