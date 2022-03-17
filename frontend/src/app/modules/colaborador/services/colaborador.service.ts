import { ColaboradorModel } from "./../models/colaborador.model";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: "root",
})
export class ColaboradorService {
    constructor(private http: HttpClient) {}

    protected UrlService: string = environment.apiUrl;

    public getColaborador(): Observable<ColaboradorModel[]> {
        return this.http.get<ColaboradorModel[]>(
            this.UrlService + "/colaborador"
        );
    }

    public postColaborador(
        colaborador: ColaboradorModel
    ): Observable<ColaboradorModel> {
        return this.http.post<ColaboradorModel>(
            this.UrlService + "/colaborador",
            colaborador
        );
    }

    public deleteColaborador(id: number): Observable<ColaboradorModel>{
        const url = `${this.UrlService}/colaborador/${id}`  //estudar template string
        return this.http.delete<ColaboradorModel>(url);
    }

    public putColaborador(colaborador: ColaboradorModel): Observable<ColaboradorModel>{
        const url = `${this.UrlService}/colaborador/${colaborador.id}`
        return this.http.put<ColaboradorModel>(url, colaborador)
    }
}
