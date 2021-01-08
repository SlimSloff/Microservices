
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


const baseUrl = 'http://localhost:8088/api/users';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  addCustomer(customer): Observable<any> {
    return this.http.post('http://localhost:8088/api/users' , {



      nom: customer.nom,
      prenom:customer.prenom,
      email:customer.email,
      adress:customer.adress,
      role_id:customer.role_id,



    });
  }



  getAll(): Observable<any> {

    return this.http.get('http://localhost:8088/api/users/all', {}, );
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
