package cybersoft.backend.java12.gira.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateGroupDto {
	@NotBlank(message ="{group.name.not-blank}")
	@Size(min = 3, max = 50, message ="{group.name.size}")
	private String name;
	
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}