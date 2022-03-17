import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { SenioridadeModel } from "../models/senioridade.model";

@Injectable({
    providedIn: "root",
})
export class SenioridadeService {
    constructor(private http: HttpClient) {}

    protected UrlService: string = environment.apiUrl;

    public getSenioridade(): Observable<SenioridadeModel[]> {
        return this.http.get<SenioridadeModel[]>(
            this.UrlService + "/senioridade"
        );
    }
}
