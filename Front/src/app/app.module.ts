import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerComponent } from './customer/customer.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ShowComponent } from './customer/show/show.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MenuComponent } from './menu/menu.component';
import { UpdateComponent } from './customer/update/update.component';
import { StockComponent } from './stock/stock.component';
import { AddComponent } from './stock/add/add.component';
import { UpdatestockComponent } from './stock/updatestock/updatestock.component';
import { FournisseurComponent } from './fournisseur/fournisseur.component';
import { AddfourComponent } from './fournisseur/addfour/addfour.component';
import { UpdatefourComponent } from './fournisseur/updatefour/updatefour.component';
import { SavComponent } from './sav/sav.component';
import { AddsavComponent } from './sav/addsav/addsav.component';
import { UpdatesavComponent } from './sav/updatesav/updatesav.component';
import { UserComponent } from './user/user.component';
import { AdduserComponent } from './user/adduser/adduser.component';
import { UpdateuserComponent } from './user/updateuser/updateuser.component';
import { HomeComponent } from './home/home.component';


@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    ShowComponent,
    MenuComponent,
    UpdateComponent,
    StockComponent,
    AddComponent,
    UpdatestockComponent,
    FournisseurComponent,
    AddfourComponent,
    UpdatefourComponent,
    SavComponent,
    AddsavComponent,
    UpdatesavComponent,
    UserComponent,
    AdduserComponent,
    UpdateuserComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
