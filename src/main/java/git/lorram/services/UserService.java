package git.lorram.services;

import java.util.List;

import git.lorram.entities.User;
import git.lorram.repositories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserService {

	@Inject 
	private UserRepository repository;
	
	public List<User> findAll() {
		List<User> list = repository.findAll().list();
		return list;
	}
	
	public User findById(Long id) {
		User user = repository.findById(id);
		return user;
	}
	
	@Transactional
	public void insert(User obj) {
		 repository.persist(obj);
	}
	
	@Transactional
	public void update(User obj, Long id) {
		User user = repository.findById(id);
		user.setName(obj.getName());
		repository.persist(user);
	}
	
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
