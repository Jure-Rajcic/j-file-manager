package hr.app.v1.services.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hr.app.v1.model.JFileEntity;
import hr.app.v1.repository.JFileRepository;
import hr.app.v1.services.interfaces.JFileService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

@Service
public class JFileServiceImpl implements JFileService {
  @Autowired
  private JFileRepository jFileRepository;

  @Override
  public void downloadAllFiles(HttpServletResponse httpResponse) throws IOException {
    List<JFileEntity> jFiles = jFileRepository.findAll();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ZipOutputStream zos = new ZipOutputStream(baos);

    for (JFileEntity jFile : jFiles) {
      try {
        zos.putNextEntry(new ZipEntry(jFile.getName()));
        zos.write(jFile.getData());
        zos.closeEntry();
      } catch (ZipException e) {
        System.out.println("Error while reading file: creating INVALID file" + e.getMessage());
      }
    }

    zos.close();

    httpResponse.setContentType("application/zip");
    httpResponse.setHeader("Content-Disposition", "attachment; filename=JFiles.zip");
    httpResponse.setContentLength(baos.size());

    OutputStream os = httpResponse.getOutputStream();
    baos.writeTo(os);
    os.flush();
    os.close();
  }

  @Override
  public ResponseEntity<String> uploadFiles(MultipartFile[] files) {
    for (MultipartFile file : files) {
      JFileEntity existingJFile = jFileRepository.findByName(file.getOriginalFilename());
      if (existingJFile != null) {
        try {
          existingJFile.setData(file.getBytes());
          existingJFile.setSize(file.getSize());
          jFileRepository.save(existingJFile);
        } catch (IOException e) {
          e.printStackTrace();
          return ResponseEntity.badRequest().body("Error while reading file: " + file.getOriginalFilename());
        }
      } else {
        JFileEntity jFileEntity = new JFileEntity(file);
        jFileRepository.save(jFileEntity);
      }
    }
    return ResponseEntity.ok("Files uploaded successfully");
  }

}
