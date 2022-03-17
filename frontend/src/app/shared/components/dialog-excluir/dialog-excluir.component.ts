import {Component, Input, OnInit} from '@angular/core';
import {Confirmation, ConfirmationService} from 'primeng';

@Component({
  selector: 'app-dialog-excluir',
  templateUrl: './dialog-excluir.component.html',
  styleUrls: ['./dialog-excluir.component.css']
})
export class DialogExcluirComponent implements OnInit {
    display = false;

    @Input() confirmation: Confirmation;
  constructor(
      private confirmationService: ConfirmationService
  ) { }

  ngOnInit(): void {
  }

    confirm() {
        this.confirmationService.confirm(this.confirmation);
    }

    showDialog() {
        this.display = true;
    }
}
