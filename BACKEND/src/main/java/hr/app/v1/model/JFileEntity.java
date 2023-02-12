package hr.app.v1.model;

import java.io.IOException;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;
import org.hibernate.annotations.Type;

import lombok.Data;

/**
 * This class represents a file entity that can be saved in the database.
 * It uses the JPA annotations to define the mapping between the class and the table in the database.
 * 
 * @author Jure Rajcic
 */
@Entity
@Table(name = "file")
@Data
public class JFileEntity {

    /**
     * The primary key of the file entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * The binary data of the file.
     * This field is mapped to the 'data' column in the 'file' table in the database.
     * The type of this field is set to 'org.hibernate.type.BinaryType' using the Type annotation.
     * The 'Lob' annotation is used to specify that this field is a Large Object.
     */
    @Lob
    @Column(name = "data", nullable = false)
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] data;
    
    /**
     * The original name of the file.
     * This field is mapped to the 'name' column in the 'file' table in the database.
     */
    @Column(name = "name", nullable = false)
    private String name;
    
    /**
     * The size of the file in bytes.
     * This field is mapped to the 'size' column in the 'file' table in the database.
     */
    @Column(name = "size", nullable = false)
    private long size;
    
    /**
     * Constructs a new FileEntity object from a MultipartFile.
     * This constructor reads the binary data, original name and size of the file from the MultipartFile.
     * If an IOException occurs while reading the file, it sets the data, name and size to default values.
     * 
     * @param file The MultipartFile to be converted to a FileEntity object.
     */
    public JFileEntity(MultipartFile file) {
        try {
            this.data = file.getBytes();
            this.name = file.getOriginalFilename();
            this.size = file.getSize();
        } catch (IOException e) {
            System.out.println("Error while reading file: creating INVALID file" + e.getMessage());
            this.data = new byte[] {};
            this.name = "INVALID";
            this.size = 0;
        }
        // System.out.println(this.toString());
    }
    
    /**
     * The default constructor for the FileEntity class.
     */
    public JFileEntity() {}
}
