import { Component, OnInit } from '@angular/core';

import {ActivatedRoute, Router} from '@angular/router';
import {User} from '../entities/user';
import {UserService} from '../services/user.service';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users: User[];
  constructor(
    private route: ActivatedRoute,

    private router: Router,
    private CustomerService: UserService
  ) { }

  ngOnInit(): void {
    this.showAll()
  }

  showAll(){
    console.log('ss')
    this.CustomerService.getAll().subscribe(users => (this.users = users));
  }

  update(id: number){
    this.router.navigate(['updateuser/', id]);
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
