import { CategoriaModel } from './../models/categoria.model';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

    constructor( private http: HttpClient ){ }

    protected UrlService: string = environment.apiUrl;

    public getCategorias(): Observable<CategoriaModel[]>{
        return this.http.get<CategoriaModel[]>( this.UrlService + "/categoria" )
    }


}
