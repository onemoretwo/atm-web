package th.ac.ku.atm.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import th.ac.ku.atm.model.Customer;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private ArrayList<Customer> customerList;

    @PostConstruct
    public void postContruct() {
        customerList = new ArrayList<>();
    }

    public void createCustomer(Customer customer) {
        // .... hash pin ....
        String hashPin = hash(""+customer.getPin());
        customer.setPin(Integer.parseInt(hashPin));
        customerList.add(customer);
    }

    public List<Customer> getCustomers() {
        return new ArrayList<>(this.customerList);
    }

    private String hash(String pin) {
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(pin, salt);
    }
}
