package com.ngando.dualaprojectback.controller.word;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ngando.dualaprojectback.model.word.Word;
import com.ngando.dualaprojectback.service.word.ITypeService;
import com.ngando.dualaprojectback.service.word.IWordService;

@Controller
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/word/*")
public class WordController {

	private static final Logger logger = LoggerFactory.getLogger(WordController.class);

	@Autowired
	private IWordService wordService;

	@SuppressWarnings("unused")
	@Autowired
	private ITypeService typeService;

	@GetMapping(value = "/all-words")
	public ResponseEntity<List<Word>> getAllWords() {
		List<Word> words = wordService.getAllWords();
		logger.info("liste des mots : " + words.toString());
		return new ResponseEntity<List<Word>>(words, HttpStatus.FOUND);
	}

	@GetMapping(value = "/find-word/{search}")
	public ResponseEntity<List<Word>> findWord(@PathVariable("search") String search) {
		List<Word> words = wordService.findByLibelle(search);
		logger.info("liste des mots trouvés : " + words.toString());
		return new ResponseEntity<List<Word>>(words, HttpStatus.FOUND);
	}

	@PostMapping(value = "/add-word")
	@Transactional
	public ResponseEntity<Word> saveWord(@RequestBody Word word) {
		Word wordSave = wordService.saveOrUpdateWord(word);
		logger.info("wordSave : " + wordSave.toString());
		return new ResponseEntity<Word>(wordSave, HttpStatus.CREATED);
	}

	@GetMapping(value = "/find-word-by-id/{id}")
	public ResponseEntity<Word> findWordById(@PathVariable("id") Long id) {
		Word word = wordService.getWordbyId(id);
		logger.debug("Mot trouvé : " + word);
		return new ResponseEntity<Word>(word, HttpStatus.FOUND);
	}

	@PutMapping(value = "/update-word/{id}")
	public ResponseEntity<Word> updateUser(@PathVariable(value = "id") Long id, @RequestBody Word word) {

		Word wordToUpdate = wordService.getWordbyId(id);
		if (wordToUpdate == null) {
			logger.debug("Le mot avec l'identifiant " + id + " n'existe pas");
			return new ResponseEntity<Word>(word, HttpStatus.NOT_FOUND);
		}

		logger.info("UPDATE word: " + wordToUpdate.getTypes().toString());
		wordToUpdate.setLibelle(word.getLibelle());
		wordToUpdate.setTraduction(word.getTraduction());
		wordToUpdate.setPhonetique(word.getPhonetique());
		Word wordUpdated = wordService.saveOrUpdateWord(wordToUpdate);
		return new ResponseEntity<Word>(wordUpdated, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete-word/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Long id) {
		wordService.deleteWord(id);
		return new ResponseEntity<Void>(HttpStatus.GONE);
	}
}
