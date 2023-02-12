package hr.app.v1.services.interfaces;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * JFileService is an interface for providing functionalities to download and upload files.
 */
public interface JFileService {

    /**
     * This method is used to download all files from the system.
     * @param httpResponse HttpServletResponse object to send the response.
     * @throws IOException if there is an error reading the files.
     */
    public void downloadAllFiles(HttpServletResponse httpResponse) throws IOException;

    /**
     * This method is used to upload multiple files to the system.
     * @param files Array of files to be uploaded.
     * @return ResponseEntity object with the appropriate HTTP status code and message.
     */
    public ResponseEntity<String> uploadFiles(MultipartFile[] files);
}
