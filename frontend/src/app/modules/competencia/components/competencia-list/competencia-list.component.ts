import { ConfirmationService, Message, MessageService } from 'primeng/api';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import { CompetenciaModel } from "./../../models/competencia.model";
import { CompetenciaService } from "../../services/competencia.service";
import {
    Component,
    OnInit
} from "@angular/core";

@Component({
    selector: "app-competencia-list",
    templateUrl: "./competencia-list.component.html",
    styleUrls: ["./competencia-list.component.css"],
})
export class CompetenciaListComponent implements OnInit {
    msgs: Message[] = [];
    cols: any[];
    competencias: CompetenciaModel[];
    display: boolean = false;
    competenciaEditada: CompetenciaModel;

    constructor(private competenciaService: CompetenciaService,
        private messageService: MessageService) {}

    ngOnInit(): void {
        this.getCompetencias();
        this.columns();
    }

    atualizarCompetencia(evento) {
        this.getCompetencias();
    }

    showDialog(edit: boolean) {
        this.display = true;
        this.competenciaEditada = edit ? this.competenciaEditada : undefined;
    }

    public columns() {
        this.cols = [
            { field: "nome", header: "Nome" },
            { field: "descricao", header: "Descricao" },
            { field: "descricaoCategoria", header: "Categoria" },
            { field: "acoes", header: "Ações" },
        ];
    }

    public getCompetencias() {
        this.competenciaService.getCompetencias().subscribe(
            (data) => {
                this.competencias = data;
                console.log(this.competencias);
            },
            (error) => {
                console.log("Erro", error);
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
                this.showMessageSuccess()
                this.getCompetencias();
            },
            () => {
                this.showMessageError()
            }
        );
    }

    showMessageSuccess() {
        this.messageService.add({severity:'success', summary: 'Competência excluída com sucesso', detail:''});
    }
    showMessageError() {
        this.messageService.add({severity:'error', summary: 'Falha ao excluir competência', detail:'Verifique se a competência está associada a algum colaborador'});
    }

}
