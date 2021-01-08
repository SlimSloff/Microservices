import { Component, OnInit } from '@angular/core';
import {StockService} from  '../../services/stock.service';
import {Stock} from '../../entities/stock';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  form: any = {};
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  currentUser: any;

  constructor(
    // tslint:disable-next-line:no-shadowed-variable
    private CustomerService: StockService,
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
    this.router.navigate(['stock']);
  }



  back(){
    console.log("back")
    this.router.navigate(['stock']);
  }



}
