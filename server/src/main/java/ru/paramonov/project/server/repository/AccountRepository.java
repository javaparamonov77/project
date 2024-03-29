package ru.paramonov.project.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.paramonov.project.server.common.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
