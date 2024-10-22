package git.lorram.entities.components;

public class VoteComponent {

	private Long userId;
	private Long candidateId;
	
	public VoteComponent(Long userId, Long candidateId) {
		this.userId = userId;
		this.candidateId = candidateId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}
}
