import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Router } from '@angular/router';
import {FournisseurService} from '../../services/fournisseur.service';

@Component({
  selector: 'app-addfour',
  templateUrl: './addfour.component.html',
  styleUrls: ['./addfour.component.css']
})
export class AddfourComponent implements OnInit {
  form: any = {};
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  currentUser: any;

  constructor(
    // tslint:disable-next-line:no-shadowed-variable
    private CustomerService: FournisseurService,
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
    this.router.navigate(['fournisseur']);
  }



  back(){
    console.log("back")
    this.router.navigate(['fournisseur']);
  }



}
