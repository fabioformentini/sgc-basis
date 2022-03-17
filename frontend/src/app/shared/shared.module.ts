import {NgModule} from '@angular/core';
import {PRIMENG_IMPORTS} from './primeng-imports';
import {DialogExcluirComponent} from './components/dialog-excluir/dialog-excluir.component';


@NgModule({
    imports: [
        PRIMENG_IMPORTS,
    ],
    providers: [],
    declarations: [DialogExcluirComponent],
    exports: [
        PRIMENG_IMPORTS,
        DialogExcluirComponent],

})
export class SharedModule { }
