import {Routes} from '@angular/router';
import {AppComponent} from './app.component';

export const routes: Routes = [
    {
        path: '',
        component: AppComponent
    },
    {
        path: 'n/:urlIdentifier',
        loadComponent: () => import('./component/note-entry/note-entry.component')
            .then(m => m.NoteEntryComponent)
    },
    {
        path: 'note',
        loadComponent: () => import('./component/note-entry-form/note-entry-form.component')
            .then(m => m.NoteEntryFormComponent)
    }
];
