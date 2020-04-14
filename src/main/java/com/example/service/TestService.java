package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.repository.TestRepository;

@Service
@Transactional
public class TestService {

	@Autowired
	private TestRepository testRepository;
	
	public void insert() {
		testRepository.insert();
	}
}
