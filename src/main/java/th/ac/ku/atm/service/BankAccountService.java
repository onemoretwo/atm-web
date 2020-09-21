package th.ac.ku.atm.service;

import org.springframework.stereotype.Service;
import th.ac.ku.atm.model.BankAccount;

import java.util.ArrayList;

@Service
public class BankAccountService {

    private ArrayList<BankAccount> bankAccountList;

    public BankAccountService(){
        bankAccountList = new ArrayList<>();
    }

    public void createBankAccount(BankAccount bankAccount){
        bankAccountList.add(bankAccount);
    }

    public ArrayList<BankAccount> getBankAccountList() {
        return bankAccountList;
    }
}
