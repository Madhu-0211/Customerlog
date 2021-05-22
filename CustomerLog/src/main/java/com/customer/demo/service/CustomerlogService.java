package com.customer.demo.service;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.demo.model.CustomerlogModel;
import com.customer.demo.repository.CustomerlogRepository;


@Service
public class CustomerlogService {
	@Autowired
	private CustomerlogRepository logRepo;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    String currentDate = dateFormat.format(new Date());
    public String getTime() {
        while(true) {
            try {
                Thread.sleep(5*100); 
                LocalTime time = LocalTime.now(ZoneId.of("Asia/Kolkata"));
                String currentTime=time.format(DateTimeFormatter.ofPattern("HH:mm"));
                return currentTime;
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

@Transactional
public void addCheckin(String name)
{
	CustomerlogModel log=new CustomerlogModel();
	log.setLogType("IN");
	log.setTime(getTime());
	log.setDate(currentDate);
	log.setId(name+getTime());
	logRepo.save(log);
}
@Transactional
public void addCheckout(String name)
{
	CustomerlogModel log=new CustomerlogModel();
	log.setLogType("OUT");
	log.setTime(getTime());
	log.setDate(currentDate);
	log.setId(name+getTime());
	logRepo.save(log);
}
@Transactional
public List<CustomerlogModel> getAllLog()
{
	return logRepo.findAll();
}
@Transactional
public List<CustomerlogModel> getLog(String date)
{
	return logRepo.findByDate(date);
}

}
