package com.curty.playmusic.api;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/listen")
public class ListenAPI {

    @RequestMapping("/music")
    public ResponseEntity<InputStreamResource> playMusic() throws IOException {
        //file variable
        File musicFile = ResourceUtils.getFile("classpath:mp3/Ser_Feliz_Pablo_Curty.mp3");
        //file size
        long len = Files.size(Paths.get(musicFile.toURI()));
        // media type to response
        MediaType mediaType = MediaType.parseMediaType("application/octet-stream");
        //create the response stream
        InputStreamResource resource = new InputStreamResource(new FileInputStream(musicFile));
        //response
        return ResponseEntity.ok()
                .contentType(mediaType)
                .contentLength(len)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + musicFile.getName() + "\"")
                .body(resource);


    }
}
