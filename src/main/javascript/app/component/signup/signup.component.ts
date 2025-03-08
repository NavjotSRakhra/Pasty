import {Component} from '@angular/core';
import {MatFormField, MatLabel} from '@angular/material/form-field';
import {MatInput} from '@angular/material/input';
import {MatCard} from '@angular/material/card';
import {MatButton} from '@angular/material/button';
import {UserAccountService} from '../../service/user-account.service';
import {UserSignup} from '../../interface/user-signup';
import {FormsModule} from '@angular/forms';
import {ErrorDto} from '../../interface/error-dto';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
    selector: 'app-signup',
    imports: [
        MatLabel,
        MatFormField,
        MatInput,
        MatCard,
        MatButton,
        FormsModule
    ],
    templateUrl: './signup.component.html',
    standalone: true,
    styleUrl: './signup.component.scss'
})
export class SignupComponent {
    private userService: UserAccountService;
    protected userSignup: UserSignup;
    private snackbar: MatSnackBar;

    constructor(userService: UserAccountService, snackbar: MatSnackBar) {
        this.snackbar = snackbar;
        this.userService = userService;
        this.userSignup = {
            'username': '',
            'password': ''
        }
    }

    createUser($event: MouseEvent) {
        if (this.userSignup.username !== '' && this.userSignup.password !== '') {
            this.userService.createUser(this.userSignup)
                .then(
                    error => {
                        this.snackbar.open(
                            this.getErrorMessage(error)
                        );
                    }
                )
        } else {
            this.snackbar.open(
                "The username and password cannot be empty!"
            )
        }
    }

    private getErrorMessage(errorDto: ErrorDto) {
        const errorId = `Error ID: ${errorDto.errorId}`;
        const errorMessage = `${errorDto.message}`;

        if (errorDto.errorId === '' || !errorDto.errorId) {
            return errorMessage;
        }
        return `${errorId}, ${errorMessage}`;
    }
}
