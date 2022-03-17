import { TurmaFormacaoListComponent } from './components/turma-formacao-list/turma-formacao-list.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [{
    path:'', component: TurmaFormacaoListComponent
}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TurmaFormacaoRoutingModule { }
