package com.ngando.dualaprojectback.service.word;

import java.util.List;

import com.ngando.dualaprojectback.model.word.Type;
import com.ngando.dualaprojectback.model.word.Word;

public interface IWordService {

	List<Word> getAllWords();

	List<Word> findByLibelle(String libelle);

	List<Word> findByType(Type type);

	Word getWordbyId(Long id);

	Word saveOrUpdateWord(Word word);

	void deleteWord(Long id);

}
