import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from './../../shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TurmaFormacaoRoutingModule } from './turma-formacao-routing.module';
import { TurmaFormacaoListComponent } from './components/turma-formacao-list/turma-formacao-list.component';
import { TurmaFormacaoFormComponent } from './components/turma-formacao-form/turma-formacao-form.component';


@NgModule({
  declarations: [TurmaFormacaoListComponent, TurmaFormacaoFormComponent],
  imports: [
    CommonModule,
    TurmaFormacaoRoutingModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class TurmaFormacaoModule { }
