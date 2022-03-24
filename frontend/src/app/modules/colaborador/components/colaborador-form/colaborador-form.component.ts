import { Observable } from 'rxjs';
import { ColaboradorModel } from '../../models/colaborador.model';
import { SenioridadeService } from '../../services/senioridade.service';
import { CompetenciaModel } from '../../../competencia/models/competencia.model';
import { CompetenciaNivel } from '../../models/competencia-nivel.model';
import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { MessageService, SelectItem } from 'primeng/api';
import { CategoriaModel } from 'src/app/modules/competencia/models/categoria.model';
import { CompetenciaService } from 'src/app/modules/competencia/services/competencia.service';

import { ColaboradorService } from '../../services/colaborador.service';
import {FuncoesUtil} from '../../../../shared/funcoes.util';
import {ConfirmationService, FileUpload} from 'primeng';

@Component({
    selector: 'app-colaborador-form',
    templateUrl: './colaborador-form.component.html',
    styleUrls: ['./colaborador-form.component.css'],
})
export class ColaboradorFormComponent implements OnInit {
    colabForm: FormGroup;
    formAdicao: FormGroup;

    nivel: CategoriaModel[] = [];
    competencia: CompetenciaModel[] = [];
    opcoesCompetencia: SelectItem[];
    competenciaSelecionada: CompetenciaModel;
    nivelSelecionado: CategoriaModel;
    senioridadeSelecionada: CategoriaModel;
    titleModal = true;
    selectedFile: File = null;

    public isVisualizar = true;

    @ViewChild('fileInput') fileInput: FileUpload;
    @Input() display = false;
    @Input() colaboradorEditado: ColaboradorModel;
    @Output() aoFechar = new EventEmitter();
    @Output() refreshColaboradores = new EventEmitter();

    constructor(
        private fb: FormBuilder,
        private rest: CompetenciaService,
        private restColab: ColaboradorService,
        private senioridadeService: SenioridadeService,
        public activatedRouter: ActivatedRoute,
        private messageService: MessageService,
        private confirmationService: ConfirmationService
    ) {
        this.opcoesCompetencia = [];
    }

    ngOnInit(): void {
        this.getCompetencia();
        this.getNivel();

        this.colabForm = this.fb.group({
            id: [null],
            nome: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(100)]],
            sobrenome: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(100)]],
            cpf: ['', [Validators.required]],
            email: ['', [Validators.required, Validators.email]],
            foto: ['', [Validators.required]],
            dataNascimento: ['', [Validators.required]],
            dataAdmissao: ['', [Validators.required]],
            idSenioridade: ['', [Validators.required]],
            competenciasList: [[], [Validators.required]],
        });
        if (!!this.colaboradorEditado) {
            this.titleModal = false;
            this.colabForm.patchValue(this.colaboradorEditado);
        }
    }

    verificaId() {
        if (!this.colabForm.get('id').value) {
            this.createColaborador();
            return;
        }
        this.updateColaborador();
    }

    createColaborador() {
        this.finalizarRequisicao(
            this.restColab.postColaborador(this.colabForm.getRawValue())
        );
        this.showMessageCriar();
    }

    updateColaborador() {
        this.finalizarRequisicao(
            this.restColab.putColaborador(this.colabForm.getRawValue())
        );
        this.showMessageEditar();
    }

    finalizarRequisicao(observable: Observable<ColaboradorModel>) {
        observable.subscribe((result) => {
            this.refreshColaboradores.emit();
            this.fecharModal();
        });
    }

    showMessageEditar() {
        this.messageService.add({severity: 'success', summary: 'Colaborador editado com sucesso!', detail: ''});
    }
    showMessageCriar() {
        this.messageService.add({severity: 'success', summary: 'Coloborador criado com sucesso!', detail: ''});
    }

    public getCompetencia() {
        this.rest.getCompetencias().subscribe(
            (data) => {
                this.competencia = data;
            },
            (error) => {
                console.log('Erro', error);
            }
        );
    }

    public getNivel() {
        this.senioridadeService.getSenioridade().subscribe(
            (data) => {
                this.nivel = data;
            },
            (error) => {
                console.log('Erro', error);
            }
        );
    }

    private selectFilesToUpload(event) {
    this.selectedFile = event.currentFiles[0];
        console.log(this.selectedFile);
    }

    converterParaDropDown(n: any[], valor: string, nome: string): SelectItem[] {
        return n.map((item: any) => ({
            value: valor ? item[valor] : item,
            label: item[nome],
        }));
    }

    fecharModal() {
        this.display = false;
        this.aoFechar.emit();
    }

    addCompetencia() {
        const campoCompetenciasList: CompetenciaNivel[] =
            this.colabForm.get('competenciasList').value;
        const idCompSelecionada = this.competenciaSelecionada.id;
        const idNivelSelecionado = this.nivelSelecionado.id;
        const compNivel: CompetenciaNivel = new CompetenciaNivel(
            idCompSelecionada,
            idNivelSelecionado
        );
        if (this.competenciaIncluida(campoCompetenciasList, compNivel)) {
            return alert('Essa competência já foi adicionada');
        }
        campoCompetenciasList.push(compNivel);
        console.log(campoCompetenciasList);
    }

    confirm(id: number) {
        this.confirmationService.confirm(FuncoesUtil.criarConfirmation('Deseja mesmo excluir o registro?', 'Confirmar Exclusão',
            () => this.removerCompetencia(id),  'Excluir', 'Cancelar'));
    }

    removerCompetencia(idComp: number): void {
        const campoCompetenciasList: CompetenciaNivel[] =
            this.colabForm.get('competenciasList').value;

        const index = campoCompetenciasList.findIndex(
            ({ idCompetencia }) => idCompetencia === idComp
        );
        campoCompetenciasList.splice(index, 1);

    }

    showMessageError(msg: string) {
        this.messageService.add({severity: 'error', summary: 'Falha ao excluir turma de formação', detail: msg});
    }

    competenciaIncluida(campoCompetenciasList, compNivel): boolean {
        return campoCompetenciasList
            .map(
                (compNivelIncluido: CompetenciaNivel) =>
                    compNivelIncluido.idCompetencia
            )
            .includes(compNivel.idCompetencia);
    }

    gerarNomeCompetencia(competenciaNivelModel: CompetenciaNivel) {
        const descricaoCompetencia = this.competencia.find(
            (competencia: CompetenciaModel) => {
                return competencia.id === competenciaNivelModel.idCompetencia;
            }
        );
        const descricaoNivel = this.nivel.find((nivel: CategoriaModel) => {
            return nivel.id === competenciaNivelModel.nivel;
        });

        return descricaoCompetencia.nome + ' = ' + descricaoNivel.descricao;
    }

    get title() {
        return this.titleModal ? 'Novo Colaborador' : 'Editar Colaborador';
    }

    get titleButton() {
        return this.titleModal ? 'Criar' : 'Editar';
    }

    verificaValidacao(campo) {
        return this.colabForm.get(campo).valid && this.colabForm.get(campo).touched;
    }

    erroCss(campo) {
        return{
            'has-error': this.verificaValidacao(campo),
            'has-feedback': this.verificaValidacao(campo)
        };
    }
}
