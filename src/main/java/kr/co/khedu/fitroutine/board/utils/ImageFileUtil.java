package kr.co.khedu.fitroutine.board.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

public final class ImageFileUtil {

    // 실제 이미지 저장 경로(서버가 구동된 컴퓨터 기준)
    private static final String UPLOAD_DIR = "C:/fitroutine-uploads/";

    // 클라이언트가 접근할 수 있는 URL prefix
    private static final String ACCESS_URL_PREFIX = "http://localhost:8080/images/";

    public static String saveFile(MultipartFile file){
        String originName = file.getOriginalFilename();
        String ext = originName.substring(originName.lastIndexOf("."));

        String now = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        int random = (int)(Math.random() * (99999 - 10000)) + 10000;
        String changeName = "fitroutine_" + now + random + ext;

        File folder = new File(UPLOAD_DIR);
        if (!folder.exists()) folder.mkdirs();

        try {
            file.transferTo(new File(UPLOAD_DIR + changeName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ACCESS_URL_PREFIX + changeName; // ✅ 전체 URL로 리턴
    }

}
