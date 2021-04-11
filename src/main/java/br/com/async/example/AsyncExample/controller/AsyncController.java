package br.com.async.example.AsyncExample.controller;

import br.com.async.example.AsyncExample.model.AsyncTeste;
import br.com.async.example.AsyncExample.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/async/example")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity getRequestAsync(@RequestBody AsyncTeste teste) throws InterruptedException {

        asyncService.asyncVoidMethod();

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/test/db/post", method = RequestMethod.POST)
    public ResponseEntity postRequestAsync(@RequestBody AsyncTeste teste) throws InterruptedException {

        asyncService.asyncDBMethod(teste.getparameter1(),teste.getparameter2());

        return ResponseEntity.ok("Será inserido " + AsyncService.QTD_LIST + " registros com pausa de 1 segundo entre cada");
    }

}
