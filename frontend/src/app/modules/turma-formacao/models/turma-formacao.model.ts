import { CompetenciaColaboradorModel } from './competencia-colaborador.model';
export class TurmaFormacaoModel{
    id: number;
    nome: string;
    descricao: string;
    dataInicio: Date;
    dataTermino: Date;
    idStatus: number;
    descricaoStatus: string;
    competenciasColaboradores: CompetenciaColaboradorModel[];
}
