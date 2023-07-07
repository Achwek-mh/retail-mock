package com.fsi.cbs.customer.repo;

import com.fsi.cbs.customer.repo.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customers, Long> {
}
