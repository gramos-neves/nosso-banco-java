package com.nosso.banco.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.nosso.banco.model.People;
import com.nosso.banco.repository.PeopleRepository;

@Component
public class Disco {

	@Autowired
	private PeopleRepository peopleRepository;

	@Value("${contato.disco.raiz}")
	private String raiz;

	@Value("${contato.disco.diretorio-photos}")
	private String diretorioFotos;

	public void salvarFoto(MultipartFile foto, long id) {
		this.salvar(this.diretorioFotos, foto, id);
	}

	public void salvar(String diretorio, MultipartFile arquivo, long id) {
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());

		try {

			People people = peopleRepository.findId(id);
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());

			// rename a file in the same directory
			Path newPath = arquivoPath.resolveSibling(people.getCpf() + ".jpg");

			// Get the file
			File f = new File(newPath.toString());
			if (f.exists()) {
				f.delete();
			}

			Files.move(arquivoPath, newPath);
			people.setPathImage(newPath.toString());
			peopleRepository.save(people);

		} catch (IOException e) {
			throw new RuntimeException("Problems trying to save file.", e);
		}
	}
}
