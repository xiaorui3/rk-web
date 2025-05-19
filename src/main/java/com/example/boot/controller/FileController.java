package com.example.boot.controller;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestPart;

@RestController
@RequestMapping("/api/file")
public class FileController {

    @Autowired
    private MinioClient minioClient;

    private static final String BUCKET_NAME = "competition";

    @PostMapping("/upload")
    public ResponseEntity<Map<String, Object>> uploadFile(
            @RequestParam String student_name,
            @RequestParam String student_id,
            @RequestParam String work_type,
            @RequestParam String description,
            @RequestParam String ai_text,
            @RequestPart("file") MultipartFile file,
            @RequestPart("ai_proof") MultipartFile aiProof) {

        String userFolder = work_type + "/" + student_name + "_" + student_id + "/";
        Map<String, Object> response = new HashMap<>();

        try {
            // 上传作品文件
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(BUCKET_NAME)
                            .object(userFolder + "作品/" + file.getOriginalFilename())
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build());

            // 上传AI凭证文件
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(BUCKET_NAME)
                            .object(userFolder + "凭证/" + aiProof.getOriginalFilename())
                            .stream(aiProof.getInputStream(), aiProof.getSize(), -1)
                            .contentType(aiProof.getContentType())
                            .build());

            // 保存文本内容为TXT文件
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(BUCKET_NAME)
                            .object(userFolder + "描述.txt")
                            .stream(new ByteArrayInputStream(description.getBytes(StandardCharsets.UTF_8)),
                                    description.getBytes(StandardCharsets.UTF_8).length, -1)
                            .contentType("text/plain")
                            .build());

            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(BUCKET_NAME)
                            .object(userFolder + "生成内容.txt")
                            .stream(new ByteArrayInputStream(ai_text.getBytes(StandardCharsets.UTF_8)),
                                    ai_text.getBytes(StandardCharsets.UTF_8).length, -1)
                            .contentType("text/plain")
                            .build());

            response.put("status", "success");
            response.put("message", "文件上传成功");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status", "error");
            response.put("message", "文件上传失败：" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}