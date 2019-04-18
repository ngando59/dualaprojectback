package com.ngando.dualaprojectback.service.word.impl;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngando.dualaprojectback.dao.word.TypeRepository;
import com.ngando.dualaprojectback.model.word.Type;
import com.ngando.dualaprojectback.service.word.ITypeService;

@Service(value = "typeService")
public class TypeServiceImpl implements ITypeService {

	@Autowired
	private TypeRepository typeRepository;

	@Override
	public Type findByTypeName(String typeName) {
		return typeRepository.findByTypeName(typeName);
	}

	@Override
	public List<Type> getAllTypes() {
		return typeRepository.findAll();
	}

	@Override
	public Stream<Type> getAllTypesStream() {
		return typeRepository.getAllTypeStream();
	}

}
