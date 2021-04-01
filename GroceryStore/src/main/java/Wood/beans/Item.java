package Wood.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String quantity;
	private String price;
	private String BackRoomLocation;
	public Item() {
		super();
		
	}
	public Item(int id, String name, String quantity, String price, String BackRoomLocation)
	{
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.BackRoomLocation = BackRoomLocation;
	}

}
