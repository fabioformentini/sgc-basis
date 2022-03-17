import { CompetenciaNivel } from "./competencia-nivel.model";
export class ColaboradorModel {
    id: number;
    nome: string;
    sobrenome: string;
    cpf: string;
    email: string;
    dataNascimento: Date;
    dataAdmissao: Date;
    idSenioridade: number;
    descricaoSenioridade: string;
    competenciasList: CompetenciaNivel[];
}
