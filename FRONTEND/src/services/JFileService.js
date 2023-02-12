import axios from 'axios';
import FileSaver from 'file-saver';

/**
 * Constants for API endpoints.
 */
const APP_API_BASE_URL = "http://localhost:8080/api";

/**
 * Class that contains methods to interact with the JFile platform's API.
 */
class JFileService {

  /**
   * Method to download files from the JFile platform's API.
   */
  downloadFiles() {
    alert('creating zip file');
    axios.get(APP_API_BASE_URL + '/download', { responseType: 'blob' })
      .then(response => {
        FileSaver.saveAs(new Blob([response.data]), 'JFiles.zip');
      })
      .catch(error => {
        console.error(error);
      });
  }

  /**
   * Method to upload files to the JFile platform's API.
   * @param {FormData} formData - The form data containing the files to be uploaded.
   */
  uploadFiles(formData) {
    axios.post(APP_API_BASE_URL + '/upload', formData, {
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    }).then(response => {
      if (response.status === 200) {
        alert("Files uploaded successfully");
      } else {
        alert("Error while uploading");
      }
    });
    console.log("axios post request sent");
    return;
  }
}

/**
 * Instance of the JFileService class.
 */
const jFileService = new JFileService();

/**
 * Exporting the JFileService instance.
 */
export default jFileService;
