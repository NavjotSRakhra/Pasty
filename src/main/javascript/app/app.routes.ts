import {Routes} from '@angular/router';

export const routes: Routes = [
    {
        path: '',
        loadComponent: () => import('./component/note-entry-form/note-entry-form.component')
            .then(m => m.NoteEntryFormComponent)
    },
    {
        path: 'n/:urlIdentifier',
        loadComponent: () => import('./component/note-entry/note-entry.component')
            .then(m => m.NoteEntryComponent)
    },
    {
        path: 'signup',
        loadComponent: () => import('./component/signup/signup.component')
            .then(m => m.SignupComponent)
    }
];
