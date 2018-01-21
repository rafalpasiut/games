import './vendor.ts';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Ng2Webstorage } from 'ngx-webstorage';

import { GamesSharedModule, UserRouteAccessService } from './shared';
import { GamesAppRoutingModule} from './app-routing.module';
import { GamesHomeModule } from './home/home.module';
import { GamesAdminModule } from './admin/admin.module';
import { GamesAccountModule } from './account/account.module';
import { GamesEntityModule } from './entities/entity.module';
import { customHttpProvider } from './blocks/interceptor/http.provider';
import { PaginationConfig } from './blocks/config/uib-pagination.config';

// jhipster-needle-angular-add-module-import JHipster will add new module here

import {
    JhiMainComponent,
    NavbarComponent,
    FooterComponent,
    ProfileService,
    PageRibbonComponent,
    ErrorComponent
} from './layouts';
import { TestComponent } from './test/test.component';

@NgModule({
    imports: [
        BrowserModule,
        GamesAppRoutingModule,
        Ng2Webstorage.forRoot({ prefix: 'jhi', separator: '-'}),
        GamesSharedModule,
        GamesHomeModule,
        GamesAdminModule,
        GamesAccountModule,
        GamesEntityModule,
        // jhipster-needle-angular-add-module JHipster will add new module here
    ],
    declarations: [
        JhiMainComponent,
        NavbarComponent,
        ErrorComponent,
        PageRibbonComponent,
        FooterComponent,
        TestComponent
    ],
    providers: [
        ProfileService,
        customHttpProvider(),
        PaginationConfig,
        UserRouteAccessService
    ],
    bootstrap: [ JhiMainComponent ]
})
export class GamesAppModule {}
