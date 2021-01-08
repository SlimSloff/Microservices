import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Router } from '@angular/router';
import {Fournisseur} from '../entities/fournisseur';
import {FournisseurService} from '../services/fournisseur.service';

@Component({
  selector: 'app-fournisseur',
  templateUrl: './fournisseur.component.html',
  styleUrls: ['./fournisseur.component.css']
})
export class FournisseurComponent implements OnInit {
  users: Fournisseur[];
  constructor(
    private route: ActivatedRoute,

    private router: Router,
    private CustomerService: FournisseurService
  ) { }

  ngOnInit(): void {
    this.showAll()
  }

  showAll(){
    console.log('ss')
    this.CustomerService.getAll().subscribe(users => (this.users = users));
  }

  update(id: number){
    this.router.navigate(['updatefour/', id]);
  }

  delete(id : number){
    console.log('del')
    this.CustomerService.deletecust(id).subscribe(
      data =>{
        this.showAll();
      }
    )
    window.location.reload();
  }
}
