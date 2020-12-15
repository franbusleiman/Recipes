package Franciscobusleiman.recipes.recipes.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public interface ImageService {

    public void SaveImage(Long id, MultipartFile file) throws IOException;
}
