package hr.app.v1.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import hr.app.v1.services.interfaces.JFileService;

/**
 * The JFileController class is a REST controller responsible for handling file uploads and downloads.
 * It uses the JFileService to perform the actual uploading and downloading of files.
 */
@CrossOrigin
@RestController
@RequestMapping("")
public class JFileController {
    /**
     * An instance of the JFileService interface.
     */
    @Autowired
    private JFileService jFileService;

    /**
     * Handles the request to download all files stored in the application.
     * 
     * @param httpResponse - the HTTP response object
     * @throws IOException - if there is an error while writing the response
     */
    @GetMapping("/download")
    public void downloadAllFiles(HttpServletResponse httpResponse) throws IOException {
        jFileService.downloadAllFiles(httpResponse);
    }

    /**
     * Handles the request to upload one or more files.
     * 
     * @param files - the uploaded files
     * @return - a response entity with the status of the upload operation
     */
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFiles(@RequestParam("file") MultipartFile[] files) {
        return jFileService.uploadFiles(files);
    }
}
