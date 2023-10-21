package se331.project.rest.util;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import jakarta.servlet.ServletException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import se331.project.rest.dao.StorageFileDao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Component
public class CloundStorageHelper {
    private static Storage storage = null;
    static {
        InputStream serviceAccount = null;

        try {
            serviceAccount = new ClassPathResource("imageupload-2e148-0515256fec36.json").getInputStream();
            storage = StorageOptions.newBuilder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setProjectId("imageupload-2e148")
                    .build().getService();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String uploadFile (MultipartFile filePart, final String bucketName) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmmssSSS");
        String dtString = sdf.format(new Date());
        final String fileName = dtString + "=" + filePart.getOriginalFilename();
        InputStream is = filePart.getInputStream();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] readBuf = new byte[4096];

        while(is.available() > 0) {
            int bytesRead = is.read(readBuf);
            os.write(readBuf, 0, bytesRead);
        }

        BlobInfo blobInfo = storage.create(
                BlobInfo.newBuilder(bucketName, fileName)
                        .setAcl(new ArrayList<>(Arrays.asList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER))))
                        .setContentType(filePart.getContentType())
                        .build(),
                os.toByteArray()
        );
        return blobInfo.getMediaLink();
    }

    public String getImageUrl (MultipartFile file, final String bucket) throws IOException, ServletException {
        final String fileName = file.getOriginalFilename();
        if(fileName != null && !fileName.isEmpty() && fileName.contains(".")) {
            final String externsion = fileName.substring(fileName.lastIndexOf('.')+1);
            String[] allowedExt = {"jpg", "jpeg", "png", "gif"};
            for (String s : allowedExt) {
                if(externsion.equals(s)) {
                    return this.uploadFile(file, bucket);
                }
            }
            throw new ServletException("file must be an image");
        }
        return null;
    }
    public StorageFileDao getStorageFileDto (MultipartFile file, final String bucket) throws IOException, ServletException {
        final String fileName = file.getOriginalFilename();

        if(fileName != null && !fileName.isEmpty() && fileName.contains(".")) {
            final String extension = fileName.substring(fileName.lastIndexOf('.')+1);
            String[] allowedExt = {"jpg", "jpeg", "png", "gif"};
            for(String s : allowedExt) {
                if(extension.equals(s)) {
                    String urlName = this.uploadFile(file, bucket);
                    return StorageFileDao.builder()
                            .name(urlName)
                            .build();
                }
            }
            throw new ServletException("file must be an image");
        }
        return null;
    }

}
