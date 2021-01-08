import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {Fournisseur} from '../../entities/fournisseur';
import {FournisseurService} from '../../services/fournisseur.service';

@Component({
  selector: 'app-updatefour',
  templateUrl: './updatefour.component.html',
  styleUrls: ['./updatefour.component.css']
})
export class UpdatefourComponent implements OnInit { form: Fournisseur;
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  currentUser: any;
  id :number;

  cust : Fournisseur;

  constructor(
    // tslint:disable-next-line:no-shadowed-variable
    private CustomerService: FournisseurService,
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
    this.router.navigate(['fournisseur']);
  }


  updateuser(){
    console.log('up')
    this.CustomerService.update2(this.id, this.form).subscribe(
      data =>{
        this.form = new Fournisseur();
        console.log(data)

      }
    )
    this.router.navigate(['fournisseur']);
  }



}
