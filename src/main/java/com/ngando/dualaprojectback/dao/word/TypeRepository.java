package com.ngando.dualaprojectback.dao.word;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ngando.dualaprojectback.model.word.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {

	Type findByTypeName(String typeName);

	@Query("select type from Type type")
	Stream<Type> getAllTypeStream();
}
