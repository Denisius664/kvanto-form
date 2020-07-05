package inc.sneid.rainbowSix.validation;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FileTypeValidator implements ConstraintValidator<FileType, MultipartFile> {

    private FileType fileType;

    @Override
    public void initialize(FileType constraintAnnotation) {
        this.fileType = constraintAnnotation;
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext c) {
        String[] types = fileType.types();
        boolean contains = false;
        for (String s : types) {
            if (file.getContentType().contains(s)){
                contains = true;
            }
        }

        return contains;
    }
}
