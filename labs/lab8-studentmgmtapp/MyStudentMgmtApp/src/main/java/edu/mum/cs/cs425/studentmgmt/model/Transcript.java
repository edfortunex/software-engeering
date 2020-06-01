package edu.mum.cs.cs425.studentmgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "transcripts")
public class Transcript {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transcriptId;

	@NotBlank(message = "Degree of title is required")
	@Column(name = "degreeTitle", nullable = false)
	private String degreeTitle;

	@OneToOne(mappedBy = "transcript")
	private Student owner;

	public Transcript() {
		super();
	}

	public Transcript(Long transcriptId, String degreeTitle) {
		this.transcriptId = transcriptId;
		this.degreeTitle = degreeTitle;
	}

	public Transcript(Long transcriptId, String degreeTitle, Student owner) {
		this(transcriptId, degreeTitle);
		this.owner = owner;
	}

	public Long getTranscriptId() {
		return transcriptId;
	}

	public void setTranscriptId(Long transcriptId) {
		this.transcriptId = transcriptId;
	}

	public String getDegreeTitle() {
		return degreeTitle;
	}

	public void setDegreeTitle(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}

	public Student getOwner() {
		return owner;
	}

	public void setOwner(Student owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Transcript [transcriptId=" + transcriptId + ", degreeTitle=" + degreeTitle + ", owner=" + owner + "]";
	}

}
