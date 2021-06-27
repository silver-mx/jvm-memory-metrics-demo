package com.dns.metrics;

import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
@RequestMapping("/api/image")
public class ThumbnailController {

    private static final Logger log = LoggerFactory.getLogger(ThumbnailController.class);

    @Value("classpath:images/img.jpg")
    private Resource image;

    @GetMapping(path = "resize", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> resizeImage() {
        try {
            return ResponseEntity.ok(resize());
        } catch (IOException e) {
            log.error("Error resizing image", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @Scheduled(fixedRate = 60000L, initialDelay = 1000L)
    private byte[] resize() throws IOException {

        log.info("Resizing image ....");

        try (ByteArrayOutputStream byteArrayOs = new ByteArrayOutputStream();
             BufferedOutputStream os = new BufferedOutputStream(byteArrayOs)) {
            Thumbnails.of(image.getFile())
                    .scale(0.10)
                    .outputFormat("jpg").toOutputStream(os);

            return byteArrayOs.toByteArray();
        }
    }

}
