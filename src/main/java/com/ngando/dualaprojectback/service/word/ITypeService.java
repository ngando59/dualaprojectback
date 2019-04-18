package com.ngando.dualaprojectback.service.word;

import java.util.List;
import java.util.stream.Stream;

import com.ngando.dualaprojectback.model.word.Type;

public interface ITypeService {
	Type findByTypeName(String typeName);

	List<Type> getAllTypes();

	Stream<Type> getAllTypesStream();
}
