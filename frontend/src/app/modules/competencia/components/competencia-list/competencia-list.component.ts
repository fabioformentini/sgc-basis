import {Message, MessageService } from 'primeng/api';
import { CompetenciaModel } from '../../models/competencia.model';
import { CompetenciaService } from '../../services/competencia.service';
import {Component, OnInit, ViewChild} from '@angular/core';
import {Confirmation, ConfirmationService} from 'primeng';
import {FuncoesUtil} from '../../../../shared/funcoes.util';
import {DialogExcluirComponent} from '../../../../shared/components/dialog-excluir/dialog-excluir.component';

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
    confirmation: Confirmation;
    idCompetenciaExcluida: number;

    @ViewChild('dialogExcluir') dialogConfirmacao: DialogExcluirComponent;

    constructor(
        private competenciaService: CompetenciaService,
        private messageService: MessageService,
        private confirmationService: ConfirmationService) {}

    ngOnInit(): void {
        this.getCompetencias();
        this.columns();
    }

    atualizarCompetencia(evento) {
        this.getCompetencias();
    }

    construirConfirmacao(id: number) {
        console.log('qntdd');
        this.confirmation = FuncoesUtil.criarConfirmation('Deseja mesmo excluir o registro?', 'Confirmar Exclusão',
            () => this.excluirCompetencia(id),  'Excluir', 'Cancelar');
    }

    showDialog(edit: boolean) {
        this.display = true;
        this.competenciaEditada = edit ? this.competenciaEditada : undefined;
    }
    confirm(id) {
        this.idCompetenciaExcluida = id;
        this.dialogConfirmacao.showDialog();
    }

    public columns() {
        this.cols = [
            { field: 'nome', header: 'Nome' },
            { field: 'descricao', header: 'Descricao' },
            { field: 'descricaoCategoria', header: 'Categoria' },
            { field: 'acoes', header: 'Ações' },
        ];
    }

    public getCompetencias() {
        this.competenciaService.getCompetencias().subscribe(
            (data) => {
                this.competencias = data;
                console.log(this.competencias);
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

    public excluirCompetencia(id: number) {
        this.competenciaService.deleteCompetencia(id).subscribe(
            () => {
                this.showMessageSuccess();
                this.getCompetencias();
            },
            () => {
                this.showMessageError();
            }
        );
    }

    showMessageSuccess() {
        this.messageService.add({severity: 'success', summary: 'Competência excluída com sucesso', detail: ''});
    }
    showMessageError() {
        this.messageService.add({severity: 'error', summary: 'Falha ao excluir competência', detail: 'Verifique se a competência está associada a algum colaborador'});
    }

}
