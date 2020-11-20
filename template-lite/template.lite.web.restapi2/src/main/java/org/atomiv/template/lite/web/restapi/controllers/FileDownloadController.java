package org.atomiv.template.lite.web.restapi.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.atomiv.template.lite.web.restapi.models.DatabaseFile;
import org.atomiv.template.lite.web.restapi.service.DatabaseFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.HttpHeaders;
import com.google.common.net.MediaType;


import ch.qos.logback.classic.Logger;

@RestController
public class FileDownloadController {
	
							// DRUGI PRIMER
	
	
//	private static final Logger logger = LoggerFactory.getLogger(FileDownloadController.class);
//
//    @Autowired
//    private FileStorageService fileStorageService;
//
//    @GetMapping("/downloadFile/{fileName:.+}")
//    public ResponseEntity < Resource > downloadFile(@PathVariable String fileName, HttpServletRequest request) {
//        // Load file as Resource
//        Resource resource = fileStorageService.loadFileAsResource(fileName);
//
//        // Try to determine file's content type
//        String contentType = null;
//        try {
//            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//        } catch (IOException ex) {
//            logger.info("Could not determine file type.");
//        }
//
//        // Fallback to the default content type if type could not be determined
//        if (contentType == null) {
//            contentType = "application/octet-stream";
//        }
//
//        return ResponseEntity.ok()
//            .contentType(MediaType.parseMediaType(contentType))
//            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//            .body(resource);
//    }
//}
								//	PRVI PRIMER
	
	
//	@Autowired
//	private DatabaseFileService fileStorageService;
//
//	@GetMapping("/downloadFile/{fileName:.+}")
//	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws FileNotFoundException {
//		// Load file as Resource
//		DatabaseFile databaseFile = fileStorageService.getFile(fileName);
//		
//		return ResponseEntity.ok().contentType(MediaType.parseMediaType(databaseFile.getFileType()))
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + databaseFile.getFileName() + "\"")
//				.body(new ByteArrayResource(databaseFile.getData()));
//	}
	}

