package com.saju.api.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/file")
public class FileController {

    // 설정 파일의 경로를 가져옴
    @Value("${file.upload-dir}")
    private String uploadDir;

    @RequestMapping(method = RequestMethod.POST, path = "/upload")
    public ResponseEntity<?> upload(@RequestParam(value = "file", required = false) MultipartFile file) {
        // 프론트엔드에 저장된 파일 정보를 넘겨줌
        Map<String, String> result = new HashMap<>();
        try {
            if(file.isEmpty()){
                return ResponseEntity.badRequest().body("파일이 없습니다.");
            }
            File folder = new File(uploadDir);
            if (!folder.exists()) {
                folder.mkdirs(); // mkdirs는 상위 폴더까지 다 만들어줍니다.
            }

            // 2. 파일명 중복 방지 (UUID 사용)
            String originalName = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();
            String extension = originalName.substring(originalName.lastIndexOf("."));
            String saveName = uuid + extension;

            // 3. 실제 저장 경로
            Path savePath = Paths.get(uploadDir + saveName);

            // 4. 파일 복사 (저장)
            Files.copy(file.getInputStream(), savePath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("파일 저장 완료: " + savePath);


            result.put("originalName", originalName);
            result.put("saveName", saveName);
            result.put("path", "/display?fileName=" + saveName); // 나중에 이미지를 보여주기 위한 경로

        }catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }
        return ResponseEntity.ok(result);
    }
}
