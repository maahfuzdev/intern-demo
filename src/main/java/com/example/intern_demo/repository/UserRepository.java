package com.example.intern_demo.repository;

import com.example.intern_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository এ ইতিমধ্যে সব CRUD method আছে:
    // save(), findAll(), findById(), deleteById(), etc.

    // Custom query (যদি দরকার হয়)
    // List<User> findByName(String name);
}