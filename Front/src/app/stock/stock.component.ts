import { Component, OnInit } from '@angular/core';
import {StockService} from  '../services/stock.service';
import {Stock} from '../entities/stock';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {
  users: Stock[];
  constructor(
    private route: ActivatedRoute,

    private router: Router,
    private CustomerService: StockService
  ) { }

  ngOnInit(): void {
    this.showAll()
  }

  showAll(){
    console.log('ss')
    this.CustomerService.getAll().subscribe(users => (this.users = users));
  }

  update(id: number){
    this.router.navigate(['updates/', id]);
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
