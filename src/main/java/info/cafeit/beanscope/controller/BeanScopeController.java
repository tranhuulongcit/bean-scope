package info.cafeit.beanscope.controller;

import info.cafeit.beanscope.bean.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanScopeController {

    @Autowired
    DataSource dataSourceSingleton;

    @Autowired
    DataSource dataSourcePrototype;

    @Autowired
    private DataSource dataSourceRequest;

    @Autowired
    private DataSource dataSourceSession;

    @Autowired
    private DataSource dataSourceApplication;

    @GetMapping("/requestScope")
    public ResponseEntity<?> requestScope() {
        return new ResponseEntity<>("Request scope: " + dataSourceRequest, HttpStatus.OK);
    }

    @GetMapping("/prototypeScope")
    public ResponseEntity<?> prototypeScope() {
        return new ResponseEntity<>("Prototype scope: " + dataSourcePrototype, HttpStatus.OK);
    }

    @GetMapping("/singletonScope")
    public ResponseEntity<?> singletonScope() {
        return new ResponseEntity<>("Singleton scope: " + dataSourceSingleton, HttpStatus.OK);
    }

    @GetMapping("/sessionScope")
    public ResponseEntity<?> sessionScope() {
        return new ResponseEntity<>("Session scope: " + dataSourceSession.getUrl(), HttpStatus.OK);
    }

    @GetMapping("/sessionScopeUpdate")
    public ResponseEntity<?> sessionScopeUpdate() {
        dataSourceSession.setUrl("Datasource updated at " + System.currentTimeMillis());
        return new ResponseEntity<>("Session scope updated: " + dataSourceSession.getUrl(), HttpStatus.OK);
    }

    @GetMapping("/applicationScope")
    public ResponseEntity<?> applicationScope() {
        return new ResponseEntity<>("Application scope: " + dataSourceApplication, HttpStatus.OK);
    }

}
