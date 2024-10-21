package git.lorram.services;

import java.util.List;

import git.lorram.entities.Candidate;
import git.lorram.repositories.CandidateRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CandidateService {

	@Inject 
	private CandidateRepository repository;
	
	public List<Candidate> findAll() {
		List<Candidate> list = repository.findAll().list();
		return list;
	}
	
	public Candidate findById(Long id) {
		Candidate candidate = repository.findById(id);
		return candidate;
	}
	
	@Transactional
	public void insert(Candidate obj) {
		 repository.persist(obj);
	}
	
	@Transactional
	public void update(Candidate obj, Long id) {
		Candidate candidate = repository.findById(id);
		candidate.setName(obj.getName());
		candidate.setNumber(obj.getNumber());
		repository.persist(candidate);
	}
	
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
