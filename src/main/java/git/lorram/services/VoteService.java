package git.lorram.services;

import java.util.List;

import git.lorram.entities.Vote;
import git.lorram.entities.components.VoteComponent;
import git.lorram.entities.components.VoteComponent;
import git.lorram.repositories.CandidateRepository;
import git.lorram.repositories.UserRepository;
import git.lorram.repositories.VoteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class VoteService {

	@Inject 
	private VoteRepository repository;
	
	@Inject
	private UserRepository userRepository;
	
	@Inject
	private CandidateRepository candidateRepository;
	
	public List<Vote> findAll() {
		List<Vote> list = repository.findAll().list();
		return list;
	}
	
	public Vote findById(Long id) {
		Vote vote = repository.findById(id);
		return vote;
	}
	
	@Transactional
	public void insert(VoteComponent voteComponent) {
		Vote vote = new Vote();
		vote.setUser(userRepository.findById(voteComponent.getUserId()));
		vote.setCandidate(candidateRepository.findById(voteComponent.getCandidateId()));
		 repository.persist(vote);
	}
	
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
