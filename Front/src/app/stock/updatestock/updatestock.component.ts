import { Component, OnInit } from '@angular/core';
import {StockService} from  '../../services/stock.service';
import {Stock} from '../../entities/stock';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-updatestock',
  templateUrl: './updatestock.component.html',
  styleUrls: ['./updatestock.component.css']
})
export class UpdatestockComponent implements OnInit {

  form: Stock;
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  currentUser: any;
  id :number;

  cust : Stock;

  constructor(
    // tslint:disable-next-line:no-shadowed-variable
    private CustomerService: StockService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.CustomerService.getById(this.id)
      .subscribe(data => {
        console.log(data)
        this.form = data ;

      }, error => console.log(error));

  }

  onSubmit() {
    console.log('clicked')
    this.CustomerService.addCustomer(this.form).subscribe(data => {
        console.log(data);

      },
    );
  }


  add() {


    this.CustomerService.addCustomer(this.form).subscribe(
      data => {
        console.log(data);
        console.log(this.form)
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }

  back() {
    console.log("back")
    this.router.navigate(['stock']);
  }


  updateuser(){
    console.log('up')
    this.CustomerService.update2(this.id, this.form).subscribe(
      data =>{
        this.form = new Stock();
        console.log(data)

      }
    )
    this.router.navigate(['stock']);
  }



}
