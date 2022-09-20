package com.bruno.os.repositories;

import com.bruno.os.domain.Cliente;
import com.bruno.os.domain.OS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsRepository extends JpaRepository<OS, Integer> {
}
