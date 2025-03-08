import {Injectable} from '@angular/core';

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

}
