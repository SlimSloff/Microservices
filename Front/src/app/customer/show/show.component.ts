import { Component, OnInit } from '@angular/core';
import {CustomerService} from  '../../services/customer.service';
import {Customer} from '../../entities/customer';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {
  users: Customer[];
  constructor(
    private route: ActivatedRoute,

    private router: Router,
    private CustomerService: CustomerService
  ) { }

  ngOnInit(): void {
    this.showAll()
  }

  showAll(){
    console.log('ss')
    this.CustomerService.getAll().subscribe(users => (this.users = users));
  }

  update(id: number){
    this.router.navigate(['update/', id]);
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
