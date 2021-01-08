import { Component, OnInit } from '@angular/core';
import {CustomerService} from  '../services/customer.service';
import {Customer} from '../entities/customer';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  form: any = {};
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  currentUser: any;

  constructor(
    // tslint:disable-next-line:no-shadowed-variable
    private CustomerService: CustomerService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {

  }

  onSubmit(){
    console.log('clicked')
    this.CustomerService.addCustomer(this.form).subscribe(data => {
        console.log(data);

      },

    );
    this.router.navigate(['show']);
}



    back(){
    console.log("back")
      this.router.navigate(['show']);
    }



  }
