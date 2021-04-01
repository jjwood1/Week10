package Wood.controller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Wood.beans.Item;
@Configuration
public class BeanController {
	@Bean
	public Item item()
	{
		Item bean = new Item();
		bean.setName("Milk");
		bean.setPrice("1.99");
		bean.setBackRoomLocation("98 8 3");
		bean.setQuantity("30");
		
		return bean;
	}
}
