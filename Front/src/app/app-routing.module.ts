import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomerComponent} from './customer/customer.component'
import { ShowComponent } from './customer/show/show.component'
import { UpdateComponent } from './customer/update/update.component'
import { StockComponent } from './stock/stock.component'
import {AddComponent} from './stock/add/add.component';
import {UpdatestockComponent} from './stock/updatestock/updatestock.component';
import {FournisseurComponent} from './fournisseur/fournisseur.component';
import {AddfourComponent} from './fournisseur/addfour/addfour.component';
import {UpdatefourComponent} from './fournisseur/updatefour/updatefour.component';
import {SavComponent} from './sav/sav.component';
import {AddsavComponent} from './sav/addsav/addsav.component';
import {UpdatesavComponent} from './sav/updatesav/updatesav.component';
import {UserComponent} from './user/user.component';
import {AdduserComponent} from './user/adduser/adduser.component';
import {UpdateuserComponent} from './user/updateuser/updateuser.component';
import {HomeComponent} from './home/home.component';

const routes: Routes = [
  {path: 'show/add', component: CustomerComponent},
  {path: 'show', component:ShowComponent },
  { path: 'update/:id', component:UpdateComponent },

  {path: 'stock', component:StockComponent },
  {path: 'stock/add', component: AddComponent},
  { path: 'updates/:id', component:UpdatestockComponent },


  {path: 'fournisseur', component:FournisseurComponent },
  {path: 'fournisseur/add', component: AddfourComponent },
  { path: 'updatefour/:id', component:UpdatefourComponent },


  {path: 'sav', component:SavComponent },
  {path: 'sav/add', component: AddsavComponent },
  { path: 'updatesav/:id', component:UpdatesavComponent },


  {path: 'user', component:UserComponent },
  {path: 'user/add', component: AdduserComponent },
  { path: 'updateuser/:id', component:UpdateuserComponent },

  {path: 'home', component:HomeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
