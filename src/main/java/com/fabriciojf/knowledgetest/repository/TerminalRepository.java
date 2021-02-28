package com.fabriciojf.knowledgetest.repository;

import com.fabriciojf.knowledgetest.model.Terminal;
import com.google.common.base.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fabricio S Costa fabriciojf@gmail.com
 * @since 24/02/2021
 */
@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Integer> {
    
    Optional<Terminal> findByLogic(Integer logic);
    
}
