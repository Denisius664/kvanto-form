package inc.sneid.rainbowSix.validation;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FileSizeValidator implements ConstraintValidator<FileSize, MultipartFile> {

    private FileSize fileSize;

    @Override
    public void initialize(FileSize constraintAnnotation) {
        this.fileSize = constraintAnnotation;
    }

    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext c) {
        long size;
        if (multipartFile != null){
            size = multipartFile.getSize();
        }else {
            size = 0;
        }
        long min = fileSize.min();
        long max = fileSize.max();
        return size >= min && size <= max;
    }
}
