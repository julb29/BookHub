import { ApplicationConfig, LOCALE_ID, provideBrowserGlobalErrorListeners } from '@angular/core';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes';

// 1. Importer la langue française et la fonction d'enregistrement
import registerFrench from '@angular/common/locales/fr';
import { registerLocaleData } from '@angular/common';

// 2. Enregistrer les données de la langue française
registerLocaleData(registerFrench);

export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideRouter(routes),
    // 3. Configurer le français comme langue par défaut pour les Pipes (Date, Currency...)
    { provide: LOCALE_ID, useValue: 'fr-FR' },
  ],
};
