package inc.sneid.rainbowSix.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImagesForm {
    private MultipartFile snilsImg;
    private MultipartFile statementImg;
    private MultipartFile consentImg;
    private MultipartFile birthCertificateImg;
    private MultipartFile passportParentImg;
    private MultipartFile passportImg;
}
