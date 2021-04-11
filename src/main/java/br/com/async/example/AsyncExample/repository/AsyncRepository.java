package br.com.async.example.AsyncExample.repository;

import br.com.async.example.AsyncExample.model.AsyncTeste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsyncRepository extends JpaRepository<AsyncTeste,String> {


}
