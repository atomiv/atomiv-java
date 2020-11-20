package org.atomiv.template.lite.web.restapi.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.atomiv.template.lite.web.restapi.exception.FileStorageException;
import org.atomiv.template.lite.web.restapi.models.DatabaseFile;
import org.atomiv.template.lite.web.restapi.repositories.DatabaseFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DatabaseFileService {

	@Autowired
	private DatabaseFileRepository dbFileRepository;

	public DatabaseFile storeFile(MultipartFile file) {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {

			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			DatabaseFile dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes());

			return dbFileRepository.save(dbFile);
		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	public DatabaseFile getFile(String fileId) throws FileNotFoundException {
		return dbFileRepository.findById(fileId)
				.orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
	}
}