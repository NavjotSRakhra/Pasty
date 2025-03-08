import {Injectable} from '@angular/core';
import {UserSignup} from '../interface/user-signup';
import {ErrorDto} from '../interface/error-dto';

@Injectable({
    providedIn: 'root'
})
export class UserAccountService {

    private baseUrl: string = '/api/user' as const;
    private loginPath: string = 'is-logged-in' as const;

    constructor() {
    }

    async isLoggedIn(): Promise<boolean> {
        const response = await fetch(`${this.baseUrl}/${this.loginPath}`, {
            method: 'GET'
        });
        return await response.json() as boolean;
    }

    async createUser(userAccount: UserSignup): Promise<ErrorDto> {
        const response = await fetch(`${this.baseUrl}`, {
            method: 'POST',
            body: JSON.stringify(userAccount),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        if (response.status === 200) {
            window.location.href = <string>response.headers.get('Location');
        }
        return (await response.json()) as ErrorDto
    }

}
