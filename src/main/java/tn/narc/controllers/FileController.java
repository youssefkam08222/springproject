package tn.narc.controllers;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.narc.entity.LoadFile;
import tn.narc.services.FileService;

@RestController
@CrossOrigin("*")
@RequestMapping("file")
public class FileController {

	@Autowired
	private FileService fileService;

	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws IOException {
		return new ResponseEntity<>(fileService.addFile(file), HttpStatus.OK);
	}

	@GetMapping("/download/{id}")
	public ResponseEntity<ByteArrayResource> download(@PathVariable String id) throws IOException {
		LoadFile loadFile = fileService.downloadFile(id);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(loadFile.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + loadFile.getFilename() + "\"")
				.body(new ByteArrayResource(loadFile.getFile()));
	}
	
	@GetMapping("/getfile/{id}")
	public ResponseEntity<String> serveFile(@PathVariable String id) throws IllegalStateException, IOException {

		LoadFile f = fileService.downloadFile(id);
		byte[] file = f.getFile();
		String i= Base64.getEncoder().encodeToString(file);
		
		return ResponseEntity.ok().body(i);
		 
		
	}

}
