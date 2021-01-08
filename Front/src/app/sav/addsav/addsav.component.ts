import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {SavService} from '../../services/sav.service';

@Component({
  selector: 'app-addsav',
  templateUrl: './addsav.component.html',
  styleUrls: ['./addsav.component.css']
})
export class AddsavComponent implements OnInit {
  form: any = {};
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  currentUser: any;

  constructor(
    // tslint:disable-next-line:no-shadowed-variable
    private CustomerService: SavService,
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
    this.router.navigate(['sav']);
  }



  back(){
    console.log("back")
    this.router.navigate(['sav']);
  }



}
