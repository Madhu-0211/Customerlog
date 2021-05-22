package com.customer.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.demo.model.CustomerlogModel;

public interface CustomerlogRepository extends JpaRepository<CustomerlogModel,Integer> {
	List<CustomerlogModel> findByDate(String date);

}
