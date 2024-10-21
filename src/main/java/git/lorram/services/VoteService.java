package git.lorram.services;

import java.util.List;

import git.lorram.entities.Vote;
import git.lorram.repositories.VoteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class VoteService {

	@Inject 
	private VoteRepository repository;
	
	public List<Vote> findAll() {
		List<Vote> list = repository.findAll().list();
		return list;
	}
	
	public Vote findById(Long id) {
		Vote vote = repository.findById(id);
		return vote;
	}
	
	@Transactional
	public void insert(Vote obj) {
		 repository.persist(obj);
	}
	
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
