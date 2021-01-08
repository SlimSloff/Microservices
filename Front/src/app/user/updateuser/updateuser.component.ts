import { Component, OnInit } from '@angular/core';

import {ActivatedRoute, Router} from '@angular/router';
import {User} from '../../entities/user';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-updateuser',
  templateUrl: './updateuser.component.html',
  styleUrls: ['./updateuser.component.css']
})
export class UpdateuserComponent implements OnInit {

  form: User;
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  currentUser: any;
  id :number;

  cust : User;

  constructor(
    // tslint:disable-next-line:no-shadowed-variable
    private CustomerService: UserService,
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
    this.router.navigate(['user']);
  }


  updateuser(){
    console.log('up')
    this.CustomerService.update2(this.id, this.form).subscribe(
      data =>{
        this.form = new User();
        console.log(data)

      }
    )
    this.router.navigate(['user']);
  }



}
