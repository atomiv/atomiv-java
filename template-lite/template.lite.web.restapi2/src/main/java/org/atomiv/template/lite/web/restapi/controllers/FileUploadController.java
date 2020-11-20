package org.atomiv.template.lite.web.restapi.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.atomiv.template.lite.web.restapi.models.DatabaseFile;
import org.atomiv.template.lite.web.restapi.service.DatabaseFileService;
import org.atomiv.template.lite.web.restapi.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.models.Response;

@RestController
public class FileUploadController {
	
						// DRUGI PRIMER
	
//	 @Autowired
//	    private FileStorageService fileStorageService;
//
//	    @PostMapping("/uploadFile")
//	    public Response uploadFile(@RequestParam("file") MultipartFile file) {
//	        String fileName = fileStorageService.storeFile(file);
//
//	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//	            .path("/downloadFile/")
//	            .path(fileName)
//	            .toUriString();
//
//	        return new Response(fileName, fileDownloadUri,
//	            file.getContentType(), file.getSize());
//	    }
//
//	    @PostMapping("/uploadMultipleFiles")
//	    public List < Response > uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//	        return Arrays.asList(files)
//	            .stream()
//	            .map(file - > uploadFile(file))
//	            .collect(Collectors.toList());
//	    }
//	}
	
					// PRVI PRIMER
	
//	@Autowired
//	private DatabaseFileService fileStorageService;
//
//	@PostMapping("/uploadFile")
//	public Response uploadFile(@RequestParam("file") MultipartFile file) {
//		DatabaseFile fileName = fileStorageService.storeFile(file);
//
//		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
//				.path(fileName.getFileName()).toUriString();
//
//		return new Response(fileName.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
//	}
//
//	@PostMapping("/uploadMultipleFiles")
//	public List<Response> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//		return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
//	}
//	
//	}
}