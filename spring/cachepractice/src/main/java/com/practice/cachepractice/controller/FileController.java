package com.practice.cachepractice.controller;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.practice.cachepractice.entity.FileData;
import com.practice.cachepractice.repo.FileRepository;

@RestController
@RequestMapping("/files")
public class FileController {
	private FileRepository respository;
	
	
	
	public FileController(FileRepository respository) {
		super();
		this.respository = respository;
	}


	@PostMapping("/upload")
	public FileData upload(@RequestParam("file") MultipartFile file) throws IOException {
		FileData data = new FileData();
		data.setFilename(file.getOriginalFilename());
		data.setFileType(file.getContentType());
		data.setData(file.getBytes());
		FileData saved=respository.save(data);
		return saved;
	}
	
	@GetMapping("/dowload/{id}")
	public ResponseEntity<byte[]> download(@PathVariable int id) {
	FileData data =	respository.findById(id).orElseThrow( () -> new RuntimeException("FileNotFound"));
	return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=/"+data.getFilename()).
			header(HttpHeaders.CONTENT_TYPE,data.getFileType())
			.body(data.getData());
	}
}
