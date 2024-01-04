package br.com.project.api.controller;



import br.com.project.api.model.ClientModel;
import br.com.project.api.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @PostMapping("/")
    public ClientModel cadastrar(@RequestBody ClientModel c){
        return repository.save(c);
    }
    
    @GetMapping("/")
    public Iterable<ClientModel> selecionar() {
        return repository.findAll();
    }
    
    @PutMapping("/")
    public ClientModel editar(@RequestBody ClientModel c){
        return repository.save(c);
    }
    
    @DeleteMapping("/{code}")
    public void remover(@PathVariable long code){
        repository.deleteById(code);
    }
}
