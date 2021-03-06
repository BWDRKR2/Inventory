package hello;

import java.util.Map;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;




//9-12
import java.util.List;
import org.springframework.data.repository.CrudRepository;


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }


   @RequestMapping(value = "/list_items")
   public String list_items() {
     return "List Items";
  }


  @RequestMapping(value = "/item")
  public String item(@RequestParam("number") int number) {
	//repository.findByitem_number('WASHER');
	//System.out.println(number.toString());

    return "Item Number = " + number;
  }

 @RequestMapping(value = "withdrawl")
public String withdrawl(@RequestParam Map<String,String> requestParams) throws Exception{
String numberString=requestParams.get("number");
String qtyString=requestParams.get("qty");

//System.out.println numberString;
//System.out.println qtyString;
System.out.println(numberString);
System.out.println(qtyString);
return "Withdrawl = " + numberString + " Qty *** = " + qtyString ;
}

  @RequestMapping(value = "/deposit")
  public String desposit(@RequestParam("number") int number) {
    return "Deposit = " + number ;
  }

	
  @RequestMapping(value = "/add_item")
  public String add_item(@RequestParam("number") int number) {
    //save(new Inventory ("999999", "Drill Bit", 51, "SKU 2144234"));
    return "Add Item = " + number ;
  }

  @RequestMapping(value = "/delete_item")
  public String delete_item(@RequestParam("number") int number) {
    return "Delete Item = " + number ;
  }






@Entity
public class Inventory {
	@Id
	@GeneratedValue
	private int id;
	private String item_number;
	private String item_name;
	private int qty_amount;
	private String inventory_code;

	protected Inventory() {}

public Inventory(String item_number, String item_name, int qty_amount, String inventory_code) {
        this.item_number = item_number;
        this.item_name = item_name;
	this.qty_amount = qty_amount;
	this.inventory_code = inventory_code;
    }
	}


public interface InventoryRepository extends CrudRepository<Inventory, Long> {

    List<Inventory> findByLastName(String item_name);
}

//




}


