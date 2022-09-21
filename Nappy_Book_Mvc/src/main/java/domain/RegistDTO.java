package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RegistDTO {
	private int id;   
	private String title; 
	private int price;
	private String summary;  
	private int viewCnt;  
	private LocalDateTime regDate; 

	public String getRegDateTime() {
		if(this.regDate == null) return "";		
		return this.regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
	
	
}
















