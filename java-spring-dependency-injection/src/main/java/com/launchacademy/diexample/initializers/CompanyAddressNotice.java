package com.launchacademy.diexample.initializers;

import com.launchacademy.diexample.models.AddressFormatter;
import com.launchacademy.diexample.models.BillingAddress;
import com.launchacademy.diexample.models.SingleLineAddressFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CompanyAddressNotice implements CommandLineRunner {
  private AddressFormatter formatter;

  @Autowired
  public void setFormatter(AddressFormatter formatter) {
    this.formatter = formatter;
  }

  @Override
  public void run(String... args) throws Exception {
    BillingAddress companyAddress = new BillingAddress();
    companyAddress.setAddress1("77 Summer Street");
    companyAddress.setAddress2("7th Floor");
    companyAddress.setCity("Boston");
    companyAddress.setState("MA");
    companyAddress.setPostalCode("02110");
    
    System.out.println("The Company Address is: \n" + formatter.formatAddress(companyAddress));
  }
}
