import { SharedModule } from './../../shared/shared.module';

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CompetenciaRoutingModule } from './competencia-routing.module';
import { CompetenciaListComponent } from './components/competencia-list/competencia-list.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CompetenciaFormComponent } from './components/competencia-form/competencia-form.component';
import { ConfirmationService, ConfirmDialog, ConfirmDialogModule } from 'primeng';


@NgModule({
  declarations: [CompetenciaListComponent, CompetenciaFormComponent],
  imports: [
    CommonModule,
    CompetenciaRoutingModule,
    FormsModule,
    SharedModule,
    ReactiveFormsModule,
    ConfirmDialogModule
  ],
  providers: [ConfirmationService]
})
export class CompetenciaModule { }
