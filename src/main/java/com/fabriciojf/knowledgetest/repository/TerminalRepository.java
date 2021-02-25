package com.fabriciojf.knowledgetest.repository;

import com.fabriciojf.knowledgetest.model.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Fabricio S Costa fabriciojf@gmail.com
 * @class TerminalRepository
 * @since 24/02/2021
 */
public interface TerminalRepository extends JpaRepository<Terminal, Integer> {
    
    Terminal findByLogic(int logic);
    
}
