
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8091/api/stocks';

@Injectable({
  providedIn: 'root'
})
export class StockService {

  constructor(private http: HttpClient) { }

  addCustomer(customer): Observable<any> {
    return this.http.post('http://localhost:8091/api/stocks' , {



      description: customer.description,
      type:customer.type,
      quantite:customer.quantite,



    });
  }



  getAll(): Observable<any> {

    return this.http.get('http://localhost:8091/api/stocks/all', {}, );
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
