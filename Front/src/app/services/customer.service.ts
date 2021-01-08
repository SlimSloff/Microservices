
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8762/customer/api/customers';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  addCustomer(customer): Observable<any> {
    return this.http.post(baseUrl , {



      email: customer.email,
      username:customer.username,
      name:customer.name,
      adress:customer.adress


    });
  }



  getAll(): Observable<any> {

    return this.http.get( baseUrl + '/all', {}, );
  }




  getById(id): Observable<any> {

    return this.http.get( baseUrl + '/' +id, {}, );
  }

  deletecust(id) {
    return this.http.delete(`${baseUrl}/${id}`);
  }


  update(id : number , value : any): Observable<any> {

    return this.http.put( baseUrl + '/' +id, value );
  }
  update2(id : number , value : any): Observable<any> {

    return this.http.put(`${baseUrl}/${id}`, value);
  }


}
