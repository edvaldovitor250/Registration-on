import { Component } from '@angular/core';
import { ClienteService } from '../servico/cliente.service';
import { Cliente } from '../modelo/Cliente';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent {

  cliente = new Cliente();


  bntCadastro: boolean = true;

  clientes:Cliente[] = [];

  tabela:boolean = true;

  constructor(private servico:ClienteService){}

  selecionar():void{
    this.servico.selecionar()
    .subscribe(retorno => this.clientes = retorno);
  }

  cadastrar():void{
    this.servico.cadastrar(this.cliente)
    .subscribe(retorno => { 
      this.clientes.push(retorno); 

      this.cliente= new Cliente();
      
      alert("Cliente cadastrado com sucesso!")

    });
  }

  selecionarCliente(posicao:number):void{
    this.cliente = this.clientes[posicao];

    this.bntCadastro = false;

    this.tabela = false;

  }

  editar():void{

    this.servico.editar(this.cliente)
    .subscribe(retorno => {
      let posicao = this.clientes.findIndex(obj => {
        return obj.code == retorno.code;
      });

      this.clientes[posicao] = retorno;
      this.cliente = new Cliente();

      this.bntCadastro = true;

      this.tabela = true;

      alert("Cliente alterado com sucesso!")

    });

  }

  remover():void{

    this.servico.remover(this.cliente.code)
    .subscribe(retorno => {
      let posicao = this.clientes.findIndex(obj => {
        return obj.code ==this.cliente.code;
      });

      this.clientes.splice(posicao,1);

      this.cliente = new Cliente();

      this.bntCadastro = true;

      this.tabela = true;

      alert("Cliente removido com sucesso!")

    });

  }


  cancelar():void{
    this.cliente = new Cliente();

    this.bntCadastro = true;

    this.tabela = true;

  }

  ngOnInit(): void {
   this.selecionar();
  }


}
