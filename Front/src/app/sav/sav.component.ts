import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {Sav} from '../entities/sav';
import {SavService} from '../services/sav.service';

@Component({
  selector: 'app-sav',
  templateUrl: './sav.component.html',
  styleUrls: ['./sav.component.css']
})
export class SavComponent implements OnInit {
  users: Sav[];
  constructor(
    private route: ActivatedRoute,

    private router: Router,
    private CustomerService: SavService
  ) { }

  ngOnInit(): void {
    this.showAll()
  }

  showAll(){
    console.log('ss')
    this.CustomerService.getAll().subscribe(users => (this.users = users));
  }

  update(id: number){
    this.router.navigate(['updatesav/', id]);
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
