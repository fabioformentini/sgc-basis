import {Confirmation} from 'primeng';

export class FuncoesUtil {

    public static criarConfirmation(
        message: string, header: string, accept: () => void, acceptLabel?: string, rejectLabel?: string
    ): Confirmation {
        return {
            message: message,
            header: header,
            acceptLabel: acceptLabel,
            rejectLabel: rejectLabel,
            accept: accept
        };
    }
}
