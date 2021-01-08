import { Component, OnInit } from '@angular/core';
import {CustomerService} from  '../../services/customer.service';
import {Customer} from '../../entities/customer';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  form: Customer;
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  currentUser: any;
  id :number;

  cust : Customer;

  constructor(
    // tslint:disable-next-line:no-shadowed-variable
    private CustomerService: CustomerService,
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
    this.router.navigate(['show']);
  }


  updateuser(){
    console.log('up')
   this.CustomerService.update2(this.id, this.form).subscribe(
     data =>{
       this.form = new Customer();
       console.log(data)

     }
   )
    this.router.navigate(['show']);
  }



}
