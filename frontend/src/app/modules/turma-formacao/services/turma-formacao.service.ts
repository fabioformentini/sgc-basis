import { TurmaFormacaoListaModel } from "./../models/turma-formacao-lista.model";
import { TurmaFormacaoModel } from "./../models/turma-formacao.model";
import { Observable } from "rxjs";
import { environment } from "./../../../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: "root",
})
export class TurmaFormacaoService {
    constructor(private http: HttpClient) {}

    protected UrlService: string = environment.apiUrl;

    public getTurmaFormacao(): Observable<TurmaFormacaoListaModel[]> {
        return this.http.get<TurmaFormacaoListaModel[]>(
            this.UrlService + "/turmaformacao"
        );
    }

    public postTurmaFormacao(
        turmaFormacao: TurmaFormacaoModel
    ): Observable<TurmaFormacaoModel> {
        return this.http.post<TurmaFormacaoModel>(
            this.UrlService + "/turmaformacao",
            turmaFormacao
        );
    }

    public deleteTurmaFormacao(id: number): Observable<TurmaFormacaoModel> {
        const url = `${this.UrlService}/turmaformacao/${id}`;
        return this.http.delete<TurmaFormacaoModel>(url);
    }

    public putColaborador(
        turmaFormacao: TurmaFormacaoModel
    ): Observable<TurmaFormacaoModel> {
        const url = `${this.UrlService}/turmaformacao/${turmaFormacao.id}`;
        return this.http.put<TurmaFormacaoModel>(url, turmaFormacao);
    }
}
