import {Routes} from '@angular/router';
import {AppComponent} from './app.component';

export const routes: Routes = [
    {
        path: '',
        component: AppComponent
    },
    {
        path: 'note/:urlIdentifier',
        loadComponent: () => import('./component/note-entry/note-entry.component')
            .then(m => m.NoteEntryComponent)
    },
];
