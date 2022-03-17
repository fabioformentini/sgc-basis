import { CompetenciaFormComponent } from './../components/competencia-form/competencia-form.component';
import { Observable } from 'rxjs';
import { CompetenciaModel } from './../models/competencia.model';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';



@Injectable({
    providedIn: "root",
})
export class CompetenciaService {

    constructor( private http: HttpClient ){ }

    protected UrlService: string = environment.apiUrl;

    public getCompetencias(): Observable <CompetenciaModel[]> {
        return this.http.get<CompetenciaModel[]>( this.UrlService + "/competencia" )
    }

    public postCompetencia(competencia: CompetenciaModel): Observable<CompetenciaModel>{
        return this.http.post<CompetenciaModel>(this.UrlService + "/competencia", competencia)
    }

    public deleteCompetencia(id: number): Observable<CompetenciaModel>{
        const url = `${this.UrlService}/competencia/${id}`  //estudar template string
        return this.http.delete<CompetenciaModel>(url);
    }

    public putCompetencia(competencia: CompetenciaModel): Observable<CompetenciaModel>{
        const url = `${this.UrlService}/competencia/${competencia.id}`
        return this.http.put<CompetenciaModel>(url, competencia)
    }
}

