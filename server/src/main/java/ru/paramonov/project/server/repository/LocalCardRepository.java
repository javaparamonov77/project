package ru.paramonov.project.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.paramonov.project.server.common.LocalCard;

@Repository
public interface LocalCardRepository extends JpaRepository<LocalCard, Long> {
}
