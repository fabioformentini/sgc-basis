import { SharedModule } from './../../shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ColaboradorRoutingModule } from './colaborador-routing.module';
import { ColaboradorListComponent } from './components/colaborador-list/colaborador-list.component';
import { ColaboradorFormComponent } from './components/colaborador-form/colaborador-form.component';

@NgModule({
  declarations: [ColaboradorListComponent, ColaboradorFormComponent],
  imports: [
    CommonModule,
    ColaboradorRoutingModule,
    FormsModule,
    SharedModule,
    ReactiveFormsModule
  ]
})
export class ColaboradorModule { }
