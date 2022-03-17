import { ColaboradorFormComponent } from './../colaborador-form/colaborador-form.component';
import { ColaboradorModel } from "./../../models/colaborador.model";
import { ColaboradorService } from "./../../services/colaborador.service";
import { Component, Input, OnInit, ViewChild } from "@angular/core";
import { MessageService } from 'primeng';

@Component({
    selector: "app-colaborador-list",
    templateUrl: "./colaborador-list.component.html",
    styleUrls: ["./colaborador-list.component.css"],
})
export class ColaboradorListComponent implements OnInit {

    cols: any[];
    colaboradores: ColaboradorModel[];
    display: boolean = false;
    colaboradorEditado: ColaboradorModel;
    isVisualizar: boolean = false;


    constructor(private colaboradorService: ColaboradorService,
        private messageService: MessageService) {}

    ngOnInit(): void {
        this.getColaborador();
        this.columns();
    }

    public columns(){
        this.cols = [
            { field: "nome", header: "Nome" },
            { field: "email", header: "Email"},
            { field: "descricaoSenioridade", header: "Senioridade"},
            { field: "acoes", header: "Ações" },
        ]
    }

    public getColaborador() {
        this.colaboradorService.getColaborador().subscribe(
            (data) => {
                this.colaboradores = data;
            },
            (error) => {
                console.log("Erro", error);
            }
        );
    }

    public editarColaborador(colaborador: ColaboradorModel){
        colaborador.dataNascimento = new Date (colaborador.dataNascimento);
        colaborador.dataAdmissao = new Date (colaborador.dataAdmissao);

        this.colaboradorEditado = colaborador;
        this.showDialog(true);
    }

    public excluirColaborador(id: number){
        this.colaboradorService.deleteColaborador(id).subscribe(() =>
        { this.showMessageSuccess, this.getColaborador(); },
        () => {this.showMessageError() })
    }

    showMessageSuccess() {
        this.messageService.add({severity:'success', summary: 'Colaborador excluído com sucesso!', detail:''});
    }
    showMessageError() {
        this.messageService.add({severity:'error', summary: 'Falha ao excluir colaborador', detail:'Verifique se o colaborador possui alguma competência vinculada'});
    }


    showDialog(edit: boolean) {
        this.display = true;
        this.colaboradorEditado = edit ? this.colaboradorEditado : undefined;
    }

    atualizarColaboradores(evento) {
        this.getColaborador();
    }


}
