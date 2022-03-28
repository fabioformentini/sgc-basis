import {Message, MessageService } from 'primeng/api';
import { CompetenciaModel } from '../../models/competencia.model';
import { CompetenciaService } from '../../services/competencia.service';
import {Component, OnInit, ViewChild} from '@angular/core';
import {Confirmation, ConfirmationService} from 'primeng';
import {FuncoesUtil} from '../../../../shared/funcoes.util';


@Component({
    selector: 'app-competencia-list',
    templateUrl: './competencia-list.component.html',
    styleUrls: ['./competencia-list.component.css'],
})
export class CompetenciaListComponent implements OnInit {
    msgs: Message[] = [];
    cols: any[];
    competencias: CompetenciaModel[];
    display = false;
    competenciaEditada: CompetenciaModel;

    constructor(
        private competenciaService: CompetenciaService,
        private messageService: MessageService,
        private confirmationService: ConfirmationService) {

    }

    ngOnInit(): void {
        this.setCompetencias();
        this.columns();
    }

    public columns() {
        this.cols = [
            { field: 'nome', header: 'Nome' },
            { field: 'descricao', header: 'Descricao' },
            { field: 'descricaoCategoria', header: 'Categoria' },
            { field: 'acoes', header: 'Ações' },
        ];
    }

    atualizarCompetencia(evento) {
        this.setCompetencias();
    }

    showDialog(edit: boolean) {
        this.display = true;
        this.competenciaEditada = edit ? this.competenciaEditada : undefined;
    }

    confirm(id) {
        this.confirmationService.confirm(FuncoesUtil.criarConfirmation('Deseja mesmo excluir o registro?', 'Confirmar Exclusão',
            () => this.excluirCompetencia(id),  'Excluir', 'Cancelar'));
    }


    public excluirCompetencia(id: number) {
        this.competenciaService.deleteCompetencia(id).subscribe(
            () => {
                this.showMessageSuccess();
                this.setCompetencias();
            },
            (error) => {
                this.showMessageError(error.error.ERRORS);
            }
        );
    }

    showMessageSuccess() {
        this.messageService.add({severity: 'success', summary: 'Competência excluída com sucesso', detail: ''});
    }
    showMessageError(msg: string) {
        this.messageService.add({severity: 'error', summary: 'Falha ao excluir competência', detail: msg});
    }

    public setCompetencias(): void {
        this.competenciaService.getCompetencias().subscribe(
            (data) => {
                this.competencias = data;
            },
            (error) => {
                console.log('Erro', error);
            }
        );
    }

    public editarCompetencia(competencia: CompetenciaModel) {
        this.competenciaEditada = competencia;
        this.showDialog(true);
    }

}
