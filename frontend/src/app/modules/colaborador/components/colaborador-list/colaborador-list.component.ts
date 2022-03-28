import {ColaboradorModel} from '../../models/colaborador.model';
import {ColaboradorService} from '../../services/colaborador.service';
import {Component, OnInit} from '@angular/core';
import {ConfirmationService, MessageService} from 'primeng';
import {FuncoesUtil} from '../../../../shared/funcoes.util';
import * as moment from 'moment';

@Component({
    selector: 'app-colaborador-list',
    templateUrl: './colaborador-list.component.html',
    styleUrls: ['./colaborador-list.component.css'],
})
export class ColaboradorListComponent implements OnInit {

    cols: any[];
    colaboradores: ColaboradorModel[];
    display = false;
    colaboradorEditado: ColaboradorModel;
    isVisualizar = false;


    constructor(
        private colaboradorService: ColaboradorService,
        private messageService: MessageService,
        private confirmationService: ConfirmationService) {
    }

    ngOnInit(): void {
        this.getColaborador();
        this.columns();
    }

    public columns() {
        this.cols = [
            {field: 'nome', header: 'Nome'},
            {field: 'email', header: 'Email'},
            {field: 'descricaoSenioridade', header: 'Senioridade'},
            {field: 'acoes', header: 'Ações'},
        ];
    }

    public getColaborador() {
        this.colaboradorService.getColaborador().subscribe(
            (data) => {
                this.colaboradores = data;
            },
            (error) => {
                console.log('Erro', error);
            }
        );
    }

    public editarColaborador(colaborador: ColaboradorModel) {
        colaborador.dataNascimento = moment(colaborador.dataNascimento).toDate();
        colaborador.dataAdmissao = moment(colaborador.dataAdmissao).toDate();
        this.colaboradorEditado = colaborador;
        this.showDialog(true);
    }

    confirm(id: number) {
        this.confirmationService.confirm(FuncoesUtil.criarConfirmation('Deseja mesmo excluir o registro?', 'Confirmar Exclusão',
            () => this.excluirColaborador(id), 'Excluir', 'Cancelar'));
    }

    public excluirColaborador(id: number) {
        this.colaboradorService.deleteColaborador(id).subscribe(
            () => {
                this.showMessageSuccess();
                this.getColaborador();
            },
            (error) => {
                this.showMessageError(error.error.ERRORS);
            }
        );
    }

    showMessageSuccess() {
        this.messageService.add({severity: 'success', summary: 'Colaborador excluído com sucesso!', detail: ''});
    }

    showMessageError(msg: string) {
        this.messageService.add({severity: 'error', summary: 'Falha ao excluir colaborador', detail: msg});
    }


    showDialog(edit: boolean) {
        this.display = true;
        this.colaboradorEditado = edit ? this.colaboradorEditado : undefined;
    }

    atualizarColaboradores(evento) {
        this.getColaborador();
    }


}
