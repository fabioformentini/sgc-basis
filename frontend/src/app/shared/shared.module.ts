import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { PRIMENG_IMPORTS } from './primeng-imports';
import { SelectItem } from 'primeng/api';


@NgModule({
    imports: [
        PRIMENG_IMPORTS,
    ],
    providers: [],
    exports: [
        PRIMENG_IMPORTS,
    ],

})
export class SharedModule { }
