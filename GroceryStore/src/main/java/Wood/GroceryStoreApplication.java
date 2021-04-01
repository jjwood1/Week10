package Wood;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.ui.Model;

import Wood.beans.Item;
import Wood.controller.BeanController;
import Wood.repository.ItemRepository;
@SpringBootApplication
public class GroceryStoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GroceryStoreApplication.class, args);
	}
	@Autowired
	ItemRepository repo;
	
	@Override
	public void run(String... args) throws Exception{
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanController.class);
		

		((AbstractApplicationContext) appContext).close();
	}
	
}


