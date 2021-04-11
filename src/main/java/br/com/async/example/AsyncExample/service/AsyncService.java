package br.com.async.example.AsyncExample.service;

import br.com.async.example.AsyncExample.model.AsyncTeste;
import br.com.async.example.AsyncExample.repository.AsyncRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AsyncService {
    public static final Integer QTD_LIST = 60;


    @Autowired
    private AsyncRepository repository;


    @Async
    public void asyncDBMethod(String parameter1, String parameter2) throws InterruptedException {
        List<AsyncTeste> list = new ArrayList<>();
        Integer count = 0;

        for (count = 1;count < QTD_LIST;count++){
            AsyncTeste item = new AsyncTeste(parameter1+ "(O CONTADOR É DE:"+ count +  ")",parameter2);
            Thread.sleep(1000l);
            log.info(item.toString());
            repository.save(item);
        }
    }


    @Async
    public void asyncVoidMethod() throws InterruptedException {
        log.info("Iniciando a pausa: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy  hh:mm:ss")).toString());
        Thread.sleep(120000L);
        log.info("Finalizando a pausa: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy  hh:mm:ss")).toString());
    }
}
