package com.ngando.dualaprojectback.service.word.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngando.dualaprojectback.dao.word.WordRepository;
import com.ngando.dualaprojectback.model.word.Type;
import com.ngando.dualaprojectback.model.word.Word;
import com.ngando.dualaprojectback.service.word.IWordService;

@Service(value = "wordService")
public class WordService implements IWordService {

	@Autowired
	private WordRepository wordRepository;

	@Override
	public List<Word> getAllWords() {
		return wordRepository.findAll();
	}

	@Override
	public List<Word> findByLibelle(String libelle) {
		return wordRepository.findByLibelle(libelle);
	}

	@Override
	public List<Word> findByType(Type type) {
		return wordRepository.findByType(type);
	}

	@Override
	public Word saveOrUpdateWord(Word word) {
		Word wordSaved = null;
		wordSaved = wordRepository.save(word);
		return wordSaved;
	}

	@Override
	public void deleteWord(Long id) {
		Word word = getWordbyId(id);
		wordRepository.delete(word);

	}

	@Override
	public Word getWordbyId(Long id) {
		Word word = null;
		word = wordRepository.getOne(id);
		return word;
	}

}
