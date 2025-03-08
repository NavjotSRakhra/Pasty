import {Component} from '@angular/core';
import {MatToolbar} from '@angular/material/toolbar';
import {MatIcon} from '@angular/material/icon';
import {MatIconButton} from '@angular/material/button';
import {Router, RouterModule} from '@angular/router';
import {NgIf} from '@angular/common';
import {UserAccountService} from '../../service/user-account.service';

@Component({
    selector: 'app-header',
    imports: [
        MatToolbar,
        MatIcon,
        MatIconButton,
        RouterModule,
        NgIf
    ],
    templateUrl: './header.component.html',
    standalone: true,
    styleUrl: './header.component.scss'
})
export class HeaderComponent {
    protected isLoggedIn: boolean = false;
    private userAccountService: UserAccountService;
    private router: Router;

    constructor(userAccountService: UserAccountService, router: Router) {
        this.userAccountService = userAccountService;
        this.router = router;
        this.userAccountService.isLoggedIn()
            .then(
                response => this.isLoggedIn = response
            );
    }

    navigate(route: string) {
        window.location.href = route;
    }
}
