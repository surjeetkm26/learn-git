package streamapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dish {
	private String name;
	private boolean vegeterian;
	private int calories;
	protected Type type;
	
}
