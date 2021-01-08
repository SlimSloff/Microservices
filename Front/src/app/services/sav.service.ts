
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8084/api/SAV';
@Injectable({
  providedIn: 'root'
})
export class SavService {

  constructor(private http: HttpClient) { }

  addCustomer(customer): Observable<any> {
    return this.http.post(baseUrl , {



      satstisfaction: customer.satstisfaction,
      avis:customer.avis,


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
