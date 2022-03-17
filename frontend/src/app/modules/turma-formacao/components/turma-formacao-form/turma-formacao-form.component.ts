import { CompetenciaColaboradorModel } from "./../../models/competencia-colaborador.model";
import { observable, Observable } from "rxjs";
import { CompetenciaModel } from "./../../../competencia/models/competencia.model";
import { ColaboradorModel } from "./../../../colaborador/models/colaborador.model";
import { CompetenciaService } from "./../../../competencia/services/competencia.service";
import { ColaboradorService } from "./../../../colaborador/services/colaborador.service";
import { ActivatedRoute } from "@angular/router";
import { StatusService } from "./../../services/status.service";
import { StatusModel } from "./../../models/status.model";
import { TurmaFormacaoModel } from "./../../models/turma-formacao.model";
import { TurmaFormacaoService } from "./../../services/turma-formacao.service";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { Component, Input, OnInit, Output, EventEmitter } from "@angular/core";
import { MessageService, SelectItem } from "primeng";

@Component({
    selector: "app-turma-formacao-form",
    templateUrl: "./turma-formacao-form.component.html",
    styleUrls: ["./turma-formacao-form.component.css"],
})
export class TurmaFormacaoFormComponent implements OnInit {
    turmaFormacaoForm: FormGroup;
    colaborador: ColaboradorModel[] = [];
    opcoesColaborador: SelectItem[];
    colaboradorSelecionado: ColaboradorModel;
    competencia: CompetenciaModel[] = [];
    opcoesCompetencia: SelectItem[];
    competenciaSelecionada: CompetenciaModel;
    status: StatusModel[] = [];
    statusSelecionado: StatusModel;
    competenciasFiltradas: CompetenciaModel[] = [];
    titleModal = true;

    public isVisualizar: boolean = true;

    @Input() display = false;
    @Input() turmaFormacaoEditada: TurmaFormacaoModel;
    @Output() aoFechar = new EventEmitter();
    @Output() refreshTurmaFormacao = new EventEmitter();

    constructor(
        private formBuilder: FormBuilder,
        private statusService: StatusService,
        private turmaFormacaoService: TurmaFormacaoService,
        private colaboradorService: ColaboradorService,
        private competenciaService: CompetenciaService,
        private messageService: MessageService
        ) {
            this.opcoesColaborador = [];
            this.opcoesCompetencia = [];
        }

    ngOnInit(): void {
        this.getColaborador();
        this.getCompetencia();
        this.getStatus();
        this.turmaFormacaoForm = this.formBuilder.group({
            id: [null],
            nome: ["", [Validators.required]],
            descricao: ["", [Validators.required]],
            dataInicio: ["", [Validators.required]],
            dataTermino: ["", [Validators.required]],
            idStatus: ["", [Validators.required]],
            competenciasColaboradores: [[]],
        });
        if (!!this.turmaFormacaoEditada) {
            this.titleModal = false;
            this.turmaFormacaoForm.patchValue(this.turmaFormacaoEditada);
        }
    }

    public filtrarCompetencias(idColab: number){
        const findColab = this.colaborador.find((it)=>it.id === idColab) //identificando colab passado
        if (findColab){
            const competencias = findColab.competenciasList
            this.competenciasFiltradas = this.competencia.filter((it)=>{
                return competencias.some((it2)=> it2.nivel === 4 && it2.idCompetencia === it.id)
            })
        }
    }

    public getColaborador() {
        this.colaboradorService.getColaborador().subscribe(
            (data) => {
                this.colaborador = data;
            },
            (error) => {
                console.log("Erro", error);
            }
        );
    }

    public getCompetencia() {
        this.competenciaService.getCompetencias().subscribe(
            (data) => {
                this.competencia = data;
            },
            (error) => {
                console.log("Erro", error);
            }
        );
    }

    public getStatus() {
        this.statusService.getStatus().subscribe(
            (data) => {
                this.status = data;
            },
            (error) => {
                console.log("Erro", error);
            }
            );
        }

        public fecharModal() {
            this.display = false;
            this.aoFechar.emit();
        }


    public finalizarRequisicao(observable: Observable<TurmaFormacaoModel>) {
        observable.subscribe((result) => {
            this.refreshTurmaFormacao.emit();
            this.fecharModal();
        });
    }

    public createTurmaFormacao() {
        this.finalizarRequisicao(
            this.turmaFormacaoService.postTurmaFormacao(
                this.turmaFormacaoForm.getRawValue()
            )
        );
        this.showMessageCriar();
    }

    public updateTurmaFormacao() {
        this.finalizarRequisicao(
            this.turmaFormacaoService.putColaborador(
                this.turmaFormacaoForm.getRawValue()
            )
        );
        this.showMessageEditar();
    }

    showMessageEditar() {
        this.messageService.add({severity:'success', summary: 'Turma de formação editada com sucesso!', detail:''});
    }
    showMessageCriar() {
        this.messageService.add({severity:'success', summary: 'Turma de formação criada com sucesso!', detail:''});
    }

    public verificaId() {
        if (!this.turmaFormacaoForm.get("id").value) {
            this.createTurmaFormacao();
            return;
        }
        this.updateTurmaFormacao();
    }


    public addCompetenciaColaborador() {
        const campoCompetenciaColaboradorList: CompetenciaColaboradorModel[] =
            this.turmaFormacaoForm.get("competenciasColaboradores").value;
        const idColaboradorSelecionado = this.colaboradorSelecionado.id;
        const idCompetenciaSelecionada = this.competenciaSelecionada.id;
        const colaboradorCompetencia: CompetenciaColaboradorModel =
            new CompetenciaColaboradorModel(
                idColaboradorSelecionado,
                idCompetenciaSelecionada
            );
        campoCompetenciaColaboradorList.push(colaboradorCompetencia);
        console.log(campoCompetenciaColaboradorList)
    }

    public removerCompetenciaColaborador(idColab: number, idComp: number): void {
        const campoCompetenciaColaboradorList: CompetenciaColaboradorModel[] =
            this.turmaFormacaoForm.get("competenciasColaboradores").value;

        const index = campoCompetenciaColaboradorList.findIndex(
            ({ idColaborador, idCompetencia }) => idColaborador === idColab && idCompetencia === idComp
        );
        campoCompetenciaColaboradorList.splice(index, 1);
    }

    public gerarNomeCompetenciaColaborador(
        competenciaColaborador: CompetenciaColaboradorModel
    ) {
        const nomeColaborador = this.colaborador.find(
            (colaborador: ColaboradorModel) => {
                return colaborador.id === competenciaColaborador.idColaborador;
            }
        );
        const nomeCompetencia = this.competencia.find(
            (competencia: CompetenciaModel) => {
                return competencia.id === competenciaColaborador.idCompetencia;
            }
        );
        return (
            nomeColaborador.nome +
            " " +
            nomeColaborador.sobrenome +
            " = " +
            nomeCompetencia.nome
        );
    }

    get title() {
        return this.titleModal ? "Nova Turma" : "Editar Turma";
    }

    get titleButton() {
        return this.titleModal ? "Criar" : "Editar";
    }

    converterParaDropDown(n: any[], valor: string, nome: string): SelectItem[] {
        return n.map((item: any) => ({
            value: valor ? item[valor] : item,
            label: item[nome],
        }));
    }

    verificaValidacao(campo){
        return this.turmaFormacaoForm.get(campo).valid && this.turmaFormacaoForm.get(campo).touched;
    }

    erroCss(campo){
        return{
            'has-error': this.verificaValidacao(campo),
            'has-feedback': this.verificaValidacao(campo)
        }
    }
}
