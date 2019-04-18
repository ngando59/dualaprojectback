package com.ngando.dualaprojectback.dao.word;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ngando.dualaprojectback.model.word.Type;
import com.ngando.dualaprojectback.model.word.Word;

public interface WordRepository extends JpaRepository<Word, Long> {

	@Query("select word from Word word where libelle like %?1%")
	List<Word> findByLibelle(String libelle);

	@Query("select word from Word word where type like %?1%")
	List<Word> findByType(Type type);

}
