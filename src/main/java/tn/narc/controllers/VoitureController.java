package tn.narc.controllers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.narc.entity.Voiture;
import tn.narc.services.VoitureService;

@CrossOrigin("*")
@RestController
@RequestMapping("voitures")
public class VoitureController {

	@Autowired
	private VoitureService voitureService;
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/check")
	public ResponseEntity getStatus() {

		return ResponseEntity.ok(true);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Voiture>> getAllVoiture() {

		return ResponseEntity.ok().body(voitureService.getAllVoiture());
	}
	
	@GetMapping("/checkvoitureserie/{voitureTypeSerie}/{voitureSerie}")
	public ResponseEntity<Boolean> checkVoitureSerie(@PathVariable String voitureTypeSerie,@PathVariable String voitureSerie) {
		
		return ResponseEntity.ok().body(voitureService.verifyVoitureSerieExists(voitureTypeSerie,voitureSerie));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Voiture> getVoitureById(@PathVariable String id) {
		return ResponseEntity.ok().body(voitureService.getVoitureById(id));
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<Voiture> createVoiture(
			@RequestBody Voiture voiture/* , @RequestPart("File") MultipartFile File */) throws IOException {
		System.out.println("voiture= "+voiture);
		return ResponseEntity.ok().body(this.voitureService.createVoiture(voiture));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Voiture> updateVoiture(@PathVariable String id, @RequestBody Voiture voiture) {
		voiture.setVoitureId(id);

		return ResponseEntity.ok().body(this.voitureService.updateVoiture(voiture));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteVoiture(@PathVariable String id) {
		voitureService.deleteVoiture(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/getjson")
	public ResponseEntity<Map<String, Object>> getJson() throws IOException {

		ClassPathResource staticDataResource = new ClassPathResource("test.json");
		String staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);

		return ResponseEntity.ok().body(new JSONObject(staticDataString).toMap());
	}
	
	

	/*
	 * @PostMapping("/uploadfile") public ResponseEntity<?>
	 * upload(@RequestParam("file") MultipartFile file) throws IOException { return
	 * new ResponseEntity<>(fileService.addFile(file), HttpStatus.OK); }
	 * 
	 * @GetMapping("/downloadfile/{id}") public ResponseEntity<ByteArrayResource>
	 * download(@PathVariable String id) throws IOException { LoadFile loadFile =
	 * fileService.downloadFile(id);
	 * 
	 * return
	 * ResponseEntity.ok().contentType(MediaType.parseMediaType(loadFile.getFileType
	 * ())) .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
	 * loadFile.getFilename() + "\"") .body(new
	 * ByteArrayResource(loadFile.getFile())); }
	 * 
	 */

}
