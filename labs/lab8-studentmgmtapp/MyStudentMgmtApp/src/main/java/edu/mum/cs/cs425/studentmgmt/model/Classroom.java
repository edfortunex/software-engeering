package edu.mum.cs.cs425.studentmgmt.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "classrooms")
public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long classroomId;

	@NotBlank(message = "Building Name is required")
	@Column(name = "buildingName", nullable = false)
	private String buildingName;

	@NotBlank(message = "Room Number is required")
	@Column(name = "roomNumber", nullable = false)
	private String roomNumber;

	@OneToMany(mappedBy = "classroomIn")
	private List<Student> students;

	public Classroom() {
		super();
	}

	public Classroom(Long classroomId, String buildingName, String roomNumber) {
		super();
		this.classroomId = classroomId;
		this.buildingName = buildingName;
		this.roomNumber = roomNumber;
	}

	public Long getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(Long classroomId) {
		this.classroomId = classroomId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	@Override
	public String toString() {
		return "Classroom [classroomId=" + classroomId + ", buildingName=" + buildingName + ", roomNumber=" + roomNumber
				+ "]";
	}

}
